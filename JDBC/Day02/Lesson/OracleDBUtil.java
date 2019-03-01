package com.ychs.utl;
/*
 * oracle的工具类
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class OracleDBUtil {
	/*
	 * 获取连接
	 */
	public static Connection getConnection() {
		Connection conn=null;

		try {
			//1.注册驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","scott");

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
