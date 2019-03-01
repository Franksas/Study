# 第二天
## 日志
###  log4j
- 定义：Log4j是Apache的一个开源项目，通过使用Log4j，我们可以控制日志信息输送的目的地是控制台、文件、GUI组件，甚至是套接口服务器、NT的事件记录器、UNIX Syslog守护进程等；我们也可以控制每一条日志的输出格式；通过定义每一条日志信息的级别，我们能够更加细致地控制日志的生成过程。最令人感兴趣的就是，这些可以通过一个配置文件来灵活地进行配置，而不需要修改应用的代码。
- 下载apache-log4j-2.11.1-bin
将log4j-api-2.11.1.jar与log4j-core-2.11.1.jar压缩包放在Web Content->WEB-INF->lib里面
- 级别： 在log4j2中， 共有8个级别，按照从低到高为：ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF。
      All:最低等级的，用于打开所有日志记录.
      Trace:是追踪，就是程序推进一下.
      Debug:指出细粒度信息事件对调试应用程序是非常有帮助的.
      Info:消息在粗粒度级别上突出强调应用程序的运行过程.
      Warn:输出警告及warn以下级别的日志.
      Error:输出错误信息日志.
      Fatal:输出每个严重的错误事件将会导致应用程序的退出的日志.
      OFF:最高等级的，用于关闭所有日志记录.
- 程序会打印高于或等于所设置级别的日志，设置的日志等级越高，打印出来的日志就越少。

###### 配置文件
- 1、根节点configuration下有两个子节点：appenders和loggers(可定义多个appender和logger了)
- 2、appenders：定义输出，如定义的Console，是将日志输出到控制台，并对输出设置属性(通过PatternLayout设置输出格式)
- 3、loggers：定义多个logger，且logger通过name进行区分，对不同的logger配置不同的输出可appender-ref引用配置的appender的name
%d{yyyy-MM-dd HH:mm:ss, SSS} : 日志生产时间
      %p : 日志输出格式
      %c : logger的名称
      %m : 日志内容，即 logger.info("message")
      %n : 换行符
      %C : Java类名
      %L : 日志输出所在行数
      %M : 日志输出所在方法名
      hostName : 本地机器名
      hostAddress : 本地ip地址
- 其中，Log4j提供的appender有以下几种
      org.apache.log4j.ConsoleAppender（控制台），  
      org.apache.log4j.FileAppender（文件），  
      org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件），  
      org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件），  
      org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）
- 其中，Log4j提供的layout有以下几种
  org.apache.log4j.HTMLLayout（以HTML表格形式布局），  
  org.apache.log4j.PatternLayout（可以灵活地指定布局模式），  
  org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），  
  org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）

### slf4j
- 定义：SLF4J，即简单日志门面（Simple Logging Facade for Java），不是具体的日志解决方案，它只服务于各种各样的日志系统。按照官方的说法，SLF4J是一个用于日志系统的简单Facade，允许最终用户在部署其应用时使用其所希望的日志System。实际上，SLF4J所提供的核心API是一些接口以及一个LoggerFactory的工厂类。
- SLF4J对比Log4J，logback和java.util.Logging的优势
    在你的代码中使用SLF4J写日志语句的主要出发点是使得你的程序独立于任何特定的日志类库，依赖于特定类库可能需要使用不同于你已有的配置，并且导致更多维护的麻烦。除此之外，还有一个SLF4J API的特性是使得我坚持使用SLF4J而抛弃我长期间钟爱的Log4j的理由，是被称为占位符(place holder)，在代码中表示为“{}”的特性。占位符是一个非常类似于在String的format()方法中的%s，因为它会在运行时被某个提供的实际字符串所替换。这不仅降低了你代码中字符串连接次数，而且还节省了新建的String对象。通过使用SLF4J，你可以在运行时延迟字符串的建立，这意味着只有需要的String对象才被建立。而如果你已经使用log4j，那么你已经对于在if条件中使用debug语句这种变通方案十分熟悉了，但SLF4J的占位符就比这个好用得多。
这是你在Log4j中使用的方案，但这并不有趣，而且降低了代码可读性，因为它增加了不必要的繁琐重复代码(boiler-plate code)：
if (logger.isDebugEnabled()) { logger.debug("Processing trade with id: " + id + " symbol: " + symbol); }
另一方面，如果你使用SLF4J的话，你可以得到更简洁格式的结果，就像以下展示的一样：
logger.debug("Processing trade with id: {} and symbol : {} ", id, symbol);

- 在SLF4J，我们不需要字符串连接而且不会导致暂时不需要的字符串消耗。取而代之，我们在一个以占位符和参数传递实际值构成的模板格式下写日志信息。你可能会在想万一我有很多个参数怎么办？嗯，那么你可以选择使用变量参数版本的日志方法或者以Object数组传递。这是一个相当方便和高效方法的打日志方法。记住，在生产最终日志信息字符串之前，这个方法会检查一个特定的日志级别是不是打开了，这不仅降低了内存消耗而且预先降低了CPU去处理字符串连接命令的时间。这里是使用SLF4J日志方法的代码，来自于slf4j-log4j12-1.6.1.jar中的Log4j的适配器类Log4jLoggerAdapter。
      public void debug(String format, Object arg1, Object arg2) {
      if (logger.isDebugEnabled()) {
      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2); logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable()); } }
同时，我们应该知道打日志是对应用程序性能有着很大影响，在生产环节上我们建议只进行必要的日志记录。
- 总结：我们使用slf4j来统一管理的我们的代码，我们不停的切换了多种日志框架来作为我们的日志输出，但是我们的业务代码，Java类中的那些日志输出代码一点都不用去改，这也真是slf4j最迷人的地方。它完美的整合了自己的一个简单日志，JDK自带的日志，log4j，logback，common-logging。

## 并发编程基础
###	线程安全
- 定义：当多个线程访问某个类时，不管运行时环境采用何种调度方式或者这些线程将如何交替执行，并且在主调代码中不需要任何额外的同步或协同，这个类都能表现出正确的行为，那么这个类就是线程安全的。正确性：某个类的行为与其规范相一致。
- 在操作系统中，线程是不拥有资源的，进程是拥有资源的。而线程是由进程创建的，一个进程可以创建多个线程，这些线程共享着进程中的资源。所以，当线程一起并发运行时，同时对一个数据进行修改，就可能会造成数据的不一致性，所以多线程并发是不安全的。
- 多线程并发不安全的原因已经知道，那么针对这个种情况，java中有两种解决思路：
  - 1.给共享的资源加把锁，保证每个资源变量每时每刻至多被一个线程占用。
  - 2.让线程也拥有资源，不用去共享进程中的资源。
- 基于上面的两种思路，下面便是3种实施方案：
  1. 多实例、或者是多副本（ThreadLocal）：对应着思路2，ThreadLocal可以为每个线程的维护一个私有的本地变量，可参考java线程副本–ThreadLocal；
  2. 使用锁机制 synchronize、lock方式：为资源加锁。
  3. 使用 java.util.concurrent 下面的类库：有JDK提供的线程安全的集合类
- 当有多条线程同时访问共享数据时，如果不进行同步，就会发生错误，java提供了多种机制保证线程同步，这里主要说下synchronized和Lock;
- synchronized关键字
 - 最简单的方式是加入synchronized关键字，只要将操作共享数据的语句加入synchronized关键字，在某一时段只会让一个线程执行完，在执行过程中，其他线程不能进来执行
方法声明中同步（synchronized ）关键字。当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。遵循以下五条原则：

  - 一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。

  - 二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。

  - 三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。

  - 四、当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。

  - 五、以上规则对其它对象锁同样适用。
- 使用锁
  区别：

  - a.Lock使用起来比较灵活，但需要手动释放和开启；采用synchronized不需要用户去手动释放锁，
  当synchronized方法或者synchronized代码块执行完之后，系统会自动让线程释放对锁的占用；

  - b.Lock不是Java语言内置的，synchronized是Java语言的关键字，因此是内置特性。Lock是一个类，通过这个类可以实现同步访问；

  - c.在并发量比较小的情况下，使用synchronized是个不错的选择，但是在并发量比较高的情况下，其性能下降很严重，此时Lock是个不错的方案。

  - d.使用Lock的时候，等待/通知 是使用的Condition对象的await()/signal()/signalAll()  ，而使用synchronized的时候，则是对象的wait()/notify()/notifyAll();由此可以看出，使用Lock的时候，粒度更细了，一个Lock可以对应多个Condition。

  - e.虽然Lock缺少了synchronized隐式获取释放锁的便捷性，但是却拥有了锁获取与是释放的可操作性、可中断的获取锁以及超时获取锁等多种synchronized所不具备的同步特性;
- 多线程编程中的三个核心概念
 - 原子性
	这一点，跟数据库事务的原子性概念差不多，即一个操作（有可能包含有多个子操作）要么全部执行（生效），要么全部都不执行（都不生效）。
 - 可见性
	可见性是指，当多个线程并发访问共享变量时，一个线程对共享变量的修改，其它线程能够立即看到。
  - 顺序性
	顺序性指的是，程序执行的顺序按照代码的先后顺序执行。但实际上JVM真正在执行这段代码时，并不保证它们一定完全按照此顺序执行。
	处理器为了提高程序整体的执行效率，可能会对代码进行优化，其中的一项优化方式就是调整代码顺序，按照更高效的顺序执行代码。讲到这里，有人要着急了——什么，CPU不按照我的代码顺序执行代码，那怎么保证得到我们想要的效果呢？实际上，大家大可放心，CPU虽然并不保证完全按照代码顺序执行，但它会保证程序最终的执行结果和代码顺序执行时的结果一致。

###	线程本地化 Threadlocal
- ThreadLocal很多地方叫做线程本地变量，也有些地方叫做本地线程变量，其实意思差不多。

   ThreadLocal和本地线程没有半毛钱关系，更不是一个特殊的Thread，它只是一个线程的局部变量(其实就是一个Map用于存储每一个线程的变量副本，Map中元素的Key为线程对象，而Value对应线程的变量副本),ThreadLocal会为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。

    对于多线程资源共享的问题，同步机制(Synchronized)采用了“以时间换空间”的方式，而ThreadLocal采用了“以空间换时间”的方式。前者仅提供一份变量，让不同的线程排队访问，而后者为每一个线程都提供了一份变量，因此可以同时访问而互不影响。

- 官方对ThreadLocal的描述：
	该类提供了线程局部（thread-local）变量。这些变量不同于他的普通对应物，因为访问某个变量（通过其get或set方法）的每个线程都有自己的局部变量，他独立于变量的初始化副本。ThreadLocal实例通常是类中的 private static字段，她希望将状态与某一个线程相关联。

- 自己理解：
  - 1、每个线程都有自己的局部变量
    每个线程都有一个独立于其他线程的上下文来保存这个变量，一个线程的本地变量对其他线程是不可见的。
  - 2、独立于变量的初始化副本
    ThreadLocal可以给一个初始值，而每个线程都会获得这个初始化值的一个副本，这样才能保证不同的线程都有一份拷贝。
  - 3、状态与某一个线程相关联
     ThreadLocal 不是用于解决共享变量的问题的，不是为了协调线程同步而存在，而是为了方便每个线程处理自己的状态而引入的一个机制。

- 深入解析ThreadLocal类
先了解一下ThreadLocal类提供的几个方法：
    	public T get() { }
    	public void set(T value) { }
    	public void remove() { }
    	protected T initialValue() { }
      get()方法是用来获取ThreadLocal在当前线程中保存的变量副本；
      set()用来设置当前线程中变量的副本；
      remove()用来移除当前线程中变量的副本；
      initialValue()是一个protected方法，一般用来在使用时进行重写的，它是一个延迟加载方法；

- ThreadLocal是如何为每个线程创建变量的副本的：
  -  1、在每个线程Thread内部有一个ThreadLocal.ThreadLocalMap类型的成员变量threadLocals，这个threadLocals就是用来存储实际的变量副本的，Key为当前ThreadLocal变量，value为变量副本（即T类型的变量）。

  - 2、初始时，在Thread里面，threadLocals为空，当通过ThreadLocal变量调用get()方法或者set()方法，就会对Thread类中的threadLocals进行初始化，并且以当前ThreadLocal变量为键值，以ThreadLocal要保存的副本变量为value，存到threadLocals。
  - 3、在当前线程里面，如果要使用副本变量，就可以通过get方法在threadLocals里面查找。 ThreadLocal的应用场景
  	最常见的ThreadLocal使用场景为：用来解决数据库连接、Session管理，多线程单例模式访问；
  	订单处理包含一系列操作：减少库存量、增加一条流水台账、修改总账，这几个操作要在同一个事务中完成，通常也即同一个线程中进行处理，如果累加公司应收款的操作失败了，则应该把前面的操作回滚，否则，提交所有操作，这要求这些操作使用相同的数据库连接对象，而这些操作的代码分别位于不同的模块类中。
  	银行转账包含一系列操作： 把转出帐户的余额减少，把转入帐户的余额增加，这两个操作要在同一个事务中完成，它们必须使用相同的数据库连接对象，转入和转出操作的代码分别是两个不同的帐户对象的方法。

- ThreadLocal使用的一般步骤
  -	1、在多线程的类（如ThreadDemo类）中，创建一个ThreadLocal对象threadXxx，用来保存线程间需要隔离处理的对象xxx。
  -	2、在ThreadDemo类中，创建一个获取要隔离访问的数据的方法getXxx()，在方法中判断，若ThreadLocal对象为null时候，应该new()一个隔离访问类型的对象，并强制转换为要应用的类型。
  - 3、在ThreadDemo类的run()方法中，通过getXxx()方法获取要操作的数据，这样可以保证每个线程对应一个数据对象，在任何时刻都操作的是这个对象。


## Maven基础
###	搭建私服
- 什么是Maven？

 Maven这个词可以翻译为“知识的积累”，也可以翻译为“专家”或“内行”。Maven作为跨平台的项目管理工具，最重要的用途—->”服务于构建”，能够帮助我们自动化构建过程，从清理、编译、测试到生成报告、再到打包和部署。

- 私服是架设在局域网的一种特殊的远程仓库，目的是代理远程仓库及部署第三方构件。有了私服之后，当 Maven 需要下载构件时，直接请求私服，私服上存在则下载到本地仓库；否则，私服请求外部的远程仓库，将构件下载到私服，再提供给本地仓库下载。

	我们可以使用专门的 Maven 仓库管理软件来搭建私服，比如：Apache Archiva，Artifactory，Sonatype Nexus。这里我们使用 Sonatype Nexus。

##### Nexus的部署
 - 1、安装

	Nexus3.x是免安装的，下载nexus-3.10.0-04-win64压缩包，将其解压到任意目录。解压完后会出现两个文件夹："nexus-3.1.0-04"为Nexus3.x的安装文件目录，“sonatype-work”为Nexus3.x的工作(或称之为数据)目录。

 -  2、Nexus端口配置

	若想修改Nexus自带的Jetty容器的服务端口，需要修改“NEXUS_HOME\sonatype-work\nexus3\etc”目录下的“nexus.properties”配置文件，修改其中的端口即可。默认端口为：8081。

- 3、运行Nexus
	虽然在“NEXUX_HOME\nexus\nexus-3.1.0-04\bin”目录下存在nexus.exe的可执行程序，但是双击程序或者右键使用管理员运行，都不能启动Nexus的服务。正确的打开姿势是：通过命令行运行。

执行步骤如下：
	- 1、Win+R，输入cmd回车，打开命令提示符窗口。
	- 2、一路cd命令，进入“NEXUX_HOME\nexus\nexus-3.1.0-04\bin”目录。
	- 3、输入 nexus,exe /run，回车即可运行。
- 4、登录Nexus管理系统

	Nexus的默认服务端口为8081，默认的用户名是：admin，密码：admin123。点击右上角的Sign in按钮，输入用户名和密码，进入仓库管理系统。

##### setting.xml 配置
- 本地仓库存储位置配置
      <localRepository>D:\WorkSoft\repo</localRepository>
- 服务器配置
      <servers>
      	<server>    
      		<id>nexus-releases</id>    
      		<username>admin</username>    
      		<password>admin123</password>    
      	</server>    
      	<server>    
      		<id>nexus-snapshots</id>    
      		<username>admin</username>    
      		<password>admin123</password>    
      	</server>    
      </servers>  

- 镜像
      <mirrors>   
          <mirror>   
            <id>nexus-releases</id>   
            <mirrorOf>*</mirrorOf>   
            <url>http://localhost:8081/nexus/content/groups/public</url>   
          </mirror>  
          <mirror>   
            <id>nexus-snapshots</id>   
            <mirrorOf>*</mirrorOf>   
            <url>http://localhost:8081/nexus/content/groups/public-snapshots</url>   
          </mirror>   
        </mirrors>
- 配置
  <profiles>  
     <profile>  
        <id>nexus</id>  
        <repositories>  
          <repository>  
            <id>nexus-releases</id>  
            <url>http://nexus-releases</url>  
            <releases><enabled>true</enabled></releases>  
            <snapshots><enabled>true</enabled></snapshots>  
          </repository>  
          <repository>  
            <id>nexus-snapshots</id>  
            <url>http://nexus-snapshots</url>  
            <releases><enabled>true</enabled></releases>  
            <snapshots><enabled>true</enabled></snapshots>  
          </repository>  
        </repositories>  
        <pluginRepositories>  
           <pluginRepository>  
                  <id>nexus-releases</id>  
                   <url>http://nexus-releases</url>  
                   <releases><enabled>true</enabled></releases>  
                   <snapshots><enabled>true</enabled></snapshots>  
                 </pluginRepository>  
                 <pluginRepository>  
                   <id>nexus-snapshots</id>  
                    <url>http://nexus-snapshots</url>  
                  <releases><enabled>true</enabled></releases>  
                   <snapshots><enabled>true</enabled></snapshots>  
               </pluginRepository>  
           </pluginRepositories>  
      </profile>  
    </profiles>  
- 当前启用配置
      <activeProfiles>  
            <activeProfile>nexus</activeProfile>  
      </activeProfiles>
      nexus插件仓库配置
      <pluginRepositories>
         <pluginRepository>  
              <id>nexus</id>  
              <name>local private nexus</name>  
         	<url>http://192.168.33.107:8081/nexus/content/groups/public</url>  
              <releases>
                 <enabled>true</enabled>
               </releases>  
               <snapshots>
                  <enabled>true</enabled>
               </snapshots>  
         </pluginRepository>  
      </pluginRepositories>
- Maven的依赖

	Maven的依赖通过dependencis元素来配置依赖，这是Maven最强大的特性之一。它支持传递性依赖。
添加依赖
	在Maven中需要使用在dependencies中定义一个或者多个dependency元素，来声明项目的一个或者多个依赖。
	每个依赖元素dependency包括：
		<>artifactId---依赖的坐标
		<>classifier---用来帮助定义构件输出的一些附属附件
		<>exclusions---用来排出的坐标
		<>groupId---依赖的坐标
		<>optionl---标记依赖是否可选
		<>scope---依赖范围
		<>systemPath---表示该依赖项在当前的绝对路径
		<>type---依赖的类型，对应项目坐标定义的packaging
		<>version---依赖的坐标
- 依赖范围（sope）
      <dependency>
          <!--
          compile（默认）：编译范围的依赖，它在编译和打包的时候都会把该依赖打包进去
          test：测试依赖范围，它在编译和打包的时候都不会把该依赖打包进去
          provided：在编译和测试范围有效，最后生成war包时不会打包进去。
          runtime：运行时依赖，编译的时候不依赖。
          system：系统依赖范围
          import：导入依赖范围
           -->
          <scope></scope>
      </dependency>

- 依赖的传递性

	在Maven中一个依赖不仅仅是一个JAR。它是一个POM文件，这个POM可能也声明了对其它构件的依赖。这些依赖的依赖叫做传递性依赖 。

	所谓传递性依赖就是： 如果项目A依赖于项目B，项目B自身依赖于项目C，那么项目A它也依赖于项目C的依赖。

	这种依赖是基于compile这个范围进行依赖
- 依赖版本的界限
在依赖某个项目的时候，你可以不必指定特定的某个版本。也可以指定一个版本范围
(,) 不包含      [,] 包含
例如：依赖一个Junit的大于等于3.8 但是小于4.0 的版本
    	<dependency>
        	<groupId>junit</groupId>
        	<artifactId>junit</artifactId>
        	<version>[3.8,4.0)</version>
    	</dependency>
