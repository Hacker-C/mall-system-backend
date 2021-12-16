package top.mphy.mallbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestBody;
import top.mphy.mallbackend.entity.User;

import java.math.BigInteger;
import java.util.List;

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

    // !更新用户基本信息
    @Update({"<script>",
            "update user",
            "  <set>",
            "    <if test='username != null'>username=#{username},</if>",
            "    <if test='telephone != null'>telephone=#{telephone},</if>",
            "    <if test='address != null'>address=#{address},</if>",
            "    <if test='sex != null'>sex=#{sex},</if>",
            "    <if test='age != 0'>age=#{age},</if>",
            "    <if test='realName != null'>real_name=#{realName},</if>",
            "    <if test='email != null'>email=#{email},</if>",
            "  </set>",
            "where user_id=#{userId}",
            "</script>"})
    void updateUser(@RequestBody User user);

    // !更新用户账号信息
    @Update({"<script>",
            "update user",
            "  <set>",
            "    <if test='username != null'>username=#{username},</if>",
            "    <if test='telephone != null'>telephone=#{telephone},</if>",
            "    <if test='realName != null'>real_name=#{realName},</if>",
            "    <if test='role != null'>role=#{role},</if>",
            "  </set>",
            "where user_id=#{userId}",
            "</script>"})
    void updateAccount(@RequestBody User user);

    // 获取用户数量
    @Select("SELECT count(*) FROM `user`")
    Integer countUser();

    // !分页查询获取所有用户信息
    @Select("select * from user where concat(user_id,' ', username,' ', real_name,' ', telephone,' ', role,' ', status) like '%${key}%' limit #{offset},#{pageSize}")
    List<User> findByPage(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("key") String key);

    // !修改用户状态
    @Select("UPDATE `user` SET `status`=#{status} WHERE user_id=#{userId}")
    void setStatus(@Param("userId") BigInteger userId, @Param("status") BigInteger status);
}
