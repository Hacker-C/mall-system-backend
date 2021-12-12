package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.mphy.mallbackend.entity.Cart;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CartMapper {
    //
    @Select("SELECT cart_id, img_src, product_name, product_price, count FROM cart, product WHERE user_id=#{userId} AND cart.product_id=product.product_id")
    List<Cart> getCartById(BigInteger userId);

    // 修改某一个购物车商品的数量
    @Update("UPDATE cart SET count=#{count} WHERE cart_id=#{cartId}")
    void setCartCount(@Param("cartId") BigInteger cartId, @Param("count") BigInteger count);
}
