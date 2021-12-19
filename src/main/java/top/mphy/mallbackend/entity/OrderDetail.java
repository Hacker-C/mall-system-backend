package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class OrderDetail {
    private String imgSrc;
    private String productName;
    private Double productPrice;
    private BigInteger count;
    // 某一件订单中一类商品的总额
    private Double orderProductPrice;
}
