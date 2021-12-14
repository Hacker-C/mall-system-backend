package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
}
