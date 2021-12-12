package top.mphy.mallbackend.service;

import org.springframework.stereotype.Service;
import top.mphy.mallbackend.entity.User;
import top.mphy.mallbackend.mapper.UserMapper;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 登录验证，根据用户名查询用户
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    // 注册验证
    public void userRegister(User user) {
        userMapper.save(user);
    }

}
