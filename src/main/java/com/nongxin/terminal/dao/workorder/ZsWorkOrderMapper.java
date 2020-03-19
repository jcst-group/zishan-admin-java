package com.nongxin.terminal.dao.workorder;

import com.nongxin.terminal.entity.workorder.ZsWorkOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 工单 Mapper 接口
 * </p>
 *
 * @author nongxin
 * @since 2019-11-09
 */
public interface ZsWorkOrderMapper extends BaseMapper<ZsWorkOrder> {

    List<ZsWorkOrder> getList(ZsWorkOrder workOrder);

    List<ZsWorkOrder> getListSort(ZsWorkOrder zsWorkOrder);
}
