package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.Shop;
import top.mphy.mallbackend.mapper.ShopMapper;

import java.math.BigInteger;

@Service
public class ShopService {
    private final ShopMapper shopMapper;

    public ShopService(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public void addShop(Shop shop) {
        shopMapper.addShop(shop);
    }

    //
    public BigInteger getUserId(String username) {
        return shopMapper.getUserId(username);
    }

    //
    public Shop findById(BigInteger userId) {
        return shopMapper.findById(userId);
    }
}
