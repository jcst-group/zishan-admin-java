package com.nongxin.terminal.service.workorder;

import com.nongxin.terminal.entity.workorder.ZsWorkOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 工单 服务类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-09
 */
public interface ZsWorkOrderService extends IService<ZsWorkOrder> {

    List<ZsWorkOrder> getList(ZsWorkOrder workOrder);

    List<ZsWorkOrder> getListSort(ZsWorkOrder zsWorkOrder);
}
