package com.nongxin.terminal.service.base.impl;

import com.nongxin.terminal.entity.base.StandardType;
import com.nongxin.terminal.dao.base.StandardTypeMapper;
import com.nongxin.terminal.service.base.StandardTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-11
 */
@Service
public class StandardTypeServiceImpl extends ServiceImpl<StandardTypeMapper, StandardType> implements StandardTypeService {

    @Autowired
    private StandardTypeMapper standardTypeMapper;

    @Override
    public List<StandardType> getTemplateStandardType(Integer templateId) {
        return standardTypeMapper.getTemplateStandardType(templateId);
    }
}
