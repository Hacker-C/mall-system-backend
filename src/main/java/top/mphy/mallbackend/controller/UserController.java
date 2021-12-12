package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.User;
import top.mphy.mallbackend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseData login(@RequestBody User queryUser) {
        // queryUser: 前端传过来的用户对象
        User user =  userService.getUserByUsername(queryUser.getUsername());
        if (user == null) {
            return  ResponseDataUtils.buildSuccess("3", "此用户不存在！");
        }
        if (!user.getPassword().equals(queryUser.getPassword())) {
            return ResponseDataUtils.buildSuccess("2", "用户名或密码错误！");
        }
        if (user.getStatus() == 0) {
            return ResponseDataUtils.buildSuccess("1", "该账号已被拉黑，请联系管理员解禁！");
        }
        return ResponseDataUtils.buildSuccess("0", "登录成功！", user);
    }
}
