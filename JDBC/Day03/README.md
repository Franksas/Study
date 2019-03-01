# JDBC第三天
#### JDBC中的事务处理
-	事务用法
  1 强制禁用掉 Java 程序自动提交功能 conn.setAutoCommit(false);
  2 当所有代码执行成功时提交 conn.commit();
  3 当程序出问题时回滚 conn.rollback();
  4 设置事务隔离级别
  conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
- 备注：参数说明
      (1)  TRANSACTION_READ UNCOMMITED（读取未提交内容）
      在该隔离级别，所有事务都可以看到其他未提交事务的执行结果。
      本隔离级别很少用于实际应用，因为它的性能也不比其他级别好多少。
      读取未提交的数据，也被称之为脏读（Dirty Read）。

      (2)  TRANSACTION_READ_COMMTIED（读取提交内容）
      这是大多数数据库系统的默认隔离级别（但不是MySQL默认的）。
      它满足了隔离的简单定义：一个事务只能看见已经提交事务所做的改变。
      这种隔离级别 也支持所谓的不可重复读（Nonrepeatable Read），
      因为同一事务的其他实例在该实例处理其间可能会有新的commit，
      所以同一select可能返回不同结果。

      (3)  TRANSACTION_REPEATABLE_READ（可重读）
      这是MySQL的默认事务隔离级别，它确保同一事务的多个实例在并发读取数据时，
      会看到同样的数据行。不过理论上，这会导致另一个棘手的问题：幻读 （Phantom Read）。
      简单的说，幻读指当用户读取某一范围的数据行时，另一个事务又在该范围内插入了新行，
      当用户再读取该范围的数据行时，会发现有新的“幻影” 行。

      (4) TRANSACTION_SERIALIZABLE（可串行化）
           这是最高的隔离级别，它通过强制事务排序，使之不可能相互冲突，
           从而解决幻读问题。简言之，它是在每个读的数据行上加上共享锁。
           在这个级别，可能导致大量的超时现象和锁竞争。
#### JDBC的批处理
- 何为批处理？批处理的使用场合
		一次性发送多条sql,批量执行sql语句就是批处理。

		批处理的应用场景！
		往数据库中插入10000个用户信息
	静态批处理
		 Statement stat = conn.createStatement();
			步骤：

					1 装载SQL代码			 stat . addBatch(SQL语句);
					2 批量执行			stat . executeBatch();
	预编译批处理
		PreparedStatement stat = conn.preparedStatement(sql);
		步骤：

		1 装载SQL代码			prep.addBatch();
		2 批量执行			prep.executeBatch();
			为什么prep.executeBatch()方法返回值-2
			executeBatch方法是提交批处理的命令，返回一个整形数组int[]，数组中的每个数字对应一条命令的影响行数，在Oracle的驱动中没有实现该功能，即提交成功后不能返回影响行数，所以返回-2。
			在JDBC的规范中Statement.SUCCESS_NO_INFO(-2)代表：执行成功，受影响行数不确定
	“预编译批处理”和“静态批处理”的区别和各自的优势
		静态批处理优势：可以处理不同的SQL语句和相同类型的SQL语句
	预编译批处理优势：处理相同的SQL语句时效率高
#### 数据库连接池
  -		数据库连接（Connection）频繁的打开关闭相当耗费资源。
  		为解决这个问题，数据库连接池的原理是系统开启时主动建立足够数额的连接，
  		并且将这些连接组成连接池，每次数据库使用连接的时候从连接池中取出，
  		用完之后再归还给连接池。
  连接池的作用		
  		通过连接池（数据源）可以优化JDBC的操作。
  		使用JDBC的时候，每操作一次都需要获取连接（创建）用完之后把连接释放掉了（销毁），
  		通过连接池来优化CURD操作。
  		连接池用来管理数据库的连接。
  		作用： 提高项目的性能。
  		就是在连接池初始化时存入一定数量的连接，用的时候通过方法获取，
  		不用的时候归还连接即可。

  		用池来管理Connection，这样可以重复使用Connection。有了池，
  		所以我们就不用自己来创建Connection，而是通过池来获取Connection对象。
  		当使用完Connection后，调用Connection的close()方法也不会真的关闭Connection，
  		而是把Connection“归还”给池。池就可以再利用这个Connection对象了。

  		所有连接池必须实现一个接口：javax.sql.DataSource接口
  		获取连接方法：   Connection getConnection()
  		归还连接方法就是以前释放资源的方法，调用connection.close()
-  自定义简易连接池
  		所有连接池必须实现一个接口：javax.sql.DataSource接口
  		获取连接方法：   Connection getConnection()
  		归还连接方法就是以前释放资源的方法，调用connection.close()

##### 常用连接池DBCP和C3P0
		Java为数据库连接池提供了公共的接口：javax.sql.DataSource，各个厂商需要让自己的连接池实现这个接口。这样应用程序可以方便的切换不同厂商的连接池！
		常见的连接池：DBCP、C3P0。

		dbcp与c3p0区别：
		dbcp没有自动回收空闲连接的功能
		c3p0有自动回收空闲连接功能
	连接池的常设属性
		必须项	 driverClassName	 数据库驱动名称
			     url	 数据库的地址
			     username	用户名
			     password	密码
		基本项	 maxActive	 最大连接数量
					  initialSize	 连接池中初始化多少个Connection连接对象
		扩展项	 maxWait	超时等待时间以毫秒为单位 1000等于1秒
		C3P0连接池的常设属性:
		除必须项外，还有下面的常设属性
		1、initialPoolSize  设置初始化连接数
		2 、maxPoolSize  连接池的最大连接数  
		3 、minPoolSize   连接池的最小连接数
-	DBCP的两种配置方式
		硬编码setter方式
			Setter方式：
			//创建数据库连接池
			BasicDataSource bds = new BasicDataSource();
			//对连接池进行基本配置
			bds.setDriverClassName(DRIVER);//这是要连接的数据库的驱动
			bds.setUrl(URL);//指定要连接的数据库地址
			bds.setUsername(USERNAME);//指定要连接数据库的用户名
			bds.setPassword(PASSWORD);//指定要连接数据库的密码
		使用配置文件dbcp.properties
			1. 类路径下提供一个dbcp.properties文件
			编写配置文件，文件的命名必须是dbcp.properties，里面配置项的格式为：
			driverClassName = com.mysql.jdbc.Driver
			url = jdbc:mysql://localhost:3306/test
			username =root
			password =root

			2、编码
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/dbcp.properties"));
			DataSource ds = new BasicDataSourceFactory().createDataSource(prop);
			Connection conn = ds.getConnection();
			System.out.println(conn);
-	C3P0的三种配置方式
		硬编码setter方式
			1.setters一个个地设置各个配置项
			这种方式最繁琐，形式一般是这样：
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			cpds.setDriverClass(“oracle.jdbc.OracleDriver”);
			cpds.setJdbcUrl(“jdbc:oracle:thin:@localhost:1521:orcl”);
			cpds.setUser("scott");
			cpds.setPassword("oracle");
			因为繁琐，所以很不适合采用，于是文档提供了另外两种方式。

		使用配置文件c3p0.properties
			2. 类路径src下提供一个c3p0.properties文件
			文件的命名必须是c3p0.properties，里面配置项的格式为：
			 c3p0.driverClass=com.mysql.jdbc.Driver
			 c3p0.jdbcUrl=jdbc:mysql://localhost:3306/test
			 c3p0.user=root
			c3p0.password=root

			上面只提供了最基本的配置项，其他配置项参照 文档配置，记得是c3p0.后面加属性名就是了，最后初始化数据源的方式就是这样简单：
			 private static ComboPooledDataSource ds = new ComboPooledDataSource(); 				 
			 public static Connection getConnection() {
				try {
					 return ds.getConnection();
				  } catch (SQLException e) {
					 throw new RuntimeException(e);
				 }
			 }

		使用配置文件c3p0-config.xml
