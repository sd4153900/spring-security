package com.study.permission.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author caad
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_acl")
public class AclEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限码
     */
    @TableField("code")
    private String code;

    /**
     * 权限名称
     */
    @TableField("name")
    private String name;

    /**
     * 权限模块id
     */
    @TableField("acl_model_id")
    private Integer aclModelId;

    /**
     * 请求url
     */
    @TableField("url")
    private String url;

    /**
     * 类型，1：菜单，2：按钮，3：其他
     */
    @TableField("type")
    private Integer type;

    /**
     * 状态，1：正常，0：冻结
     */
    @TableField("status")
    private Integer status;

    /**
     * 顺序
     */
    @TableField("seq")
    private Integer seq;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
