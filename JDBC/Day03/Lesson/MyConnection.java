package com.ychs.data;

import java.sql.Connection;
import java.util.LinkedList;

import com.ychs.utl.OracleDBUtil;

/*
 * 自定义一个连接池
 */
public class MyConnection {
	private static final Connection MyConnection = null;
	private static LinkedList<Connection> pools= new LinkedList<Connection>();
	static {
		for(int i=0;i<3;i++) {
			Connection conn = OracleDBUtil.getConnection();
			pools.add(conn);
		}
	}
	/**
	 * 获取一个链接
	 */
	public static Connection getConnection() {
		return pools.removeFirst();
	}
	/**
	 * 把连接归还连接池
	 */
	public static void closeConnection(Connection conn) {
		pools.add(conn);
	}
	public static void main(String[] args) {
		Connection conn = ((OracleDBUtil) MyConnection).getConnection();
		System.out.println(conn);
	}
}
