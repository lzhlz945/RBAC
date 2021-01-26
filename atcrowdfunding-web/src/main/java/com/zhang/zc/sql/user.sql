/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : mp

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 25/01/2021 17:18:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `useraccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 611 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'admin', 'admin@qq.com');
INSERT INTO `user` VALUES (2, 'zs', 'zs', 'zs', 'zs@');
INSERT INTO `user` VALUES (3, 'ls', 'ls', 'ls', 'ls@');
INSERT INTO `user` VALUES (4, 'ww', 'ww', 'ww', 'ww@');
INSERT INTO `user` VALUES (5, 'zl', 'zl', 'zl', 'zl@');
INSERT INTO `user` VALUES (6, 'cq', 'cq', 'cq', 'cq@');
INSERT INTO `user` VALUES (7, 'jiags', 'jiags', '架构师1', 'jiags@');

SET FOREIGN_KEY_CHECKS = 1;
