# 第十二天
### Servlet
###### jsp的解析
-    pageEncoding="ISO-8859-1"这是关于页面内容的编码        charset=ISO-8859-1" 告诉浏览器以什么编码来解析  
    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
- get 是提交请求，得到响应 ，数据容易被劫持，不安全，可以提交的数据大小有限（大约是2k)
- post 是提交数据，应用场景：登录，注册，上传文件。提交表单数据
- response 响应
##### 提交
- form表单没有指定提交方式，默认是get方式
- Get方法:
    - 地址栏访问；
    -  window.location.href;
    -  form-method-get；
    -  get是提交请求，得到响应（数据容易被劫持；数据量有限，大约2k）
- Post方法：
   - form-method-post；
   - 提交数据：登陆、注册、上传文件/提交表单数据（只能用post）
-  response
  - setCharacterEncoding只是告诉浏览器如何编码
  - response设置只能是在任何输出操作前完成，否则失效
- Log4j2
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

##### 配置文件
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
    
