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
}
