package com.example.mybatis.model;

import lombok.Data;

@Data
public class User {
    /**
     * 对应数据库 user.id
     */
    private Integer id;

    /**
     * 对应数据库 user.name
     */
    private String name;

    /**
     * 对应数据库 user.telephone
     */
    private String telephone;
}