# JDBC第四天
#### DBUtils 开源组件
	如果只使用JDBC进行开发，我们会发现冗余代码过多，为了简化JDBC开发，
	采用apache commons组件一个成员：DbUtils。
	DbUtils就是JDBC的简化开发工具包。需要项目导入commons-dbutils-1.6.jar才能够正常
	使用DBUtils工具。

- 什么是DbUtils
		DbUtils是Apache组织的一个工具类，JDBC的框架，更方便我们使用
		DbUtils是Java编程中的数据库操作实用工具，小巧简单实用。
		DbUtils封装了对JDBC的操作，简化了JDBC操作，可以少写代码。
		DbUtils三个核心功能介绍
		QueryRunner中提供对sql语句操作的API.
		ResultSetHandler接口，用于定义select操作后，怎样封装结果集.
		DbUtils就是一个工具类,定义了关闭资源与事务处理的方法。

-	DbUtils的使用步骤
  		DbUtils使用步骤：
  		1、导入jar包（commons-dbutils-1.4.jar）
  		2、创建一个QueryRunner类 （QueryRunner作用：操作sql语句）
  			  new QueryRunner(DataSource ds)
  		3、编写sql语句   (带？的用于预编译的sql语句)
  		4、执行sql语句   （增删改查CURD）
  			 使用QueryRunner里的方法：
  			query(...)    :执行查询操作（R )
  			update(...) : 执行增删改操作（CUD操作）

-	JavaBean的介绍
  		JavaBean就是一个类，在开发中常用封装数据。具有如下特性
  		1.需要实现接口：java.io.Serializable ，通常实现接口这步骤省略了，不会影响程序。
  		2.提供私有字段：private 类型 字段名;
  		   该类中的成员变量与数据库表中的字段相对应（变量名对应数据库表字段名、变量数据类型对应数据库表字段类型），
  		3.提供公共的getter/setter方法：
  		4.提供无参构造方法
- QueryRunner类
  		QueryRunner核心类
  		 1、作用
  			用于操作sql语句
  		2、构造器（构造方法）
  			QueryRunner qr = new QueryRunner();   //手动提交事务
  			QueryRunner  qr = new QueryRunner(DataSource ds);  // 自动提交事务
  		3、常用方法
  		   update(String sql,Object... params)
  		update(Connection conn, String sql, Object... params) ，用来完成表数据的增加、删除、更新操作
  		query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)，
  		用来完成表数据的查询操作
  		   query (String sql,ResultSetHandle<T> rsh )
		注意： QueryRunner类底层已经帮助我们创建了连接，创建了语句执行者，释放资源。
		使用QueryRunner实现增删改操作
		使用QueryRunner实现查询操作
			query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) ，用来完成表数据的查询操作
			ResultSetHandler结果集处理类的介绍及使用
- ResultSetHandler结果集处理类的介绍及使用
  	ResultSetHandler结果集处理类（封装结果集）：
  	1、ArrayHandler	 将结果集中的第一条记录封装到一个Object[]数组中，
  	数组中的每一个元素就是这条记录中的每一个字段的值
  	2、ArrayListHandler	 将结果集中的每一条记录都封装到一个Object[]数组中，
  	将这些数组再封装到List集合中。
  	3、BeanHandler	 将结果集中第一条记录封装到一个指定的JavaBean中。
  	4、BeanListHandler	 将结果集中每一条记录封装到指定的JavaBean中，
  	将这些JavaBean在封装到List集合中
  	5、ColumnListHandler	 将结果集中指定的列的字段值，封装到一个List集合中
  	6、ScalarHandler	 针对聚合函数，它是用于单数据。返回的是Long类型的值
  	，例如select count(*) from 表操作。
  	7、MapHandler	 将结果集第一行封装到Map集合中,Key 列名, Value 该列数据
  	8、MapListHandler	 将结果集第一行封装到Map集合中,Key 列名, Value 该列数据,
  	Map集合存储到List集合
  	9、KeyedHandler  将结果集中指定的key的值封装到一个Map集合中
