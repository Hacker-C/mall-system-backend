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

    // 根据用户ID获取其所有购物车信息
    @GetMapping("/{userId}")
    public ResponseData getCartById(@PathVariable("userId") BigInteger userId) {
        List<Cart> carts = cartService.getCartById(userId);
        return ResponseDataUtils.buildSuccess("0", "购物车信息获取成功！", carts);
    }

    // 修改某一个购物车商品的数量
    @PatchMapping("/{cartId}")
    public ResponseData setCartCount(@PathVariable("cartId") BigInteger cartId, @RequestBody Cart cart) {
        cartService.setCartCount(cartId, cart.getCount());
        return ResponseDataUtils.buildSuccess("0", "购物车信息修改成功");
    }

    // 根据用户ID获取购物车信息条数
    @GetMapping("/count/{userId}")
    public BigInteger getCartCount(@PathVariable("userId") BigInteger userId) {
        return cartService.getCartCountById(userId);
    }

    // 用户添加商品到购物车
    @PostMapping
    public ResponseData addToCart(@RequestBody Cart user) {
        BigInteger userId = user.getUserId();
        BigInteger productId = user.getProductId();
        Cart cart = cartService.findCartItem(userId, productId);
        if (cart != null) {
            return ResponseDataUtils.buildSuccess("1", "您已将该商品加入购物车！");
        }
        cartService.addToCart(userId, productId);
        return ResponseDataUtils.buildSuccess("0", "成功加入到购物车！");
    }
}
