# 第十五天
### 服务器端会话技术.
- 获取一个session:HttpSession  request.getSession()
- 域对象:
		xxxAttribute
		生命周期:
			创建:第一次调用request.getsession()创建
			销毁:
						服务器非正常关闭
						session超时
									默认时间超时:30分钟  web.xml有配置
						手动设置超时:setMaxInactiveInterval(int 秒) 了解
						手动干掉session
								session.invalidate()
- 存放的私有的数据.
##### ServletContext上下文(全局管理者)
-	一个项目的引用.代表了当前项目.表述该项目的上下文信息。
-	ServletContext对象的作用是在整个Web应用的动态资源之间共享数据。我们可以在N多个Servlet中来获取这个唯一的对象，使用它可以给多个Servlet传递数据。例如在AServlet中向ServletContext对象中保存一个值，然后在BServlet中就可以获取这个值，这就是共享数据了。
- 服务器会为每个应用创建一个ServletContext对象：
ServletContext对象的创建是在服务器启动时完成的；
ServletContext对象的销毁是在服务器关闭时完成的。
-	当项目启动的时候,服务器为每一个web项目创建一个servletcontext对象.
-	当项目被移除的时候或者服务器关闭的时候servletcontext销毁
- 作用:
	1.获取全局的初始化参数
	2.共享资源(xxxAttribute)
-	获取ServletContext:
  		方式1:
  		getServletConfig().getServletContext()
  		方式2:
  		getServletContext()
- 常用方法:
      1.String  getInitParameter(String key):通过名称获取指定的参数值
      	Enumeration getInitParameterNames() :获取所有的参数名称
      		在根标签下有一个 context-param子标签 用来存放初始化参数
    		<context-param>
    					<param-name>encoding</param-name>
    					<param-value>utf-8</param-value>
    		</context-param>
		2.xxxAttribute
- 存放:共享的数据
