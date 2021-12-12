package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mphy.mallbackend.entity.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM `user` WHERE `username`=#{username}")
    User getUserByUsername(String username);
}
