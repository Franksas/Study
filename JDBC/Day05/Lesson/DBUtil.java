package com.ychs.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private static ComboPooledDataSource ds=new ComboPooledDataSource();
	public static DataSource getDataSource() {
		return ds;
	}
	private static Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn=null;

		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;
    }
    public static void main(String[] args) {
		Connection connection= DBUtil.getConnection();
		System.out.println(connection);
	}
}
