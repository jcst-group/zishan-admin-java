package com.nongxin.terminal.dao.envmonitor;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.entity.envmonitor.EnvMonitorDayAvg;
import com.nongxin.terminal.vo.app.SpecialVo;

import java.util.List;

public interface EnvMonitorDayAvgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvMonitorDayAvg record);

    @SqlParser(filter = true)
    int insertSelective(EnvMonitorDayAvg record);

    EnvMonitorDayAvg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvMonitorDayAvg record);

    int updateByPrimaryKey(EnvMonitorDayAvg record);

    //App环控中心--获取本周监测数据
    List<EnvMonitor> getWeekEnv(Integer baseId);

    //获取本月监测数据
    List<EnvMonitor> getMonthEnv(Integer baseId);

    SpecialVo getSpecialByType(Integer typeId,Integer index,Integer baseId);
}