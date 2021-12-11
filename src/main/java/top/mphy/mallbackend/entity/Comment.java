package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class Comment {
    private BigInteger commentId;
    private BigInteger productId;
    private String commentText;
    private Timestamp commentTime;
    private BigInteger userId;
}
