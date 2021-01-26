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

 Date: 25/01/2021 17:19:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'PM-项目经理');
INSERT INTO `role` VALUES (2, 'SE-软件工程师');
INSERT INTO `role` VALUES (3, 'PG-程序员');
INSERT INTO `role` VALUES (4, 'TL-组长');
INSERT INTO `role` VALUES (5, 'GL-组长');
INSERT INTO `role` VALUES (6, 'QC-品质控制');
INSERT INTO `role` VALUES (7, 'SA-架构师');
INSERT INTO `role` VALUES (8, 'SYSTEM-系统管理员');
INSERT INTO `role` VALUES (9, 'HR-人事');

SET FOREIGN_KEY_CHECKS = 1;
