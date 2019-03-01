# Oracle第二天
#####	常用的数据字典：
		dba_tablespaces  关于表空间的信息
		dba_ts_quotas   所有用户表空间限额
		dba_free_space  所有表空间中的自由分区
		dba_segments  描述数据库中所有段的存储空间
		dba_extents  数据库中所有分区的信息
		dba_tables   数据库中所有数据表的描述
		v$database  描述关于数据库的相关信息
		v$datafile  数据库使用的数据文件信息
		v$log      从控制文件中提取有关重做日志组的信息
		v$logfile   有关实例重置日志组文件名及其位置的信息
#### SQL*Plus工具主要用来进行数据查询和数据处理。利用SQL*Plus可将SQL和Oracle专有的PL/SQL结合起来进行数据查询和处理。
#### 	登录：
- 1、sys管理员，登录不需要密码也可以
		可以在运行窗口输入下面命令
		SQLPLUS  / AS SYSDBA      数据库管理员身份
		SQLPLUS  sys/sys@IP地址：1521/ORCL  [ AS SYSDBA]
- 2、SQLPLUS  system/system@orcl
		@orcl一般不用写，如果在当前数据库服务器上操作，默认的数据库就是orcl，所以不用写，省略。
- 3、sqlplus
			用户名：scott
			密码    ：scott  (自己装数据库设的密码)
- 4、修改账号密码的命令：
		ALTER USER scott ACCOUNT UNLOCK;
		alter user hr account unlock;
		ALTER USER scott IDENTIFIED BY scott;
- 5、连接数据库账户,切换连接用户
		   CONN scott/scott
-	6、退出 ：QUIT
- 7.显示当前用户
		show user;
- 8. 链接数据库：打开cmd，输入 sqlplus,敲回车，再输入sys/Oracle11g as sysdba(sys/密码 as sysdba)，如果是管理员，则不用输密码，直接输as sysdba
- 切换账户：conn 名字/密码 as sysdba
- 解锁用户：alter user 名字 account unlock；
- 改密码：alter user 名字 identified by 密码；
- show user； 显示当前用户
- quit 退出
##### Oracle 体系结构
	物理存储结构 包括（数据文件，日志文件和控制文件）
	逻辑存储结构
		Oracle数据库由多个表空间组成，而表空间又由多个段组成，段由多个数据区组成，数据区又由多个数据块组成。
		表空间
			表空间是 ORACLE数据库的逻辑单元。  数据库里有多个表空间  ， 一个表空间可以与多个数据文件（物理结构）关联。
			一个数据库下可以建立多个表空间，一个表空间可以建立多个用户、一个用户下可以建立多个表。
			安装完成后有几个默认的表空间：system ,sysaux,temp,undotbs1, users
			system系统表空间，不建议使用
			users表空间 ，新建用户，如果不指定用户的表空间，默认是这个
			新建专门的表空间，建用户时指定给它。
##### 数据字典
-	一、数据字典也就是系统表，存放数据库相关信息的表。
- 1、数据字典是每个Oracle数据库的核心
-	2、用于描述数据库和它的所有对象
-	3、包括了只读的表和视图
- 4、被SYS用户拥有
-	5、被Oracle Server 维护
- 6、用户可以使用SELECT访问
##### Oracle数据字典的名称由前缀和后缀组成，使用下划线“_”连接，其代表的含义如：
- （1）DBA_：包含数据库实例的所有对象信息。
-	（2) V$_：当前实例的动态视图，包含系统管理和系统优化等所使用的视图。
-	(3) USER_：记录用户的对象信息。
-	(4) GV_：分布式环境下所有实例的动态视图，包含系统管理和系统优化使用的视图。
- (5) ALL_：记录用户的对象信息机被授权访问的对象信息。
##### 一、CONNECT角色： --是授予最终用户的典型权利，最基本的
    ALTER SESSION --修改会话
    CREATE CLUSTER --建立聚簇
    CREATE DATABASE LINK --建立数据库链接
    CREATE SEQUENCE --建立序列
    CREATE SESSION --建立会话
    CREATE SYNONYM --建立同义词
    CREATE VIEW --建立视图
##### 二、RESOURCE角色： --是授予开发人员的
    CREATE CLUSTER --建立聚簇
    CREATE PROCEDURE --建立过程
    CREATE SEQUENCE --建立序列
    CREATE TABLE --建表
    CREATE TRIGGER --建立触发器
    CREATE TYPE --建立类型
##### 三、DBA角色：拥有全部特权，是系统最高权限，只有DBA才可以创建数据库结构，并且系统权限也需要DBA授出，且DBA用户可以操作全体用户的任意基表，包括删除。
##### 数据库的基本操作
- 查看用户的状态
	SELECT username, account_status
	FROM  dba_users;
	常用的用户有：sys  , system, scott  ,hr
	为已有用户解锁及更改设置用户密码
- 为hr用户解锁
			ALTER  USER  hr ACCOUNT UNLOCK;
- 解锁后必须要为用户设置密码
			ALTER USER hr IDENTIFIED BY oracle;
	用户的创建、管理与删除
		使用超级管理员登录后，才有权限自己创建新用户。
- 创建一个新用户myuser，并设置密码，指定默认表空间
	CREATE USER myuser (用户名)  IDENTIFIED BY myuser(密码) DEFAULT TABLESPACE users（表空间）;
- 用户的授权问题
		DCL数据控制语言用于给用户或角色执行权限授予和权限收回操作。
	主要包括GRANT和REVOKE两条命令。其中，GRANT命令用于给用户或角色授予权限，而REVOKE命令则用于收回用户或角色所具有的权限。
	GRANT...TO
	REVOKE...FROM
		GRANT是赋予授权：
-	1、创建用户myuser，密码也是myuser（记得以；分号结束）：
  			 CREATE USER myuser IDENTIFIED BY myuser;
- 2、给用户或角色授权可以连接数据库：
  			--必须给CREATE SESSION权限（允许用户登陆Oracle）
  			例如：给用户mytest授权连接数据库的权限：
  			GRANT CREATE SESSION TO myuser;
-	3、给mytest分配创建表的权限；
  			GRANT CREATE TABLE TO myuser;
- 4、给mytest分配表空间的使用权限；
      	GRANT UNLIMITED TABLESPACE TO myuser;
  			给用户myuser授权所有权限
  			GRANT RESOURCE,DBA,CONNECT TO myuser;
  			Oracle中已存在三个重要的预定义角色：
  			CONNECT角色，RESOURCE角色，
  			DBA角色。
  		REVOKE  RESOURCE,DBA,CONNECT FROM myuser;		
- 	删除用户myuser
			DROP USER myuser CASCADE;
			DROP...CASCADE  级联删除，连其他的与myuser相关的对象信息及数据都被删除。		

- 什么是SQL？
SQL，指结构化查询语言，全称是 Structured Query Language。SQL 是用于访问和处理数据库的可以与数据库交互的计算机语言。
SQL 是一种 ANSI（American National Standards Institute 美国国家标准化组织）标准的计算机语言。
SQL属于非过程化语言。
##### SQL语言分类
- 1、DDL是Data Define  Language 的简称，是数据定义语言，主要用于定义和管理数据库的各种对象。如：数据表，视图，索引。
	对数据表进行创建，修改，删除的操作使用的SQL语言属于DDL（Data Define Language）数据定义语言。
	针对的是数据表的结构，不是数据表里的数据。
- 2、DML(Data Manipulation Language)数据操作语言：用于插入或更新修改和删除数据。
	INSERT INTO...   、UPDATE  ...SET...
	DELETE FROM..
- 3、DQL（Data Query Language）数据查询语言主要用于查询检索数据。
	DQL数据查询语言用于检索数据库中的数据，主要是SELECT语句，它在操作数据库的过程中使用最为频繁。SELECT语句是数据库中非常重要的SQL语句，主要用于数据查询。
- 4、DCL(Data Control Language)数据控制语言： 用于定义数据库用户权限等。
	DCL数据控制语言用于执行权限授予和权限收回操作。
	主要包括GRANT和REVOKE两条命令。其中，GRANT命令用于给用户或角色授予权限，而REVOKE命令则用于收回用户或角色所具有的权限。
	GRANT...TO..;
	REVOKE  ...FROM...;
-	5、TCL(Transaction Control Language）事务控制语言用于维护数据的一致性，包括COMMIT、ROLLBACK和SAVEPOINT 语句。
	其中，COMMIT语句用于提交对数据库的更改，ROLLBACK语句用于取消对数据库的更改，而SAVEPOINT语句则用于设置保存点。

##### 2、常用数据类型
	CHAR(size) 定长字符串
		CHAR(size)：  CHAR(20)    
		定长字符串 ，最多存储2000byte
		所谓固定长度：是指虽然输入的字段值小于该字段的限制长度，但是实际存储数据时，会先自动向右补足空格后，才将字段值的内容存储到数据块中。这种方式虽然比较浪费空间，但是存储效率较可变长度类型要好。同时还能减少数据行迁移情况发生。
		CHAR是区分中英文的，中文在CHAR中占两个字节，而英文占一个，所以CHAR(20)你只能存20个字母或10个汉字。
	VARCHAR2(size)变长字符串
		VARCHAR2(size)：可变长字符串，最多存储4000byte
		所谓可变长度：是指当输入的字段值小于该字段的限制长度时，直接将字段值的内容存储到数据块中，而不会补上空白，这样可以节省数据块空间。
	NUMBER数值类型
		NUMBER(n)表示一个整数，长度是n
		NUMBER(m,n):表示一个小数，总长度是m，小数是n，整数是m-n
		NUMBER(10,2):整数部分占 8 位，小数部分占2位
	DATE 日期类型
		DATE 表示日期类型
		（在英文版本的ORACLE中默认日期格式为'DD-MON-YY',例如'01-JAN-98'
		在汉化的中文版本中ORACLE默认日期格式为'日-月-年',例如'21-8月-2003'或'21-8月-03'）
	BLOB大数据类型
		BLOB是按二进制来存储的。它用于存储数据库中的大型二进制对象。可存储的最大大小为4G字节。
		为了更好的管理ORACLE数据库，通常像图片、文件、音乐等信息就用BLOB字段来存储，先将文件转为二进制再存储进去。
	CLOB大数据类型
		CLOB是可以直接存储文字的。单位字符串数据最大字节数4G。
		像文章或者是较长的文字，就用CLOB存储，这样对以后的查询更新存储等操作都提供很大的方便。

##### 3、(DDL数据定义语言)数据表的操作
- 语法格式：
	CREATE TABLE  表名(   
		字段1  数据类型1，
		字段2   数据类型2，
		字段3    数据类型3，
		字段4    数据类型4 );
-	约束(Constraint)
	是在数据表上强制执行的数据校验规则，用于保护数据的完整。具体包括如下五种
	非空约束：NOT NULL 唯一约束：UNIQUE 主键约束：PRIMARY KEY 外键约束：FOREIGN KEY 检查约束：CHECK（条件）
- 主键约束
			唯一标识表中的某一条记录，相当于非空+唯一，用PRIMARY KEY表示
			一个表中只能有一个主键，可以由一个字段表示，也可以由多个字段联合组成
			如果采用联合主键时，每个字段都不能为空。
		设置方法一：
		CREATE TABLE 表名(
			列名1 数据类型  PRIMARY KEY ,     
			列名2 数据类型 ,
		  列名3 数据类型
		);
		设置方法二：
		CREATE TABLE 表名(
			列名1 数据类型 CONSTRAINT 约束名 PRIMARY KEY,
			列名2 数据类型 ,
		   列名3 数据类型
		);
- 联合主键的设置方法：
		CREATE TABLE 表名(
			列名1 数据类型  ,
			列名2 数据类型,
		  列名3 数据类型 ,
		 CONSTRAINT  约束名
		 PRIMARY KEY (列名1，列名2)
		);
- 非空约束（not null）要确保字段值不能为空		
- 唯一约束 确保所在的字段不出现重复值，但是允许出现 NULL 值，UNIQUE表示，
- 条件约束 也叫检查约束，定义指定字段都必须：满足定义的条件，用CHECK（条件）表示
- 	外键约束 Foreign Key (FK)
		用 REFERENCES 表示参照，主要作用：确保相关的两个字段之间的参照关系
		被参照的表称为主表，参照主表的表被称之子表，子表中的参照字段可以为空或者来自主表

##### 列级约束:
		从形式上看，在每列定义完后马上定义的约束，在逗号之前就定义好了。
		创建方式（在建表的同时创建约束,可以指定约束名）：
		CREATE TABLE 表名1(
		字段1  数据类型1  PRIMARY KEY  ，
		字段2   数据类型2  
		CONSTRAIN  约束名 NOT NULL，
		字段3    数据类型3   UNIQUE，
		字段4    数据类型4   CHECK(条件)
		字段5    数据类型5   REFERENCES 表名2（字段）
		);
		注意：创建表时列级约束中有外键约束时，需要先建父表，再子表，否则，执行出错。
	表级约束
		语法:
		CREATE TABLE 表名(
		字段1  数据类型1  ，
		字段2   数据类型2，
		字段3    数据类型3，
		字段4    数据类型4,
		CONSTRAINT 约束名  PRIMARY KEY(字段1) ,
		CONSTRAINT  约束名  FOREIGN KEY(字段4) REFERENCES 表名2(字段)
		）；
##### 增加约束
- 1.给已创建好的表增加主键约束
		语法：
		ALTER TABLE 表名1   ADD CONSTRAINT  约束名
		PRIMARY KEY(主键列名) ；
		--2.给已创建好的表增加外键约束
		语法：
		ALTER TABLE 表名1   ADD CONSTRAINT  约束名
		FOREIGN KEY(外键列名)  REFERENCES 表名2（主键名）；
- 2. 语法：
		ALTER TABLE 表名 DROP  CONSTRAINT 约束名称;
	2） 删除数据表  DROP	 
	DROP、TRUNCATE都是DDL语句(数据定义语言),执行后会自动提交。
	删除数据表格式：DROP TABLE 表名；
		一、功能
		表中所有数据将被删除
		1、没有完成的事务被提交
		2、所有相关的索引被删除
-	注意： DROP 后的表被放在回收站(user_recyclebin)里了，而不是直接从数据库里删除掉。这样，回收站里的表信息就可以被恢复，或彻底清除。
##### 二、语法
		DROP TABLE table_name;
		清除回收站里的信息：
- 1. 清除指定表：PURGE  TABLE <table_name>;
- 2.清除当前用户的回收站：purge  recyclebin;
-3.清除所有用户的回收站：purge dba_recyclebin;
-	4、若要彻底删除表，不放在回收站，则使用语句：
		DROP TABLE  table_name purge;
		但是这样就无法闪回了。
- 注意事项
		对于Oracle9i:表删除不能恢复
		对于Oracle10g,Oracle11g:可以使用如下命令恢复
		FLASHBACK TABLE  t_student TO BEFORE DROP;
	TRUNCATE  TABLE
- 一、语法
		TRUNCATE  TABLE  table_name;
- 	二、作用
		使用TRUNCATE 删除表格，删除了表里的数据，表结构还在。表格里的数据被清空，数据所占的表空间会释放，但是索引所在的一些存储空间不会被释放。
		运行后会自动提交，包括之前其它未提交的会话，因而一旦清空无法回退。
		只有表格的创建者或者其他拥有删除任意表格权限的用户（如DBA）才能清空表格。
		注意：TRUNCATE  TABLE  后要释放所有表空间可以使用下面语句：
		ALTER TABLE 表名称 DEALLOCATE UNUSED KEEP 0;
		或者 TRUNCATE TABLE 表名称 DROP STORAGE;
##### DROP TABLE与TRUNCATE TABLE的区别
- DROP TABLE :
		表中所有数据将被删除
		1、没有完成的事务被提交
		2、表的结构、属性以及索引也会被删除
		3、删除的表有时候是可以闪回的
		FLASHBACK TABLE  t_student TO BEFORE DROP;
- TRUNCATE  TABLE:
		1、表中所有数据将被删除,但是表结构还在。
		2、数据所占用的存储空间会被释放。其他索引等所有一些表空间不会被释放，如果要被释放 使用TRUNCATE TABLE 表名  DROP STORAGE
		3、运行后会自动提交，包括之前其它未提交的会话，因而一旦清空无法回退。
		只有表格的创建者或者其他拥有删除任意表格权限的用户（如DBA）才能清空表格。
##### 编码规则
	命名规则：
	命名规则注意事项：
	1、必须以字符开头, 不能以数字开头
	2、只能包含A-Z,a-z,0-9,_,$,#
	3、长度不超过30个字符
	4、不要使用Oracle的保留字
	5、同一用户下的对象不能同名
	6、有意义易于理解
##### 为了提高程序可读性，除了满足上面命名规则外，建议按照下面规则命名：
	1、项目系统模块以公司名称缩写开头，例如：YCKJ_
	2、数据库表名以 t_为前缀命名，_例如：t_student ；
	3、对于有主明细的表来说。明细表的名称为：主表的名称 + 字符Dts。例如：采购定单的名称为：PO_order，则采购定单的明细表为：PO_orderDts
	4、字段（列名）要命名有意义，例如
	  name, sex等
	5、约束名以 pk_,fk_, en_, ck_ ,nn_为前缀
	主键约束以pk_为前缀，外键约束以fk_为前缀，唯一约束以en_为前缀，检查约束以ck_为前缀，非空约束nn_为前缀
	6、视图以view_作为前缀，例如：
	view_emp
	7、序列以seq_为前缀,例如：
	 seq_test
	8、索引以index_为前缀，例如：
	  index_stu_cno
	9、触发器以trigger_为前缀,例如：
	  trigger_emp
##### 书写规则：
		为了提高程序的可读性和性能，Oracle建议用户按照以下书写规则编写代码：
		1、SQL的所有关键字采用大写格式，例如CREATE 、SELECT  、UPDATE、INSERT INTO等
		2、数据类型采用大写格式，例如NUMBER、VARCHAR2、DATE等
		3、Oracle常用函数名称采用大写格式
		4、数据表和列名采用小写格式，例如：t_emp、sal、ename等
		5、视图、序列、索引、触发器等数据库对象的名称采用小写，例如view_emp 、emp_deptno_index
		6、约束名称采用小写，例如：fk_emp_deptno
		7、SQL语句以分号;结尾。

- 删除约束
    ALTER TABLE t_student3 DROP CONSTRAINT FK_STU3_CNO;
- 删除表

    CREATE TABLE t_temp(
           id VARCHAR2(20)
    );
    INSERT INTO t_temp VALUES('2');
