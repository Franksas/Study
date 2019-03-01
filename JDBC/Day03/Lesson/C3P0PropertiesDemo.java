package com.ychs.data;

import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 读取properties文件
 * @author asus
 *
 */
public class C3P0PropertiesDemo {
	public static void main(String[] args) throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource("mySource");
		System.out.println(ds.getConnection());
	}
}
