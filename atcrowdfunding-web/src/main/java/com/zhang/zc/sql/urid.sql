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

 Date: 25/01/2021 17:19:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for urid
-- ----------------------------
DROP TABLE IF EXISTS `urid`;
CREATE TABLE `urid`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uId` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of urid
-- ----------------------------
INSERT INTO `urid` VALUES (1, 1, 8);
INSERT INTO `urid` VALUES (2, 7, 7);
INSERT INTO `urid` VALUES (3, 7, 8);

SET FOREIGN_KEY_CHECKS = 1;
