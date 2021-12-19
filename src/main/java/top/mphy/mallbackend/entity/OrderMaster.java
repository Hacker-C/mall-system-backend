package top.mphy.mallbackend.entity;

import lombok.Data;

@Data
public class OrderMaster {
    private Integer orderId;
    // 顶单编号，前端生成
    private String orderNumber;
    // 客户ID
    private Integer buyerId;
    // 此次订单总金额
    private Double orderAmount;
    // 订单状态：0表示未支付，1表示未发货，2表示已发货，3表示已完成
    private Integer orderStatus;
}
