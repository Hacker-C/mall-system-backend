package top.mphy.mallbackend.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
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
    public ResponseData getCartById(@PathVariable("userId") BigInteger userId) {
        List<Cart> carts = cartService.getCartById(userId);
        return ResponseDataUtils.buildSuccess("0", "购物车信息获取成功！", carts);
    }

    @PatchMapping("/{cartId}")
    public ResponseData setCartCount(@PathVariable("cartId") BigInteger cartId, @RequestBody Cart cart) {
        cartService.setCartCount(cartId, cart.getCount());
        return ResponseDataUtils.buildSuccess("0", "购物车信息修改成功");
    }
}
