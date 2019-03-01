/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
/**
 * 对Oracle中的t_student进行增删改查
@author yinhansong
@version  1.0
*/
package com.ychs.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class StudentManager {
	Connection con=null;
	PreparedStatement ps=null;
	@Test
	public void deleteStudent() throws SQLException{
		System.out.println("删除学生");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","scott");
			String sql="delete from t_student where sno=?";
			ps= con.prepareStatement(sql);
			ps.setInt(1,10);
			int Result=ps.executeUpdate();
			if(Result>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ps.close();
			con.close();
		}
	}
	@Test
	public void insertStudent() throws SQLException{
		System.out.println("插入学生");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","scott");
			String sql="insert into t_student(sno,sname,sex)"+"values(?,?,?)";
			ps= con.prepareStatement(sql);
			ps.setInt(1, 011);
			ps.setString(2, "fhs");
			ps.setString(3, "女");
			int Result=ps.executeUpdate();
			if(Result>0){
				System.out.println("输入成功");
			}else{
				System.out.println("输入失败");
			}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ps.close();
			con.close();
		}
	}
	@Test
	public void selectStudent() throws SQLException {
		System.out.println("查询学生");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","scott");
			System.out.println("连接对象为："+con);
			String sql="select * from t_student where sno=?";
			ps= con.prepareStatement(sql);
			ps.setInt(1,21);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
			}

		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ps.close();
			con.close();
		}
	}
	@Test
public void updatestudent() throws SQLException {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","scott");
		System.out.println(con);
		String sql="update t_student set sname='凤凰城' where sno=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1,21);
		int Result=ps.executeUpdate();
		System.out.println(Result);
		if(Result>0){
			System.out.println("更新成功");
		}else{
			System.out.println("更新失败");
		}
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		ps.close();
		con.close();
	}
}
}
