package com.study.springshiro.mapper;

import com.study.springshiro.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getByUsername(@Param("username") String username);
}
