package com.ychs.demo;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;
import com.ychs.utl.OracleDBUtil2;

import oracle.jdbc.internal.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class ProcedureDemo {
	public static void main(String[] args) throws SQLException {
		Connection conn = OracleDBUtil2.OraclegetConnection();
			//1.编写调用存储过程的sql
			String sql = "{call getempno(?,?)}";
			//2.获取callableStatement语句发送对象
			java.sql.CallableStatement prepareCall = conn.prepareCall(sql);
			//3.设置参数
			prepareCall.setInt(1, 7499);
			prepareCall.registerOutParameter(2, OracleTypes.NUMBER);
			//4.执行
			prepareCall.execute();
			//5.获取结果
			Object obj = prepareCall.getObject(2);
			System.out.println("结果是："+obj);
		}


}
