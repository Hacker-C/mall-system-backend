package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.User;

@Mapper
public interface UserMapper {
    // 验证登录
    @Select("SELECT * FROM `user` WHERE `username`=#{username}")
    User getUserByUsername(String username);

    // 用户注册插入数据
    @Select("INSERT INTO `user`(username, `password`) VALUES (#{username}, #{password})")
    void save(User user);
}
