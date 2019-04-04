package com.study.permission.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author caad
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 电话号码
     */
    @TableField("telephone")
    private String telephone;

    /**
     * 邮箱
     */
    @TableField("mail")
    private String mail;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 部门id
     */
    @TableField("dept_id")
    private Integer deptId;

    /**
     * 状态,1：正常，0：冻结，2：删除状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
