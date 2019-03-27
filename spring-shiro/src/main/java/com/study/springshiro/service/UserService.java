package com.study.springshiro.service;

import com.study.springshiro.model.User;

public interface UserService {

    User getByUsername(String username);
}
