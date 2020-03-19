package com.nongxin.terminal.entity.base;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author nongxin
 * @since 2019-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nx_standard_type")
public class StandardType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "value", type = IdType.AUTO)
    private Integer value;

    /**
     * 检测项目
     */
    @NotNull(message = "检测项目不能为空")
    private String displayName;

    private String code;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String remark;


}
