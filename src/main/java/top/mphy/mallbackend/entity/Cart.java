package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Cart {
    private BigInteger cartId;
    private BigInteger productId;
    private String imgSrc;
    private String productName;
    private Double productPrice;
    private BigInteger count;
}
