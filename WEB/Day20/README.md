# 第二十天

##### 九大内置对象
- page（当前jsp的实例）
- pageContext J2EE中最小的容器，只在当前页面范围内有效
- request（比pageContext大的容器）
- session（比request大的容器）
- application
- config（读取配置信息的对象）
- exception(如果不是错误页面，则没有此对象)
 - isErrorPage(指定当前页面是否具有捕获异常)
 - errorPage
- response
- out（在jsp页面输出一些内容，类似于document）
##### jstl jsp标准的标签库语言
	apache的
	用来替代java脚本
	使用步骤:
		1.导入jar包 (jstl.jar和standard.jar)
		2.在页面上导入标签库
				<%@taglib prefix="" uri=""%>

			例如:
				<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-	jstl的分类:
		core:核心类库 	
-	core:掌握
						★c:if
						★c:forEach

						c:set 往域中设置值
						c:choose c:when c:otherwise 分支

- c:if 判断
						<c:if test="${el表达式}">满足的时候输出的内容</c:if>
						例如:
									<c:if test="${3>4 }">
												3大于4
									</c:if>
									<c:if test="${3<=4 }">
												3不大于4
									</c:if>

- c:forEach 循环
					格式1:
			 					<c:forEach begin="从那里开始" end="到那里结束" step="步长" var="给变量起个名字" varStatus="循环状态变量">
											${i }--${vs.count }--${vs.current }<br>
			 					</c:forEach>

					varStatus:用来记录循环的状态
					常用的属性:
					count:记录次数
					current:当前遍历的内容
		例如:
			<c:forEach begin="1" end="20" step="1" var="i" varStatus="vs">
				${i }--${vs.count }--${vs.current }<br>
			</c:forEach>

- c:set 和 c:choose

##### 动态包含<jsp :include page=“a.jsp”/>与静态包含<%@include  file=“fileurl”%>的区别
- 1.动态包含用的元素是page，而且有两种形式。静态包含用的是file,只有一种形式。
- 2.生成的文件不同，静态的包含是将两个jsp文件二合一，生成一个以包含页面命名的servlet和class文件，动态包含的两个jsp文件各自生成自己的servlet和class文件。

- 3. 传参方式一：<jsp:include page=“a.jsp?param=123”/>时被包含的jsp页面是可以访问该参数的。

- 4. 传参方式二：
            <jsp:include page=“a.jsp”>

                     <jsp:param name=“” value=“”>

                    <jsp:param name=“” value=“”>

           </ jsp:include >
- 5.在客户端访问包含页面时地址栏后面直接加上参数后传递，这种形式的传参是客户端送来的，但是这两个页面的request对象不是同一个，因为3中已经说了包含的页面可以向被包含的页面传递参数，所以被包含的request对象含的参数个数应该大于等于包含页面的参数个数的。所以它们各有各的request对象。而且被包含的jsp页面可以访问传到包含页面的参数。
- 6.动态包含只有在执行到它的时候才加载，所以它才叫动态包含。
