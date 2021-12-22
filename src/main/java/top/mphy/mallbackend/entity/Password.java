package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Password {
    private BigInteger userId;
    private String passWord;
    private String newPassword;
}
