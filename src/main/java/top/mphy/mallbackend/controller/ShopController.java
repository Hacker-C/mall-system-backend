package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.Shop;
import top.mphy.mallbackend.service.ShopService;
import top.mphy.mallbackend.service.UserService;

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
        shopService.addShop(shop);
        BigInteger userId = shopService.getUserId(shop.getUsername());
        shop.setOwnerId(userId);
        return ResponseDataUtils.buildSuccess("0", "注册并开店成功！请前往登录！");
    }

}
