package com.nongxin.terminal.service.base.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.dao.base.DetempRelMapper;
import com.nongxin.terminal.entity.base.DetectionTemplate;
import com.nongxin.terminal.dao.base.DetectionTemplateMapper;
import com.nongxin.terminal.entity.base.DetempRel;
import com.nongxin.terminal.service.base.DetectionTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-13
 */
@Service
public class DetectionTemplateServiceImpl extends ServiceImpl<DetectionTemplateMapper, DetectionTemplate> implements DetectionTemplateService {

    @Autowired
    private DetectionTemplateMapper detectionTemplateMapper;
    @Autowired
    private DetempRelMapper detempRelMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(DetectionTemplate detectionTemplate) {
        if (detectionTemplate.getId() != null){
            detectionTemplateMapper.updateById(detectionTemplate);
            Map map = new HashMap<String, Object>();
            map.put("template_id",detectionTemplate.getId());
            detempRelMapper.deleteByMap(map);
        }else{
            detectionTemplateMapper.insert(detectionTemplate);
        }
        List<DetempRel> detempRels = detectionTemplate.getDetempRel();
        if (detempRels != null && !detempRels.isEmpty()){
            for (DetempRel detempRel : detempRels) {
                detempRel.setTemplateId(detectionTemplate.getId());
                detempRelMapper.insert(detempRel);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(DetectionTemplate detectionTemplate) {
        detectionTemplateMapper.updateById(detectionTemplate);
        Map map = new HashMap<String, Object>();
        map.put("template_id",detectionTemplate.getId());
        detempRelMapper.deleteByMap(map);
        List<DetempRel> detempRels = detectionTemplate.getDetempRel();
        if (detempRels != null && !detempRels.isEmpty()){
            for (DetempRel detempRel : detempRels) {
                detempRel.setTemplateId(detectionTemplate.getId());
                detempRelMapper.insert(detempRel);
            }
        }
        return true;
    }

    @Override
    public IPage<DetectionTemplate> getDetectionTemplate(Page<DetectionTemplate> page, String templateName) {
        return detectionTemplateMapper.getDetectionTemplate(page,templateName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean copyTemplate(Integer id,String templateName) {
        DetectionTemplate detectionTemplate = new DetectionTemplate();
        detectionTemplate.setTemplateName(templateName);
        detectionTemplateMapper.insert(detectionTemplate);
        //复制检测项
        List<DetempRel> detempRels = detempRelMapper.selectByTemplateId(id);
        if (detempRels != null && !detempRels.isEmpty()){
            for (DetempRel detempRel : detempRels) {
                detempRel.setTemplateId(detectionTemplate.getId());
                detempRelMapper.insert(detempRel);
            }
        }
        return true;
    }
}
