package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.DetailsComment;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CommentMapper {
    // *根据指定商品ID获取评论信息
    @Select("SELECT `comment_text`, username, avatar FROM `comment`, `user` WHERE product_id=#{productId} AND `comment`.user_id=`user`.user_id")
    List<DetailsComment> findCommentsById(BigInteger productId);

    // 查询某个商品所有的评论数
    @Select("SELECT COUNT(*) FROM `comment` WHERE product_id=#{productId}")
    BigInteger getCountById(BigInteger productId);

}
