package com.nongxin.terminal.service.base.impl;

import com.nongxin.terminal.dao.base.EnvStandardsMapper;
import com.nongxin.terminal.entity.base.EnvStandards;
import com.nongxin.terminal.service.base.EnvStandardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvStandardsServiceImpl implements EnvStandardsService {

    @Autowired(required = false)
    private EnvStandardsMapper envStandardsMapper;

    @Override
    public boolean add(EnvStandards envStandards) {
        return envStandardsMapper.insertSelective(envStandards)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return envStandardsMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(EnvStandards envStandards) {
        return envStandardsMapper.updateByPrimaryKeySelective(envStandards)==1;
    }

    @Override
    public List<EnvStandards> getEnvStandards(EnvStandards envStandards) {
        return envStandardsMapper.getEnvStandards(envStandards);
    }

    @Override
    public List<EnvStandards> selectByItem(String item, Integer standardTypeId,Integer id) {
        return envStandardsMapper.selectByItem(item,standardTypeId,id);
    }

    @Override
    public List<EnvStandards> selectByTemplateId(Integer baseId) {
        return envStandardsMapper.selectByTemplateId(baseId);
    }
}
