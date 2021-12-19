package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Shop {
    private BigInteger shopId;
    private BigInteger ownerId;
    private String shopName;
    private String username;
    private String realName;
    private String telephone;
    private String password;
}
