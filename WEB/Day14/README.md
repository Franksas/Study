# 第十四天笔记
##### 建立一个Dynamic Web Project
- 1.下载apache-tomcat-9.0.11,建立相应服务（Servers） Host name为为浏览器访问格式
2.Server Locations选择第二个，deploy path去掉wtp

- 2.右键新建Dynamic Web Project项目，选择2.5

- 3.Web Content下放Web网页，Java Resources放Java代码

- 4.运行网页必须添加服务，启动服务

- 5.修改jsp格式,要在WebContent下面新建一个jsp点击next->下面的JSP Templates->New JSP File(html)修改格式即可

- 6.jsp的编码规范：要改为UTF-8
出现乱码是因为jsp编码规范与浏览器的编码规范不一致，将浏览器的编码规范改为jsp的编码规范

        <!-- pageEncoding="ISO-8859-1" 这是关于页面内容的编码 ,charset=ISO-8859-1告诉浏览器的编码格式-->
        <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <html>
- 7.下载apache-log4j-2.11.1-bin
将log4j-api-2.11.1.jar与log4j-core-2.11.1.jar压缩包放在Web Content->WEB-INF->lib里面
- 8.Web中的.html文件,charset="UTF-8",此为系统内部的访问
- form表单没有指定提交方式，默认是get方式
    - get：
    get是提交请求,得到响应，但是数据容易被劫持，不安全，可以提交的数据量大小有限（大约是2k）
  -  post:
    post是登录/提交表单数据，注册/提交保单数据，上传文件/提交表单数据（只能使用post上传）
  -  打开或访问某个页面或资源
//观察这个路径或资源，和浏览器的地址栏内容一样，get方式提交
//window.location.href="http://ychs/822/HelloServlet";
- 9.Java Resources->src->package->HelloServlet.java 建立一个logger对象 Logger为接口
  //	private Logger logger = LogManager.getLogger(HelloServlet.class);
  	private Logger logger = LogManager.getLogger(this.getClass());
- doSet()方法与doPost()方法：
注意：调用doPost时会调用一次doSet方法

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		logger.info("INFO");
    		logger.error("ERROR");
    		logger.debug("DEBUG");
    		logger.warn("WARN");
    		// TODO Auto-generated method stub
    //		System.out.println("get");
    //		response.getWriter().append("Served at: ").append(request.getContextPath());
    		//response.setCharacterEncoding("UTF-8");//设置他的编码是UTF-8,是告诉服务器如何编码
    		//response设置编码只能是在任何输出操作之前完成，否则失败
    		response.setContentType("text/html; charset=UTF-8");//告诉浏览器用UTF-8进行解码(正确方式)
    		response.getWriter().println("Welcome");
    		response.getWriter().append("欢迎您！");
    	}
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      		// TODO Auto-generated method stub
      		doGet(request, response);
      	}
    Java Resources->src->log4j.xml
- 10.总的级别时Debug
    控制台：只要是等于或高于xxx级别的日志都输出 文件：只要是等于或高于yyy级别的日志才输出
      <?xml version="1.0" encoding="UTF-8"?>
      <!-- status是log4j框架自身的日志输出级别
      monitorInterval系统自动检测当前配置文件的变化，自动生效，不用重启系统-->
      <Configuration status="warn" name="MyApp" monitorInterval="100">
      	<!-- 日志输出目的地 -->
          <appenders>
          	<!-- 控制台 -->
              <Console name="Console" target="SYSTEM_OUT">  
              	<!-- 只要是等于或高于debug级别的日志都输出   
                  <ThresholdFilter level="debug"/>    
                  <PatternLayout pattern="%m%n"/>-->  

                  <ThresholdFilter level="error"/>    
                  <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %class{36} %L %M -- %msg%xEx%n"/>
              </Console>
              <!-- 文件 -->   
              <File name="log" fileName="e:\\test1.log" append="true">
              	<!--  只要是等于或高于error级别的日志才输出-->
                  <ThresholdFilter level="error"/>
                  <PatternLayout pattern="%d-%m%n"/>    
              </File>  
          </appenders>

          <loggers>
          	<!-- 总的级别是debug -->
              <root level="debug">
              	<!-- 引用以上定义的输出目的地 -->
                  <appender-ref ref="Console"></appender-ref>
                  <appender-ref ref="log"></appender-ref>
              </root>
          </loggers>
      </Configuration>
