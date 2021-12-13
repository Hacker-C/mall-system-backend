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
    // 获取某个用户的所有购物车信息
    @Select("SELECT cart_id, cart.product_id, img_src, product_name, product_price, count FROM cart, product WHERE user_id=#{userId} AND cart.product_id=product.product_id")
    List<Cart> getCartById(BigInteger userId);

    // 修改某一个购物车商品的数量
    @Update("UPDATE cart SET count=#{count} WHERE cart_id=#{cartId}")
    void setCartCount(@Param("cartId") BigInteger cartId, @Param("count") BigInteger count);

    // 获取某个用户的购物车信息的数量
    @Select("SELECT COUNT(*) FROM cart WHERE user_id=#{userId}")
    BigInteger getCartCountById(BigInteger userId);

    // 用户添加商品到购物车
    @Select("INSERT INTO cart(user_id, product_id, count) VALUE(#{userId}, #{productId}, #{count})")
    void addToCart(@Param("userId") BigInteger userId, @Param("productId") BigInteger productId, @Param("count") BigInteger count);

    // 检验用户是否收藏了某一件商品
    @Select("SELECT * FROM cart WHERE user_id=#{userId} AND product_id=#{productId}")
    Cart findCartItem(@Param("userId") BigInteger userId, @Param("productId") BigInteger productId);
}
