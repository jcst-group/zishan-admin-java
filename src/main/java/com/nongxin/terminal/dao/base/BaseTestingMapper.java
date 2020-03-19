package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.BaseTesting;
import com.nongxin.terminal.vo.base.BaseTestingVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseTestingMapper {
    int deleteByPrimaryKey(Integer envStandardsId);

    int insert(BaseTesting record);

    int insertSelective(BaseTesting record);

    BaseTesting selectByPrimaryKey(Integer envStandardsId);

    int updateByPrimaryKeySelective(BaseTesting record);

    int updateByPrimaryKey(BaseTesting record);

    List<BaseTestingVo> selectByBaseId(Integer baseId);

    int addBaseTesting(@Param("list") List<BaseTestingVo> list, @Param("baseId")Integer baseId);

    int deleteByBaseId(Integer baseId);

    //获取所有基地土壤金属平均值
    List<BaseTestingVo> getAllTestingAvg();

    //基地农残
    List<Map<String,Object>> getPesticideResByBaseId(@Param("baseId") Integer baseId);
}