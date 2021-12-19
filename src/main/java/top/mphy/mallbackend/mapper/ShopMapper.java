package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.Shop;

import java.math.BigInteger;

@Mapper
public interface ShopMapper {

    @Insert("INSERT INTO shop(shop_name, username, owner_id) VALUE(#{shopName}, #{username}, #{ownerId})")
    void addShop(Shop shop);

    // !根据用户名获取用户ID
    @Select("SELECT user_id FROM user WHERE username=#{username}")
    BigInteger getUserId(String username);
}
