package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.*;
import top.mphy.mallbackend.entity.Like;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface LikeMapper {
    // 查询某用户收藏的所有商品
    @Select("SELECT like_id,product_name, product_price, p.product_id,like_time,discount,img_src FROM product AS p,`like` WHERE p.product_id=`like`.product_id AND `like`.user_id=#{userId}")
    List<Like> findAll(BigInteger userId);

    // 获取用户收藏商品的总数
    @Select("SELECT count(*) FROM `like` WHERE user_id=#{userId}")
    BigInteger count(BigInteger userId);

    // 用户删除某一天收藏夹商品
    @Delete("DELETE FROM `like` WHERE like_id=#{likeId}")
    void delete(BigInteger likeId);

    // 检验用户是否收藏了某个商品
    @Select("SELECT * FROM `like` WHERE product_id=#{productId} AND user_id=#{userId}")
    Like findById(@Param("productId") BigInteger productId, @Param("userId") BigInteger userId);

    // 用户添加收藏
    @Insert("INSERT INTO `like`(product_id, user_id) VALUE(#{productId}, #{userId})")
    void save(@Param("productId") BigInteger productId, @Param("userId") BigInteger userId);
}
