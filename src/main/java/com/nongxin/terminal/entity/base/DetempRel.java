package com.nongxin.terminal.entity.base;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author nongxin
 * @since 2019-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nx_detemp_rel")
public class DetempRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 基地检测模板id
     */
    private Integer templateId;

    /**
     * 基地检测id
     */
    private Integer envStandardsId;


}
