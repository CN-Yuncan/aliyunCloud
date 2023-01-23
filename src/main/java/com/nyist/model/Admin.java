package com.nyist.model;

import lombok.Data;

@Data
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;

}
