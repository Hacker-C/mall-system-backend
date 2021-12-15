package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.Cart;
import top.mphy.mallbackend.mapper.CartMapper;

import java.math.BigInteger;
import java.util.List;

@Service
public class CartService {

    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public List<Cart> getCartById(BigInteger userId) {
        return cartMapper.getCartById(userId);
    }

    // 修改某一个购物车商品的数量
    public void setCartCount(BigInteger cartId, BigInteger count) {
        cartMapper.setCartCount(cartId, count);
    }

    // 获取某个用户的购物车信息的数量
    public BigInteger getCartCountById(BigInteger userId) {
        return cartMapper.getCartCountById(userId);
    }

    // 用户添加商品到购物车
    public void addToCart(BigInteger userId, BigInteger productId, BigInteger count) {
        cartMapper.addToCart(userId, productId, count);
    }

    // 检验用户是否收藏了某一件商品
    public Cart findCartItem(BigInteger userId, BigInteger productId) {
        return cartMapper.findCartItem(userId, productId);
    }

    //  删除某用户的某一条购物车商品信息
    public void deleteCartItem(BigInteger userId) {
        cartMapper.deleteCartItem(userId);
    }
}
