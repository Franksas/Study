/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

/**

@author yinhansong
@version  1.0
*/

package com.ychs.demo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Usermanager {
public static void main(String[] args) throws SQLException {
	Statement stat=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stumanager","root","root");
		System.out.println(conn);
		String sql="delete from t_student where id=20";
	    stat= (Statement) conn.createStatement();
		int result=stat.executeUpdate(sql);
		System.out.println("删除结果是："+result);
		if(result>0){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		}

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		stat.close();

	}
}
}
