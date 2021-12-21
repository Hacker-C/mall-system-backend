package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class Shop {
    private BigInteger shopId;
    private BigInteger ownerId;
    private String shopName;
    private String username;
    private String realName;
    private Timestamp createTime;
    private Double income;
    private String telephone;
    private String password;
}
