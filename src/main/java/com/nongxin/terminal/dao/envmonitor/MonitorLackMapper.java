package com.nongxin.terminal.dao.envmonitor;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.nongxin.terminal.entity.envmonitor.MonitorLack;

import java.util.Date;
import java.util.List;

public interface MonitorLackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonitorLack record);

    @SqlParser(filter = true)
    int insertSelective(MonitorLack record);

    MonitorLack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonitorLack record);

    int updateByPrimaryKey(MonitorLack record);

    List<MonitorLack> getList(Integer equipmentId, Integer baseId,Date startTime,Date endTime);
}