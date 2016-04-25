/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.16 : Database - barbershop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`barbershop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `barbershop`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `desc` text COMMENT '客户信息描述',
  `pictureAddress` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `creatTime` date DEFAULT NULL COMMENT '创建时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新人',
  `isDelete` int(50) DEFAULT NULL COMMENT '是否删除;1删除,2未删除',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

/*Table structure for table `customermember` */

DROP TABLE IF EXISTS `customermember`;

CREATE TABLE `customermember` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `customerId` bigint(50) DEFAULT NULL COMMENT '客户id',
  `memberId` bigint(50) DEFAULT NULL COMMENT '会员id',
  `currentAmount` int(255) DEFAULT NULL COMMENT '当前金额',
  `remainingAmount` int(255) DEFAULT NULL COMMENT '剩余金额',
  `historyAmount` int(255) DEFAULT NULL COMMENT '历史总消费金额',
  `creatTime` date DEFAULT NULL COMMENT '创建时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新人',
  `isDelete` int(50) DEFAULT NULL COMMENT '是否删除;1删除,2未删除',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customermember` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `desc` text COMMENT '描员工信息描述',
  `pictureAddress` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `creatTime` date DEFAULT NULL COMMENT '创建时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新人',
  `isDelete` int(50) DEFAULT NULL COMMENT '是否删除;1删除,2未删除',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

/*Table structure for table `employeeserviceproducts` */

DROP TABLE IF EXISTS `employeeserviceproducts`;

CREATE TABLE `employeeserviceproducts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `EmployeeId` bigint(50) DEFAULT NULL COMMENT '员工id',
  `ServiceProductsId` bigint(50) DEFAULT NULL COMMENT '服务产品id',
  `currentNumber` int(255) DEFAULT NULL COMMENT '当前理发数',
  `historyNumber` int(255) DEFAULT NULL COMMENT '历史理发数',
  `creatTime` date DEFAULT NULL COMMENT '创建时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新人',
  `isDelete` int(50) DEFAULT NULL COMMENT '是否删除;1删除,2未删除',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employeeserviceproducts` */

/*Table structure for table `historyorderinfo` */

DROP TABLE IF EXISTS `historyorderinfo`;

CREATE TABLE `historyorderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `customerId` bigint(50) DEFAULT NULL COMMENT '客户id',
  `memberId` bigint(50) DEFAULT NULL COMMENT '会员id',
  `EmployeeId` bigint(50) DEFAULT NULL COMMENT '员工id',
  `ServiceProductsId` bigint(50) DEFAULT NULL COMMENT '服务产品id',
  `currentAmount` int(255) DEFAULT NULL COMMENT '当前消费金额',
  `remainingAmount` int(255) DEFAULT NULL COMMENT '剩余消费金额',
  `historyAmount` int(255) DEFAULT NULL COMMENT '历史总消费金额',
  `desc` text COMMENT '客户+会员+员工+服务4个对象订单详细历史记录',
  `creatTime` date DEFAULT NULL COMMENT '创建时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新人',
  `isDelete` int(50) DEFAULT NULL COMMENT '是否删除;1删除,2未删除',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `historyorderinfo` */

/*Table structure for table `memberinfo` */

DROP TABLE IF EXISTS `memberinfo`;

CREATE TABLE `memberinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `desc` text COMMENT '会员信息描述',
  `level` int(50) DEFAULT NULL COMMENT '会员级别',
  `levelIntegral` bigint(50) DEFAULT NULL COMMENT '会员积分',
  `levelPrice` int(255) DEFAULT NULL COMMENT '会员价格',
  `pictureAddress` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `creatTime` date DEFAULT NULL COMMENT '创建时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新人',
  `isDelete` int(50) DEFAULT NULL COMMENT '是否删除;1删除,2未删除',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `memberinfo` */

/*Table structure for table `serviceproducts` */

DROP TABLE IF EXISTS `serviceproducts`;

CREATE TABLE `serviceproducts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `desc` text COMMENT '描述',
  `price` int(255) DEFAULT NULL COMMENT '商品价格',
  `pictureAddress` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `creatTime` date DEFAULT NULL COMMENT '创建时间',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新人',
  `isDelete` int(50) DEFAULT NULL COMMENT '是否删除;1删除,2未删除',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `serviceproducts` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
