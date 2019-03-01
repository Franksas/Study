# Oracle第三天
##### 事务的特性
- 1.原子性
- 2.一致性
- 3.隔离性
- 4.持久性

多个事务并发所可能存在的问题：
- 1.脏读
- 2.不可重复读
- 3.幻读
##### 1、DML语言
- 插入数据
- 向班级表插入一条完整的记录。
INSERT INTO t_class VALUES('101','计科一班');
- 向学生表插入一条记录，只插入学号，姓名，电话三个值的信息。
INSERT INTO t_student(sno,sname,telephone)  VALUES('yc001','王五'，'13509876767' );

- 删除语句
删除sno为2的记录
DELETE FROM  t_student WHERE sno = 'yc002';
删除t_test所有记录
DELETE FROM  t_test;

##### 2、序列
- 创建序列
 ````
   create sequence SEQ_T_CLASS
   minvalue 1
   maxvalue 99
  start with 8
  increment by 1
  nocache;
  使用序列
 INSERT INTO T_CLASS(cno,cname) - - VALUES(seq_t_class.nextval,'aaa'||seq_t_class.nextval);
 ````
##### 3、事务（hr用户下）
  ````
CREATE table new_emp (employee_id NUMBER,name VARCHAR2(30));
INSERT INTO new_emp SELECT employee_id,last_name FROM employees;
SAVEPOINT s2;
DELETE FROM new_emp;
ROLLBACK to s2;
DELETE FROM new_emp WHERE employee_id=180;
UPDATE new_emp SET name='James';
ROLLBACK to s2;
UPDATE new_emp SET name ='James' WHERE employee_id=180;
ROLLBACK;
 ````
##### 4、查询
- 以SCOTT用户模式下员工表为例
- 任务、查询所有员工的部门号和姓名,包括rowid伪列。
SELECT deptno,ename,rowid,rownum FROM  emp;

- 查询员工信息：员工号 姓名 月薪 年薪 奖金 年收入(定义别名)
SELECT empno,ename,sal,sal*12,comm,sal*12+NVL(comm,0) AS yearsal
FROM emp;           
- 显示昨天，今天，明天的时间。（使用系统虚表dual）
SELECT SYSDATE-1,SYSDATE,SYSDATE+1
FROM dual;
- 去掉重复的行(DISTINCT)在SCOTT模式下，显示emp表中的job(职务）列，要求显示的“职务”记录不重复。
SELECT DISTINCT job FROM emp;
- DISTINCT的作用范围是后面所有字段的组合。
SELECT * FROM emp;
SELECT DISTINCT job,deptno FROM emp;

- 连接符使用||
SELECT ename||'的职位是'||job||',入职时间是'||hiredate FROM emp;
