package com.study.permission.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色用户关联表
 * </p>
 *
 * @author caad
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role_user")
public class RoleUserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;


}
