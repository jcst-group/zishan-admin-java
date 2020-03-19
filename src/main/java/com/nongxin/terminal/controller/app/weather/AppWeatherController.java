package com.nongxin.terminal.controller.app.weather;

import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.dao.address.AreaMapper;
import com.nongxin.terminal.dao.weather.WeatherAreaMapper;
import com.nongxin.terminal.entity.address.Area;
import com.nongxin.terminal.entity.weather.WeatherArea;
import com.nongxin.terminal.entity.weather.WeatherReal;
import com.nongxin.terminal.schedule.WeatherTask;
import com.nongxin.terminal.service.common.AreaService;
import com.nongxin.terminal.service.weather.WeatherHourService;
import com.nongxin.terminal.util.weather.FetchUtil;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.weather.AreaNameVo;
import com.nongxin.terminal.vo.weather.WeatherVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * App天气模块接口
 */
@RestController
@RequestMapping("/app/weather")
public class AppWeatherController {

    @Autowired
    private WeatherHourService weatherHourService;

    @Autowired
    private WeatherAreaMapper weatherAreaMapper;

    @Autowired
    private AreaService areaService;

    @Autowired
    private FetchUtil fetchUtil;

    @GetMapping("/getWeatherArea")
    @ApiOperation(value = "获取当前地区天气状况")
    public Result<WeatherVo> getWeatherArea(String areaName) throws Exception {
        Result<WeatherVo> result = new Result<>();
        WeatherVo weatherVo = weatherHourService.getWeatherByArea(areaName);
        if(weatherVo!=null &&weatherVo.getNow()!=null){
            result.setResult(weatherVo);
            result.setSuccess(true);
        }else{
            WeatherArea weatherArea = new WeatherArea();
            weatherArea.setAreaName(areaName);
//            weatherAreaMapper.insertSelective(weatherArea);
            fetchUtil.now(areaName);
            fetchUtil.weatherHour(areaName);
            fetchUtil.weatherDay(areaName);
            TimeUnit.SECONDS.sleep(1);
            WeatherVo weatherVo1 = weatherHourService.getWeatherByArea(areaName);
            if (weatherVo1!=null && weatherVo1.getNow()!=null){
                result.setResult(weatherVo1);
                result.setSuccess(true);
            }else {
                result.setSuccess(false);
            }
        }
        return result;
    }

    @PostMapping("/getAreaByName")
    @ApiOperation(value = "模糊搜索城市")
    public Result<List<Area>> getAreaByName(@RequestBody AreaNameVo areaNameVo){
        Result<List<Area>> result = new Result<>();
        result.setSuccessResult(areaService.getAreaByName(areaNameVo.getAreaName()));
        return result;
    }

}
