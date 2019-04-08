package com.study.permission.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author caad
 * @date: Create in 12:59 2019/4/3
 */
@Data
public class BaseEntity implements Serializable {

    @Min(1)
    @TableId(type = IdType.AUTO)
    private int id;

    @TableField(value = "operator")
    private String operator;

    @TableField(value = "operator_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime operatorTime;

    @TableField(value = "operator_ip")
    private String operatorIp;

}
