package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.OrderDetail;
import top.mphy.mallbackend.entity.OrderMaster;
import top.mphy.mallbackend.mapper.OrderMapper;

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

}
