package com.nongxin.terminal.service.company;

import com.nongxin.terminal.entity.company.PlatformInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 平台信息 服务类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-16
 */
public interface PlatformInfoService extends IService<PlatformInfo> {

    List<PlatformInfo> getlist();

    boolean isExistType(Integer type);

    PlatformInfo getInfoByType(Integer type);
}
