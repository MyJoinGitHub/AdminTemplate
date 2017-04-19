DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `resource_code` varchar(50) DEFAULT '' COMMENT '资源编码',
  `resource_name` varchar(50) DEFAULT '' COMMENT '资源名称',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源信息表';

DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `permission_code` varchar(50) DEFAULT '' COMMENT '权限编码',
  `permission_name` varchar(50) DEFAULT '' COMMENT '权限名称',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限信息表';

DROP TABLE IF EXISTS `t_permission_resource`;
CREATE TABLE `t_permission_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `permission_id` bigint(50) DEFAULT '0' COMMENT '权限标识',
  `resource_id` bigint(50) DEFAULT '0' COMMENT '资源标识',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源-权限信息表';

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `role_code` varchar(50) DEFAULT '' COMMENT '角色编码',
  `role_name` varchar(50) DEFAULT '' COMMENT '角色名称',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';

DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `role_id` bigint(50) DEFAULT '0' COMMENT '角色标识',
  `permission_id` bigint(50) DEFAULT '0' COMMENT '权限标识',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-权限信息表';

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `user_code` varchar(50) DEFAULT '' COMMENT '用户编码',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户名称',
  `user_password` varchar(50) DEFAULT '' COMMENT '用户密码',
  `user_telephone` varchar(20) DEFAULT '' COMMENT '用户固定电话',
  `user_mobile` varchar(20) DEFAULT '' COMMENT '用户移动电话',
  `user_email` varchar(20) DEFAULT '' COMMENT '用户邮箱',
  `user_address` varchar(50) DEFAULT '' COMMENT '用户地址',
  `last_login_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '用户最后登录时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `user_id` bigint(50) DEFAULT '0' COMMENT '用户标识',
  `role_id` bigint(50) DEFAULT '0' COMMENT '角色标识',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';

DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `group_code` varchar(50) DEFAULT '' COMMENT '用户组编码',
  `group_name` varchar(50) DEFAULT '' COMMENT '用户组名称',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组信息表';

DROP TABLE IF EXISTS `t_group_role`;
CREATE TABLE `t_group_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `group_id` bigint(50) DEFAULT '0' COMMENT '用户组标识',
  `role_id` bigint(50) DEFAULT '0' COMMENT '角色标识',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';

DROP TABLE IF EXISTS `t_group_user`;
CREATE TABLE `t_group_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `group_id` bigint(50) DEFAULT '0' COMMENT '用户组标识',
  `user_id` bigint(50) DEFAULT '0' COMMENT '用户标识',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';

DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `dictionary_code` varchar(50) DEFAULT '' COMMENT '数据字段编码',
  `dictionary_name` varchar(50) DEFAULT '' COMMENT '数据字段名称',
  `dictionary_type_id` bigint(50) DEFAULT '0' COMMENT '数据字段类型标识',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字段信息表';

DROP TABLE IF EXISTS `t_system_param`;
CREATE TABLE `t_system_param` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识',
  `sys_param_code` varchar(50) DEFAULT '' COMMENT '系统参数编码',
  `sys_param_value` varchar(50) DEFAULT '' COMMENT '系统参数值',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除标志。0：不删除，1：已删除',
  `creator` bigint(20) DEFAULT '0' COMMENT '创建人标识',
  `modifier` bigint(20) DEFAULT '0' COMMENT '修改人标识',
  `create_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '1970-01-01 00:00:00' COMMENT '最后更新时间',
  `sys_version` int(11) DEFAULT '0' COMMENT '版本号',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数信息表';

