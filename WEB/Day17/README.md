# 第十七天
###  
##### Filter:过滤器（过滤请求和响应）
-	作用:
  		自动登录.
  		统一编码.
  		过滤关键字
- 编写filter步骤:
		1.编写一个类
				a.实现filter接口
				b.重写方法
		2.编写配置文件
				a.注册filter
				b.绑定路径
		3.测试

- Filter接口的方法:
		init(FilterConfig config):初始化操作
		doFilter(ServletRequest request, ServletResponse response, FilterChain chain):处理业务逻辑
		destroy() :销毁操作

- filter的生命周期
      filter单实例多线程
  	filter在服务器启动的时候 服务器创建filter 调用init方法 实现初始化操作
  	请求来的时候,创建一个线程 根据路径调用dofilter 执行业务逻辑
  	当filter被移除的时候或者服务器正常关闭的时候 调用destory方法 执行销毁操作.
  	FilterChain:过滤链
  	通过chain的dofilter方法,可以将请求放行到下一个过滤器

- 一个资源有可能被多个过滤器匹配成功,多个过滤器的执行顺序是按照web.xml中filter-mapping的顺序执行的
