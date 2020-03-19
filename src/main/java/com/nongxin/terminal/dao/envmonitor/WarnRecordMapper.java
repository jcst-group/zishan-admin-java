package com.nongxin.terminal.dao.envmonitor;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.nongxin.terminal.entity.envmonitor.WarnRecord;
import com.nongxin.terminal.vo.app.AppEnvRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WarnRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarnRecord record);

    @SqlParser(filter = true)
    int insertSelective(WarnRecord record);

    WarnRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarnRecord record);

    int updateByPrimaryKey(WarnRecord record);

    List<WarnRecord> getWarnRecordByTime(Integer typeId,@Param("baseId") String[] baseId);

    List<AppEnvRecordVo> getRecordByTime(Date time);

    List<WarnRecord> getRecordList(Integer equipmentId, Integer baseId, Date startTime, Date endTime);
}