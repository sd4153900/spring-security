package com.study.springshiro.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private int uid;

    private String username;

    private String password;

    private Set<Role> roles = new HashSet<>();
}
