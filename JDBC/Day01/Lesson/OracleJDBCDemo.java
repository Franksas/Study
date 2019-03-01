/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

/**

@author yinhansong
@version  1.0
*/

package com.ychs.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class OracleJDBCDemo {
private static final int Result = 0;

public static void main(String[] args) throws SQLException {
	String ename="张山";
	int sal=8000;
	int deptno=10;
	Statement sta=null;
	Connection conn=null;
	try {
		//1.注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.获取获取连接
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","scott");
		System.out.println("打印数据库的连接对象："+conn);

		//3.编写SQL语句
		String sql = "insert into emp(empno,ename,sal,deptno)"+"values(9882,'"+ename+"',"+sal+","+deptno+")";
		//4.通过connection对象获取语句的执行者
		sta= conn.createStatement();
		//5.执行sql语句
		int Result=sta.executeUpdate(sql);
		if(Result>0){
			System.out.println("输入成功");
		}else{
			System.out.println("输入失败");
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		sta.close();
		conn.close();
	}

}
}
