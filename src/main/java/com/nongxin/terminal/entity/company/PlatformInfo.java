package com.nongxin.terminal.entity.company;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.util.enumUtil.base.SoilTypeEnum;
import com.nongxin.terminal.util.enumUtil.common.PlatformTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 平台信息
 * </p>
 *
 * @author nongxin
 * @since 2019-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

@TableName("nx_platform_info")
public class PlatformInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 网页title
     */
    private String title;

    /**
     * 底注名称
     */
    private String copyright;

    /**
     * icp备案号
     */
    private String icp;

    /**
     * 平台类型：1、看板 2、后台
     */
    private Integer type;

    @TableField(exist = false)
    private String platformName ;

    @TableField(exist = false)
    private PictureInfo ico;

    public String getPlatformName() {
        return PlatformTypeEnum.getByValue(type).getName();
    }

    public void setPlatformName(String platformName) {
        this.platformName = PlatformTypeEnum.getByValue(type).getName();
    }
}
