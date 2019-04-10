package com.study.permission.model.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author caad
 * @date: Create in 15:16 2019/4/9
 */
@ApiModel(value = "DeptForm",description = "部门信息")
@Data
public class DeptForm {

    @ApiModelProperty(value = "部门id",name = "id",dataType = "Integer")
    private Integer id;

    @ApiModelProperty(value = "部门名",name = "name",dataType = "String",required = true)
    @NotBlank(message = "部门名不能为空")
    @Length(max = 15,min = 2,message = "部门名长度2-15")
    private String name;

    @ApiModelProperty(value = "父部门id",name = "parentId",dataType = "Integer")
    private Integer parentId;

    @ApiModelProperty(value = "顺序",name = "seq",dataType = "Integer",required = true)
    @NotNull(message = "顺序不能为空")
    private Integer seq;

    @ApiModelProperty(value = "部门id",name = "remark",dataType = "Integer")
    @Length(max = 150,message = "备注长度小于150")
    private String remark;
}
