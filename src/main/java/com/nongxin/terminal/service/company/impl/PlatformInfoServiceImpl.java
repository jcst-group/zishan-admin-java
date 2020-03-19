package com.nongxin.terminal.service.company.impl;

import com.nongxin.terminal.entity.company.PlatformInfo;
import com.nongxin.terminal.dao.company.PlatformInfoMapper;
import com.nongxin.terminal.service.company.PlatformInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 平台信息 服务实现类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-16
 */
@Service
public class PlatformInfoServiceImpl extends ServiceImpl<PlatformInfoMapper, PlatformInfo> implements PlatformInfoService {

    @Autowired
    private PlatformInfoMapper platformInfoMapper;

    @Override
    public List<PlatformInfo> getlist() {
        return platformInfoMapper.getlist();
    }

    @Override
    public boolean isExistType(Integer type) {
        return platformInfoMapper.getInfoByType(type) == null;
    }

    @Override
    public PlatformInfo getInfoByType(Integer type) {
        return platformInfoMapper.getInfoByType(type);
    }
}
