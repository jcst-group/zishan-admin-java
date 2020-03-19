package com.nongxin.terminal.controller.retrocoding;

import com.nongxin.terminal.entity.plant.WorkOrder;
import com.nongxin.terminal.service.base.BaseInfoService;
import com.nongxin.terminal.service.crop.BatchEnvironmentService;
import com.nongxin.terminal.service.plan.MaterialInfoService;
import com.nongxin.terminal.service.plan.WorkOrderService;
import com.nongxin.terminal.service.traceability.ProTraceabilityService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 追溯码种植批次接口
 */
@RestController
@RequestMapping("/retro/planBatch")
public class RetroPlanBatchController {

    @Autowired
    private ProTraceabilityService proService;
    @Autowired
    private BatchEnvironmentService environmentService;
    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private MaterialInfoService materialInfoService;
    @Autowired
    private BaseInfoService baseInfoService;


    @GetMapping("/getProTraceability")
    @ApiOperation("根据追溯码获取种植批次产品信息")
    public Result getProTraceability(@RequestParam(required = true)String retroCode){
        Result result = new Result();
        result.setSuccessResult(proService.selectByRetroCode(retroCode));
        return result;
    }

    @GetMapping("/getBatchAndBase")
    @ApiOperation("根据追溯码获取种植批次信息")
    public Result<Map<String,Object>> getBatchAndBase(@RequestParam(required = true) String retroCode){
        Result<Map<String,Object>> result = new Result<>();
        result.setSuccessResult(proService.getBatchAndBaseByRetroCode(retroCode));
        return result;
    }

    @GetMapping("/getBatchEnvironment")
    @ApiOperation("根据追溯码获取种植批次环境数据")
    public Result getBatchEnvironment(@RequestParam(required = true) String retroCode){
        Result result = new Result();
        result.setSuccessResult(environmentService.selectByRetroCode(retroCode));
        return result;
    }

    @GetMapping("/getOrderByRetroCod")
    @ApiOperation("根据追溯码获取种植批次工单")
    public Result getOrderByBatchId(@RequestParam(required = true)String retroCode){
        Result result = new Result();
        List<WorkOrder> workOrderList= workOrderService.getOrderByRetroCode(retroCode);
        result.setSuccessResult(workOrderList);
        return result;
    }

    @GetMapping("/getMaterialPicByRetroCode")
    @ApiOperation("根据追溯码获取农资品检测报告")
    public Result getMaterialPicByRetroCode(@RequestParam(required = true) String retroCode){
        Result result = new Result();
        result.setSuccessResult(materialInfoService.getMaterialPicByRetroCode(retroCode));
        return result;
    }

    @GetMapping("/getBaseDetectionPic")
    @ApiOperation("根据追溯码获取基地检测报告")
    public Result getBaseDetectionPic(@RequestParam(required = true) String retroCode){
        Result result = new Result();
        result.setSuccessResult(baseInfoService.getBaseDetectionPic(retroCode,null));
        return result;
    }


}
