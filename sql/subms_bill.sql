/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 50554
 Source Host           : localhost:3306
 Source Schema         : keshe

 Target Server Type    : MySQL
 Target Server Version : 50554
 File Encoding         : 65001

 Date: 25/09/2023 20:05:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for subms_bill
-- ----------------------------
DROP TABLE IF EXISTS `subms_bill`;
CREATE TABLE `subms_bill`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `billCode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `productName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `productDesc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `productUnit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `productCount` decimal(20, 2) NULL DEFAULT NULL,
  `totalPrice` decimal(20, 2) NULL DEFAULT NULL,
  `isPayment` int(10) NULL DEFAULT NULL,
  `createBy` bigint(20) NULL DEFAULT NULL,
  `creationDate` datetime NULL DEFAULT NULL,
  `modifyBy` bigint(20) NULL DEFAULT NULL,
  `modifyDate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subms_bill
-- ----------------------------
INSERT INTO `subms_bill` VALUES (11, 'wjj123test', '旺仔牛逼糖', 'wjj123test', 'wjj123test', 123.00, 123.00, 0, 4, '2022-07-13 22:55:38', 1, '2022-07-14 15:54:50');
INSERT INTO `subms_bill` VALUES (12, '123213', '娃哈哈哈哈', 'test', 'twa', 111.00, 111.00, 1, 1, '2022-07-14 09:36:54', 1, '2022-07-14 15:54:25');
INSERT INTO `subms_bill` VALUES (13, 'f30433951ec645e8b972', '菠萝', 'ddfbce31d95543858424', 'testUnit1', 300.00, 2020.33, 0, 1, '2022-07-14 15:51:24', 1, '2022-07-14 15:52:40');
INSERT INTO `subms_bill` VALUES (15, 'fdsafdsafdsaf', '超级大芒果', 'fded43d52edd4ad6b5f4', 'testUnit1', 300.00, 2020.33, 0, 1, '2022-07-14 15:51:30', 1, '2022-07-14 19:56:35');
INSERT INTO `subms_bill` VALUES (16, '8e862f745fa74244b868', '苹果', 'fb43b36a9a884b99a26c', 'testUnit1', 300.00, 2020.33, 0, 1, '2022-07-14 15:51:33', 1, '2022-07-14 15:53:17');
INSERT INTO `subms_bill` VALUES (17, 'e1003a8915ff44cd88c3', '火龙果', 'a0c38cd584a143fbb343', 'testUnit2', 300.00, 2020.33, 0, 1, '2022-07-14 15:51:35', 1, '2022-07-14 15:53:25');
INSERT INTO `subms_bill` VALUES (18, 'd41002bc7eb3491097e1', '鸭梨', 'f1394a39f6d841b1a9cb', 'testUnit1', 300.00, 2020.33, 0, 1, '2022-07-14 15:51:37', 1, '2022-07-14 15:53:37');
INSERT INTO `subms_bill` VALUES (19, '840a2d3b553d4b8ea252', '果冻', '2da4b75b8623458f8e0e', 'testUnit1', 300.00, 2020.33, 0, 1, '2022-07-14 15:51:39', 1, '2022-07-14 15:53:44');
INSERT INTO `subms_bill` VALUES (20, 'fb07f768ac0443a88c4e', '大个核桃', 'db1c32c2b4974cf4bd94', 'testUnit3', 300.00, 2020.33, 0, 1, '2022-07-14 15:51:41', 1, '2022-07-14 15:53:52');
INSERT INTO `subms_bill` VALUES (21, '91ea47d648eb4ee99f5f', '雷碧', 'a41757fde2554f3bb7ca', 'testUnit1', 300.00, 2020.33, 0, 1, '2022-07-14 15:51:43', 1, '2022-07-14 15:54:01');
INSERT INTO `subms_bill` VALUES (22, 'b8d3a529e2814e3ca50c', '六个核弹', 'ee62ab4b38d34d83a0b3', 'testUnit1', 300.00, 2020.33, 0, 1, '2022-07-14 15:51:46', 1, '2022-07-14 15:54:13');

SET FOREIGN_KEY_CHECKS = 1;
