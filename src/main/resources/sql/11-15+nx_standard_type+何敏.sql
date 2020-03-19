/*
 Navicat Premium Data Transfer

 Source Server         : ddwb
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : zishan

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 13/11/2019 10:48:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nx_standard_type
-- ----------------------------
DROP TABLE IF EXISTS `nx_standard_type`;
CREATE TABLE `nx_standard_type`  (
  `value` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `display_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '检测项目',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`value`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nx_standard_type
-- ----------------------------
INSERT INTO `nx_standard_type` VALUES (1, '水源', 'WATER', '2019-11-13 10:22:47', NULL);
INSERT INTO `nx_standard_type` VALUES (2, '空气', 'AIR', '2019-11-13 10:22:45', NULL);
INSERT INTO `nx_standard_type` VALUES (3, '土壤', 'SOIL', '2019-11-13 10:22:41', NULL);
INSERT INTO `nx_standard_type` VALUES (4, '农残', 'PESTICIDE_RESIDUES', '2019-11-13 10:22:39', NULL);

SET FOREIGN_KEY_CHECKS = 1;
