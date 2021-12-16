package top.mphy.mallbackend.controller;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.User;
import top.mphy.mallbackend.service.UserService;
import top.mphy.mallbackend.vo.Page;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // !获取所有用户信息
    // GET: 分页查询
    @GetMapping
    public ResponseData findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String key) {
        int offset = (pageNum - 1) * pageSize;
        List<User> userData = userService.findByPage(offset, pageSize, key);
        Page<User> page = new Page<>();
        page.setData(userData);
        Integer total = userService.countUser();
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return ResponseDataUtils.buildSuccess("0", "用户信息获取成功！", page);
    }


    // !登录验证
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

    // !注册验证
    // TODO 普通用户注册，未来还要写商家注册
    @PostMapping("/register")
    public ResponseData userRegister(@RequestBody User queryUser) {
        // 根据前端传来的注册用户名查询用户名是否重复
        User user = userService.getUserByUsername(queryUser.getUsername());
        // 用户名重复，禁止注册
        if (user != null) {
            return ResponseDataUtils.buildSuccess("1", "该用户名已被使用！");
        }
        userService.userRegister(queryUser);
        return ResponseDataUtils.buildSuccess("0", "注册成功！");
    }

    // !根据用户ID获取用户信息
    @GetMapping("/{userId}")
    public ResponseData getUserById(@PathVariable("userId")BigInteger userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseDataUtils.buildSuccess("1", "未查询到该用户！");
        }
        return ResponseDataUtils.buildSuccess("0", "查询用户信息成功！", user);
    }

    // !更新用户信息
    @PutMapping("/{id}")
    public ResponseData getUserById(@PathVariable("id")BigInteger id, @RequestBody User user) {
        user.setUserId(id);
        userService.updateUser(user);
        return ResponseDataUtils.buildSuccess("0", "修改用户信息成功！");
    }

    // !更新用户状态
    @PatchMapping("/{userId}/{status}")
    public ResponseData changeStatus(@PathVariable("userId") BigInteger userId, @PathVariable("status") BigInteger status) {
        userService.setStatus(userId, status);
        return ResponseDataUtils.buildSuccess("0", "修改用户信息成功！");
    }

    // !更新账户信息
    @PostMapping("/account")
    public ResponseData updateAccount(@RequestBody User user) {
        userService.updateAccount(user);
        return ResponseDataUtils.buildSuccess("0", "修改账户信息成功！");
    }
}
