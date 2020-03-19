package com.nongxin.terminal.controller.backstage.base;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.entity.plant.LotCalRel;
import com.nongxin.terminal.service.base.LotService;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lot")
public class LotController {

    @Autowired
    private LotService lotService;

    @PostMapping("/add")
    @ApiOperation("添加地块")
    public Result addLot(@Validated @RequestBody Lot lot){
        Result result = new Result();
        lot.setLotCode(CodeUtil.getCode(CodeEnum.LOT));
        boolean isSuccess = lotService.add(lot);
        if (isSuccess){
            result.setMessage("添加地块成功");
        }else {
            result.setMessage("添加地块失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除地块")
    public Result deleteLot(Integer id){
        Result result = new Result();
        boolean isSuccess = lotService.delete(id);
        if (isSuccess){
            result.setMessage("删除地块成功");
        }else {
            result.setMessage("删除地块失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改地块")
    public Result updateLot(@RequestBody Lot lot){
        Result result = new Result();
        boolean isSuccess = lotService.update(lot);
        if (isSuccess){
            result.setMessage("修改地块成功");
        }else {
            result.setMessage("修改地块失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询地块")
    public Result<PageInfo> getLotList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        Integer baseId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<Lot> lotList = lotService.getLotList(baseId);
        PageInfo pageInfo = new PageInfo(lotList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("获取基地所有地块")
    public Result getLotByBaseId(@RequestParam("baseId") Integer baseId){
        Result result = new Result();
        result.setSuccessResult(lotService.getIdAndNameByBaseId(baseId));
        return result;
    }

    @GetMapping("/getLotById")
    @ApiOperation("根据地块id获取地块信息")
    public Result getLotById(Integer id){
        Result result = new Result();
        result.setSuccessResult(lotService.selectByPrimaryKey(id));
        return result;
    }

    @GetMapping("/getLotScale")
    @ApiOperation("获取多个地块规模")
    public Result ge(@RequestParam(required = true)Integer[] lots,@RequestParam(required = true)Integer cropId,
                     @RequestParam(required = true)Integer calId){
        Result result = new Result();
        result.setSuccessResult(lotService.getLotScale(lots,cropId,calId));
        return result;
    }

    @GetMapping("/getLotScaleByLotId")
    @ApiOperation(value = "获取地块规模",notes = "根据地块id获取地块规模")
    public Result ge(@RequestParam(required = true)Integer lotId){
        Result result = new Result();
        result.setSuccessResult(lotService.getLotScaleByLotId(lotId));
        return result;
    }

    @GetMapping("/updateLotScale")
    @ApiOperation("修改地块对应作物规模")
    public Result updateLotScale(String jsonStr){
        Result result = new Result();
        List<LotCalRel> lotCalRelList = JSON.parseArray(jsonStr,LotCalRel.class);
        boolean isSuccess = lotService.updateLotScale(lotCalRelList);
        if (isSuccess){
            result.setMessage("修改地块对应作物规模成功");
        }else {
            result.setMessage("修改地块对应作物规模失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/addLotScale")
    @ApiOperation("添加地块对应作物规模")
    public Result addLotScale(@Validated @RequestBody LotCalRel lotScale) throws BaseException {
        Result result = new Result();
        boolean isSuccess = lotService.addLotScale(lotScale);
        if (isSuccess){
            result.setMessage("添加地块对应作物规模成功");
        }else {
            result.setMessage("添加地块对应作物规模失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/deleteLotScale")
    @ApiOperation("删除地块对应作物规模")
    public Result deleteLotScale(Integer lotId,Integer lotCalId) throws BaseException {
        Result result = new Result();
        boolean isSuccess = lotService.deleteLotScale(lotId,lotCalId);
        if (isSuccess){
            result.setMessage("删除地块对应作物规模成功");
        }else {
            result.setMessage("删除地块对应作物规模失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

}
