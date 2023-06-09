/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : study

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 31/05/2023 18:34:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `credit` int(0) NULL DEFAULT NULL,
  `hour` int(0) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程类型：专业课、选修课等',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '数据结构', 4, 64, '必修课', '计算机');
INSERT INTO `course` VALUES (2, '操作系统', 5, 32, '必修课', '计算机');
INSERT INTO `course` VALUES (3, '理论力学', 4, 64, '必修课', '机械');
INSERT INTO `course` VALUES (4, '计算机网络', 4, 64, '必修课', '计算机');

-- ----------------------------
-- Table structure for experience
-- ----------------------------
DROP TABLE IF EXISTS `experience`;
CREATE TABLE `experience`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sid` int(0) NULL DEFAULT NULL,
  `sname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` date NULL DEFAULT NULL,
  `end_time` date NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '待批阅',
  `filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experience
-- ----------------------------
INSERT INTO `experience` VALUES (1, 1, '张三', '实习', 'ovo', '2022-01-01', '2022-03-03', '很好的经历', '', NULL);
INSERT INTO `experience` VALUES (2, 1, '张三', '竞赛', '互联网+', '2022-01-03', '2023-01-01', '很好的比赛', '', NULL);
INSERT INTO `experience` VALUES (3, 2, NULL, '实习', '大厂', '2022-01-01', NULL, '很好的经历', '', NULL);
INSERT INTO `experience` VALUES (14, 1, '张三', NULL, '大厂', '2022-01-01', NULL, NULL, '待批阅', NULL);
INSERT INTO `experience` VALUES (15, 1, '张三', NULL, '大厂', '2022-01-01', NULL, NULL, '待批阅', 'abc.docx');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `sid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `credit` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`sid`, `cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------

-- ----------------------------
-- Table structure for institution
-- ----------------------------
DROP TABLE IF EXISTS `institution`;
CREATE TABLE `institution`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of institution
-- ----------------------------
INSERT INTO `institution` VALUES (3, 'abc', NULL, '公司', '1331313111', NULL, '是一个好的机构');
INSERT INTO `institution` VALUES (6, 'hdu', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `institution` VALUES (8, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sid` int(0) NULL DEFAULT NULL,
  `cid` int(0) NULL DEFAULT NULL,
  `score` int(0) NULL DEFAULT NULL,
  `time` date NULL DEFAULT NULL,
  `gpa` double(255, 2) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 1, 2, 90, '2022-10-15', 4.50, '通过');
INSERT INTO `score` VALUES (2, 1, 1, 80, '2022-01-06', 5.00, '通过');
INSERT INTO `score` VALUES (3, 2, 1, 85, NULL, NULL, '通过');
INSERT INTO `score` VALUES (4, 2, 4, 90, NULL, 5.00, '未通过');
INSERT INTO `score` VALUES (5, 2, 1, 65, '2022-01-01', 4.50, '通过');
INSERT INTO `score` VALUES (6, 2, 1, 55, '2022-01-01', 4.50, '未通过');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `snum` int(0) NULL DEFAULT NULL COMMENT '学号',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `graduation_date` date NULL DEFAULT NULL COMMENT '毕业日期',
  `major` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '个人简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'Mr.y', 200101, 'female', '2022-01-03', NULL, '2222222222151', NULL, '2022-06-06', NULL, NULL, '一个勤奋好学的学生');
INSERT INTO `student` VALUES (2, '好同学', 200102, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES (3, '张三', 219, 'male', NULL, NULL, NULL, NULL, NULL, 'cs', '大二', NULL);
INSERT INTO `student` VALUES (4, '张三', 2005161, 'male', NULL, NULL, NULL, NULL, NULL, 'cs', '大二', NULL);
INSERT INTO `student` VALUES (5, '李四', 1234567, 'male', NULL, NULL, NULL, NULL, NULL, 'cs', '大二', NULL);
INSERT INTO `student` VALUES (6, '李四', 1234567, 'male', NULL, NULL, NULL, NULL, NULL, 'cs', '大二', NULL);
INSERT INTO `student` VALUES (7, '李四', 1234567, 'male', NULL, NULL, NULL, NULL, NULL, 'cs', '大二', NULL);
INSERT INTO `student` VALUES (8, '李四', 1234567, 'male', NULL, NULL, NULL, NULL, NULL, 'cs', '大二', NULL);
INSERT INTO `student` VALUES (9, '王五', 20052319, 'male', NULL, NULL, NULL, NULL, NULL, 'cs', '大二', NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `tnum` int(0) NOT NULL COMMENT '职工号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职位',
  `birthday` date NULL DEFAULT NULL,
  `appointment_time` date NULL DEFAULT NULL,
  `leave_time` date NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (4, 125, 'abc', 'male', NULL, '教授', '1956-02-03', '2002-01-01', '2022-01-01', NULL, NULL, '是一个好的老师');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_deleted` int(0) NULL DEFAULT NULL,
  `identity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'student', '1', 0, '1');
INSERT INTO `user` VALUES (2, 'teacher', '1', 0, '2');
INSERT INTO `user` VALUES (3, 'insti', '1', 0, '3');
INSERT INTO `user` VALUES (4, 'abcd', '4', 0, NULL);
INSERT INTO `user` VALUES (5, '1234567', '1234567', 0, NULL);
INSERT INTO `user` VALUES (6, '20052319', '20052319', 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
