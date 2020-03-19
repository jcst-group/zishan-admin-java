package com.nongxin.terminal.service.weather.impl;

import com.nongxin.terminal.dao.weather.WeatherHourMapper;
import com.nongxin.terminal.entity.weather.WeatherHour;
import com.nongxin.terminal.service.weather.WeatherHourService;
import com.nongxin.terminal.vo.weather.WeatherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherHourServiceImpl implements WeatherHourService {

    @Autowired
    private WeatherHourMapper weatherHourMapper;

    @Override
    public List<WeatherHour> getWeather(String areaCode) {
        return weatherHourMapper.getWeather(areaCode);
    }

    @Override
    public WeatherVo getWeatherByArea(String areaName) {
        return weatherHourMapper.getWeatherByArea(areaName);
    }
}
