# 第十三天笔记
####
###### 生命周期
- Servlet池是一直增加的

- Tomcat 拿到请求-》在Servlet 池中寻找请求的Servlet-》执行找到的Servlet-》创建Servlet对象——》在项目的web.xml中寻找Servlet名称——》找到则根据类创建——》响应404
- Tomcat
- 生命周期：创建（一次）——》初始化init（一次）——》service（多次）——》销毁destory(一次)
- Tomcat和Tomcat的Servlet池的工作原理
  - 1.Tomcat拿到请求 2.在Servlet中寻找请求的Servlet 3.执行找到的Servlet 4.创建Servlet对象：在项目的web.xml中寻找Servlet名称，找到则根据类创建，响应404

- 初始/销毁
创建1：首次访问(单例) 创建2：服务器启动创建(单例) 创建3：创建(1次)->初始化(init 1次)->业务(service多次)->销毁(destroy 1次)

- Servlet配置参数
web.xml中配置参数：1.单个Servlet getInitParameter 2.Servlet容器的getServletContext

- 传参
按方向分：1.前到后：1).页面name属性 2.)Servlet获取参数 2.后到前：attribute属性

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		//按照页面文本框的name属性的值来获取他对应的页面的值
    		//页面中的文本框的name和他对应的页面的值在传递时是以键值对的形式出现
    		//根据name来获取值，更多的时候把他们称为参数和参数对应的值
    		//http://ychs/0822/ParameterServlet?username=%22Tom%22
    		//?后面试参数的开始，多个参数中间用&分开，参数名=参数值成对出现
    		String username = request.getParameter("username");
    		logger.debug("username:" + username);
    	}
