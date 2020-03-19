package com.nongxin.terminal.dao.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.base.DetectionTemplate;
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
public interface DetectionTemplateMapper extends BaseMapper<DetectionTemplate> {

    IPage<DetectionTemplate> getDetectionTemplate(Page<DetectionTemplate> page, @Param("templateName") String templateName);

}
