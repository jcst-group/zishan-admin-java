package com.nongxin.terminal.service.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.base.DetectionTemplate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nongxin.terminal.entity.testing.DetectionItems;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-13
 */
public interface DetectionTemplateService extends IService<DetectionTemplate> {

    boolean add(DetectionTemplate detectionTemplate);

    boolean update(DetectionTemplate detectionTemplate);

    IPage<DetectionTemplate> getDetectionTemplate(Page<DetectionTemplate> page, String templateName);

    boolean copyTemplate(Integer id,String templateName);

}
