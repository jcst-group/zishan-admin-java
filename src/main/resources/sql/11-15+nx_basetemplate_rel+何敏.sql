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

 Date: 14/11/2019 10:22:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nx_basetemplate_rel
-- ----------------------------
DROP TABLE IF EXISTS `nx_basetemplate_rel`;
CREATE TABLE `nx_basetemplate_rel`  (
  `base_id` int(11) NOT NULL COMMENT '基地id',
  `template_id` int(11) NOT NULL COMMENT '检测模板id',
  INDEX `base_id`(`base_id`) USING BTREE,
  INDEX `template_id`(`template_id`) USING BTREE,
  CONSTRAINT `nx_basetemplate_rel_ibfk_1` FOREIGN KEY (`base_id`) REFERENCES `ddwb_base_info` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `nx_basetemplate_rel_ibfk_2` FOREIGN KEY (`template_id`) REFERENCES `nx_detection_template` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
