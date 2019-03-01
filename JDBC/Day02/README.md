## JDBC如何调用存储过程和存储函数
-	CallableStatement接口可以用于调用存储过程
		使用原因：为了数据安全，不把SQL语句暴露在 Java 代码中。
		将SQL代码包装在存储过程中。在 Java 中调用存储过程。
- 使用存储过程的好处：
		1 数据比较安全
		2 SQL语句是在数据库中存放的，执行的时候少了编译的过程，速度较快。
- 使用步骤：
		1 编写调用存储过程的SQL
				String sql = "{CALL myproc(?,?,?)}"；
		2 建立 CallableStatement 语句发送对象
				CallableStatement callstatment = conn.prepareCall(sql);
		3 设置传入参数和传出参数
				in	参数：callstatment.setXxx(index,values);
				out 参数：callstatment.registerOutParameter(index,sqlType);
		4 执行
				callstatment.execute();
		5 获取返回值
		callstatment.getType(index);
