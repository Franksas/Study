# 第六天
###
#####子查询
- 定义：子查询是指插入在其他SQL语句中的SELECT语句，也称为嵌套查询。
- 什么时候使用子查询
  	1、当要显示的数据在表里并不存在，但可以通过对已有数据的加工获得，可通过子查询实现。
  	2、子查询可以出现在SELECT、WHERE子句、FROM子句、DML语句、DDL语句中。
  	3、在SELECT、INSERT、UPDATE或DELETE命令中允许是一个表达式的地方都可以包含子查询，子查询甚至可以包含在另外一个子查询中。
- 子查询的编写思路
  	1、仔细分析题目，确定要查询的表及字段（数据）
  	2、分析要查询的字段（数据）哪些在表里直接存在，哪些不存在
  	3、考虑如何把要显示的数据造出来（通过查询语句获得）
  	4、考虑子查询与表的连接点是什么(通常是主外键、共有字段)
  	5、考虑子查询放在什么位置
  	6、组合成完整的SQL语句
- 1、子查询与主查询使用同一张表：任务一：查询与SCOTT在同一部门的员工的姓名，薪水
  	SELECT ename,sal
  	FROM emp
  	WHERE deptno=(SELECT deptno FROM emp
  							   WHERE ename=‘SCOTT’);

-	2、子查询与主查询不是使用的同一张表：任务二  ： 查询部门名称为"RESEARCH"的员工信息(显示员工号，姓名，职位)
  		SELECT empno,ename,sal
  		FROM emp
  		WHERE deptno = (SELECT deptno FROM dept
  									 WHERE dname='RESEARCH');

- 注意：在WHERE中引用单行子查询时，可以使用单行比较操作符=，>, < , >=, <=, <>
在HAVING子句中的单行子查询
  	任务：在SCOTT用户模式下查询出各部门员工的平均工资低于各部门最高平均工资的部门号和部门的平均工资。
  	SELECT deptno,AVG(sal) avgsal
  	FROM emp
  	GROUP BY deptno
  	HAVING  AVG(sal)<( SELECT  MAX(AVG(sal)) FROM emp GROUP BY deptno);		 
- 单行子查询中经常遇到的错误
  	1、因为WHERE条件限定不规范而返回多行，就会出现单行子查询返回多行的错误。
  	2、WHERE子查询中不能包含ORDER BY 子句，相反任何排序都必须在外部查询中完成。
---
##### 多行子查询
-	多行子查询中使用IN操作符
  		当多行子查询中使用IN操作符时，会处理匹配子查询中任一个值的行。
  		任务一.	列出薪金与30号部门员工的薪金相同的所有员工的姓名和薪金。
  		SELECT ename,sal
  		FROM emp
  		WHERE sal IN (SELECT sal FROM emp WHERE deptno = 30);
  		标准嵌套子查询多层嵌套案例：
  		任务.	列出薪水与销售部门的员工薪水相同的所有员工的姓名和薪金。
  		SELECT ename,sal
  		FROM emp
  		WHERE sal  IN (SELECT sal  
  								FROM emp
  								WHERE deptno =   (SELECT   deptno     
  															   FROM dept WHERE  dname = 'SALES'));
- 多行子查询中使用ANY操作符，当多行子查询中使用ANY操作符时，ANY操作符必须与单行操作符结合使用，它会匹配只要符合子查询结果的任一个值的行。
  - 注意：<ANY 比任何一个值都小，>ANY 比任何一个值都大，	=ANY 等效于IN
		任务：在emp表中，查询工资大于部门编号为10的任意一个员工工资的其他部门的员工信息。
		SELECT deptno,ename,sal
		FROM emp
		WHERE sal>ANY(SELECT sal
									  FROM emp
									  WHERE  deptno=10)
		AND deptno<>10;											
-	多行子查询中使用ALL操作符
			当多行子查询中使用ALL操作符时，ALL操作符必须与单行操作符结合使用，它会处理匹配所有子查询结果的行。

			注意： <ALL  比最小值小，>ALL  比最大值大，<>ALL 等效于NOT IN
			任务：显示工资大于所有部门平均工资的雇员姓名,工资
			SELECT  ename,sal
			FROM emp
			WHERE  sal>ALL（SELECT AVG(sal) FROM emp GROUP BY deptno);
-	子查询中使用EXISTS操作符
  		EXISTS操作符：用于检查子查询返回行的存在性。如果子查询返回一行或者多行，EXISTS返回TRUE;如果子查询未返回行，EXISTS返回FALSE
  		任务：查询在“SALES"销售部门的所有员工信息。
  		SELECT  *
  		FROM emp e
  		WHERE  EXISTS (SELECT deptno
  								   FROM dept  d
  								   WHERE e.deptno = d.deptno
  								   AND d.dname='SALES');
  		或者
  		SELECT  *
  		FROM emp e
  		WHERE  EXISTS (SELECT 1
  								   FROM dept  d
  								   WHERE e.deptno = d.deptno
  								   AND d.dname='SALES');
- 多列子查询，说明：子查询只返回多列。
		任务：在SCOTT用户模式下查询显示和ALLEN同部门同职位的员工姓名、职位、部门编号
		SELECT  ename,job,deptno
		FROM emp
		WHERE (deptno,job)=(SELECT deptno,job
											  FROM  emp  
											  WHERE ename = 'ALLEN');
- 	关联子查询
		非关联子查询内查询和外查询是分开执行的，也就是说内查询的执行与外查询的执行没有关系，外查询仅仅是使用内查询的最终结果。
		但是关联子查询中内查询与外查询是相互关联的。
		内查询的执行需要借助于外查询，而外查询的执行又离不开内查询的执行。
		任务： 在emp表中，使用“关联子查询”检索工资大于同职位的平均工资的员工信息(显示字段：员工编号，姓名，工资）。
		SELECT empno,ename,sal
		FROM emp e
		WHERE  sal>(SELECT AVG(sal) FROM emp WHERE job=e.job);
在建表语句中使用子查询
	表的复制:

	CREATE TABLE  表名 	AS  SELECT  语句

-	1、只复制表结构
	CREATE TABLE 表名 	AS   [SELECT 语句 FROM... WHERE 条件不成立]
-	2、连带数据一次性复制

      	CREATE TABLE 表名 	AS [SELECT 语句]
      	任务一  创建一个和员工表一样的表，结构与数据都一样。
      	CREATE TABLE  emp1  AS  
      	SELECT  *  FROM  emp;
      	任务二  创建一个和员工表结构一样的空表。
      	CREATE TABLE  emp2  AS  
      	SELECT  *  FROM  emp
      	WHERE  1=2;
-  在SELECT中使用子查询
  	任务：统计出有奖金和没有奖金的人数
  	 SELECT DISTINCT (SELECT COUNT(comm)
  								FROM emp
  							   WHERE comm !=0 )  "有奖金人数",
  		   (SELECT COUNT(empno)  
  			FROM emp
  			WHERE comm IS NULL OR comm=0)  "没有奖金人数"
  	FROM emp;
- 插入语句中（在INSERT语句中使用子查询）
  	批量插入：
  	INSERT INTO 表名(字段列表) [SELECT 语句];
  	使用INSERET SELECT 语句可以将一个数据表中的数据插入到另一个新的数据表中。插入时要注意以下几点：
  	1、必须保证插入的表已经存在。
  	2、对于插入新数据的表，各个需要插入数据的列与类型必须与源数据表中各列数据类型保持一致
  	3、必须明确是否存在默认值，是否允许为NULL值，如果不允许为空，则必须在插入的时候，为这些列提供列值。

  	注意：插入表的字段个数和类型与SELECT语句中的字段个数和类型要匹配
  	任务： 将20号部门的员工信息插入新的员工表emp2中 （emp2与emp结构一样，没有数据)
  	INSERT INTO emp2(empno,ename,sal,deptno)
  	SELECT empno,ename,sal,deptno FROM emp WHERE deptno=20;
- 更新语句中（在UPDATE语句中使用子查询）
	语法：
  	UPDATE 表名 SET 字段1 = (SELECT  语句）；
  	基于同一张表修改数据：
  	任务：将emp1表里JAMES的职位，薪水，奖金更改为和SCOTT一样的职位，薪水，奖金。
  	UPDATE emp1 SET(job,sal,comm)=(SELECT job,sal,comm FROM emp1 WHERE ename='SCOTT')
  	WHERE ename='JAMES';
- 删除语句中（在DELETE语句中使用子查询）
  	任务一   删除t_test2表中多余的重复记录，重复记录根据单个字段（tid）来判断，只留有rowid最小的记录 （以t_test2（tid,tname,sex,telephone）为例，删除tname重复的记录）
  	DELETE  FROM t_test2
  	WHERE  tname IN (SELECT  tname   FROM  t_test2
  								  GROUP BY   tname     
  								  HAVING COUNT(tname) > 1)
  	AND   tid NOT IN (SELECT  MIN(tid)  FROM t_test2
  								 GROUP BY  tname     
  								 HAVING  COUNT(tname)>1) ;
  FROM子句中使用子查询（分页查询）

#####  使用子查询的注意事项
    	1、要将子查询放入圆括号中。
    	2、子查询可出现在WHERE子句、FROM子句、SELECT 列表（此处只能是一个单行子查询）和HAVING子句,DDL,DML中。
    	3、子查询不能出现在主查询的GROUP BY语句中
    	4、子查询和主查询可以使用不同表，只要子查询返回的结果能够被主查询使用即可。
    	5、单行子查询只能使用单行操作符，多行子查询只能使用多行操作符。
    	6、在多行子查询中，ALL和ANY操作符不能单独使用，而只能与单行比较符（=、<、>、<=、>=、<>)结合使用。
    	7、要注意子查询中的空值问题。如果子查询返回了一个空值，则主查询将不会查询任何结果。
    	8、子查询允许嵌套多层，但不能超过255层。
- 集合操作
    	UNION 并集（去除结果集的重复行）
    		取查询结果的并集，会自动去掉重复行。
    	UNION ALL并集（不去除结果集的重复行）
    		取查询结果的并集，不去掉重复行。不进行排序排列
    	INTERSECT  交集
    		取两个结果集的交集，也就是在两个结果集中都存在的记录。最后结果以第一列的结果进行升序排列
    	MINUS 差集
    		显示在A中存在，而在B中不存在的数据。结果以第一列的结果进行升序排列。
	---
### 索引
- 定义：		索引：类似“目录”，给一张表添加了一个目录
- 索引的作用
		1、为了提高查询效率
		2、通过快速定位数据的方法，减少磁盘I/O操作
- 创建索引的原则
		创建索引的原则：
		一、适合创建索引的情况：
		 1、字段有主键约束
		 2、字段有唯一约束
		 3、字段取值分布范围很广
		 4、字段中包含大量空值
		 5、字段经常出现在 WHERE 子句或连接条件中

	二、不适合建索引的情况：
		1、表很小
		2、字段不经常出现在 WHERE 子句中
		3、字段经常更新
-	如何创建索引
  		CREATE INDEX 索引名称 ON 表名（字段1，字段2）;
  		索引信息与表独立存放
  		Oracle 数据库自动使用和维护索引，不需要特意使用，只需要创建就可以。
  		1、自动: 当在表上定义一个PRIMARY KEY 或者UNIQUE 约束条件时,Oracle数据库自动创建一个对应的唯一索引.
  		2、手动: 用户可以创建索引以加速查询.

- 索引的删除    DROP INDEX 索引名称;
