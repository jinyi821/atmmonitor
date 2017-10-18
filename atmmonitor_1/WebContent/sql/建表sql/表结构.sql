---------------------------------------------
-- Export file for user AUTOOM             --
-- Created by TMP246 on 2017/5/16, 9:52:41 --
---------------------------------------------

set define off
spool aa.log

prompt
prompt Creating table ZNXJ_BELONG
prompt ==========================
prompt
create table ZNXJ_BELONG
(
  id      VARCHAR2(100) not null,
  engname VARCHAR2(200),
  chsname VARCHAR2(400)
)
;
alter table ZNXJ_BELONG
  add constraint PK_ZNXJ_BELONG primary key (ID);

prompt
prompt Creating table ZNXJ_PROCESS
prompt ===========================
prompt
create table ZNXJ_PROCESS
(
  id        INTEGER not null,
  task_name VARCHAR2(200),
  status    VARCHAR2(200),
  dstatus   VARCHAR2(200),
  value     VARCHAR2(4000),
  ne_name   VARCHAR2(200),
  ne_region VARCHAR2(200),
  ne_vendor VARCHAR2(200),
  ne_type   VARCHAR2(200),
  starttime DATE not null,
  endtime   DATE,
  neunit    VARCHAR2(100) default ('市属'),
  flag      INTEGER default 1 not null,
  report    CLOB
)
;
comment on column ZNXJ_PROCESS.task_name
  is '任务名称';
comment on column ZNXJ_PROCESS.status
  is '登录状态';
comment on column ZNXJ_PROCESS.dstatus
  is '结果状态';
comment on column ZNXJ_PROCESS.value
  is '结果';
comment on column ZNXJ_PROCESS.ne_name
  is '网元名称';
comment on column ZNXJ_PROCESS.ne_region
  is '城市';
comment on column ZNXJ_PROCESS.ne_vendor
  is '厂家';
comment on column ZNXJ_PROCESS.ne_type
  is '类型';
comment on column ZNXJ_PROCESS.starttime
  is '开始时间';
comment on column ZNXJ_PROCESS.endtime
  is '结束时间';
comment on column ZNXJ_PROCESS.flag
  is '1 手动执行 2 自动执行';
comment on column ZNXJ_PROCESS.report
  is '报文';
alter table ZNXJ_PROCESS
  add constraint PK_ZNXJ_PROCESS primary key (ID);

prompt
prompt Creating table ZNXJ_REGION
prompt ==========================
prompt
create table ZNXJ_REGION
(
  id      VARCHAR2(100) not null,
  engname VARCHAR2(200) not null,
  chsname VARCHAR2(400)
)
;
alter table ZNXJ_REGION
  add constraint PK_ZJXJ_REGION primary key (ID);

prompt
prompt Creating table ZNXJ_STRUCTURED
prompt ==============================
prompt
create table ZNXJ_STRUCTURED
(
  id          INTEGER not null,
  task_belong INTEGER,
  task_vendor INTEGER,
  task_type   INTEGER
)
;
alter table ZNXJ_STRUCTURED
  add constraint PK_ZNXJ_STRUCTURED primary key (ID);

prompt
prompt Creating table ZNXJ_TASK
prompt ========================
prompt
create table ZNXJ_TASK
(
  id           INTEGER not null,
  task_name    VARCHAR2(255),
  ne_vendor    VARCHAR2(100),
  ne_type      VARCHAR2(255),
  program_id   VARCHAR2(255),
  program_name VARCHAR2(255),
  rule         CLOB,
  resources_id VARCHAR2(255)
)
;
alter table ZNXJ_TASK
  add constraint PK_CRUISERTEMPLATEINFO_1 primary key (ID);

prompt
prompt Creating table ZNXJ_TYPE
prompt ========================
prompt
create table ZNXJ_TYPE
(
  id      VARCHAR2(100) not null,
  engname VARCHAR2(200) not null,
  chsname VARCHAR2(400)
)
;
alter table ZNXJ_TYPE
  add constraint PK_ZNXJ_TYPE primary key (ID);

prompt
prompt Creating table ZNXJ_VENDOR
prompt ==========================
prompt
create table ZNXJ_VENDOR
(
  id      VARCHAR2(100) not null,
  engname VARCHAR2(200),
  chsname VARCHAR2(400)
)
;
alter table ZNXJ_VENDOR
  add constraint PK_ZNXJ_VENDOR primary key (ID);


spool off
