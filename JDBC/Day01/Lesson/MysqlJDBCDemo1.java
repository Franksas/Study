/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
/**

@author yinhansong
@version  1.0
*/

package com.ychs.demo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MysqlJDBCDemo1 {
	public static void main(String[] args) {
	 try {
		 //1.注册驱动(把驱动程序加载进内存)
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取数据库连接
		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stumanager","root","root");
		System.out.println(conn);
		//3.编写SQL语句
		String sql = "select * from t_student";
		//4.通过connection对象获取语句的执行者
		Statement stat= (Statement) conn.createStatement();
		//5.执行sql语句
		ResultSet rs=stat.executeQuery(sql);
		//6.遍历结果集
		while(rs.next()){
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		}


	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
