# 第十六天笔记

###### Listener:
- 监听器	作用:
  	监听web中中的域对象 ServletContext ServletRequest HttpSession
监听内容:
  	监听三个对象的创建和销毁
  	监听三个对象属性的变化
- 监听三个对象的创建和销毁(接口)
      ServletContextListener
      ServletRequestListener
      HttpSessionListener
- 监听三个对象属性的变化
		ServletContextAttributeListener
		ServletRequestAttributeListener
		HttpSessionAttributeListener
- 使用步骤:
	1.编写一个类 实现接口
	2.重写方法
	3.编写配置文件(大部分都是)    配置监听  在web.xml里面配置监听
- 演示各个监听器
	监听三个对象的创建和销毁
  	ServletContextListener
  	创建:服务器启动的时候,会为每一个项目都创建一个servletContext
  	销毁:服务器关闭的时候,或者项目被移除的时候
  	以后用来加载配置文件         可以在项目启动的时候，加载一些配置文件
  	ServletRequestListener
  			创建:请求来的时候
  			销毁:响应生成的时候
  	HttpSessionListener
  			创建:
  			java中第一次调用request.getSession的时候
  			jsp访问的时候创建   jsp有一个内置对象session
  			销毁:
  			三种情况:
  			    session超时
  	        手动销毁session
  	        服务器非正常关闭
- 监听三个对象属性的变化(添加 替换 删除)
  	ServletContextAttributeListener
  	ServletRequestAttributeListener
  	HttpSessionAttributeListener
