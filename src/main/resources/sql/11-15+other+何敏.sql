#修改检测项目类型
alter table ddwb_env_standards MODIFY item_name int(11) NOT NULL COMMENT '检测项目';
#添加检测项目单位外键
alter table ddwb_env_standards add constraint fk_item foreign key(item_name) REFERENCES nx_standard_type(value);
#后台权限
INSERT INTO `zishan`.`auth_resource`(`ID`, `CODE`, `NAME`, `PARENT_ID`, `URI`, `TYPE`, `METHOD`, `ICON`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) VALUES (478, '/envtype', '检测类型', 343, NULL, 1, NULL, NULL, 1, NULL, NULL);

INSERT INTO `zishan`.`auth_resource`(`ID`, `CODE`, `NAME`, `PARENT_ID`, `URI`, `TYPE`, `METHOD`, `ICON`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) VALUES (479, '/envmmuban', '基地检测模板', 343, NULL, 1, NULL, NULL, 1, NULL, NULL);