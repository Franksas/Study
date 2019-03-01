package com.ychs.utl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 *
 */
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class OracleDBUtil2 {
	private static  String driver = null;
	private static  String url = null;
	private static  String username = null;
	private static  String password = null;


	//静态代码块只能自己内部处理异常，不能抛出异常
	static {
		Properties properties= new Properties();
		try {
			properties.load(new FileInputStream("src/db.properties"));
			driver=properties.getProperty("driver");
			url =properties.getProperty("url");
			username =properties.getProperty("username");
			password= properties.getProperty("password");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static Connection OraclegetConnection() {
		Connection connection=null;
    	try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
public static void close(Connection connection ,PreparedStatement preparedStatement ,ResultSet result ) {

    	if (result!=null) {
    		try {
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(preparedStatement!=null) {
    		try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if (connection!=null) {
    		try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

}
}
