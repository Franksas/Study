# 第四天
##数据库
### JDBC （链接、事务、异常处理）
### 链接
JDBC的特性：跨平台，跨数据库
JDBC中常用的接口和类
JDBC（Java Database Connectivity）,即 Java 数据库连接。
JDBC是Oracle公司制定的一套规范（一套接口）。它是一个连接独立数据库的标准Java API， 用于Java编程语言和广泛的数据库之间的连接。其主要作用是建立 Java 程序及数据库的桥梁， 实现 Java 和 数据库数据的传递。
跨平台
Java 是跨平台的语言，JDBC 是用 Java 写的，所以 JDBC 也可以跨平台
跨数据库
 JDBC是Oracle公司指定的一套规范(一套接口), JDBC 可以连接多种数据库。
 驱动: JDBC的实现类.  它由数据库厂商提供.
我们就可以通过一套规范操作不同的数据库了(多态)
JDBC中的常用接口和类（API） DriverManager
  DriverManager:管理了一组JDBC驱动程序的基本服务。它是一个类。
注册驱动 static void registerDriver(Driver driver) 将类加载到内存中：
Class.forname("全限定名");//类名+包名 比如MySQL的全限定名是com.mysql.jdbc.Driver
获取连接
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
Connection Connection :连接 （接口） 常用方法：
   1）获取语句执行者
       （了解）Statement createStatement():获取普通的语句执行者，会出现sql注入的问题
       （必须掌握）PreparedStatement preparedStatement(String sql):预编译的语句执行者
        CallableStatement prepareCall(String sql) ：创建一个 CallableStatement 对象来调用数据库存储过程。
      2） void setAutoCommit(false) :手动开启事务
       commit():提交事务
         rollback():回滚事务
Statement
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
PreparedStatement PreparedStatement:预编译语句执行者，它也是一个接口，它是Statement的子类
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
ResultSet ResultSet :结果集， 接口 执行查询语句后返回的结果 常用方法：
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
导入JDBC连接所需的jar包 （连接数据库所需用的类在jar包里）

      mysql-connector-java-5.1.39-bin.jar     连接MySQL所需的jar包
      jdbc6.jar     连接Oracle所需的jar包
关闭连接
      rs.close();
      stmt.close();
      conn.close();
如何防止SQL注入
  使用PreparedStatement对SQL语句进行“预编译”
预编译的优势有哪些？
   预先进行SQL语句的编译，对于同类SQL多次执行，速度要更快
   不会出现因“SQL拼接”出现的错误
   可防止sql的注入问题
- 事务
事务用法 1 强制禁用掉 Java 程序自动提交功能 conn.setAutoCommit(false); 2 当所有代码执行成功时提交 conn.commit(); 3 当程序出问题时回滚 conn.rollback(); 4 设置事务隔离级别 conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
备注：参数说明
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
- 异常处理
JDBC 中，和异常相关的两个类是 SQLException 和 SQLWarning。
1. SQLException 类：用来处理较为严重的异常情况。
        比如 :  ① 传输的 SQL 语句语法的错误；
                   ② JDBC 程序连接断开；
                   ③ SQL 语句中使用了错误的函数。
        SQLException 提供以下方法：
                getNextException() —— 用来返回异常栈中的下一个相关异常；
                getErrorCode() —— 用来返回代表异常的整数代码 (error code）；
                getMessage() —— 用来返回异常的描述信息 (error message)。
2. SQLWarning 类：用来处理不太严重的异常情况，也就是一些警告性的异常。其提供的方法和使用与                                       SQLException 基本相似。
                结合异常的两种处理方式，明确何时采用哪种:
                        A. throws 处理不了，或者要让调用者知道，就 throws;
                        B. try … catch 能自行处理，就进行异常处理。
3.常见异常
        1.ClassNotFoundException:
                  No  Suitable Driver Found.....
                原因：没有导入第三方jar包
        2.invalid username/password
               无效的用户名/密码
       3. IO 错误:
           The Network Adapter could not establish the connection
             原因:  数据库的两个服务有可能没有开启
      4. 标识符无效：
            原因：有可能是写错了sql中的字段名
      5. 无效字符：
            原因：有可能在结尾处添加了分号    
      6. 没有足够的值/或过多的值。
             插入的值的个数与字段的个数不匹配
## 数据源 连接池 （自行实现、Druid）
#### 数据源
数据源技术是Java操作数据库的一个很关键技术，流行的持久化框架都离不开数据源的应用。
数据源提供了一种简单获取数据库连接的方式，并能在内部通过一个池的机制来复用数据库连接，这样就大大减少创建数据库连接的次数，提高了系统性能。
对于数据源的应用，一般都选择实用开源的数据源或数据库连接池来使用，比如，常见的有DBCP、C3P0、Proxool等等。
常用连接池DBCP和C3P0
    Java为数据库连接池提供了公共的接口：javax.sql.DataSource，各个厂商需要让自己的连接池实现这个接口。这样应用程序可以方便的切换不同厂商的连接池！
    常见的连接池：DBCP、C3P0。
    dbcp与c3p0区别：
    dbcp没有自动回收空闲连接的功能
    c3p0有自动回收空闲连接功能
连接池的常设属性
    必须项     driverClassName     数据库驱动名称
             url     数据库的地址
             username    用户名
             password    密码
    基本项     maxActive     最大连接数量
                  initialSize     连接池中初始化多少个Connection连接对象
    扩展项     maxWait    超时等待时间以毫秒为单位 1000等于1秒
    C3P0连接池的常设属性:
    除必须项外，还有下面的常设属性
    1、initialPoolSize  设置初始化连接数
    2 、maxPoolSize  连接池的最大连接数  
    3 、minPoolSize   连接池的最小连接数
DBCP的两种配置方式 硬编码setter方式
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
C3P0的三种配置方式 硬编码setter方式
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
#### 连接池
##### 数据库连接池
- 数据库连接（Connection）频繁的打开关闭相当耗费资源。 为解决这个问题，数据库连接池的原理是系统开启时主动建立足够数额的连接， 并且将这些连接组成连接池，每次数据库使用连接的时候从连接池中取出， 用完之后再归还给连接池。 连接池的作用
通过连接池（数据源）可以优化JDBC的操作。 使用JDBC的时候，每操作一次都需要获取连接（创建）用完之后把连接释放掉了（销毁）， 通过连接池来优化CURD操作。 连接池用来管理数据库的连接。 作用： 提高项目的性能。 就是在连接池初始化时存入一定数量的连接，用的时候通过方法获取， 不用的时候归还连接即可。
用池来管理Connection，这样可以重复使用Connection。有了池， 所以我们就不用自己来创建Connection，而是通过池来获取Connection对象。 当使用完Connection后，调用Connection的close()方法也不会真的关闭Connection， 而是把Connection“归还”给池。池就可以再利用这个Connection对象了。
所有连接池必须实现一个接口：javax.sql.DataSource接口 获取连接方法： Connection getConnection() 归还连接方法就是以前释放资源的方法，调用connection.close()
自定义简易连接池
   所有连接池必须实现一个接口：javax.sql.DataSource接口
   获取连接方法：   Connection getConnection()
   归还连接方法就是以前释放资源的方法，调用connection.close()
