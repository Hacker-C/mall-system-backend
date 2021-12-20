package top.mphy.mallbackend.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import top.mphy.mallbackend.entity.Shop;
import top.mphy.mallbackend.entity.User;
import top.mphy.mallbackend.mapper.UserMapper;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 获取所有用户信息
    public List<User> findByPage(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("key") String key) {
        return userMapper.findByPage(offset, pageSize, key);
    }

    // 获取所有商家信息
    public List<User> findShopsByPage(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("key") String key) {
        return userMapper.findShopsByPage(offset, pageSize, key);
    }

        // !修改用户状态
    public void setStatus(BigInteger userId, BigInteger status) {
        userMapper.setStatus(userId, status);
    }

    // !获取用户数量
    public Integer countUser() {
        return userMapper.countUser();
    }

    // !获取店家数量
    public Integer countShops() {
        return userMapper.countShops();
    }



    // 登录验证，根据用户名查询用户
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    // 注册验证
    public void userRegister(User user) {
        userMapper.save(user);
    }

    // 根据用户ID获取用户信息
    public User getUserById(BigInteger userId) {
        return userMapper.getUserById(userId);
    }

    // 更新用户基本信息
    public void updateUser(@RequestBody User user) {
        userMapper.updateUser(user);
    }

    // 更新账户信息
    public void updateAccount(@RequestBody User user) {
        userMapper.updateAccount(user);
    }

    // 重置密码
    public void reset(BigInteger userId) {
        userMapper.reset(userId);
    }

    // 删除用户
    public void delete(BigInteger userId) {
        userMapper.delete(userId);
        Shop shop = userMapper.checkShop(userId);
        if (shop != null) {
            userMapper.deleteP(userId);
            userMapper.deleteS(userId);
        }
    }

    // 添加新用户
    public void addNew(User user) {
        userMapper.add(user);
    }

    // 用户充值
    public void recharge(BigInteger userId, Double addMoney) {
        userMapper.recharge(userId, addMoney);
    }

    // 店家注册
    public void shopRegister(Shop shop) {
        userMapper.shopRegister(shop);
    }


}
