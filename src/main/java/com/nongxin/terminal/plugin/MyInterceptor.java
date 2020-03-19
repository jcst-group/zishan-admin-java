package com.nongxin.terminal.plugin;

import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.nongxin.terminal.plugin.vo.Customer;
import com.nongxin.terminal.plugin.vo.SaasUser;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author clover
 * @date 2019/11/13
 * @description
 */
@Component
@Intercepts(value = {
        @Signature(type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class,Integer.class})})
public class MyInterceptor implements Interceptor {
    private static final String preState="/*!mycat:datanode=";
    private static final String afterState="*/";


    private Map<String,String> saasUser;

    @Autowired
    private SaasUser suser;

    private String user_node = null;
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler=(StatementHandler)invocation.getTarget();
        MetaObject metaStatementHandler= SystemMetaObject.forObject(statementHandler);
        Object object=null;
        //分离代理对象链
        while(metaStatementHandler.hasGetter("h")){
            object=metaStatementHandler.getValue("h");
            metaStatementHandler=SystemMetaObject.forObject(object);
        }
        statementHandler=(StatementHandler)object;
        String sql=(String)metaStatementHandler.getValue("delegate.boundSql.sql");
        /*
        String node=(String)TestController.threadLocal.get();
        */
        HttpServletRequest request = null;
//        System.out.println(SqlParserHelper.getSqlParserInfo(metaStatementHandler));
        if(!(SqlParserHelper.getSqlParserInfo(metaStatementHandler))){
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }

        String host = null;
        String node= "dn1";

        if(request!=null){
            host = request.getHeader("Host");

//            System.out.println("user:"+request.getServletPath()+request.getAttribute("schema"));
//            if(request.getServletPath().equals("/show/user/login")||
//                    request.getServletPath().equals("/user/login")){
//                user_node = String.valueOf(request.getAttribute("schema"));
//                node = user_node;
//                System.out.println("user_node0:"+user_node);
//            }
//            node = user_node;
//            System.out.println("user_node:"+user_node);
        }
//        if(user_node!=null&&!user_node.equals("null")){
//            node = user_node;
//            System.out.println("node0:"+node);
//        }

//        System.out.println("Host is "+host);

        //根据域名---数据节点  --多租户
        if(saasUser==null){
            saasUser = new HashMap<>();
            List<Customer> list = suser.getSaasHostList();
            for(int i=0;i<list.size();i++){
                saasUser.put(list.get(i).getHost(),list.get(i).getDb());
            }
        }

        String s = saasUser.get(host);

        if(s!=null){
            node= s;
        }

//        System.out.println("saasUser:"+saasUser);

        if(node!=null) {
            sql = preState + node + afterState + sql;
        }

        metaStatementHandler.setValue("delegate.boundSql.sql",sql);
        Object result = invocation.proceed();
//        System.out.println("Invocation.proceed()");
        return result;
    }

    @Override
    public Object plugin(Object target) {

        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String prop1 = properties.getProperty("prop1");
        String prop2 = properties.getProperty("prop2");
        System.out.println(prop1 + "------" + prop2);
    }
}
