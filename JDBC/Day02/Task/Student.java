package com.ychs.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ychs.utl.OracleDBUtil2;

public class Student {
	/**
	 * 1学员信息表中所有数据做分页
	 * 2实现用户输入页码获取当页数据,还可以提示用户共有几页数据
	 * 3提供”首页”，"上一页”，“下一页”,”尾页”功能
	 */
	public void getInformation() {
		Scanner sc = new Scanner(System.in);
		int page = 1;
			Connection conn = null;
			PreparedStatement ps = null;
			PreparedStatement ps1 = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			int num = 0;
			int count = 0;
			int pageCount = 3;
			//获取总页数
				try {
					conn = OracleDBUtil2.OraclegetConnection();
					String sql1 = " SELECT b.* FROM("
							+ "SELECT a.*,ROWNUM rn FROM ("
							+ "SELECT * FROM t_student1 ORDER BY sid) a) b ";
					ps1 = conn.prepareStatement(sql1);
					rs1 = ps1.executeQuery();
					while(rs1.next()) {
						num = num+1;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(num%pageCount==0) {
				count = num/pageCount;
			} else {
				count = num/pageCount+1;
			}
		for(;;) {
			try {
			conn = OracleDBUtil2.OraclegetConnection();
			//给所有数据做分页
			String sql = " SELECT b.* FROM("
					+ "SELECT a.*,ROWNUM rn FROM ("
					+ "SELECT * FROM t_student ORDER BY student_id) a) b "
					+ "WHERE b.rn > ? AND b.rn <= ? ";
				if(page <= count & page > 0) {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, (page - 1)*pageCount);
					ps.setInt(2, page * pageCount);
					rs = ps.executeQuery();
					System.out.println("-------------学员信息"+page+"/"+count+"-----------------");
					System.out.println("学员id" +"\t"+ "学员姓名 " +"\t"+ "学员性别"+"\t"+"学员地址" + "\t"+"学号");
					while(rs.next()) {
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)
											+"\t"+rs.getString(3)+"\t"+rs.getString(4)
											+"\t"+rs.getInt(5));
					}
					System.out.println(page+"页，还剩"+(count-page)+"页,共有"+count+"页");
				} else {
					System.out.println("没有此页");
				}
				System.out.println("输入数字选择功能 \t0首页 \t 1上一页 \t 2下一页 \t 3尾页 \t 4去指定页数");
				int num1 = sc.nextInt();
				if(num1 == 0) {
					page = 1;
				} else if(num1 == 1) {
					page = page - 1;
				} else if(num1 == 2) {
					page = page + 1;
				} else if(num1 == 3) {
					page = count;
				} else {
					page = sc.nextInt();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				OracleDBUtil2.close(conn, ps, rs);
			}
		}
	}

	public static void main(String[] args) {
		StudentInformation student = new StudentInformation();
		student.getInformation();
	}
}
