package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.Cart;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CartMapper {
    @Select("SELECT cart_id, img_src, product_name, product_price, count FROM cart, product WHERE user_id=#{userId} AND cart.product_id=product.product_id")
    List<Cart> getCartById(BigInteger userId);
}
