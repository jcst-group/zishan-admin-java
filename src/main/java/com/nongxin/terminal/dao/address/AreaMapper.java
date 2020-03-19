package com.nongxin.terminal.dao.address;

import com.nongxin.terminal.entity.address.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    List<Area> getAreaByLevel(Integer level);

    List<Area> getAreaByParentCode(String parentCode);

    String getAreaCodeByName(String name);

    List<String> getMzArea();

    List<Area> getAreaByName(@Param("areaName") String areaName);

    String getCityName(String code);

    String getProvinceName(String code);

    String getAreaCode(String areaName);
}