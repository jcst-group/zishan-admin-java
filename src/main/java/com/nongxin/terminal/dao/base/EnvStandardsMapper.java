package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.EnvStandards;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnvStandardsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvStandards record);

    int insertSelective(EnvStandards record);

    EnvStandards selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvStandards record);

    int updateByPrimaryKey(EnvStandards record);

    //获取基地环境标准
    List<EnvStandards> getEnvStandards(EnvStandards envStandards);

    List<EnvStandards> selectByItem(@Param("item")String item,@Param("standardTypeId")Integer standardTypeId,@Param("id")Integer id);

    List<EnvStandards> selectByTemplateId(@Param("templateId")Integer templateId);

}