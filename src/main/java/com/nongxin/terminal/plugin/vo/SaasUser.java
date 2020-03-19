package com.nongxin.terminal.plugin.vo;

import com.nongxin.terminal.plugin.YamlPropertyLoaderFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author clover
 * @date 2019/11/14
 * @description
 */
@Component
@PropertySource(value = "classpath:application-saas.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "saas")
public class SaasUser {

    private List<Customer> saasHostList;

    public List<Customer> getSaasHostList() {
        return saasHostList;
    }

    public void setSaasHostList(List<Customer> saasHostList) {
        this.saasHostList = saasHostList;
    }

    @Override
    public String toString() {
        return "SaasUser{" +
                "saasHostList=" + saasHostList +
                '}';
    }
}
