package top.mphy.mallbackend.controller;

import org.springframework.web.bind.annotation.*;
import top.mphy.mallbackend.common.ResponseData;
import top.mphy.mallbackend.common.ResponseDataUtils;
import top.mphy.mallbackend.entity.Password;
import top.mphy.mallbackend.entity.RoleCount;
import top.mphy.mallbackend.entity.Shop;
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
    // !GET: 分页查询
    @GetMapping
    public ResponseData<?> findByPage( @RequestParam(defaultValue = "user") String flag,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String key) {
//        System.out.println(flag);

        int offset = (pageNum - 1) * pageSize;
        List<User> userData;
        Integer total;
        if (flag.equals("shop")) {
            userData = userService.findShopsByPage(offset, pageSize, key);
            total = userService.countShops();
        } else {
            userData = userService.findByPage(offset, pageSize, key);
            total = userService.countUser();
        }
        Page<User> page = new Page<>();
        page.setData(userData);
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return ResponseDataUtils.buildSuccess("0", "用户信息获取成功！", page);
    }


    // !登录验证
    @PostMapping("/login")
    public ResponseData<?> login(@RequestBody User queryUser) {
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

    // !普通用户注册
    @PostMapping("/register")
    public ResponseData<?> userRegister(@RequestBody User queryUser) {
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
    public ResponseData<?> getUserById(@PathVariable("userId")BigInteger userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseDataUtils.buildSuccess("1", "未查询到该用户！");
        }
        return ResponseDataUtils.buildSuccess("0", "查询用户信息成功！", user);
    }

    // !更新用户信息
    @PutMapping("/{id}")
    public ResponseData<?> getUserById(@PathVariable("id")BigInteger id, @RequestBody User user) {
        user.setUserId(id);
        userService.updateUser(user);
        return ResponseDataUtils.buildSuccess("0", "修改用户信息成功！");
    }

    // !更新用户状态
    @PatchMapping("/{userId}/{status}")
    public ResponseData<?> changeStatus(@PathVariable("userId") BigInteger userId, @PathVariable("status") BigInteger status) {
        userService.setStatus(userId, status);
        return ResponseDataUtils.buildSuccess("0", "修改用户信息成功！");
    }

    // !更新账户信息
    @PostMapping("/account")
    public ResponseData<?> updateAccount(@RequestBody User user) {
        userService.updateAccount(user);
        return ResponseDataUtils.buildSuccess("0", "修改账户信息成功！");
    }

    // !重置密码
    @PatchMapping("/reset/{userId}")
    public ResponseData<?> reset(@PathVariable("userId") BigInteger userId) {
        userService.reset(userId);
        return ResponseDataUtils.buildSuccess("0", "重置密码成功！");
    }

    // !删除用户（软删除）
    @DeleteMapping("/{userId}")
    public ResponseData<?> delete(@PathVariable("userId") BigInteger userId) {
        userService.delete(userId);
        return ResponseDataUtils.buildSuccess("0", "删除用户成功！");
    }

    // !添加新用户
    @PostMapping("/add")
    public ResponseData<?> addNew(@RequestBody User user) {
        userService.addNew(user);
        return ResponseDataUtils.buildSuccess("0", "添加新用户成功！");
    }

    // !充值
    @PatchMapping("/recharge")
    public ResponseData<?> recharge(@RequestBody User user) {
        BigInteger userId = user.getUserId();
        Double addMoney = user.getMoney();
        System.out.println(userId);
        System.out.println(addMoney);
        userService.recharge(userId, addMoney);
        return ResponseDataUtils.buildSuccess("0", "充值成功！");
    }

    // !店家注册
    @PostMapping("/shop/register")
    public ResponseData<?> shopRegister(@RequestBody Shop queryShop) {
        // 根据前端传来的注册名查询用户名是否重复
        User user = userService.getUserByUsername(queryShop.getUsername());
        // 用户名重复，禁止注册
        if (user != null) {
            return ResponseDataUtils.buildSuccess("1", "该用户名已被使用！");
        }
        userService.shopRegister(queryShop);
        return ResponseDataUtils.buildSuccess("0", "店家注册成功！请前往登录！");
    }

    // !根据 userId 获取 shopId
    @GetMapping("/shop_id/{userId}")
    public BigInteger getShopId(@PathVariable BigInteger userId) {
        return userService.getShopId(userId);
    }

    // !修改密码
    @PostMapping("/password")
    public ResponseData<?> setPassword(@RequestBody Password password) {
        userService.setPassword(password);
        return ResponseDataUtils.buildSuccess("0", "密码修改成功！");
    }


    // !查询某用户是否购买了某商品
    @GetMapping("/check/{userId}/{productId}")
    public ResponseData<?> check(@PathVariable BigInteger userId, @PathVariable BigInteger productId) {
        BigInteger flag = userService.check(userId, productId);
        if (flag==null) {
            return ResponseDataUtils.buildSuccess("1", "购买该商品才能评价！");
        }
        return ResponseDataUtils.buildSuccess("0", "已购买该商品");
    }

    // !
    @GetMapping("/order_number/{orderNumber}")
    public User getUserByOrderNumber(@PathVariable String orderNumber) {
        return userService.getUserByOrderNumber(orderNumber);
    }

    // !
    @GetMapping("/role/count")
    public RoleCount getRoleCount() {
        return userService.getRoleCount();
    }

}
