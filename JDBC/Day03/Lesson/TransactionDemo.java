package com.ychs.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ychs.utl.OracleDBUtil;

/*
 * 设置手动提交
 */
public class TransactionDemo {
	public static void main(String[] args) {
		//获取连接
		Connection conn = null;
		PreparedStatement ps= null;
		PreparedStatement ps2= null;
		conn = OracleDBUtil.getConnection();
		try {
			String sql = "insert into t_student(sno,sname) values(10,'邯郸')";
			String sql2 = "insert into t_student(sno,sname) values(41,'事务')";
			//手动开启事务
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			//int j=1/0;
			ps2 = conn.prepareStatement(sql2);
			//执行SQL
			int res = ps.executeUpdate();
			int res2= ps2.executeUpdate();
			//提交到数据库
			conn.commit();
			if(res>0&&res2>0) {
				//手动提交到数据库
				conn.commit();
			}else {
				//回滚
				conn.rollback();
			}
		} catch (Exception e) {
			try {//回滚
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			e.printStackTrace();
		}finally {

			OracleDBUtil.close(conn, ps, null);
		}

	}
}
