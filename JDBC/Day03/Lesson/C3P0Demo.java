package com.ychs.data;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * c3p0数据库连接至
 */
public class C3P0Demo {
	public static void main(String[] args) throws SQLException, PropertyVetoException {
		ComboPooledDataSource  ds = new ComboPooledDataSource();
		ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
		ds.setUser("scott");
		ds.setPassword("scott");
		Connection conn = ds.getConnection();
		System.out.println(conn);

	}

}
