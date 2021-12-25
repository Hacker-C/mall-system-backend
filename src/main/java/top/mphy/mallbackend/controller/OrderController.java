package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.OrderDetail;
import top.mphy.mallbackend.entity.OrderMaster;
import top.mphy.mallbackend.entity.PayInfo;
import top.mphy.mallbackend.entity.Product;
import top.mphy.mallbackend.service.OrderService;
import top.mphy.mallbackend.vo.Page;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "http://119.23.46.102:8081", maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // !添加一条订单
    @PostMapping("/master")
    public ResponseData<?> addOrderMaster(@RequestBody OrderMaster orderMaster) {
        orderService.addOrderMaster(orderMaster);
        return ResponseDataUtils.buildSuccess("0", "订单提交成功！");
    }

    // !保存订单信息中每一天商品信息
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

    // !获取用户订单数
    @GetMapping("/count/{userId}")
    public  ResponseData<?> getOrderCount(@PathVariable BigInteger userId) {
        BigInteger count =  orderService.getCount(userId);
        return ResponseDataUtils.buildSuccess("0", "获取订单数成功！", count);
    }

    // !删除订单
    @DeleteMapping("/{orderNumber}")
    public ResponseData<?> deleteOrder(@PathVariable String orderNumber) {
//        orderService.deleteP(orderNumber);
        orderService.deleteO(orderNumber);
        return ResponseDataUtils.buildSuccess("0", "订单删除成功！");
    }

    // !取消订单
    @PatchMapping("/cancel/{orderNumber}")
    public ResponseData<?> cancel(@PathVariable String orderNumber) {
        orderService.cancel(orderNumber);
        return ResponseDataUtils.buildSuccess("0", "订单取消成功！");
    }

    // !发货
    @PatchMapping("/send/{orderNumber}")
    public ResponseData<?> send(@PathVariable String orderNumber) {
        orderService.send(orderNumber);
        return ResponseDataUtils.buildSuccess("0", "发货成功！");
    }

    // !支付
    @PostMapping("/pay")
    public ResponseData<?> pay(@RequestBody PayInfo payInfo) {
        BigInteger userId = payInfo.getUserId();
        String orderNumber = payInfo.getOrderNumber();
        Double payMoney = payInfo.getPayMoney();
        Double leftMoney = orderService.getUserMoney(userId);
        if (leftMoney < payInfo.getPayMoney()) {
            return ResponseDataUtils.buildSuccess("1", "账户余额不足，请充值！");
        }

        // !设置为支付状态（待收货）
        orderService.pay(orderNumber, userId, payMoney);
        return ResponseDataUtils.buildSuccess("0", "支付成功！");
    }

    // !分页查询
    @GetMapping("/shop")
    public ResponseData<?> findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                      @RequestParam BigInteger shopId) {
        int offset = (pageNum - 1) * pageSize;
        List<OrderMaster> userData = orderService.findByPage(offset, pageSize, shopId);
        Page<OrderMaster> page = new Page<>();
        page.setData(userData);
        Integer total = orderService.countShopOrder(shopId);
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return ResponseDataUtils.buildSuccess("0", "订单信息获取成功！", page);
    }

}
