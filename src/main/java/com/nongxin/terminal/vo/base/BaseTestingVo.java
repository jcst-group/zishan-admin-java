package com.nongxin.terminal.vo.base;

import com.nongxin.terminal.entity.base.StandardType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BaseTestingVo {

    private Integer baseId;

    private Integer envStandardsId;

    //检测项目
    private String item;

    //检测项目所属类型
    private StandardType itemName;

    //值
    private BigDecimal value;
}
