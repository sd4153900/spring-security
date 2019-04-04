package com.study.permission.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限模块表
 * </p>
 *
 * @author caad
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_acl_module")
public class AclModuleEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限模块名称
     */
    @TableField("name")
    private String name;

    /**
     * 上级权限模块id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 权限模块层级
     */
    @TableField("level")
    private String level;

    /**
     * 顺序
     */
    @TableField("seq")
    private Integer seq;

    /**
     * 状态，1：正常，0：冻结
     */
    @TableField("status")
    private Integer status;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
