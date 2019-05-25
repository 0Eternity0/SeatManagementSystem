/*
Navicat MySQL Data Transfer

Source Server         : phpstudy
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : seat_management_system

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-05-25 19:59:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '预约人主键',
  `seat_id` int(11) NOT NULL COMMENT '座位主键',
  `start_time` datetime NOT NULL COMMENT '预约开始时间',
  `status` int(11) DEFAULT NULL COMMENT '座位状态码。0待签到入座；1入座；2暂离；',
  `end_time` datetime NOT NULL COMMENT '预约结束时间',
  PRIMARY KEY (`id`),
  KEY `order_user` (`user_id`),
  KEY `order_seat` (`seat_id`),
  CONSTRAINT `order_seat` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`),
  CONSTRAINT `order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `region_name` varchar(50) NOT NULL COMMENT '阅读区名字',
  `region_category` varchar(50) DEFAULT NULL COMMENT '阅读区分类，如计算机科学区，文学区',
  `seat_num` int(11) NOT NULL DEFAULT '0' COMMENT '座位数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `informer_id` int(11) DEFAULT NULL COMMENT '举报人主键',
  `accused_id` int(11) DEFAULT NULL COMMENT '被举报人主键',
  `img_url` varchar(255) DEFAULT NULL COMMENT '举报照片路径',
  `time` timestamp NULL DEFAULT NULL COMMENT '举报时间',
  `info` varchar(255) DEFAULT NULL COMMENT '举报信息说明',
  `seat_info` varchar(255) DEFAULT NULL COMMENT '当时被举报人所预约座位的信息',
  `type` varchar(50) DEFAULT NULL COMMENT '举报类型',
  PRIMARY KEY (`id`),
  KEY `informer_user` (`informer_id`),
  KEY `accused_user` (`accused_id`),
  CONSTRAINT `accused_user` FOREIGN KEY (`accused_id`) REFERENCES `user` (`id`),
  CONSTRAINT `informer_user` FOREIGN KEY (`informer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `region_id` int(11) NOT NULL COMMENT '座位所属预览区编号',
  `loca` varchar(10) NOT NULL COMMENT '座位的位置信息，如三排六列：（3，6）',
  `falg` varchar(2) NOT NULL COMMENT '启用状态，0允许预约，1不允许预约',
  PRIMARY KEY (`id`),
  KEY `seat_region` (`region_id`),
  CONSTRAINT `seat_region` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) NOT NULL COMMENT '登录用用户名，即学号',
  `password` varchar(100) NOT NULL,
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `department` varchar(30) DEFAULT NULL COMMENT '学院信息',
  `grade` int(11) DEFAULT NULL COMMENT '信用评级分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
