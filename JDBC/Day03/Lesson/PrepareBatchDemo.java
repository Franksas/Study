package com.ychs.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ychs.utl.OracleDBUtil;

public class PrepareBatchDemo {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		conn = OracleDBUtil.getConnection();
		String sql = "insert into t_user values(?,?,?,?)";
		conn.setAutoCommit(false);
		//获取PrepareStatement对象
		PreparedStatement ps =conn.prepareStatement(sql);
		/*ps.setInt(1, 1);
		ps.setString(2,"为何");
		ps.setString(3,"156895");
		ps.setString(4, "普通用户");
		ps.addBatch();

		ps.setInt(1, 2);
		ps.setString(2,"为wg何");
		ps.setString(3,"156895");
		ps.setString(4, "普通用户");
		ps.addBatch();

		ps.setInt(1, 3);
		ps.setString(2,"问号何");
		ps.setString(3,"156895");
		ps.setString(4, "普通用户");
		ps.addBatch();*/
		for(int i=10;i<20;i++){
			ps.setInt(1, i);
			ps.setString(2,"教案吧");
			ps.setString(3,"1568495");
			ps.setString(4, "普通用户");
			ps.addBatch();
		}
		int[] res=ps.executeBatch();
		System.out.println(res[0]+res[1]);
		conn.commit();
		OracleDBUtil.close(conn, ps, null);
	}

}
