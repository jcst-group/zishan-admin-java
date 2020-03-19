package com.nongxin.terminal.service.workorder.impl;

import com.nongxin.terminal.entity.workorder.ZsWorkOrder;
import com.nongxin.terminal.dao.workorder.ZsWorkOrderMapper;
import com.nongxin.terminal.service.workorder.ZsWorkOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 工单 服务实现类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-09
 */
@Service
public class ZsWorkOrderServiceImpl extends ServiceImpl<ZsWorkOrderMapper, ZsWorkOrder> implements ZsWorkOrderService {

    @Autowired
    private ZsWorkOrderMapper zsWorkOrderMapper;

    @Override
    public List<ZsWorkOrder> getList(ZsWorkOrder workOrder) {
        return zsWorkOrderMapper.getList(workOrder);
    }

    @Override
    public List<ZsWorkOrder> getListSort(ZsWorkOrder zsWorkOrder) {
        return zsWorkOrderMapper.getListSort(zsWorkOrder);
    }
}
