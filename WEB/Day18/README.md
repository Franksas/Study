# 第十八天

- 创建ligin.jsp完成用户登录,action里面会找到Login然后通过web.xml转到LoginServlet从而执行LoginServlet.java.
LoginServlet.java

- request.getParameter是用来接受用post和get方法传递过来的参数，会从web客户端到web服务器端，代表HTTP请求。
假如两个页面为连接关系是，可以通过get.Parameter来获取请求参数（一般使用在表单和链接传递参数）
假如当两个web组件之间发生转换关系时，转发目标通过getAttribute()来和转发源组件共享request范围内的数据，使用get时要先进行set方法赋值才能使用get方法获取值
- ServletContext上下文
每个应用都会有一个ServletContext对象与之关联，当容器分布在在多个虚拟机上时，web应用在所分布的每个虚拟机上都拥有一个ServletContext实例.实现数据共享。
通过ServletContext可以访问应用范围的初始化参数和属性（在init()方法中访问了初始化参数）在Encding1中得到体现，访问属性首先要用setAttribute(a,b)来设置属性，通过getAttribute()来获取属性
- doGet
在doGet中通过request.getAttribute("flag")来获取flag的值，然后匹配到相应的函数，首先会调用LoginServlet的login函数登录并且在线人数加1，重定向到success.jsp界面输出用户信息，点击退出会访问logout函数回到loginServlet.java并且flag=logout会匹配到loginServlet.java中的logout函数，通过ServletContext使在线人数-1
- session/session.invalidate()
在输入用户名密码时创建了一个session,此时session会一直存在，它是一个会话，具体介绍如下：当浏览器第一次请求时，服务器创建一个session对象，同时生成一个sessionId，并在此次响应中将sessionId 以响应报文的方式传回客户端浏览器内存或以重写url方式送回客户端，来保持整个会话。关闭此浏览器窗口，其内存中的sessionId也就随之销毁
 session.invalidate()是将session设置为失效，一般在退出时使用，但要注意的是：session失效的同时 浏览器会立即创建一个新的session的，你第一个session已经失效了 所以调用它的getAttribute方法时候一定会抛出NullPointerException的
- 全局变量的设置
<context-param>
  	<param-name>encoding</param-name>
  	<param-value>utf-8</param-value>
  </context-param>
servlet.java文件
 servlet的生命周期有4个阶段

- 加载和实例化
- 1.Servlet容器负责加载和实例化Servlet.当Servlet容器启动时，或者在容器检测到需要这个Servlet来响应第一个请求时，创建Servlet实例。当Servlet容器启动后，它必须要知道所需的Servlet类在什么位置，Servlet容器可以从本地文件系统、远程文件系统或者其他的网络服务中通过类加载器加载Servlet类，成功加载后，容器创建Servlet的实例。因为容器是通过Java的反射API来创建Servlet实例，调用的是Servlet的默认构造方法（即不带参数的构造方法），所以我们在编写Servlet类的时候，不应该提供带参数的构造方法。
- 2.初始化 Servlet实例化之后，容器将调用Servlet的init()方法初始化这个对象。初始化的目的是为了让Servlet对象在处理客户端请求前完成一些初始化的工作，如建立数据库的连接，获取配置信息等。对于每一个Servlet实例，init()方法只被调用一次。在初始化期间，Servlet实例可以使用容器为它准备的ServletConfig对象从Web应用程序的配置信息（在web.xml中配置）中获取初始化的参数信息。在初始化期间，如果发生错误，Servlet实例可以抛出ServletException异常或者UnavailableException异常来通知容器。ServletException异常用于指明一般的初始化失败，例如没有找到初始化参数；而UnavailableException异常用于通知容器该Servlet实例不可用。例如，数据库服务器没有启动，数据库连接无法建立，Servlet就可以抛出UnavailableException异常向容器指出它暂时或永久不可用
- 3.请求处理 Servlet容器调用Servlet的service()方法对请求进行处理。要注意的是，在service()方法调用之前，init()方法必须成功执行。在service()方法中，Servlet实例通过ServletRequest对象得到客户端的相关信息和请求信息，在对请求进行处理后，调用ServletResponse对象的方法设置响应信息。在service()方法执行期间，如果发生错误，Servlet实例可以抛出ServletException异常或者UnavailableException异常。如果UnavailableException异常指示了该实例永久不可用，Servlet容器将调用实例的destroy()方法，释放该实例。此后对该实例的任何请求，都将收到容器发送的HTTP404（请求的资源不可用）响应。如果UnavailableException异常指示了该实例暂时不可用，那么在暂时不可用的时间段内，对该实例的任何请求，都将收到容器发送的HTTP 503（服务器暂时忙，不能处理请求）响应
- 4.服务终止 当容器检测到一个Servlet实例应该从服务中被移除的时候，容器就会调用实例的destroy()方法，以便让该实例可以释放它所使用的资源，保存数据到持久存储设备中。当需要释放内存或者容器关闭时，容器就会调用Servlet实例的destroy()方法。在destroy()方法调用之后，容器会释放这个Servlet实例，该实例随后会被Java的垃圾收集器所回收。如果再次需要这个Servlet处理请求，Servlet容器会创建一个新的Servlet实例。 Image text
- session失效的三种方法
- 1.在主页面或者公共页面中加：session.setMaxInactiveInterval(600);参数600单位是秒，即在没有10分钟活动后，session将失效。
这里要注意这个session设置的时间是根据服务器来计算的，而不是客户端。所以如果是在调试程序，应该是修改服务器端时间来测试，而不是客户端。(客户端是浏览器，服务器端是提供服务的计算机或tomact)
- 2.也是比较通用的设置session失效时间的方法，就是在项目的web.xml中设置
<!-- 设置session失效，单位分 -->
<session-config>
　　<session-timeout>1</session-timeout>
</session-config>
- 3.直接在应用服务器中设置，如果是tomcat，可以在tomcat目录下conf/web.xml中找到元素，tomcat默认设置是30分钟，只要修改这个值就可以了。
- 4.三种方式的优先级：如果上述三个地方如果都设置了，有个优先级的问题，从高到低：（1）>（2）>（3）  建议使用第一种
web.xml中servlet配置
- 1.配置servlet，有名称和路径
- 2.配置servlet映射信息，也有名称和路径
- 配置路径精确配置：/servlet
- 配置路径模糊配置：/，/lm/,.后缀名（                     .do，.action，.html(伪静态)）
注意：  1）url-pattern要么以 / 开头，要么以开头。  绝对不能漏掉斜杠
2）不能同时使用两种模糊匹配，例如/lm/.do是非法路径
3）当有输入的URL有多个servlet同时被匹配的情况下 ： 精确匹配优先。以后缀名结尾的模糊匹配先级最低！！！
