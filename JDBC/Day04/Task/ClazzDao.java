package com.ychs.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
	@org.junit.Test
	public Clazz getClazzById() {
		Clazz clazz =  null;
		try {
			QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
			String sql = "select * from t_class1 where id=4";
			clazz = qr.query(sql,new BeanHandler<Clazz>(Clazz.class));
			System.out.println(clazz);

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
			System.out.println(list);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;

	}
	/**
	 * 删除学生
	 * @return
	 */
	public int deleteClazz() {
		Clazz clazz = new Clazz();
		clazz.setId(24);
		int res =0;

		try {
			QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
			String sql= "delete from t_class1 where id=?";

			res = qr.update(sql,new Object[] {clazz.getId()});
			System.out.println(res);
			if(res>0) {
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;

	}
	/**
	 * 修改学生
	 */
	public int updateClazz() {
		Clazz clazz = new Clazz();
		clazz.setId(5);
		int res =0;
		try {
			QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
			String sql= "update t_class1 set id=1 where id=?";
			res = qr.update(sql,new Object[] {clazz.getId()});
			if(res>0) {
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;

	}

}
