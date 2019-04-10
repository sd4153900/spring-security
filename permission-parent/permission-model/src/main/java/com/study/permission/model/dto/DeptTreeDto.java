package com.study.permission.model.dto;

import com.google.common.collect.Lists;
import com.study.permission.model.entity.DeptEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author caad
 * @date: Create in 17:21 2019/4/9
 */
@Data
public class DeptTreeDto extends DeptEntity {

    private List<DeptTreeDto> deptTreeDtoList = Lists.newArrayList();

    public DeptTreeDto(DeptEntity deptEntity){
        BeanUtils.copyProperties(deptEntity,this);
    }

}
