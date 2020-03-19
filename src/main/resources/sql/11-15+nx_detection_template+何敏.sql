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

 Date: 13/11/2019 10:07:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nx_detection_template
-- ----------------------------
DROP TABLE IF EXISTS `nx_detection_template`;
CREATE TABLE `nx_detection_template`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '基地检测模板',
  `template_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for nx_detemp_rel
-- ----------------------------
DROP TABLE IF EXISTS `nx_detemp_rel`;
CREATE TABLE `nx_detemp_rel`  (
  `template_id` int(11) NOT NULL COMMENT '基地检测模板id',
  `env_standards_id` int(11) NOT NULL COMMENT '基地检测id',
  PRIMARY KEY (`template_id`) USING BTREE,
  INDEX `env_standards_id`(`env_standards_id`) USING BTREE,
  CONSTRAINT `nx_detemp_rel_ibfk_1` FOREIGN KEY (`template_id`) REFERENCES `nx_detection_template` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `nx_detemp_rel_ibfk_2` FOREIGN KEY (`env_standards_id`) REFERENCES `ddwb_env_standards` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
