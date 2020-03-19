package com.nongxin.terminal.entity.base;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
 * @since 2019-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nx_basetemplate_rel")
public class BasetemplateRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 基地id
     */
    @NotNull(message = "基地id不能为空")
    private Integer baseId;

    /**
     * 检测模板id
     */
    @NotNull(message = "检测模板id不能为空")
    private Integer templateId;


}
