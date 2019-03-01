/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

/**

@author yinhansong
@version  1.0
*/

package com.ychs.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleJDBCDemo3 {
public static void main(String[] args) throws SQLException {
	PreparedStatement ps=null;
	Connection conn=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","scott");
		String sql = "insert into emp(empno,ename,sal,deptno)"+"values(?,?,?,?)";
		ps= conn.prepareStatement(sql);
		ps.setInt(1, 9016);
		ps.setString(2, "ls");
		ps.setDouble(3,99.8);
		ps.setInt(4, 20);
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
		conn.close();
	}


}
}
