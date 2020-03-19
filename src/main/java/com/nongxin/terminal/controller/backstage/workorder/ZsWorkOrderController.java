package com.nongxin.terminal.controller.backstage.workorder;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.workorder.ZsWorkOrder;
import com.nongxin.terminal.service.workorder.ZsWorkOrderService;
import com.nongxin.terminal.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 工单 前端控制器
 * </p>
 *
 * @author nongxin
 * @since 2019-11-09
 */
@RestController
@RequestMapping("/zsWorkorder")
public class ZsWorkOrderController {

    @Autowired
    private ZsWorkOrderService zsWorkOrderService;

    @PostMapping("/add")
    public Result<String> add(@RequestBody ZsWorkOrder workOrder){
        Result<String> result = new Result<>();
        if(zsWorkOrderService.save(workOrder)){
            result.setSuccess(true);
            result.setMessage("添加成功");
        }else{
            result.setSuccess(false);
            result.setMessage("添加失败");
        }
        return result;
    }

    @PostMapping("/update")
    public Result<String> update(@RequestBody ZsWorkOrder workOrder){
        Result<String> result = new Result<>();
        if(zsWorkOrderService.updateById(workOrder)){
            result.setSuccess(true);
            result.setMessage("修改成功");
        }else{
            result.setSuccess(false);
            result.setMessage("修改失败");
        }
        return result;
    }

    @GetMapping("/delete")
    public Result<String> delete(Integer id){
        Result<String> result = new Result<>();
        if(zsWorkOrderService.removeById(id)){
            result.setSuccess(true);
            result.setMessage("删除成功");
        }else{
            result.setSuccess(false);
            result.setMessage("删除失败");
        }
        return result;
    }

    @GetMapping("/list")
    public Result<PageInfo> getList(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                             @RequestParam(name="pageSize", defaultValue="10") Integer pageSize
                                             ,ZsWorkOrder workOrder){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<ZsWorkOrder> list = zsWorkOrderService.getList(workOrder);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }

}
