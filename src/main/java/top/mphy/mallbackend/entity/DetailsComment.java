package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class DetailsComment {
    private BigInteger commentId;
    private String commentText;
    private String username;
    private String avatar;
}
