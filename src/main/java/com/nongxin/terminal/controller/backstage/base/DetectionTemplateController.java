package com.nongxin.terminal.controller.backstage.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.base.DetectionTemplate;
import com.nongxin.terminal.service.base.DetectionTemplateService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nongxin
 * @since 2019-11-13
 */
@RestController
@RequestMapping("/detectionTemplate")
public class DetectionTemplateController {

    @Autowired
    private DetectionTemplateService detectionTemplateService;

    @PostMapping("/add")
    @ApiOperation("添加检测模板")
    public Result add(@RequestBody DetectionTemplate detectionTemplate){
        Result result = new Result();
        QueryWrapper<DetectionTemplate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("template_name",detectionTemplate.getTemplateName());
        queryWrapper.ne(detectionTemplate.getId() != null,"id",detectionTemplate.getId());
        Map map = detectionTemplateService.getMap(queryWrapper);
        if (map != null){
            result.setMessage("该模板名称已存在");
            result.setSuccess(false);
            return result;
        }
        boolean isSuccess = detectionTemplateService.add(detectionTemplate);
        result.setSuccess(isSuccess);
        result.setMessage(isSuccess ? "添加检测模板成功" : "添加检测模板失败");
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改检测模板")
    public Result update(@RequestBody DetectionTemplate detectionTemplate){
        Result result = new Result();
        boolean isSuccess = detectionTemplateService.update(detectionTemplate);
        result.setSuccess(isSuccess);
        result.setMessage(isSuccess ? "修改检测模板成功" : "修改检测模板失败");
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除检测模板")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = detectionTemplateService.removeById(id);
        result.setSuccess(isSuccess);
        result.setMessage(isSuccess ? "删除检测模板成功" : "删除检测模板失败");
        return result;
    }

    @GetMapping("/list")
    @ApiOperation("查询检测模板")
    public Result list(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                       @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                       String templateName){
        Result result = new Result();
        Page<DetectionTemplate> page = new Page(pageNo,pageSize);
        result.setSuccessResult(detectionTemplateService.getDetectionTemplate(page,templateName));
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("获取所有模板")
    public Result all(){
        Result result = new Result();
        result.setSuccessResult(detectionTemplateService.list());
        return result;
    }

    @GetMapping("/copyTemplate")
    @ApiOperation("复制检测模板")
    public Result copyTemplate(Integer id,String templateName){
        Result result = new Result();
        QueryWrapper<DetectionTemplate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("template_name",templateName);
        Map map = detectionTemplateService.getMap(queryWrapper);
        if (map != null){
            result.setMessage("该模板名称已存在");
            result.setSuccess(false);
            return result;
        }
        boolean isSuccess = detectionTemplateService.copyTemplate(id,templateName);
        result.setSuccess(isSuccess);
        result.setMessage(isSuccess ? "复制模板成功" : "复制模板失败");
        return result;
    }

}
