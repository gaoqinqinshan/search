package com.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实例化
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;

    private String username;

    private String password;

    private String token;
}
