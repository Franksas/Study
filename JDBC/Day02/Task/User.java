package com.ychs.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ychs.utl.OracleDBUtil2;

/**
 *  任务一： 创建一“用户表”（用户 id，用户名，用户密码，用户权限<1 普通用户 2 管理员 3 超级管理员>）
 *	实现“控制台注册”功能（要求用户名已经注册过的不允许再次注册）
 *  实现“控制台登录”功能（登录成功显示“欢迎***进入系统，您的权限为***“，
 *  否则登录失败显示”对不起，您的用户名或密码错误 ，请重试”，“是否还没注册，请注册”）
 * @author lenovo
 * @version 1.0
 *
 */
public class User {
	public static void main(String[] args) {
		Sign sign = new Sign();
		Enter enter = new Enter();
		Scanner sc = new Scanner(System.in);
		enter.enterIn();
		System.out.println("输入1，进入注册页面！！ 输入0，退出此程序！！");
		int num = sc.nextInt();
		while(true) {
			if(num == 1) {
				sign.signin();
				enter.enterIn();
			} else {
				return;
			}
		}
	}
}

class Sign {
	public void signin() {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		System.out.println("----------进入注册页面--------------");
		System.out.println("请输入用户ID：");
		int id = sc.nextInt();
		System.out.println("请输入用户名：");
		String name = sc.next();
		System.out.println("请输入用户密码：");
		String password = sc.next();
		System.out.println("请输入用户权限<1 普通用户 2 管理员 3 超级管理员>）：");
		String permission = sc.next();
		conn = OracleDBUtil2.OraclegetConnection();
		try {
			String sql1 = " select name from t_user ";
			ps1 = conn.prepareStatement(sql1);
			rs = ps1.executeQuery();
				while(rs.next()) {
					String name1 = rs.getString("name");
					if(name1.equals(name1)) {
						System.out.println("注册失败，可能是用户名已被注册,请重新输入用户名");
						return;
					}
				}
				String sql = " insert into t_user values(?,?,?,?) ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, password);
				ps.setString(4, permission);
				int num = ps.executeUpdate();
				if(num > 0) {
					System.out.println("注册成功");
				} else {
					System.out.println("注册失败");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil2.close(conn, ps, null);
			OracleDBUtil2.close(null, ps1, rs);
		}

	}
}


class Enter {
	public void enterIn() {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("----------进入登录页面--------------");
		System.out.println("请输入用户名：");
		String name = sc.next();
		System.out.println("请输入用户密码：");
		String password = sc.next();

		conn = OracleDBUtil2.OraclegetConnection();
		try {
			String sql = " select * from t_user where name = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(!rs.next()&rs.getString("password").equals(password)) {
				System.out.println("欢迎您，登录成功!!  您的权限为"+rs.getString("permission")+"<1 普通用户 2 管理员 3 超级管理员>");
				System.exit(0);
			} else if(!rs.getString("password").equals(password)) {
				System.out.println("用户密码错误");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("登录失败，用户可能未注册，是否注册？");
		} finally {
			OracleDBUtil2.close(conn, ps, rs);
		}
	}
}
