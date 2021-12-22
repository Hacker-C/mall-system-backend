package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.Comment;
import top.mphy.mallbackend.entity.DetailsComment;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CommentMapper {
    // *根据指定商品ID获取评论信息
    @Select("SELECT `comment_text`, username, avatar, comment_id FROM `comment`, `user` WHERE product_id=#{productId} AND `comment`.user_id=`user`.user_id")
    List<DetailsComment> findCommentsById(BigInteger productId);

    // 查询某个商品所有的评论数
    @Select("SELECT COUNT(*) FROM `comment` WHERE product_id=#{productId}")
    BigInteger getCountById(BigInteger productId);

    // 添加评论
    @Select("INSERT INTO `comment`(product_id,comment_text,user_id) VALUE(#{productId},#{commentText},#{userId})")
    void comment(Comment comment);

    // 删除评论
    @Delete("DELETE FROM `comment` WHERE comment_id=#{commentId}")
    void delete(BigInteger commentId);
}
