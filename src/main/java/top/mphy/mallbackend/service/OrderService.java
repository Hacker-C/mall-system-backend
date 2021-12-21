package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.OrderDetail;
import top.mphy.mallbackend.entity.OrderMaster;
import top.mphy.mallbackend.mapper.OrderMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void addOrderMaster(OrderMaster orderMaster) {
        orderMapper.save(orderMaster);
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderMapper.add(orderDetail);
    }

    public List<OrderMaster> findById(BigInteger buyerId) {
        return orderMapper.findById(buyerId);
    }

    public BigInteger getCount(BigInteger userId) {
        return orderMapper.count(userId);
    }

    public void deleteO(String orderNumber) {
        orderMapper.deleteO(orderNumber);
    }

    public void deleteP(String orderNumber) {
        orderMapper.deleteP(orderNumber);
    }


}
