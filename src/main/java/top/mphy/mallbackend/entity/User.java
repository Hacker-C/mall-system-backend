package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class User {
    private BigInteger userId;
    private String username;
    private String password;
    private String realName;
    // 客户：user, 管理员：admin，商家：shop
    private String role;
    // 用户状态，0禁止登录，1可以登陆
    private int status;
    private String avatar;
    private int age;
    private String sex;
    private String address;
    private String telephone;
    // 用户剩余资金，用于购买商品
    private double money;
    // 账号注册时间
    private Timestamp createTime;
    private String email;
    // 软删除，1表示删除，0表示未删除
    private Integer isDeleted;
}
