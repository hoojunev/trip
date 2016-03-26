/**
*Author:itcast
*Date:2016-01-20
*Desc:创建人员组织机构数据库表 数据库已经导入
*/

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/1/20 15:38:59                           */
/*==============================================================*/


drop table if exists t_dept;

drop table if exists t_emp;

drop table if exists t_emp_role;

drop table if exists t_leader;

drop table if exists t_org;

drop table if exists t_privilege;

drop table if exists t_role;

drop table if exists t_role_pri;

/*==============================================================*/
/* Table: t_dept                                                */
/*==============================================================*/
create table t_dept
(
   dept_id              varchar(32) not null,
   org_id               varchar(32) not null,
   name                 varchar(20),
   primary key (dept_id)
);

/*==============================================================*/
/* Table: t_emp                                                 */
/*==============================================================*/
create table t_emp
(
   emp_id               varchar(32) not null,
   dept_id              varchar(32) not null,
   name                 varchar(20),
   primary key (emp_id)
);

/*==============================================================*/
/* Table: t_emp_role                                            */
/*==============================================================*/
create table t_emp_role
(
   role_id              varchar(32) not null,
   emp_id               varchar(32) not null,
   state                bool,
   primary key (role_id, emp_id)
);

/*==============================================================*/
/* Table: t_leader                                              */
/*==============================================================*/
create table t_leader
(
   emp_id               varchar(32) not null,
   dept_id              varchar(32),
   name                 varchar(20),
   position             int,
   primary key (emp_id)
);

/*==============================================================*/
/* Table: t_org                                                 */
/*==============================================================*/
create table t_org
(
   org_id               varchar(32) not null,
   name                 varchar(20),
   primary key (org_id)
);

/*==============================================================*/
/* Table: t_privilege                                           */
/*==============================================================*/
create table t_privilege
(
   pri_id               varchar(32) not null,
   name                 varchar(20),
   primary key (pri_id)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   role_id              varchar(32) not null,
   name                 varchar(20),
   primary key (role_id)
);

/*==============================================================*/
/* Table: t_role_pri                                            */
/*==============================================================*/
create table t_role_pri
(
   role_id              varchar(32) not null,
   pri_id               varchar(32) not null,
   primary key (role_id, pri_id)
);

alter table t_dept add constraint FK_org_dept foreign key (org_id)
      references t_org (org_id) on delete restrict on update restrict;

alter table t_emp add constraint FK_dept_emp foreign key (dept_id)
      references t_dept (dept_id) on delete restrict on update restrict;

alter table t_emp_role add constraint FK_t_emp_role foreign key (role_id)
      references t_role (role_id) on delete restrict on update restrict;

alter table t_emp_role add constraint FK_t_emp_role2 foreign key (emp_id)
      references t_emp (emp_id) on delete restrict on update restrict;

alter table t_leader add constraint FK_Inheritance_1 foreign key (emp_id)
      references t_emp (emp_id) on delete restrict on update restrict;

alter table t_role_pri add constraint FK_belong foreign key (role_id)
      references t_role (role_id) on delete restrict on update restrict;

alter table t_role_pri add constraint FK_own foreign key (pri_id)
      references t_privilege (pri_id) on delete restrict on update restrict;




/**
*Author:itcast
*Date:2016-01-23
*Desc:创建投诉受理数据库表
*/

drop table if exists complain;

/*==============================================================*/
/* Table: complain                                              */
/*==============================================================*/
create table complain
(
   comp_id              varchar(32) not null,
   comp_company         varchar(100),
   comp_name            varchar(20),
   comp_mobile          varchar(20),
   comp_time            datetime,
   to_comp_dept         varchar(100),
   to_comp_name         varchar(20),
   comp_title           varchar(200),
   comp_content         text,
   is_nm                bool,
   state                varchar(1),
   primary key (comp_id)
);


drop table if exists complain_reply;

/*==============================================================*/
/* Table: complain_reply                                        */
/*==============================================================*/
create table complain_reply
(
   reply_id             varchar(32) not null,
   comp_id              varchar(32) not null,
   replyer              varchar(20),
   reply_dept           varchar(100),
   reply_time           datetime,
   content              varchar(500),
   primary key (reply_id)
);

alter table complain_reply add constraint FK_comp_reply foreign key (comp_id)
      references complain (comp_id) on delete restrict on update restrict;

/**
*Author:itcast
*Date:2016-01-26
*Desc:创建月份数据库表
*/
CREATE TABLE `tmonth` (
  `imonth` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`imonth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/**
*Author:itcast
*Date:2016-01-27
*Desc:创建事项表和预约服务表
*/
drop table if exists item;

/*==============================================================*/
/* Table: item                                                  */
/*==============================================================*/
create table item
(
   item_id              varchar(32) not null,
   item_no              varchar(32),
   item_name            varchar(100),
   item_dept            varchar(100),
   item_dealDeptr       varchar(20),
   item_state           varchar(1),
   user_id              varchar(32),
   primary key (item_id)
);

drop table if exists reserve;

/*==============================================================*/
/* Table: reserve                                               */
/*==============================================================*/
create table reserve
(
   reserve_id           varchar(32) not null,
   item_id              varchar(32) not null,
   reserve_no           varchar(32),
   reserve_time         datetime,
   reserve_place        varchar(100),
   reserve_declare      varchar(200),
   name                 varchar(20),
   reserve_mobile       varchar(20),
   reply_time           datetime,
   result               varchar(1),
   content              varchar(500),
   user_id              varchar(32),
   primary key (reserve_id)
);

alter table reserve add constraint FK_item_reserve foreign key (item_id)
      references item (item_id) on delete restrict on update restrict;
