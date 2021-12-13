package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.User;

import java.math.BigInteger;

@Mapper
public interface UserMapper {
    // 验证登录
    @Select("SELECT * FROM `user` WHERE `username`=#{username}")
    User getUserByUsername(String username);

    // 用户注册插入数据
    @Select("INSERT INTO `user`(username, `password`) VALUES (#{username}, #{password})")
    void save(User user);

    // 根据userId获取用户信息
    @Select("SELECT * FROM `user` WHERE user_id=#{userId}")
    User getUserById(BigInteger userId);
}
