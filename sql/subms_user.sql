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

 Date: 25/09/2023 20:05:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for subms_user
-- ----------------------------
DROP TABLE IF EXISTS `subms_user`;
CREATE TABLE `subms_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE COMMENT '用户名唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subms_user
-- ----------------------------
INSERT INTO `subms_user` VALUES (1, 'admin', '123456');
INSERT INTO `subms_user` VALUES (3, 'admin123', '123456');
INSERT INTO `subms_user` VALUES (4, 'wjj', '123');

SET FOREIGN_KEY_CHECKS = 1;
