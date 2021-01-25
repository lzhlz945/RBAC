package com.zhang.zc.bean;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String userAccount;
    private String password;
    private String username;
    private String email;
    private List<Role> role;
    private List<Urid> urid;
}
