# Oracle第四天
#### 基本查询语句
-	指定过滤条件 WHERE子句
		使用特殊关键字筛选
		在WHERE中使用下面特殊关键字

			   关键字	        含义	   
		   BETWEEN...AND... 	   在两值之间(包含)	   
		   IN(目标值1，目标值2...) 	   匹配列出的值	   
		   LIKE 	   匹配一个字符模式	   
		   IS NULL 	   是空值	 

- IN  和 LIKE，NULL，BETWEEN...AND前都可以加NOT 表示否定的判断。
	BETWEEN…AND… ：两个值之间包含边界，等价于……<= AND >=……
			IN ：和多个值的任何一个匹配
			LIKE： 匹配（用于模糊查询）
			LIKE运算符可以使用“%”和“_”进行字符匹配
-	% 表示零或更多任意的字符
-	_ 代表一个字符
-	IS NULL：	是空值  

	 	注：查询条件可包含文字字符或数字
	 	•(%) 表示零或多个字符
		 •( _) 表示一个字符
		 •使用ESCAPE 转义
#### 排序，分组及过滤
##### 排序ORDER BY
 -  使用规则
		    使用ORDER BY 子句将查询出的记录排序
    		 ASC: 升序,缺省
    		DESC: 降序
    		–ORDER BY 子句出现在SELECT语句的最后
    		注意：DESC的作用域是作用在离它最近的列上。
  ##### 分组GROUP BY子句和分组函数
- 语法：
		SELECT column, group_function
		FROM table
		[WHERE condition]
		[GROUP BY group_by_expression]
		[HAVING group_condition]
		[ORDER BY column]；

- 分组函数
	 分组函数用于统计表数据。
		MAX( ) 求最大值 ，返回表达式中所有值的最大值。适用任何数据类型
		MIN( ) 求最小值，返回表达式中所有值的最小值。适用任何数据类型
		AVG( ) 求平均值，返回表达式中所有值的平均值，只能用于数字
		SUM( ) 求和，返回表达式中所有值的和，只能用于数字求和
		COUNT( )  统计计算总行数，返回整数。

		注意：COUNT(*) 与COUNT(列名)的区别：
		COUNT(*)将返回表格中所有存在的行的总数包括值为NULL的行，然而COUNT(列名)将返回表格中除去NULL以外的所有行的总数(有默认值的列也会被计入）.  
		COUNT(DISTINCT 列名),得到的结果将是除去值为NULL和重复数据后的结果  

##### 分组函数使用注意事项
		1、分组函数只能出现在SELECT选择列表、HAVING子句、ORDER BY
		子句中。
		2、在查询SELECT列表中出现的列没有在分组函数中出现的话，就必须在GROUP BY中出现。不使用组函数的字段，必须在 GROUP BY子句中出现
		3、GROUP BY子句的位置在WHERE 子句的后面，ORDER  BY的前面
		4、分组结果限制只能使用HAVING。
- HAVING子句
		HAVING:对分组后的结果进行过滤筛选

-	WHERE子句和HAVING子句的区别
  		（1）WHERE 搜索条件在进行分组操作之前应用。而 HAVING 搜索条件在进行分组操作之后应用。
  		（2）WHERE子句过滤的是行（记录），HAVING子句过滤的是分组（组标识、每组数据的聚合结果）
  		（3）WHERE子句包含单行函数, HAVING子句只能包含GROUP BY后面的表达式和组函数
  		（4）WHERE子句执行在前，HAVING子句执行在后
  		（5）WHERE子句和HAVING子句都不允许用列别名
- SELECT语句书写顺序与实际执行顺序
		查询中用到的关键词主要包含六个，并且SQL语句书写顺序依次为 ：
		SELECT--FROM--WHERE--GROUP BY-HAVING--ORDER BY

		其中SELECT和FROM是必须的，其他关键词是可选的，这六个关键词的执行顺序
		与SQL语句的书写顺序并不是一样的，而是按照下面的顺序来执行
		FROM--WHERE--GROUP BY--HAVING--SELECT--ORDER BY

		FROM:需要从哪个数据表检索数据
		WHERE:过滤表中数据的条件
		GROUP BY:如何将上面过滤出的数据分组
		HAVING:对上面已经分组的数据进行过滤的条件
		SELECT:查看结果集中的哪个列，或列的计算结果
		ORDER BY  :按照什么样的顺序来查看返回的数据

- 1、单行函数
	单行函数
	这些函数仅对单行进行处理，为每行返回一个结果
	多行函数
	这些函数可以处理成组的行，为每组行返回一个结果。
- 字符函数
		返回字符串的小写形式：LOWER(String)
		返回字符串的大写形式：UPPER(String)		
		单词首字母大写：INITCAP(String)		
		返回字符串的长度：LENGTH(String)		
		截取字符串：SUBSTR(String,start_index,length)		
		删除字符串两侧空格：TRIM(String)
- 数值函数
		四舍五入：ROUND(源数值[,小数位数])
		取模操作:MOD(被除数，除数)
		截取数字：TRUNC(源数值[,小数位数])
- 日期函数
		获取系统当前日期：SYSDATE
		将字符串转换成日期：TO_DATE(StrDate，格式)
		为日期加上指定月份：ADD_MONTHS(date，n)
		返回特定日期所在月份的最后一天：LAST_DAY(date)
		返回两个日期所差的月数：MONTHS_BETWEEN(date1，date2)
		返回特定日期之后的一周内的日期：NEXT_DAY(date，n)
		返回日期的某个域--EXTRACT()函数
- 转换函数
		把日期型或数值型数据转换成变长的字符串：TO_CHAR(日期格式，格式)
		把一个数字组成的字符串转换成数值：TO_NUMBER(字符串)
		将字符串转换成日期：TO_DATE(StrDate，格式)
- 通用函数
		空值处理：NVL()
		结果集的行号：ROWNUM
- 分组函数
	最小值:MIN()
	最大值：MAX()
	平均值：AVG()
	统计记录数：COUNT()
	总额：SUM()
- CASE WHEN表达式
	简单CASE函数
		简单Case函数  
		语法：
		CASE search_expression
		WHEN expression1
		THEN result1
		WHEN expression2
		THEN result2
		...
		ELSE default_result
		END
- CASE搜索函数
		语法:
		CASE  WHEN condition1 THEN result1
		WHEN condition2 THEN result2
		　　...
		WHEN conditionN THEN resultN
		ELSE default_result
		END
- DECODE()函数

	语法：
	DECODE(条件,值1,返回值1,值2,返回值2,...值n,返回值n,缺省值)
