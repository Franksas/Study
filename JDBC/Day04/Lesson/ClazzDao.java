package com.ychs.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ychs.bean.Clazz;
import com.ychs.util.DBUtil;

/**
 * 对班级的操作（增删改查）
 * @author asus
 *
 */
public class ClazzDao {
	/*
	 * 插入班级表
	 */
	public int insertClszz(Clazz clazz) {
		int res =0;
		try {

			//获取QueryRunner对象，用它来操作SQL
			QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
			//编写SQL
			String sql = "insert into t_class1 values (?,?)";
			//通过QueryRunner对象执行sql
			 res = qr.update(sql,new Object[] {clazz.getId(),clazz.getCname()});
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 查询班级列表
	 * @return
	 */
	public Clazz getClazzById() {
		Clazz clazz =  null;
		try {
			QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
			String sql = "select * from t_class1 where id=1";
			clazz = qr.query(sql,new BeanHandler<Clazz>(Clazz.class));


		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return clazz;
	}
	/**
	 * 返回所有的班级列表
	 */
	public List<Clazz> getClazz() {
		List<Clazz> list = null;
		try {

			QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
			String sql = "select * from t_class1";
			list = qr.query(sql, new BeanListHandler<Clazz>(Clazz.class));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	}

}
