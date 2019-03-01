# 第七天
###
#####PL/SQL基本语法及流程控制
- 介绍：
      1.PL/SQL也是一种程序语言，被叫做支持SQL的程序语言。
      2、PL/SQL 是 Oracle 数据库独有的一种程序语言，是 Oracle 数据库对 SQL 语句的扩展
      3、是把数据操作和查询语句组织在PL/SQL代码的过程性单元中，通过逻辑判断，循环等操作实现复杂的功能或者计算的程序语言。
- SET SEVEROUTPUT ON打开输出方式
- PL/SQL编写规则
  	PL/SQL编程中所允许的使用的合法字符集有：
  	1、大写和小写字母：A~Z或a~z
  	2、数字：0~9
  	3、非显示的字符：制表符、空格和回车
  	4、数学符号：+，-，*，/,>,<,=等
  	5、其他符号：包括( ),{ },[ ],?,!; ,: ,@,#,%,$,&,||, =>等
  	6、除了字符串和日期用单引号“ ‘ ’”引起来，其他的不区分，大小写。
  	为了提高程序可阅读性，建议按照命名规则和书写规则编写PL/SQL。
-	标识符命名规则
			命名规则：
			1、标识符名称必须以字符开头，并且长度不能超过30个字符。
			2、当定义变量时，建议使用v_作为前缀，例如：v__sal 、v_job等
			3、当定义常量时，建议使用c_作为前缀，例如：c_rate
			4、当定义游标时，建议使用_cursor作为后缀或前缀，例如emp_cursor
			5、当定义异常时，建议使用e_作为前缀，例如e_integrity_error
			6、当定义PL/SQL类型时，建议使用_table_type作为后缀，例如: sal_table_type
			7、当定义PL/SQL表变量时，建议使用_tablename作为后缀，例如sal_emp
			8、当定义PL/SQL记录类型时，建议使用_record_type作为后缀，例如：emp_record_type
			9、当定义PL/SQL记录变量时，建议使用_record作为后缀，例如emp_record
			10、存储函数名称建议使用_func作为后缀，例如： raiseSal_func
			11、存储过程名称建议使用_proc作为后缀，例如：raiseSal_proc
-	程序书写规则
			虽然在PL/SQL块中编写SQL语句和PL/SQL语句时，语句既可以使用大写格式，也可以使用小写格式，但是，为了提高程序的可读性和性能，Oracle建议用户按照以下书写规则编写代码：

			1、SQL关键字采用大写格式，例如SELECT  、UPDATE等
			2、PL/SQL关键字采用大写格式，例如DECLARE、BEGIN、END等
			3、数据类型采用大写格式，例如NUMBER、VARCHAR2、DATE等

			4、标识符和参数采用小写格式，例如v_sal 、c_rate等
			5、数据库对象和列采用小写格式，例如：emp、sal、ename等
			6、PL/SQL里的存储函数名称和存储过程名称如果是由多个单词组成，第一个单词小写，后面的单词首字母大写。
- PL/SQL的基本结构
		块是PL/SQL的基本执行单元。PL/SQL程序由三个块组成：声明定义部分（DECLARE）、执行部分（执行体开始BEGIN、执行体结束END）、异常处理部分(EXCEPTION)。
		DECLARE – 可选部分
			变量、常量、复合数据类型、游标、用户定义异常的声明
		BEGIN – 必要部分
			SQL语句和PL/SQL语句构成的执行程序
	  [EXCEPTION
		--异常处理部分]
		END; - 必要部分。

-	注意：
         1、dbms_output 是 Oracle 所提供的系统包
    	  2、put_line 是该包所包含的过程，用于输出字符串信息,输出后换行。dbms_output.put(); 输出不换行。
    	  3、在SQL Plus或SQL Developer 想在控制台输出信息，
		需先执行SET SERVEROUTPUT ON; 打开输入输出方法
		但是在PL/SQL工具中不需要，也不支持，PL/SQL有自己的输入输出控制台。
- 变量的赋值方式 1、直接赋值 	2、SQL赋值
  	数据库赋值是通过 SELECT语句来完成的，每次执行SELECT语句就赋值一次，一般要求被赋值的变量与SELECT中的列名要一一对应
  	格式：SELECT  字段1 ，字段2，... INTO 变量1，变量2，...  FROM  表名……

- 	直接赋值
1、可以定义的时候同时赋值
2、可以先定义，后赋值
--1、定义声明的同时直接赋值：
案例：定义一个变量并在控制台输出。
		  DECLARE
			v_age  NUMBER(3) :=26;--长度为3，初始值为26
		  BEGIN
			dbms_output.put_line(v_age);
		  END;

	- 2、先定义声明变量然后在执行体里给变量赋值
		 DECLARE
				v_age  NUMBER(3);--长度为3，初始值为26
			  BEGIN
			v_age:=26;
				dbms_output.put_line(v_age);
			  END;

-	使用SQL语句赋值
		数据库赋值是通过 SELECT语句来完成的，每次执行SELECT语句就赋值一次，一般要求被赋值的变量与SELECT中的列名要一一对应		
		语法格式：
		SELECT 列名1，列名2... INTO 变量1，变量2...  FROM  表名  WHERE ...;
	从控制台输入值赋值
		通过控制台接收用户输入信息  &变量名
常量
	常量是指其值在程序运行过程中不可改变的数据存储结果。
	定义常量的标准语法格式如下：
	<常量名> CONSTANT <数据类型>:=<常量值>;
	PL/SQL中的数据类型
		简单数据类型(基本数据类型)
##### 一、数值类型
- 1、NUMBER[(precision,scale)]固定长度的整数和浮点数
其子类型（类型别名）：BINARY_INTEGRR、PLS_INTEGER、INTEGER、INT、DOUBLE、DECIMAL等
注：BINARY_INTEGRR、PLS_INTEGER、INTEGER、INT只能存储整数。
- 2、字符类型
CHAR[(maxlength)] 定长字符串类型，最大存2000字节。
VARCHAR2(maxlength) 变长字符串类型，最大长度是4000字节。
LONG类型：表示一个可变的字符串，最大长度是32767字节，而数据库类型的LONG最大长度可达2GB
NCHAR和NVARCHAR2类型，根据各国字符集确定其长度。
- 3、日期类型
DATE 类型：用来存储日期和时间，存储空间是7个字节。
4、布尔类型
BOOLEAN类型：主要用于程序的流程控制和业务逻辑判断，其变量的值可以是TRUE、FALSE或NULL中的一种。
- 创建类型格式：
		TYPE 记录类型名 IS RECORD(  
				Field1 type1 [NOT NULL] [:= exp1 ],
				Field2 type2 [NOT NULL] [:= exp2 ], 
					...
				Fieldn typen [NOT NULL] [:= expn ]
		);
- 注意：RECORD 类型变量声明时可以为 NULL，但必须赋初始值，引用记录型变量的方法是“记录变量名.基本类型变量名”
		参照数据类型
%TYPE类型
		定义一个变量，其数据类型与已经定义的某个数据变量的类型相同，或者与数据库表的某个列的数据类型相同，这时可以使用%TYPE
	使用%TYPE特性的优点：
			所引用的数据库列的数据类型可以不必知道；
			所引用的数据库列的数据类型可以实时改变

- %ROWTYPE类型
%TYPE
定义一个变量，其数据类型与已经定义的某个数据变量的类型相同，或者与数据库表的某个列的数据类型相同，这时可以使用%TYPE
使用%TYPE特性的优点：
	所引用的数据库列的数据类型可以不必知道；
	所引用的数据库列的数据类型可以实时改变
运算符
	- 关系运算符
           =                  等于
  		<> 、!=、~=、^=  不等于
  		 <                 小于
  		 >                 大于
  		 <=             小于等于
  		 >=             大于等于
- 一般运算符
  	算术运算符：
  	+ 、-、*、/
  	赋值号：     ：=
  	范围运算符：   ..
  	字符连接符：  ||

- 逻辑运算符
		IS NULL    是空值
		BETWEEN  介于两者之间
		IN           在一列值中间
		AND         逻辑与
		OR            逻辑或
		NOT          取反
- 流程控制
选择
	IF
		IF语句语法格式：		
		IF 布尔表达式 THEN
			执行语句；
		END IF;
	IF……ELSE
		格式：
		IF 布尔表达式 THEN
			 执行语句;
		ELSE
			  执行语句;
		END IF;
	IF……ELSIF……ELSE
		IF 布尔表达式 THEN
			执行语句;
		ELSIF 布尔表达式 THEN
				执行语句;
		ELSE
				执行语句;
		END IF;
	CASE语句
		当程序中的选择过多时，使用IF条件选择语句会相当繁琐，这时，我们可以使用Oracle提供的CASE语句来实现。

		一、简单CASE语句语法：
		CASE search_expression
			 WHEN expression1 THEN  result1;
			 WHEN expression2 THEN  result2;
			...
			WHEN expressionn THEN resultn;
			[ELSE default_result;]
		END CASE;

		二、搜索CASE语句语法：
		CASE
			 WHEN condition1  THEN result1;
			 WHEN condition2  THEN result2;
			  ...
			 WHEN conditionn  THEN resultn;
			 [ELSE default_result;]
		END CASE;
循环
	LOOP
		格式一
			循环一：LOOP…EXIT…END…LOOP;

			格式：
					LOOP   
						循环语句段;
						IF 条件语句  THEN  
							EXIT;
						ELSE
						不退出循环的处理语句段;
						END IF;
					END LOOP;
		格式二
			循环二：LOOP…EXIT WHEN…END…LOOP
			格式：
					LOOP      
						要执行的语句;  
					  EXIT WHEN <条件语句>  /*条件满足，退出循环语句*/  
					END LOOP;

			注意：
			EXIT WHEN  实际上就相当于
			IF 条件  THEN
			EXIT;
			END IF;

	WHILE
		WHILE…LOOP…END LOOP

		语法格式：
			WHILE <布尔表达式>  LOOP    
				 要执行的语句;
		END LOOP;
	FOR
		格式：
		FOR 循环计数器（变量） IN [ REVERSE ] 下限 .. 上限
		LOOP   
				要执行的语句;
	   END LOOP;
