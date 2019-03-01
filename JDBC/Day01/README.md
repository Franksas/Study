# JDBC第一天
#####
- JDBC的特性：跨平台，跨数据库
- JDBC中常用的接口和类
- JDBC（Java Database Connectivity）,即 Java 数据库连接。
- JDBC是Oracle公司制定的一套规范（一套接口）。它是一个连接独立数据库的标准Java API，
	用于Java编程语言和广泛的数据库之间的连接。其主要作用是建立 Java 程序及数据库的桥梁，
	实现 Java 和 数据库数据的传递。
- 跨平台
  	Java 是跨平台的语言，JDBC 是用 Java 写的，所以 JDBC 也可以跨平台
- 跨数据库
	   JDBC是Oracle公司指定的一套规范(一套接口), JDBC 可以连接多种数据库。
       驱动: JDBC的实现类.  它由数据库厂商提供.
      我们就可以通过一套规范操作不同的数据库了(多态)

- JDBC中的常用接口和类（API）
	DriverManager
		DriverManager:管理了一组JDBC驱动程序的基本服务。它是一个类。
- 注册驱动   static void registerDriver(Driver driver) 将类加载到内存中：
- Class.forname("全限定名");//类名+包名  比如MySQL的全限定名是com.mysql.jdbc.Driver
-  获取连接
       public static Connection getConnection(String url,
           String user,
           String password)
  		参数说明：
  		    参数1：告诉我们连接哪个类型的数据库及连接哪个具体的数据库
  			   url的组成:    
           协议：数据库类型：子协议 参数1：
       例如：
  		     mysql:  jdbc:mysql://localhost:3306/数据库名称
  			  Oracle: jdbc:oracle:thin@localhost:1521@实例
  			参数2：数据库账户名称
  			参数3：数据库账户密码
-	Connection
		Connection :连接 （接口）
        常用方法：
            1）获取语句执行者
                （了解）Statement createStatement():获取普通的语句执行者，会出现sql注入的问题
                （必须掌握）PreparedStatement preparedStatement(String sql):预编译的语句执行者
                 CallableStatement prepareCall(String sql) ：创建一个 CallableStatement 对象来调用数据库存储过程。
           	2） void setAutoCommit(false) :手动开启事务
			    commit():提交事务
				  rollback():回滚事务
- Statement
		Statement: 语句执行者 ，它是一个接口
		常用方法：
		（1） ResultSet executeQuery(String sql)
				执行给定的 SQL 语句，该语句返回单个 ResultSet 对象

		（2） int executeUpdate(String sql)
				  执行给定 SQL 语句，该语句可能为 INSERT、UPDATE 或 DELETE 语句，或者不返回任何内容的 SQL 语句（如 SQL   DDL 语句）

		（3） void addBatch(String sql)
				  将给定的 SQL 命令添加到此 Statement 对象的当前命令列表中。

		（4） int[] executeBatch()
				  将一批命令提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组
-	PreparedStatement
		PreparedStatement:预编译语句执行者，它也是一个接口，它是Statement的子类
		 常用方法：
		 （1）设置参数（给参数赋值）
					setXxx(int 第几个问号,Object 实际参数);
						常用方法： setInt();
								   setString();
								   setObject();
		 （2）ResultSet executeQuery()
				  在此 PreparedStatement 对象中执行 SQL 查询，并返回该查询生成的 ResultSet 对象。
		 （3）  executeUpdate()
				  在此 PreparedStatement 对象中执行 SQL 语句，该语句必须是一个 SQL 数据操作语言（Data Manipulation Language，DML）语句，比如 INSERT、UPDATE 或 DELETE 语句；或者是无返回内容的 SQL 语句，比如 DDL 语句。
		（4） void addBatch(String sql)
				  将给定的 SQL 命令添加到此 Statement 对象的当前命令列表中。

-	ResultSet
		ResultSet :结果集， 接口
        执行查询语句后返回的结果
        常用方法：
            boolean next():判断是否有下一条记录，若有返回true且将光标移到下一行，若没有返回false;
			光标一开始处于第一条记录的上面
			获取具体内容的方法：
			   getXxx(int|String)
			     若参数为int:第几列
				   若参数为String:列名（字段名）
			    例如：获取username的内容可以通过
				      getString(2)
				    或 getString("username")
				常用的get方法：
				   getInt
				   getString 可以获取字符串类型的值，也可以获取int值
				   getObject 可以获取任意值		
- 导入JDBC连接所需的jar包 （连接数据库所需用的类在jar包里）
			mysql-connector-java-5.1.39-bin.jar     连接MySQL所需的jar包
			jdbc6.jar     连接Oracle所需的jar包

- 关闭连接		
			rs.close();
			stmt.close();
			conn.close();
- 如何防止SQL注入
		使用PreparedStatement对SQL语句进行“预编译”
##### 预编译的优势有哪些？
		 预先进行SQL语句的编译，对于同类SQL多次执行，速度要更快
		 不会出现因“SQL拼接”出现的错误
		 可防止sql的注入问题
