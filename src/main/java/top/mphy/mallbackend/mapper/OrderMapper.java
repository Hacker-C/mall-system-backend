package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.OrderDetail;
import top.mphy.mallbackend.entity.OrderMaster;

@Mapper
public interface OrderMapper {

    // !添加一条订单信息
    @Select("INSERT INTO order_master(order_number,buyer_id, order_amount) VALUE(#{orderNumber}, #{buyerId}, #{orderAmount})")
    void save(OrderMaster orderMaster);

    // !添加订单信息中每一条商品
    @Insert("INSERT INTO order_detail(order_number,product_id,count) VALUE(#{orderNumber}, #{productId}, #{count})")
    void add(OrderDetail orderDetail);
}
