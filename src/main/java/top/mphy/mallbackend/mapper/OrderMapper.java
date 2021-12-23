package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.*;
import top.mphy.mallbackend.entity.OrderDetail;
import top.mphy.mallbackend.entity.OrderMaster;
import top.mphy.mallbackend.entity.Product;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface OrderMapper {

    // !添加一条订单信息
    @Select("INSERT INTO order_master(order_number,buyer_id, order_amount, shop_id) VALUE(#{orderNumber}, #{buyerId}, #{orderAmount}, #{shopId})")
    void save(OrderMaster orderMaster);

    // !添加订单信息中每一条商品
    @Insert("INSERT INTO order_detail(order_number,product_id,count) VALUE(#{orderNumber}, #{productId}, #{count})")
    void add(OrderDetail orderDetail);

    // !获取某用户得全部订单信息
    @Select("SELECT * FROM order_master WHERE buyer_id=#{buyerId} AND order_status<4")
    List<OrderMaster> findById(BigInteger buyerId);

    // !根据用户id获取订单数，可修改为待付款的订单数
    @Select("SELECT count(*) FROM order_master WHERE buyer_id=#{userId} AND order_status<4")
    BigInteger count(BigInteger userId);

    // !删除订单信息
    @Delete("UPDATE order_master SET order_status=4 WHERE order_number=#{orderNumber}")
    void deleteO(String orderNumber);

    // !删除订单详情中的所有商品
    @Delete("DELETE FROM order_detail WHERE order_number=#{orderNumber}")
    void deleteP(String orderNumber);

    // !取消订单
    @Update("UPDATE order_master SET order_status=2 WHERE order_number=#{orderNumber}")
    void cancel(String orderNumber);

    // !发货
    @Update("UPDATE order_master SET order_status=3 WHERE order_number=#{orderNumber}")
    void send(String orderNumber);

    // !获取用户余额
    @Select("SELECT money FROM `user` WHERE user_id=#{userId}")
    Double getUserMoney(BigInteger userId);

    // !支付
    @Update("UPDATE order_master SET order_status=1 WHERE order_number=#{orderNumber}")
    void setPayStatus(String orderNumber);

    // !扣去用户账户余额
    @Update("UPDATE `user` SET money=money-#{payMoney} WHERE user_id=#{userId}")
    void pay(@Param("payMoney") Double payMoney, @Param("userId") BigInteger userId);

    // TODO 店铺总收入增加

    // !获取店家订单
    // !分页查询
    // SELECT * FROM order_master WHERE shop_id=1
    @Select("SELECT * FROM order_master WHERE shop_id=#{shopId} limit #{offset},#{pageSize}")
    List<OrderMaster> findByPage(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("shopId") BigInteger shopId);

    // !获取订单数
    @Select("SELECT count(*) FROM order_master WHERE shop_id=#{shopId}")
    Integer countShopOrder(BigInteger shopId);

}
