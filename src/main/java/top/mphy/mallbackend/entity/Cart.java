package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Cart {
    private BigInteger cartId;
    private BigInteger productId;
    private Double discount;
    private BigInteger userId;
    private String imgSrc;
    private String productName;
    private Double productPrice;
    private Double weight;
    private BigInteger count;
}
