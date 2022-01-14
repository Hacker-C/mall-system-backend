/*
 Navicat Premium Data Transfer

 Source Server         : mysql57
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 26/12/2021 19:03:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cart_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '每一条购物车中的记录ID',
  `user_id` bigint(11) NOT NULL COMMENT '这条购物车物品属于的用户id',
  `product_id` bigint(11) NULL DEFAULT NULL COMMENT '这条购物车记录的物品ID',
  `count` bigint(20) NULL DEFAULT 1 COMMENT '物品数量（>=1）',
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (3, 2, 3, 10);
INSERT INTO `cart` VALUES (6, 2, 1, 3);
INSERT INTO `cart` VALUES (8, 2, 2, 1);
INSERT INTO `cart` VALUES (15, 4, 3, 1);
INSERT INTO `cart` VALUES (16, 4, 1, 1);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '此条评论ID',
  `product_id` bigint(11) NOT NULL COMMENT '评论所属商品的ID',
  `comment_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品内容',
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '评论用户',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (5, 3, '非常好看的一本书，值得推荐！', '2021-12-11 15:20:04', 1);
INSERT INTO `comment` VALUES (10, 2, '6666', '2021-12-24 00:15:46', 3);

-- ----------------------------
-- Table structure for countdown
-- ----------------------------
DROP TABLE IF EXISTS `countdown`;
CREATE TABLE `countdown`  (
  `id` int(11) NOT NULL DEFAULT 1,
  `new_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of countdown
-- ----------------------------
INSERT INTO `countdown` VALUES (1, '2021-12-24 23:30:00', '2021-12-24 19:57:47');

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like`  (
  `like_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '收藏信息ID',
  `product_id` bigint(11) NULL DEFAULT NULL COMMENT '所收藏的商品的ID',
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '收藏这件商品的客户的ID',
  `like_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`like_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of like
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL COMMENT '公告ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '2021-12-17 10:17:24', '2021-12-24 22:04:05', '我是一条公告哈哈哈哈哈哈。欢迎光临！！！1234');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '订单编号',
  `product_id` bigint(32) UNSIGNED NOT NULL,
  `count` int(11) NOT NULL COMMENT '商品数量',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (38, '20211221231742316730', 5, 1, '2021-12-21 23:17:43', '2021-12-21 23:17:43');
INSERT INTO `order_detail` VALUES (39, '20211222005320845996', 2, 1, '2021-12-22 00:53:20', '2021-12-22 00:53:20');
INSERT INTO `order_detail` VALUES (40, '20211222005320845996', 10, 1, '2021-12-22 00:53:20', '2021-12-22 00:53:20');
INSERT INTO `order_detail` VALUES (41, '20211222005320845996', 5, 2, '2021-12-22 00:53:20', '2021-12-22 00:53:20');
INSERT INTO `order_detail` VALUES (42, '20211222095531205376', 9, 1, '2021-12-22 09:55:32', '2021-12-22 09:55:32');
INSERT INTO `order_detail` VALUES (43, '20211222095531205376', 1, 1, '2021-12-22 09:55:32', '2021-12-22 09:55:32');
INSERT INTO `order_detail` VALUES (44, '20211222095531205376', 5, 1, '2021-12-22 09:55:32', '2021-12-22 09:55:32');
INSERT INTO `order_detail` VALUES (45, '20211222112711033209', 5, 1, '2021-12-22 11:27:11', '2021-12-22 11:27:11');
INSERT INTO `order_detail` VALUES (46, '20211222113103566761', 2, 1, '2021-12-22 11:31:03', '2021-12-22 11:31:03');
INSERT INTO `order_detail` VALUES (47, '20211222113353566450', 1, 1, '2021-12-22 11:33:53', '2021-12-22 11:33:53');
INSERT INTO `order_detail` VALUES (48, '20211222113420562846', 10, 1, '2021-12-22 11:34:21', '2021-12-22 11:34:21');
INSERT INTO `order_detail` VALUES (50, '20211223210339656725', 10, 1, '2021-12-23 21:03:39', '2021-12-23 21:03:39');
INSERT INTO `order_detail` VALUES (52, '20211224002341948074', 9, 1, '2021-12-24 00:23:41', '2021-12-24 00:23:41');
INSERT INTO `order_detail` VALUES (53, '20211224002341948074', 1, 3, '2021-12-24 00:23:41', '2021-12-24 00:23:41');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '订单编号，前端生成',
  `buyer_id` int(11) NOT NULL COMMENT '买主ID',
  `order_amount` decimal(10, 2) NOT NULL COMMENT '订单总额',
  `order_status` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单状态，1表示已付钱，0表示未付钱',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新时间',
  `shop_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES (28, '20211221231742316730', 3, 2659.05, 4, '2021-12-21 23:17:43', '2021-12-23 20:30:19', 1);
INSERT INTO `order_master` VALUES (29, '20211222005320845996', 3, 7342.02, 4, '2021-12-22 00:53:20', '2021-12-23 20:30:21', 1);
INSERT INTO `order_master` VALUES (30, '20211222095531205376', 3, 2693.88, 2, '2021-12-22 09:55:32', '2021-12-23 23:18:13', 1);
INSERT INTO `order_master` VALUES (31, '20211222112711033209', 3, 2659.05, 4, '2021-12-22 11:27:11', '2021-12-23 20:30:25', 1);
INSERT INTO `order_master` VALUES (32, '20211222113103566761', 3, 44.91, 3, '2021-12-22 11:31:03', '2021-12-23 20:30:27', 1);
INSERT INTO `order_master` VALUES (33, '20211222113353566450', 3, 7.92, 2, '2021-12-22 11:33:53', '2021-12-23 23:23:06', 1);
INSERT INTO `order_master` VALUES (34, '20211222113420562846', 3, 1979.01, 2, '2021-12-22 11:34:21', '2021-12-23 23:58:28', 1);
INSERT INTO `order_master` VALUES (35, '20211223210339656725', 3, 1979.01, 2, '2021-12-23 21:03:39', '2021-12-24 00:01:45', 1);
INSERT INTO `order_master` VALUES (37, '20211224002341948074', 3, 50.67, 3, '2021-12-24 00:23:41', '2021-12-24 00:24:26', 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
  `product_price` decimal(10, 2) NOT NULL COMMENT '单价',
  `discount` decimal(10, 2) NULL DEFAULT 1.00 COMMENT '商品折扣',
  `left` bigint(20) NULL DEFAULT 999 COMMENT '商品剩余量',
  `sold` bigint(255) NULL DEFAULT 0 COMMENT '已售量',
  `rate` decimal(10, 2) UNSIGNED NULL DEFAULT 5.00 COMMENT '商品评分',
  `img_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '商品图片',
  `product_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '商品描述',
  `category_id` bigint(11) NOT NULL COMMENT '商品所属分类',
  `shop_id` bigint(20) NOT NULL COMMENT '商品所属店的id',
  `weight` double NULL DEFAULT NULL COMMENT '商品重量',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '三体全集', '2021-12-08 19:30:48', 45.00, 0.90, 999, 900, 4.90, 'http://119.23.46.102:9090/files/fe7807180b1f47898d1f1301b7b2bb09', '《三体》第73届世界科幻雨果奖获奖作品，银河奖特别奖，《三体3》轨迹奖长篇科幻小说！2017年世界雨果奖提名作品', 2, 1, 0.5);
INSERT INTO `product` VALUES (2, '西游记', '2021-12-07 19:32:34', 49.90, 0.90, 999, 777, 4.90, 'http://localhost:8081/files/b6b43dad96874248a5766f70d3657714', '《西游记》通过神话的形式，曲折地反映出现实的社会矛盾，表现了人民群众惩恶扬善的愿望和要求。另外为便于读者阅读，本书选配了名家戴敦邦所绘彩色插图附于书中，同时编制了“西游取经历难平妖简表”。', 2, 1, 0.5);

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类ID',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品分类名称',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (2, '图书教育');
INSERT INTO `product_category` VALUES (3, '家用电器');
INSERT INTO `product_category` VALUES (4, '个护清洁');
INSERT INTO `product_category` VALUES (5, '电子数码');
INSERT INTO `product_category` VALUES (6, '医药保健');
INSERT INTO `product_category` VALUES (7, '玩具乐器');
INSERT INTO `product_category` VALUES (8, '服饰衣物');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `shop_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '开店ID',
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '店的名字',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '店主名字',
  `owner_id` bigint(20) NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开店时间',
  `income` double NULL DEFAULT 0 COMMENT '收入',
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (1, '杰克森的店铺', 'shop', 2, '2021-12-21 14:12:12', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名，用于登录',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '12345' COMMENT '登录密码',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '真实姓名',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT 'user' COMMENT '用户角色，0客户，1店家，2管理员',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png' COMMENT '用户头像',
  `age` int(11) NULL DEFAULT 0 COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '男' COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '电话号码',
  `status` int(255) NULL DEFAULT 1 COMMENT '当前状态，管理员可拉黑用户和店家',
  `money` double(255, 2) NULL DEFAULT 0.00 COMMENT '用户剩余资金，用于购买商品',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账号创建时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin1234', '张三', 'admin', 'http://localhost:8081/files/f0ca164d2df840bf9395a35d1c69a33d', 18, '男', '江西南昌', '18100000001', 1, 1423.50, '2021-12-10 21:08:24', '1234@qq.com');
INSERT INTO `user` VALUES (2, 'shop', 'shop', '杰克森', 'shop', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', 18, '男', '上海', '12345678901', 1, 0.00, '2021-12-10 21:08:24', NULL);
INSERT INTO `user` VALUES (3, 'user', 'abcd1234', '刘星', 'user', 'http://119.23.46.102:9090/files/5c9e4b961f1b466a9b09e5d00e71ff75', 26, '男', '南昌大学', '325345214', 1, 6374.66, '2021-12-10 21:08:24', '123@qq.com');
INSERT INTO `user` VALUES (4, 'hello', '12345', '谢生', 'user', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', 0, '男', '', '346342342', 1, 0.00, '2021-12-10 21:08:24', NULL);

SET FOREIGN_KEY_CHECKS = 1;
