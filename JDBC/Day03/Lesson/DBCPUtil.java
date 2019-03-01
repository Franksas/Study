package com.ychs.utl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbcp.DbcpException;

import com.sun.org.apache.bcel.internal.generic.INVOKESTATIC;

/**
 * dbcp的工具类
 * @author asus
 *
 */
public class DBCPUtil {
	private static  DataSource ds=null;

	static Properties prop = new Properties();
	static {
    	Properties properties =new Properties();
		try {
			properties.load(new FileInputStream("src/dbcp.properties"));
			//通过datesorce获取数据源
			 ds= BasicDataSourceFactory.createDataSource(properties);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
    }



/**
 * 获取数据源（通过数据源获取数据库的连接对象，对象指connection
 */
 	public static DataSource getDataSource() {
	return ds;
 	}
 	/**
 	 * 获取连接池中的连接
 	 */
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
		DBCPUtil dbcpUtil=new DBCPUtil();
		Connection conn= dbcpUtil.getConnction();
		System.out.println(conn);
		dbcpUtil.closeConnection(conn);
	}

}
