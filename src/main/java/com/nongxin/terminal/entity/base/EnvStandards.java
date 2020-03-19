package com.nongxin.terminal.entity.base;

import com.nongxin.terminal.util.enumUtil.detection.DetectionUnitEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class EnvStandards {
    private Integer id;

    private StandardType itemName;

    private Integer standardTypeId;

    @NotEmpty(message = "检测项目不能为空")
    private String item;

    @NotNull(message = "检测单位不能为空")
    private DetectionUnitEnum unit;

    @NotNull(message = "检测标准最小值不能为空")
    private BigDecimal minValue;

    @NotNull(message = "检测标准最大值不能为空")
    private BigDecimal maxValue;
}