package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.DetempRel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nongxin
 * @since 2019-11-13
 */
public interface DetempRelMapper extends BaseMapper<DetempRel> {

    List<DetempRel> selectByTemplateId(@Param("templateId")Integer templateId);

}
