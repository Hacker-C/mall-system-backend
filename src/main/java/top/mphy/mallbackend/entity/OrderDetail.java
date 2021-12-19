package top.mphy.mallbackend.entity;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class OrderDetail {
    private Integer detailId;
    private String orderNumber;
    private BigInteger productId;
    private BigInteger count;
    private Timestamp createTime;
    private Timestamp updateTime;
}
