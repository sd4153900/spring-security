package com.study.permission.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author caad
 * @date: Create in 12:59 2019/4/3
 */
@Data
public class BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;

    @TableField(value = "operator")
    private String operator;

    @TableField(value = "operator_time")
    private LocalDateTime operatorTime;

    @TableField(value = "operator_ip")
    private String operatorIp;

}
