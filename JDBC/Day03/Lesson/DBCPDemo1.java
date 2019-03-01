package com.ychs.data;

import java.security.PrivilegedActionException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * dbcp获取连接
 * @author yinhansong
 *
 */
public class DBCPDemo1 {
	private static  final String driver="oracle.jdbc.driver.OracleDriver";
	private static  final String url="jdbc:oracle:thin:@localhost:1521:ORCL";
	private static  final String username="scott";
	private static  final String password="scott";


	public static void main(String[] args) throws SQLException {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
		ds.setUsername("scott");
		ds.setPassword("scott");
		ds.setInitialSize(5);
		Connection conn = ds.getConnection();
		System.out.println(conn);
		conn.close();

	}
}
