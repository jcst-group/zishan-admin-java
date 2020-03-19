package com.nongxin.terminal.controller.backstage.company;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.entity.company.PlatformInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.service.company.PlatformInfoService;
import com.nongxin.terminal.service.file.PictureInfoService;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

/**
 * <p>
 * 平台信息 前端控制器
 * </p>
 *
 * @author nongxin
 * @since 2019-11-16
 */
@RestController
@RequestMapping("/platform-info")
public class PlatformInfoController {

    @Autowired
    private PlatformInfoService platformInfoService;

    @Autowired
    private PictureInfoService pictureInfoService;

    @Autowired
    private PictureInfoMapper pictureInfoMapper;

    @PostMapping("/add")
    @ApiOperation(value="添加平台信息", notes = "POST添加平台信息")
    public Result<PlatformInfo> add(@Validated @RequestBody PlatformInfo platformInfo){
        Result<PlatformInfo> result = new Result<>();
        if(!platformInfoService.isExistType(platformInfo.getType())){
            result.setSuccess(false);
            result.setMessage("已存在该类型配置信息");
            return result;
        }
        boolean isInsertSuccess = platformInfoService.save(platformInfo);
        if(isInsertSuccess){
            result.setMessage("添加平台信息成功");
        }else{
            result.setMessage("添加平台信息失败");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation(value="修改平台信息", notes = "POST修改平台信息")
    public Result<PlatformInfo> update( @RequestBody PlatformInfo platformInfo){
        Result<PlatformInfo> result = new Result<>();
        boolean isUpdateSuccess = platformInfoService.updateById(platformInfo);
        if(isUpdateSuccess){
            result.setMessage("修改平台信息成功");
        }else{
            result.setMessage("修改平台信息失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value="删除数据", notes = "GET删除公司信息数据")
    public Result<PlatformInfo> delete(Integer id){
        Result<PlatformInfo> result = new Result<>();
        boolean isDelSuccess = platformInfoService.removeById(id);
        if(isDelSuccess){
            result.setMessage("删除平台信息成功");
        }else{
            result.setMessage("删除平台信息失败");
        }
        result.setSuccess(isDelSuccess);
        return result;
    }

    @GetMapping("/getPlatformByType")
    @ApiOperation(value="查询平台信息", notes = "GET根据id查询平台信息列表")
    public Result<PlatformInfo> getCompanyById(Integer type){
        Result<PlatformInfo> result = new Result<>();
        PlatformInfo platformInfo = platformInfoService.getInfoByType(type);
        result.setResult(platformInfo);
        result.setSuccess(true);
        return result;
    }

    @PostMapping("/addPlatformIco")
    @ApiOperation("添加平台logo")
    public Result addPlatformIco(MultipartFile file){
        return pictureInfoService.add(file,1001, ImgRelationTypeEnum.ICO);
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询平台信息列表",notes = "GET分页模糊查询平台信息列表")
    public Result<PageInfo> getCompanyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                           @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<PlatformInfo> platformInfoList = platformInfoService.getlist();
        PageInfo pageInfo = new PageInfo(platformInfoList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @PostMapping("/addBackHomePic")
    @ApiOperation("添加后台背景图")
    public Result addBackHomePic(MultipartFile file){
        return pictureInfoService.add(file,1000, ImgRelationTypeEnum.BACKGROUND);
    }

    @GetMapping("/getBackPicName")
    @ApiOperation(value = "获取后台首页图片")
    public Result<PictureInfo> getBackGroundPicName(){
        Result<PictureInfo> result = new Result<>();
        PictureInfo pictureInfo = pictureInfoMapper.getBackGround();
        result.setSuccessResult(pictureInfo);
        return result;
    }

    @GetMapping("/getLogoPic")
    @ApiOperation(value = "获取LOGO图片")
    public Result<PictureInfo> getLogoPic(){
        Result<PictureInfo> result = new Result<>();
        PictureInfo pictureInfo = pictureInfoMapper.getLogoPic();
        result.setSuccessResult(pictureInfo);
        return result;
    }
}
