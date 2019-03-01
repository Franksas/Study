/*
 * Mysql的工具类
 */
package com.ychs.utl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDBUtil {
	public static Connection getConnection1() {
		Connection conn=null;

		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/stumanager","root","root");
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/*
	 * 关闭连接
	 */
	public static void  close(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		if(conn!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

	}
}
