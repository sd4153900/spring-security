package com.study.permission.service.service;

import com.study.permission.model.dto.DeptTreeDto;
import com.study.permission.model.entity.DeptEntity;
import com.study.permission.model.form.DeptForm;
import com.study.permission.service.service.BaseService;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author caad
 * @since 2019-04-04
 */
public interface DeptService extends BaseService<DeptEntity> {

    DeptEntity save(DeptForm deptForm);

    List<DeptTreeDto> getDeptTree();

}
