package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.StandardType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nongxin
 * @since 2019-11-11
 */
public interface StandardTypeMapper extends BaseMapper<StandardType> {

    StandardType selectById(@Param("id")Integer id);

    List<StandardType> getTemplateStandardType(@Param("templateId")Integer templateId);

}
