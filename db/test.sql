
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_url` varchar(255) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_role_resource` (
  `role_id` int(11) DEFAULT NULL,
  `resoruce_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `t_user` VALUES ('1', 'admin', '123456', '1');
INSERT INTO `t_user` VALUES ('2', 'u1', '123456', '1');
INSERT INTO `t_user` VALUES ('3', 'u2', '123456', '1');

INSERT INTO `t_role` VALUES ('1', 'r1');
INSERT INTO `t_role` VALUES ('2', 'r2');

INSERT INTO `t_user_role` VALUES ('2', '1');
INSERT INTO `t_user_role` VALUES ('3', '2');

INSERT INTO `t_resource` VALUES ('1', '/r1.html', null, null, null);
INSERT INTO `t_resource` VALUES ('2', '/r2.html', null, null, null);
INSERT INTO `t_resource` VALUES ('3', '/r3.html', null, null, null);

INSERT INTO `t_role_resource` VALUES ('1', '1');
INSERT INTO `t_role_resource` VALUES ('2', '2');
INSERT INTO `t_role_resource` VALUES ('2', '3');

