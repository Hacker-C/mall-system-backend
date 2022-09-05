# 商城系统

## 关于

一个基于 SpringBoot + MySQL 的具有客户、商家、管理员三种模式的商城系统。



数据库文件已经更新。



这里是后端部分，前端部分以及界面示例请前往：https://github.com/Hacker-C/mall-system

<p align="right">(<a href="#top">back to top</a>)</p>

## 技术栈

项目后端所使用的技术栈。

- SpringBoot
- MySQL

<p align="right">(<a href="#top">back to top</a>)</p>

## 开发环境

本项目环境由 `pom.xml` 统一管理，部分环境版本如下。

- SpringBoot：v2.3.7
* jdk：v1.8
* Mybatis：v2.1.4
* MySQL：v5.7
## 功能实现

### 顾客模块

- [x] 登陆网站
- [x] 浏览网站内容
- [x] 注册成此网站会员
    - [x] 编辑自己基本信息
    - [x] 修改密码
    - [x] 重置账户金额
- [x] 将选中的商品加入购物车
    - [x] 对购物车进行管理
      - [x] 删除购物车中商品
      - [x] 将购物车商品一起购买
- [x] 购买商品（管理订单）
    - [x] 提交订单
    - [x] 对订单进行付款
    - [x] 删除订单
    - [x] 取消订单
- [x] 对购买后的商品进行评价
    - [x] 评价商品
    - [x] 删除自己的评论
- [x] 收藏夹
    - [x] 添加商品到收藏集
    - [x] 删除收藏夹中内容

<p align="right">(<a href="#top">back to top</a>)</p>

### 商家模块

- [x] 注册申请开店
- [x] 对自己的店进行管理
  - [x] 上传商品图片
  - [x] 对商品进行介绍
  - [x] 编辑商品价格、剩余量、折扣等基本信息
- [x] 统计店内商品销售情况
  - [x] 查看总体收入情况
  - [x] 查看各类商品销售量、总收入
- [x] 管理订单
  - [x] 查看订单信息
    - [x] 查看订单总金额、下单时间
    - [x] 对订单中的商品进行发货操作
  - [x] 编辑订单状态
    - [x] 取消订单
    - [x] 对订单进行发货

<p align="right">(<a href="#top">back to top</a>)</p>

### 管理员模块

- [x] 对商家进行管理
  - [x] 查看、删除该商家下的所有商品
  - [x] 编辑商家和店铺的相关信息
- [x] 对系统进行维护管理
- [x] 管理所有用户
  - [x] 管理顾客、商家基本信息
  - [x] 重置顾客、商家登录密码
  - [x] 拉黑顾客、商家（拉黑后无法登录）
  - [x] 管理用户身份角色
    例如将某顾客身份改为商家，活着将其升级为管理员
  - [x] 查看所有用户组成（管理员、顾客、商家）
- [x] 管理系统
  - [x] 管理首页限时折扣倒计时时间
  - [x] 管理首页商品分类功能
    - [x] 编辑商品分类名称
    - [x] 删除商品分类
    - [x] 添加新的商品分类
  - [x] 管理系统的公告
    - [x] 编辑公告内容

## 接口文档

### 1. 统一接口文档

后端统一返回格式：demo例子。

```plain
{
	"code": "0",
  "msg": "登录成功",
  "data": null
}
```

- code："0"代表操作成功，"1"或者"2"等代表其他
- msg：返回信息

- data：返回数据

### 2. RESTful 接口风格

接口设计原则：请求 = 动词 + 宾语
增删改查：

- 增：POST
- 删：DELETE

- 改（全部修改）：PUT
- 改（部分修改）：PATCH

- 查：GET

### 3. 相关接口

1.  `/user` 
    
    -  获取所有用户：`GET`： 
    -  登录验证：`/login`（`POST`）
    - 前端传入和参数：`  {"username": "user", "password": "user1234"}`
    - `/register`（`POST`）
    - 前端传入和参数： `{"username": "test",   "password": "test123"}`
    - 后端返回数据，登录成功：`  {"code": "0", "msg": "登录成功", "data": null}`
    - 后端返回数据，登录成功：` {code: "1",   msg: "登录失败",   "data": null}`
2. `/product` 
    -  `/product/all`：`GET` 请求，获取所有商品 
    -  `/product/{id}`：`GET` 请求，根据商品ID获取商品信息及 
    -  `/product/shop`：`POST` 请求，根据店铺id获取店内所有商品 
    -  `/product`：`PUT` 请求，更新商品信息 
    -  `/product`：`POST` ：`POST`请求，添加商品 
    -  `/product/search`：`GET` 请求，首页搜索 
    -  `/product/{productId`：`DELETE` 请求，删除商品
3. `/order`
    - `/order/master`：`POST` 请求，添加订单
    - `/order/detail`：`POST` 添加订单中的每一天商品信息
    - `/order/{buyerId}`：`GET` 获取用户的所有订单
4.  `/files/upload`
    - 文件上传（图片）

5. `/like`

   - `/like/{userId}`：`GET` 请求，获取用户收藏
   - `/like/{userId}`：`DELETE` 请求，删除用户收藏
   - `/like`：`POST` 请求，用户添加收藏

6. `/shop`

   - `/shop`：`POST` ：`POST`请求，商家开店
   - `/shop/{userId}`：`GET` 请求，获取店铺信息

   
