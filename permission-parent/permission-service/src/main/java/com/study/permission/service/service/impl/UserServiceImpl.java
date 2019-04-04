package com.study.permission.service.service.impl;

import com.study.permission.model.entity.UserEntity;
import com.study.permission.model.mapper.UserMapper;
import com.study.permission.service.service.UserService;
import com.study.permission.service.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author caad
 * @since 2019-04-04
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserEntity> implements UserService {

}
