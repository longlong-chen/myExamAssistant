/*
Navicat MySQL Data Transfer

Source Server         : sa
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : db_education_platform

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2021-06-11 18:52:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for  student_question_answer
-- ----------------------------
DROP TABLE IF EXISTS ` student_question_answer`;
CREATE TABLE ` student_question_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `chapter_id` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL,
  `question_points` int(11) NOT NULL,
  `is_right` int(11) NOT NULL,
  `mark` int(11) NOT NULL,
  `answer` varchar(2000) NOT NULL,
  `enclosure` varchar(5000) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `check_flag` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of  student_question_answer
-- ----------------------------

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `administrator_id` int(11) NOT NULL AUTO_INCREMENT,
  `administrator_name` varchar(255) NOT NULL,
  `administrator_password` varchar(255) NOT NULL,
  `administrator_phone` varchar(11) DEFAULT NULL,
  `administrator_email` varchar(255) DEFAULT NULL,
  `disabled_flag` int(1) DEFAULT '0',
  `role` int(1) DEFAULT '0',
  `sex` int(1) DEFAULT '1',
  PRIMARY KEY (`administrator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20210002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('20210001', '陈龙', '123', '15896993517', '574746989@qq.com', '1', '0', '1');

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `chapter_id` int(11) NOT NULL AUTO_INCREMENT,
  `chapter_name` varchar(255) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`chapter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('100', '绪论', '100');
INSERT INTO `chapter` VALUES ('101', '线性表', '100');
INSERT INTO `chapter` VALUES ('102', '计算机网络体系结构', '101');
INSERT INTO `chapter` VALUES ('103', '物理层', '101');
INSERT INTO `chapter` VALUES ('104', '操作系统概述', '102');
INSERT INTO `chapter` VALUES ('105', '进程管理', '102');
INSERT INTO `chapter` VALUES ('106', '计算机发展概述', '103');
INSERT INTO `chapter` VALUES ('107', '数值系统', '103');
INSERT INTO `chapter` VALUES ('108', '栈、队列和数组', '100');
INSERT INTO `chapter` VALUES ('109', '树与二叉树', '100');
INSERT INTO `chapter` VALUES ('110', '图', '100');
INSERT INTO `chapter` VALUES ('111', '查找', '100');
INSERT INTO `chapter` VALUES ('112', '排序', '100');
INSERT INTO `chapter` VALUES ('113', '内存管理', '102');
INSERT INTO `chapter` VALUES ('114', '文件管理', '102');
INSERT INTO `chapter` VALUES ('115', 'I/O管理', '102');
INSERT INTO `chapter` VALUES ('116', '数据链路层', '101');
INSERT INTO `chapter` VALUES ('117', '网络层', '101');
INSERT INTO `chapter` VALUES ('118', '传输层', '101');
INSERT INTO `chapter` VALUES ('119', '应用层', '101');
INSERT INTO `chapter` VALUES ('120', '存储器', '103');
INSERT INTO `chapter` VALUES ('121', '指令系统', '103');
INSERT INTO `chapter` VALUES ('122', '中央处理器', '103');
INSERT INTO `chapter` VALUES ('123', '总线', '103');
INSERT INTO `chapter` VALUES ('124', '输入输出系统', '103');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `commodity_id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_name` varchar(255) NOT NULL,
  `commodity_detail` varchar(2000) NOT NULL,
  `price` float(10,2) NOT NULL,
  `baidu_link` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`commodity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('100', '机器学习', '电子书籍《机器学习》,周志华著，ISBN编号为9787302423287，总页数425页，带有书签的PDF文件，一经购买，概不退货', '1.80', 'http://baidu.com', '1234', '1234');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('100', '数据结构');
INSERT INTO `course` VALUES ('101', '计算机网络');
INSERT INTO `course` VALUES ('102', '操作系统');
INSERT INTO `course` VALUES ('103', '计算机组成原理');

-- ----------------------------
-- Table structure for exam_info
-- ----------------------------
DROP TABLE IF EXISTS `exam_info`;
CREATE TABLE `exam_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `chapter_id` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `check_flag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_info
-- ----------------------------

-- ----------------------------
-- Table structure for filling
-- ----------------------------
DROP TABLE IF EXISTS `filling`;
CREATE TABLE `filling` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(2000) NOT NULL,
  `rightAnswer` varchar(500) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '2',
  `analysis` varchar(1000) DEFAULT NULL,
  `level` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL DEFAULT '20211001',
  `image` varchar(255) DEFAULT NULL,
  `Image_status` int(11) NOT NULL DEFAULT '0',
  `course_id` int(11) NOT NULL,
  `chapter_id` int(11) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20212006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filling
-- ----------------------------
INSERT INTO `filling` VALUES ('20212001', '从计算机网络系统组成的角度看，计算机网络可以分为()和()', '通信子网资源子网', '2', null, '3', '20211001', null, '0', '101', '119');
INSERT INTO `filling` VALUES ('20212002', '收发电子邮件，属于ISO/OSI RM中 ()层的功能。', '应用', '2', null, '1', '20211001', null, '0', '101', '119');
INSERT INTO `filling` VALUES ('20212003', 'Outlook等常用电子邮件软件接收邮件使用的协议是(),发送邮件时使用的协议是()', 'POP3 SMTP', '2', null, '1', '20211001', null, '0', '101', '119');
INSERT INTO `filling` VALUES ('20212004', 'WWW上的每一个网页都有一个独立的地址，这些地址称为  ()', '统一资源定位器/URL ', '2', null, '2', '20211001', null, '0', '101', '119');
INSERT INTO `filling` VALUES ('20212005', '按照IPV4标准,IP地址205.3.127.13属于()类地址。', 'C', '2', '基础题，答案略', '1', '20211001', null, '0', '101', '117');

-- ----------------------------
-- Table structure for mainmenu
-- ----------------------------
DROP TABLE IF EXISTS `mainmenu`;
CREATE TABLE `mainmenu` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mainmenu
-- ----------------------------
INSERT INTO `mainmenu` VALUES ('100', '权限管理', '/admin');
INSERT INTO `mainmenu` VALUES ('101', '学习天地', '/learn');
INSERT INTO `mainmenu` VALUES ('102', '试题仓库', '/data');
INSERT INTO `mainmenu` VALUES ('103', '个人中心', '/person');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '学习方法分享', 'Good Good Study，Day Day Up', '2021-05-08');
INSERT INTO `message` VALUES ('2', '测试', '再测一波', '2021-05-07');
INSERT INTO `message` VALUES ('3', '无聊', '不想做毕设怎么办？', '2021-05-07');
INSERT INTO `message` VALUES ('4', '无标题', '让我通过吧？', '2021-05-07');
INSERT INTO `message` VALUES ('5', '功能缺陷', '这个功能也太丑了吧', '2021-05-07');

-- ----------------------------
-- Table structure for paper_manage
-- ----------------------------
DROP TABLE IF EXISTS `paper_manage`;
CREATE TABLE `paper_manage` (
  `paper_id` int(11) DEFAULT NULL,
  `questionType` int(1) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of paper_manage
-- ----------------------------
INSERT INTO `paper_manage` VALUES ('2021001', '1', '20211001');
INSERT INTO `paper_manage` VALUES ('2021002', '1', '20211002');
INSERT INTO `paper_manage` VALUES ('2021002', '1', '20211003');
INSERT INTO `paper_manage` VALUES ('2021002', '1', '20211004');
INSERT INTO `paper_manage` VALUES ('2021002', '1', '20211007');
INSERT INTO `paper_manage` VALUES ('2021002', '2', '20212002');
INSERT INTO `paper_manage` VALUES ('2021002', '2', '20212001');
INSERT INTO `paper_manage` VALUES ('2021002', '2', '20212004');
INSERT INTO `paper_manage` VALUES ('2021002', '2', '20212005');
INSERT INTO `paper_manage` VALUES ('2021002', '3', '20213002');
INSERT INTO `paper_manage` VALUES ('2021002', '3', '20213001');
INSERT INTO `paper_manage` VALUES ('2021002', '3', '20213010');
INSERT INTO `paper_manage` VALUES ('2021002', '3', '20213003');
INSERT INTO `paper_manage` VALUES ('2021002', '4', '20214002');
INSERT INTO `paper_manage` VALUES ('2021002', '4', '20214001');
INSERT INTO `paper_manage` VALUES ('2021001', '1', '20211005');
INSERT INTO `paper_manage` VALUES ('2021001', '1', '20211008');
INSERT INTO `paper_manage` VALUES ('2021001', '2', '20212003');
INSERT INTO `paper_manage` VALUES ('2021001', '2', '20212002');
INSERT INTO `paper_manage` VALUES ('2021001', '3', '20213005');
INSERT INTO `paper_manage` VALUES ('2021001', '3', '20213008');
INSERT INTO `paper_manage` VALUES ('2021001', '3', '20213004');
INSERT INTO `paper_manage` VALUES ('2021001', '3', '20213001');
INSERT INTO `paper_manage` VALUES ('2021001', '4', '20214002');
INSERT INTO `paper_manage` VALUES ('2021001', '4', '20214001');
INSERT INTO `paper_manage` VALUES ('2021003', '1', '20211008');
INSERT INTO `paper_manage` VALUES ('2021003', '1', '20211007');
INSERT INTO `paper_manage` VALUES ('2021003', '1', '20211001');
INSERT INTO `paper_manage` VALUES ('2021003', '1', '20211002');
INSERT INTO `paper_manage` VALUES ('2021003', '1', '20211004');
INSERT INTO `paper_manage` VALUES ('2021003', '2', '20212001');
INSERT INTO `paper_manage` VALUES ('2021003', '2', '20212003');
INSERT INTO `paper_manage` VALUES ('2021003', '2', '20212004');
INSERT INTO `paper_manage` VALUES ('2021003', '2', '20212005');
INSERT INTO `paper_manage` VALUES ('2021003', '2', '20212002');
INSERT INTO `paper_manage` VALUES ('2021003', '3', '20213005');
INSERT INTO `paper_manage` VALUES ('2021003', '3', '20213006');
INSERT INTO `paper_manage` VALUES ('2021003', '3', '20213012');
INSERT INTO `paper_manage` VALUES ('2021003', '3', '20213002');
INSERT INTO `paper_manage` VALUES ('2021003', '3', '20213010');
INSERT INTO `paper_manage` VALUES ('2021003', '4', '20214001');
INSERT INTO `paper_manage` VALUES ('2021003', '4', '20214002');

-- ----------------------------
-- Table structure for replay
-- ----------------------------
DROP TABLE IF EXISTS `replay`;
CREATE TABLE `replay` (
  `replayId` int(11) NOT NULL AUTO_INCREMENT,
  `messageId` int(11) DEFAULT NULL,
  `replay` varchar(255) DEFAULT NULL,
  `replayTime` date DEFAULT NULL,
  PRIMARY KEY (`replayId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of replay
-- ----------------------------
INSERT INTO `replay` VALUES ('1', '1', 'You\'re right!', '2021-05-08');
INSERT INTO `replay` VALUES ('2', '1', '顶顶顶顶', '2021-05-07');
INSERT INTO `replay` VALUES ('3', '3', '凉拌', '2021-05-07');
INSERT INTO `replay` VALUES ('4', '3', '不做也要做', '2021-05-07');
INSERT INTO `replay` VALUES ('5', '3', '没法', '2021-05-07');
INSERT INTO `replay` VALUES ('6', '4', '想的美', '2021-05-07');
INSERT INTO `replay` VALUES ('7', '5', '不想改，就是玩', '2021-05-07');
INSERT INTO `replay` VALUES ('8', '5', '打死你个龟孙', '2021-05-07');

-- ----------------------------
-- Table structure for right_or_wrong
-- ----------------------------
DROP TABLE IF EXISTS `right_or_wrong`;
CREATE TABLE `right_or_wrong` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(2000) NOT NULL,
  `rightAnswer` varchar(11) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '2',
  `analysis` varchar(1000) DEFAULT NULL,
  `level` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT '20211001',
  `image` varchar(255) DEFAULT NULL,
  `image_status` int(11) NOT NULL DEFAULT '0',
  `course_id` int(11) NOT NULL,
  `chapter_id` int(11) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20213014 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of right_or_wrong
-- ----------------------------
INSERT INTO `right_or_wrong` VALUES ('20213001', '与有线网相比,无线网的数据传输率一般相对较慢', 'T', '2', null, '1', '20211001', null, '0', '101', '118');
INSERT INTO `right_or_wrong` VALUES ('20213002', 'OSI参考模型中,不同节点的同等层具有不同的功能', 'F', '2', null, '1', '20211001', null, '0', '101', '102');
INSERT INTO `right_or_wrong` VALUES ('20213003', '普通电脑不能作为服务器', 'F', '2', null, '1', '20211001', null, '0', '101', '119');
INSERT INTO `right_or_wrong` VALUES ('20213004', '没有网线的电脑不能连入互联网', 'F', '2', null, '1', '20211001', null, '0', '101', '117');
INSERT INTO `right_or_wrong` VALUES ('20213005', '网卡必须安装驱动程序', 'F', '2', null, '2', '20211001', null, '0', '101', '117');
INSERT INTO `right_or_wrong` VALUES ('20213006', 'UTP为屏蔽双绞线', 'F', '2', null, '2', '20211001', null, '0', '101', '118');
INSERT INTO `right_or_wrong` VALUES ('20213007', '网络接口卡又称为网卡,它是构成网络的基本部件', 'T', '2', null, '2', '20211001', null, '0', '101', '117');
INSERT INTO `right_or_wrong` VALUES ('20213008', '无线AP可以成倍地扩展网络覆盖范围', 'T', '2', null, '2', '20211001', null, '0', '101', '117');
INSERT INTO `right_or_wrong` VALUES ('20213009', 'SMTP是一组用于由源地址到目的地址传送邮件的协议', 'T', '2', null, '2', '20211001', null, '0', '101', '118');
INSERT INTO `right_or_wrong` VALUES ('20213010', '利用BT下载时,用户越多,下载速度越快', 'T', '2', null, '2', '20211001', null, '0', '101', '117');
INSERT INTO `right_or_wrong` VALUES ('20213011', '任务管理器可以关闭所有的进程', 'F', '2', null, '2', '20211001', null, '0', '101', '119');
INSERT INTO `right_or_wrong` VALUES ('20213012', 'INTERNET上向朋友发送电子邮件,必须知道对方的真实姓名和家庭住址', 'F', '2', null, '2', '20211001', null, '0', '101', '119');
INSERT INTO `right_or_wrong` VALUES ('20213013', 'CD光盘上记录数据的数据道是一条由里向外的螺旋道。', 'T', '2', '概念题，CD光盘上记录数据的数据道是一条由里向外的螺旋道。', '2', '20211001', null, '0', '103', '120');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `score` int(5) DEFAULT NULL,
  `answerDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '2021002', '20212001', '6', '2021-05-07');
INSERT INTO `score` VALUES ('2', '2021002', '20212001', '12', '2021-05-07');
INSERT INTO `score` VALUES ('3', '2021002', '20212001', '75', '2021-05-07');
INSERT INTO `score` VALUES ('4', '2021002', '20212001', '149', '2021-05-08');
INSERT INTO `score` VALUES ('5', '2021002', '20212001', '114', '2021-04-08');
INSERT INTO `score` VALUES ('6', '2021002', '20212002', '6', '2021-05-08');
INSERT INTO `score` VALUES ('7', '2021002', '20212002', '6', '2021-05-08');
INSERT INTO `score` VALUES ('8', '2021002', '20212001', '2', '2021-05-16');

-- ----------------------------
-- Table structure for selectproblem
-- ----------------------------
DROP TABLE IF EXISTS `selectproblem`;
CREATE TABLE `selectproblem` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(2000) NOT NULL,
  `choice_A` varchar(400) NOT NULL,
  `choice_B` varchar(400) NOT NULL,
  `choice_C` varchar(400) NOT NULL,
  `choice_D` varchar(400) NOT NULL,
  `analysis` varchar(400) DEFAULT NULL,
  `rightAnswer` varchar(10) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '2',
  `level` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT '20211001',
  `image` varchar(255) DEFAULT NULL,
  `Image_status` int(11) NOT NULL DEFAULT '0',
  `course_id` int(11) NOT NULL,
  `chapter_id` int(11) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20211010 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of selectproblem
-- ----------------------------
INSERT INTO `selectproblem` VALUES ('20211001', '已知一棵二叉树的树形如下图所示，其后序序列为e，a，c，b，d，g，f，树中与结点a\r\n同层的结点是', 'c', 'd', 'f', 'g', null, 'B', '2', '2', '20211001', '001.png', '1', '100', '109');
INSERT INTO `selectproblem` VALUES ('20211002', '设有如下图所示的火车车轨，入口到出口之间有n条轨道，列车的行进方向均为从左至右，列车可驶入任意一条轨道。现有编号为1～9的9列列车，驶入的次序依次是8，4，2，5，3， 9，1，6，7。若期望驶出的次序依次为1～9，则n至少是', '2', '3', '4', '5', null, 'C', '2', '3', '20211001', '002.png', '1', '100', '108');
INSERT INTO `selectproblem` VALUES ('20211003', '使用迪杰斯特拉(Dijkstra)算法求下图中从顶点1到其他各顶点的最短路径，依次得到的各最短路径的目标顶点是', '5，2，3，4，6', '5，2，3，6，4', '5，2，4，3，6', '5，2，6，3，4', null, 'B', '2', '3', '20211001', '003.png', '1', '100', '110');
INSERT INTO `selectproblem` VALUES ('20211004', 'DNS 服务器和DHCP服务器的作用是（）', '将IP地址翻译为计算机名，为客户机分配IP地址', '将IP地址翻译为计算机名、解析计算机的MAC地址', '将计算机名翻译为IP地址、为客户机分配IP地址', '将计算机名翻译为IP地址、解析计算机的MAC地址', null, 'C', '2', '2', '20211001', null, '0', '101', '119');
INSERT INTO `selectproblem` VALUES ('20211005', 'HTTP协议通常使用什么协议进行传输（）', 'ARP', 'DHCP', 'UDP', 'TCP', null, 'D', '2', '2', '20211001', null, '0', '101', '119');
INSERT INTO `selectproblem` VALUES ('20211006', '在TCP协议中采用（ ）来区分不同的应用进程', '端口号', 'IP地址', '协议类型', 'MAC地址', '', 'A', '2', '3', '20211001', null, '0', '101', '118');
INSERT INTO `selectproblem` VALUES ('20211007', '可靠的传输协议中的“可靠”指的是（ ）', '使用面向连接的会话', '使用“尽力而为”的传输', '使用滑动窗口来维持可靠性', '使用确认重传机制来确保传输的数据不丢失', '', 'D', '2', '2', '20211001', null, '0', '101', '118');
INSERT INTO `selectproblem` VALUES ('20211008', '在Internet上用TCP/IP播放视频，想用传输层的最快协议，以减少时延，要使用（ ）', 'UDP协议的低开销特性', 'UDP协议的高开销特性', 'TCP协议的低开销特性', 'TCP协议的高开销特性', '无', 'A', '2', '2', '20211001', null, '0', '101', '118');
INSERT INTO `selectproblem` VALUES ('20211009', '在决定选取何种存储结构时，一般不考虑（）', '各节点的值', '结点个数多少', '对数据有哪些运算', '所用的编程语言', '选取存储结构时不考虑使用何种编程语言，另外三个选项都需要进行考虑，根据不同情况选用合适的数据结构。', 'D', '2', '2', '20211001', null, '0', '100', '100');

-- ----------------------------
-- Table structure for short_question
-- ----------------------------
DROP TABLE IF EXISTS `short_question`;
CREATE TABLE `short_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(2000) NOT NULL,
  `rightAnswer` varchar(5000) NOT NULL,
  `analysis` varchar(5000) DEFAULT '',
  `score` int(11) NOT NULL DEFAULT '15',
  `level` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL DEFAULT '20211001',
  `image` varchar(255) DEFAULT NULL,
  `Image_status` int(11) NOT NULL DEFAULT '0',
  `course_id` int(11) NOT NULL,
  `chapter_id` int(11) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20214003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of short_question
-- ----------------------------
INSERT INTO `short_question` VALUES ('20214001', '简述进程和线程的区别与联系', '线程是进程中执行运算的最小单位，是进程中的一个实体，是被系统独立调度和分派的基本单位，线程自己不拥有系统资源，只拥有一点在运行中必不可少的资源，但它可与同属一个进程的其它线程共享进程所拥有的全部资源。一个线程可以创建和撤消另一个线程，同一进程中的多个线程之间可以并发执行。\n\n\n', '详情见答案', '10', '3', '20211001', '', '0', '102', '105');
INSERT INTO `short_question` VALUES ('20214002', '简述一个完整的计算机系统有哪些部分组成。', '一个完整的计算机系统由硬件系统和软件系统所组成。其中硬件系统包括:输入设备、控制器、运算器、存储器和输出设备五部分。软件系统则由系统软件和应用软件所组成。', '详情见答案', '15', '2', '20211001', null, '0', '103', '106');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) NOT NULL,
  `student_password` varchar(255) NOT NULL,
  `student_phone` varchar(11) DEFAULT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `role` int(1) DEFAULT '2',
  `disabled_flag` int(1) DEFAULT '0',
  `student_school` varchar(255) DEFAULT NULL,
  `student_major` varchar(255) DEFAULT NULL,
  `sex` int(1) DEFAULT '1',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20212005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20212001', '陈龙龙', '123', '15896993517', '574746989@qq.com', '2', '1', '河南科技大学', '计算机科学与技术', '1');
INSERT INTO `student` VALUES ('20212002', '李哲', '1234', '15478996541', '8888@qq.com', '2', '1', '河南科技大学', '计算机科学与技术', '0');
INSERT INTO `student` VALUES ('20212003', '陈旭阳', '123', '15896554784', '777@qq.com', '2', '0', '河南科技大学', '计算机科学与技术', '0');
INSERT INTO `student` VALUES ('20212004', '翟西零', '123', '15896998741', '555@qq.com', '2', '1', '河南科技大学', '计算机科学与技术', '1');

-- ----------------------------
-- Table structure for submenu
-- ----------------------------
DROP TABLE IF EXISTS `submenu`;
CREATE TABLE `submenu` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `mid` int(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submenu
-- ----------------------------
INSERT INTO `submenu` VALUES ('100', '用户列表', '/user', '100');
INSERT INTO `submenu` VALUES ('101', '快速刷题', '/practice', '101');
INSERT INTO `submenu` VALUES ('102', '练透考点', '/knowledge', '101');
INSERT INTO `submenu` VALUES ('103', '真题演练', '/past_exam', '101');
INSERT INTO `submenu` VALUES ('104', '精品课程', '/course', '101');
INSERT INTO `submenu` VALUES ('105', '试题管理', '/manage_exam', '102');
INSERT INTO `submenu` VALUES ('106', '个人信息', '/manage_info', '103');
INSERT INTO `submenu` VALUES ('107', '刷题记录', '/exam_log', '103');
INSERT INTO `submenu` VALUES ('108', '收藏题目', '/exam_love', '103');
INSERT INTO `submenu` VALUES ('109', '错题本', '/exam_book', '103');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) NOT NULL,
  `teacher_password` varchar(255) NOT NULL,
  `teacher_phone` varchar(255) DEFAULT NULL,
  `teacher_email` varchar(255) DEFAULT NULL,
  `teacher_type` varchar(255) DEFAULT NULL,
  `disabled_flag` int(1) DEFAULT '0',
  `role` int(1) DEFAULT '1',
  `sex` int(1) DEFAULT '1',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20211009 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('20211001', '陈龙龙', '123', '15896993517', '574746989@qq.com', '教授', '1', '1', '1');
INSERT INTO `teacher` VALUES ('20211003', '花花', '123', '12589665474', '777@qq.com', '教授', '0', '1', '1');
INSERT INTO `teacher` VALUES ('20211004', '翟熙菱', '123', '15896886547', '4444@qq.com', '教授', '1', '1', '1');
INSERT INTO `teacher` VALUES ('20211006', '陈旭阳', '123', '15896558541', '7777@qq.com', '教授', '1', '1', '0');
INSERT INTO `teacher` VALUES ('20211008', '李哲', '123', '18585889651', '4444@qq.com', '教授', '1', '1', '1');

-- ----------------------------
-- Table structure for test_paper_info
-- ----------------------------
DROP TABLE IF EXISTS `test_paper_info`;
CREATE TABLE `test_paper_info` (
  `paper_id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_name` varchar(255) NOT NULL,
  `teacher_id` int(11) DEFAULT '20211001',
  `mark` int(11) NOT NULL DEFAULT '150',
  `totalTime` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `publish_flag` int(11) NOT NULL DEFAULT '0',
  `create_date` varchar(255) DEFAULT NULL,
  `tips` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2021009 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_paper_info
-- ----------------------------
INSERT INTO `test_paper_info` VALUES ('2021001', '测试1', '20211001', '150', '180', '模拟题', '1', '2021-04-13', '别想一下造出大海，必须先由小河川开始。');
INSERT INTO `test_paper_info` VALUES ('2021002', '测试2', '20211001', '150', '180', '模拟题', '1', '2021-04-14', '别想一下造出大海，必须先由小河川开始。');
INSERT INTO `test_paper_info` VALUES ('2021003', '测试3', '20211001', '150', '180', '模拟题', '1', '2021-04-12', '有事者，事竟成；破釜沉舟，百二秦关终归楚；苦心人，天不负；卧薪尝胆，三千越甲可吞吴。');
INSERT INTO `test_paper_info` VALUES ('2021004', '测试4', '20211001', '150', '180', '模拟题', '0', '2021-04-14', '每一份付出，都将得到回报');
INSERT INTO `test_paper_info` VALUES ('2021006', '测试6', '20211001', '150', '180', '真题', '0', '2021-04-25', '多做一道题，成功多一分');
INSERT INTO `test_paper_info` VALUES ('2021007', '测试7', '20211001', '100', '120', '模拟题', '0', '2021-04-25', '别想一下造出大海，必须先由小河川开始。');
INSERT INTO `test_paper_info` VALUES ('2021008', '模拟1', '20211001', '100', '120', '模拟题', '1', '2021-04-25', '人之所以有一张嘴，而有两只耳朵，原因是听的要比说的多一倍。');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'chenlong', '24', '学生', '河南科技大学', '计算机科学与技术', '574746989@qq.com', '15896993517');
