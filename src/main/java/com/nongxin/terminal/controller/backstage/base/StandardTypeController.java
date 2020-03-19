package com.nongxin.terminal.controller.backstage.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.base.StandardType;
import com.nongxin.terminal.service.base.StandardTypeService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nongxin
 * @since 2019-11-11
 */
@RestController
@RequestMapping("/standardType")
public class StandardTypeController {

    @Autowired
    private StandardTypeService standardTypeService;

    @GetMapping("/check")
    @ApiOperation("校验名称、code唯一")
    public boolean check(String displayName,String code,Integer id){
        QueryWrapper<StandardType> wrapper = new QueryWrapper();
        wrapper.ne(id != null,"value",id).and(wq->wq.eq("display_name",displayName).or().eq("code",code));
        return standardTypeService.getMap(wrapper)==null ? true : false;
    }

    @PostMapping("/add")
    @ApiOperation("新增基地检测项")
    public Result add(@RequestBody @Validated StandardType standardType){
        Result result = new Result();
        boolean isSuccess = standardTypeService.save(standardType);
        result.setSuccess(isSuccess);
        result.setMessage(isSuccess ? "添加检测项目成功" : "添加检测项目失败");
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除基地检测项")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = standardTypeService.removeById(id);
        result.setSuccess(isSuccess);
        result.setMessage(isSuccess ? "删除检测项目成功" : "删除检测项目失败");
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改基地检测项")
    public Result update(@RequestBody StandardType standardType){
        Result result = new Result();
        boolean isSuccess = standardTypeService.updateById(standardType);
        result.setSuccess(isSuccess);
        result.setMessage(isSuccess ? "修改检测项目成功" : "修改检测项目失败");
        return result;
    }

    @GetMapping("/list")
    @ApiOperation("查询基地检测项目")
    public Result list(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                       @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize){
        Result result = new Result();
        IPage<StandardType> page = new Page<>(pageNo, pageSize);
        QueryWrapper<StandardType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        result.setSuccessResult(standardTypeService.page(page,queryWrapper));
        return result;
    }


}
