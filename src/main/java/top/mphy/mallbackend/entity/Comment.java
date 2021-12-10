package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Comment {
    private BigInteger commentId;
    private BigInteger productId;
    private String commentText;
}
