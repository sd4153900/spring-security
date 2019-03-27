package com.study.springshiro.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Role {

    private int rid;

    private String name;

    private Set<Permission> permissions = new HashSet<>();

    private Set<User> users = new HashSet<>();


}
