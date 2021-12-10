package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ProductCategory {
    private BigInteger categoryId;
    private String categoryName;
}
