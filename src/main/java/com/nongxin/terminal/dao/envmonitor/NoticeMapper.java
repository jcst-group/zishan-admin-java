package com.nongxin.terminal.dao.envmonitor;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.nongxin.terminal.entity.envmonitor.Notice;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    @SqlParser(filter = true)
    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

}