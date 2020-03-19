package com.nongxin.terminal.dao.company;

import com.nongxin.terminal.entity.company.PlatformInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.util.enumUtil.common.PlatformTypeEnum;

import java.util.List;

/**
 * <p>
 * 平台信息 Mapper 接口
 * </p>
 *
 * @author nongxin
 * @since 2019-11-16
 */
public interface PlatformInfoMapper extends BaseMapper<PlatformInfo> {

    List<PlatformInfo> getlist();

    PlatformInfo getInfoByType(Integer type);

}
