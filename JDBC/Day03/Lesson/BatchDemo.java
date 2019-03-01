package com.ychs.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.ychs.utl.OracleDBUtil;

/*
 * 静态批处理
 */
public class BatchDemo {
	public static void main(String[] args) throws SQLException {
		//获取连接
		Connection conn = null;
		PreparedStatement ps= null;
		Statement stat= null;
		try {
			conn = OracleDBUtil.getConnection();
			String sql = "insert into t_user values(110,'shh',123456,'普通用户')";
			String sql2 = "insert into t_user values(190,'事jsg务',145545,'普通用户')";
			String sql3 = "insert into t_user values(150,'事sg务',123654,'普通用户')";
			conn.setAutoCommit(false);
			//获取语句的执行者
			stat =conn.createStatement();
			stat.addBatch(sql);
			stat.addBatch(sql2);
			stat.addBatch(sql3);
			//执行批处理
			int[] res=stat.executeBatch();
			conn.commit();
			//有问题，要提交一起提交，要回滚一起回滚

		} catch (SQLException e) {
			try {//回滚
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			e.printStackTrace();
		}finally {
			stat.close();
			conn.close();
		}
	}
}
