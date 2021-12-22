package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PayInfo {
    private BigInteger userId;
    private Double payMoney;
    private String orderNumber;
}
