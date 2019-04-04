package com.study.permission.service.service.impl;

import com.study.permission.model.entity.RoleUserEntity;
import com.study.permission.model.mapper.RoleUserMapper;
import com.study.permission.service.service.RoleUserService;
import com.study.permission.service.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色用户关联表 服务实现类
 * </p>
 *
 * @author caad
 * @since 2019-04-04
 */
@Service
public class RoleUserServiceImpl extends BaseServiceImpl<RoleUserMapper, RoleUserEntity> implements RoleUserService {

}
