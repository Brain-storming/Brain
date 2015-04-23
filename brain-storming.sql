/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50616
Source Host           : wangyu
Source Database       : brain-storming

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-04-20 15:13:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commentinfo
-- ----------------------------
DROP TABLE IF EXISTS `commentinfo`;
CREATE TABLE `commentinfo` (
  `contentId` int(11) NOT NULL,
  `commentUserId` int(11) NOT NULL,
  `commentId` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL,
  PRIMARY KEY (`commentId`),
  KEY `contentId` (`contentId`),
  KEY `commentUserId` (`commentUserId`),
  CONSTRAINT `commentUserId` FOREIGN KEY (`commentUserId`) REFERENCES `userinfo` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contentId` FOREIGN KEY (`contentId`) REFERENCES `contentinfo` (`contentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for contentinfo
-- ----------------------------
DROP TABLE IF EXISTS `contentinfo`;
CREATE TABLE `contentinfo` (
  `contentId` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `userId` int(11) NOT NULL,
  `useful` int(11) NOT NULL,
  PRIMARY KEY (`contentId`),
  KEY `userId` (`userId`),
  KEY `contentId` (`contentId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userId` int(11) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `userSex` varchar(255) DEFAULT NULL,
  `pass` varchar(255) NOT NULL,
  `userTel` varchar(255) DEFAULT NULL,
  `level` int(11) NOT NULL,
  `exp` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
