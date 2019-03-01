package com.ychs.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.ychs.utl.OracleDBUtil;

public class UserManager {
public static void main(String[] args) {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	conn=OracleDBUtil.getConnection();
	try {

	//3.编写sql语句
		String sql="select * from t_student";
	//4.获取预编译的执行者
		//ctrl+2 l
		ps= conn.prepareStatement(sql);
	//5.设置参数

	//6.执行sql
		rs=ps.executeQuery();
	//7.结果集处理
		while(rs.next()){
			System.out.println(rs.getString("sname"));
		}
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {

		OracleDBUtil.close(conn, ps, rs);


	}

}

@Test
public void getUser(){
	int page=1;
	int pageCount=2;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;
	try {
		conn=OracleDBUtil.getConnection();
		String sql = "select u.* from (select t.*,rownum rn from (select * from t_student order by sno desc) t) u where u.rn>? and u.rn<=?";
		ps = conn.prepareStatement(sql);
		//已知页码（page) ，一页条数 pageCount
		//第一个问号（page-1）*pageCount
		//第二个问号 page*pageCount
		ps.setInt(1,(page-1)*pageCount);
		ps.setInt(2, page*pageCount);
		rs=ps.executeQuery();
		//7.结果集处理
			while(rs.next()){
				System.out.println(rs.getInt(1));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			OracleDBUtil.close(conn, ps, rs);


		}
}
}
