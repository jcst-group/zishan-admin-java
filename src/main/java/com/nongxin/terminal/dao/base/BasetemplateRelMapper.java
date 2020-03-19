package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.BasetemplateRel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nongxin
 * @since 2019-11-14
 */
public interface BasetemplateRelMapper extends BaseMapper<BasetemplateRel> {

    BasetemplateRel selectByBaseId(@Param("baseId")Integer baseId);

}
