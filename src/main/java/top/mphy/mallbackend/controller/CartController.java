package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mphy.mallbackend.entity.Cart;
import top.mphy.mallbackend.service.CartService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public List<Cart> getCartById(@PathVariable("userId")BigInteger userId) {
        return cartService.getCartById(userId);
    }

}
