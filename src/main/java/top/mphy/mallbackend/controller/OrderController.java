package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.OrderDetail;
import top.mphy.mallbackend.entity.OrderMaster;
import top.mphy.mallbackend.service.OrderService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/master")
    public ResponseData<?> addOrderMaster(@RequestBody OrderMaster orderMaster) {
        orderService.addOrderMaster(orderMaster);
        return ResponseDataUtils.buildSuccess("0", "订单提交成功！");
    }

    @PostMapping("/detail")
    public ResponseData<?> addOrderDetail(@RequestBody OrderDetail orderDetail) {
        orderService.addOrderDetail(orderDetail);
        return ResponseDataUtils.buildSuccess("0", "订单商品保存成功！");
    }

    // !获取用户所有订单
    @GetMapping("/{buyerId}")
    public ResponseData<?> findById(@PathVariable BigInteger buyerId) {
        List<OrderMaster> orderMasters = orderService.findById(buyerId);
        return ResponseDataUtils.buildSuccess("0", "订单信息获取成功！", orderMasters);
    }

}
