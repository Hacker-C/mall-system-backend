package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class User {
    private BigInteger userId;
    private String username;
    private String password;
    private String realName;
    private int role;
    // 用户状态，0禁止登录，1可以登陆
    private int status;
    private String avatar;
    private int age;
    private String sex;
    private String address;
    private String telephone;
}
