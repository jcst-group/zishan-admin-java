package com.nongxin.terminal.service.base;

import com.nongxin.terminal.entity.base.StandardType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-11
 */
public interface StandardTypeService extends IService<StandardType> {

    List<StandardType> getTemplateStandardType(Integer templateId);

}
