/*
 Navicat MySQL Data Transfer

 Source Server         : mysql-origin
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : 124.222.44.115:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 05/09/2022 19:50:37
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
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '此条评论ID',
  `product_id` bigint(11) NOT NULL COMMENT '评论所属商品的ID',
  `comment_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品内容',
  `comment_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '评论用户',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for countdown
-- ----------------------------
DROP TABLE IF EXISTS `countdown`;
CREATE TABLE `countdown`  (
  `id` int(11) NOT NULL DEFAULT 1,
  `new_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of countdown
-- ----------------------------
INSERT INTO `countdown` VALUES (1, '2022-09-05 23:45:00', '2022-09-05 18:35:44');

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like`  (
  `like_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '收藏信息ID',
  `product_id` bigint(11) NULL DEFAULT NULL COMMENT '所收藏的商品的ID',
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '收藏这件商品的客户的ID',
  `like_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`like_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of like
-- ----------------------------
INSERT INTO `like` VALUES (7, 7, 6, '2022-09-05 19:11:12');
INSERT INTO `like` VALUES (8, 12, 6, '2022-09-05 19:12:50');
INSERT INTO `like` VALUES (9, 16, 6, '2022-09-05 19:12:54');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL COMMENT '公告ID',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '2021-12-17 10:17:24', '2022-07-19 11:22:56', '我是一条公告哈哈哈哈哈哈。欢');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '订单编号',
  `product_id` bigint(32) UNSIGNED NOT NULL,
  `count` int(11) NOT NULL COMMENT '商品数量',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (63, '20220905191135414837', 7, 5, '2022-09-05 19:11:35', '2022-09-05 19:11:35');

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
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '订单更新时间',
  `shop_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES (46, '20220905191135414837', 6, 5400.00, 3, '2022-09-05 19:11:35', '2022-09-05 19:12:30', 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
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
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (6, '三体', '2022-09-05 16:23:07', 83.50, 0.85, 999, 387, 5.00, 'http://124.222.44.115:9092/files/28a6a8ed9611419ea2cda2785bf38af5', '《三体》第73届世界科幻雨果奖获奖作品，银河奖特别奖，《三体3》轨迹奖长篇科幻小说！2017年世界雨果奖提名作品。', 2, 1, 0.3);
INSERT INTO `product` VALUES (7, '红米 note 9', '2022-09-05 17:36:42', 1200.00, 0.90, 999, 233, 5.00, 'http://124.222.44.115:9092/files/5606469732fd4ea5913e8751c3d797d7', '红米Note9 6GB+128GB 全网通4G', 3, 1, 0.5);
INSERT INTO `product` VALUES (8, 'iphone 13', '2022-09-05 17:43:31', 7000.00, 0.80, 9999, 375, 5.00, 'http://124.222.44.115:9092/files/11c51a668c114d5c98b31cc32dda2b34', 'Apple 苹果13Pro (A2639) iPhone 13Pro 5G手机 远峰蓝色 128GB', 3, 1, 0.3);
INSERT INTO `product` VALUES (9, 'Redmi Watch 2', '2022-09-05 17:47:26', 399.00, 1.00, 999, 163, 5.00, 'http://124.222.44.115:9092/files/fbe1aa4e530941d2a4587318c4526bfd', 'AMOLED 高清大屏  |  独立卫星定位  |  117种运动模式  |  12天超长续航', 3, 1, 0.1);
INSERT INTO `product` VALUES (10, 'Redmi Buds 3', '2022-09-05 17:51:46', 199.00, 1.00, 998, 168, 5.00, 'http://124.222.44.115:9092/files/fea23cd9f59743f3b9d6505105bdf0b3', '轻巧半入耳 | 通话降噪 | 20小时长续航', 3, 1, 1);
INSERT INTO `product` VALUES (11, 'Redmi Book Pro 15', '2022-09-05 17:58:44', 5999.00, 1.00, 892, 127, 5.00, 'http://124.222.44.115:9092/files/eca976c92afb4f6196c2affaee312292', '全新12代英特尔处理器 | Windows 11 家庭中文版 | 可选RTX 2050高性能独立显卡 | 3.2K 90Hz 原色超清屏', 3, 1, 2.8);
INSERT INTO `product` VALUES (12, '乌合之众', '2022-09-05 18:06:28', 12.00, 1.00, 567, 131, 5.00, 'http://124.222.44.115:9092/files/efd46f06aace4010bcf50350c676d363', '一本赞扬和骂名同样猛烈的书。 它提出了惊世骇俗的 暴民理论 ；它预见了20世纪的心理学和政治发展；它影响了很多不想被其影响的人', 2, 1, 0.3);
INSERT INTO `product` VALUES (13, '阿西莫夫：机器人短篇全集', '2022-09-05 18:08:06', 100.00, 0.98, 689, 454, 5.00, 'http://124.222.44.115:9092/files/3df4d75950d14fd0a04b6e1751c4f7c3', '现代机器人科幻小说之父 阿西莫夫完整的机器人短篇小说典藏集！机器人学三大法则 源于本书！！现代机器人科幻的起源！', 2, 1, 0.3);
INSERT INTO `product` VALUES (14, '银河帝国：机器人五部曲', '2022-09-05 18:09:18', 124.00, 1.00, 999, 199, 5.00, 'http://124.222.44.115:9092/files/2d14e36b75d543fdb9a8b04177ef9180', '被马斯克用火箭送上太空的科幻神作，讲述人类未来两万年的历史。 ◆ 银河帝国 百万册全新纪念版。 ★人类历史不容错过的系列小说', 2, 1, 0.6);
INSERT INTO `product` VALUES (15, 'Python编程 从入门到实践 第2版', '2022-09-05 18:10:57', 75.00, 0.90, 998, 254, 5.00, 'http://124.222.44.115:9092/files/e874f3039c174e9bbef8d407a6bacb61', '1.中文版累计销量突破1000000册； 2.针对Python 3.x新特性升级，重写项目代码； 3.真正零基础，自学也轻松； 4.赠送配套学习视频，边看边学更便捷', 2, 1, 0.3);
INSERT INTO `product` VALUES (16, '小米平板5 Pro', '2022-09-05 18:17:32', 3099.00, 1.00, 899, 457, 5.00, 'http://124.222.44.115:9092/files/e4fd18dcaa5d49acae7e4cbcd633dc66', '骁龙870芯片 | 2.5K超高清｜120HZ高刷新率', 3, 1, 0.4);
INSERT INTO `product` VALUES (17, 'Redmi显示器23.8英寸', '2022-09-05 18:19:08', 599.00, 1.00, 799, 144, 5.00, 'http://124.222.44.115:9092/files/d5c8d9b211c849cdbeff4ee47d5ce9e5', '【活动到手价599元】【HDMI低蓝光办公显示器】IPS技术硬屏 | 1080P画质 | 7.3mm薄机身 |TÜV认证低蓝光', 3, 1, 0.5);
INSERT INTO `product` VALUES (18, '米家波轮洗衣机', '2022-09-05 18:20:34', 599.00, 1.00, 679, 106, 5.00, 'http://124.222.44.115:9092/files/4f69f9154c9f44baba61fe7146ea7fc2', '「波轮爆款！预售到手价仅1099元！」「10kg大容量，智能称重，省水省电！」10kg大容量/智能称重,省水省电/16种洗涤模式/DIY洗涤程序', 5, 1, 10);
INSERT INTO `product` VALUES (19, '小米手环5/6 专用充电线', '2022-09-05 18:23:04', 19.90, 1.00, 899, 467, 5.00, 'http://124.222.44.115:9092/files/d0491c56b34e4ed0a30ee143a4862dbd', '小米手环5/6 专用充电线免拆磁吸充电，快速补充电力，铜质镀金触点，增加充电寿命，TPE线材，反复折叠不易损坏', 3, 1, 0.1);
INSERT INTO `product` VALUES (20, 'JavaScript高级程序设计', '2022-09-05 18:39:37', 90.00, 0.80, 478, 119, 5.00, 'http://124.222.44.115:9092/files/ae7f9565196a438284fc5edb5b9080d8', 'web前端开发经典教程，JS“红宝书”全新升级，入门+实战，涵盖ECMAScript 2019，提供教学视频+配套编程环境，可直接在线运行随书代码', 2, 1, 0.4);
INSERT INTO `product` VALUES (21, '一次性医用外科口罩100只', '2022-09-05 18:44:35', 20.00, 0.90, 897, 324, 5.00, 'http://124.222.44.115:9092/files/09f63acc61384a86bdbc18f72e7196d4', '一次性医用外科口罩100只（每10只独立包装/袋*10）三层防护灭菌级防尘防细菌', 4, 1, 0.1);
INSERT INTO `product` VALUES (22, ' 乙醇消毒喷雾', '2022-09-05 18:48:04', 55.00, 1.00, 799, 269, 5.00, 'http://124.222.44.115:9092/files/a8d2005a9bf44a08a37614a504c63e8b', '乙醇消毒喷雾皮肤物居家办公免洗手消毒液剂 99.999%有效杀菌', 4, 1, 0.8);
INSERT INTO `product` VALUES (23, '运动棒球帽', '2022-09-05 18:50:16', 50.00, 1.00, 385, 148, 5.00, 'http://124.222.44.115:9092/files/425f47b5bd0b42759bdacc6c55dc802c', '022春季刺绣L潮牌鸭舌帽黑色硬顶时尚帽', 8, 1, 0.1);

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类ID',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '商品分类名称',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (2, '图书教育');
INSERT INTO `product_category` VALUES (3, '电子数码');
INSERT INTO `product_category` VALUES (4, '个护清洁');
INSERT INTO `product_category` VALUES (5, '家用电器');
INSERT INTO `product_category` VALUES (8, '服饰衣物');
INSERT INTO `product_category` VALUES (9, '蔬菜零食');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `shop_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '开店ID',
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '店的名字',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '店主名字',
  `owner_id` bigint(20) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开店时间',
  `income` double NULL DEFAULT 0 COMMENT '收入',
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

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
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账号创建时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '张三', 'admin', 'http://localhost:8081/files/f0ca164d2df840bf9395a35d1c69a33d', 18, '男', '江西南昌', '18100000001', 1, 1423.50, '2021-12-10 21:08:24', '1234@qq.com');
INSERT INTO `user` VALUES (2, 'shop', 'shop', '李四', 'shop', 'http://124.222.44.115:9092/files/9fe1eec996be40dc899e8241e99ac747', 18, '男', '上海', '12345678901', 1, 0.00, '2021-12-10 21:08:24', NULL);
INSERT INTO `user` VALUES (6, 'user', 'user', '王五', 'user', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', 0, '男', NULL, '18894726250', 1, 4599.00, '2022-07-16 20:53:57', NULL);

SET FOREIGN_KEY_CHECKS = 1;
