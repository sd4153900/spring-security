package com.study.permission.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author caad
 * @since 2019-04-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dept")
public class DeptEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 部门名称
     */
    @TableField("name")
    private String name;

    /**
     * 上级部门id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 部门层级
     */
    @TableField("level")
    private String level;

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
