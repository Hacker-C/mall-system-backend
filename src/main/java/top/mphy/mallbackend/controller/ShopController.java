package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.Shop;
import top.mphy.mallbackend.service.ShopService;

import java.math.BigInteger;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseData<?> register(@RequestBody Shop shop) {
        BigInteger userId = shopService.getUserId(shop.getUsername());
        shop.setOwnerId(userId);
        shopService.addShop(shop);
        return ResponseDataUtils.buildSuccess("0", "注册并开店成功！请前往登录！");
    }

    // !获取shop信息
    @GetMapping("/{userId}")
    public ResponseData<?> findById(@PathVariable BigInteger userId) {
        Shop shop = shopService.findById(userId);
        return ResponseDataUtils.buildSuccess("0", "获取店铺信息成功！", shop);
    }

    // !根据shop_id获取店铺信息
    @GetMapping("/shop_id/{shopId}")
    public ResponseData<?> findByShopId(@PathVariable BigInteger shopId) {
        Shop shop = shopService.findByShopId(shopId);
        return ResponseDataUtils.buildSuccess("0", "获取店铺信息成功！", shop);
    }

}
