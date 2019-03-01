package com.ychs.utl;
import java.sql.Connection;
import java.sql.SQLException;


import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3P0Util {
	private static ComboPooledDataSource ds =  new ComboPooledDataSource();
	public static DataSource getDataSource() {
		return ds;
	}


 	public static Connection getConnction() {
 		Connection  conn = null;
 		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
 		return conn;
 	}
 	/*
 	 * 归还连接
 	 */

 	public static void closeConnection(Connection conn) {
 		try {
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

 	}
 	public static void main(String[] args) {
		Connection conn= C3P0Util.getConnction();
		System.out.println(conn);
		C3P0Util.closeConnection(conn);
	}

}
