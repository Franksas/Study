package com.ychs.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

import com.mysql.jdbc.ConnectionGroupManager;
import com.ychs.utl.MysqlDBUtil;


public class MysqlUserManager {
@Test
public void getuser() {

	int page = 1;
	int pageCount=3;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection conn=null;
	try {
		conn=MysqlDBUtil.getConnection1();
		String sql = "select * from t_student limit ?,?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1,(page)*pageCount);
		ps.setInt(2, page*pageCount);
		rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1));
			}

	} catch (SQLException e) {
		// TODO: handle exception
		MysqlDBUtil.close(conn, ps, rs);
	}


}
}
