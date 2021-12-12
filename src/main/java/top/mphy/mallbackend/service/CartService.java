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

}
