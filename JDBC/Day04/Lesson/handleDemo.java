package com.ychs.test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.ychs.util.DBUtil;


/*
 * 结果集的处理类
 */
public class handleDemo {
	private static final String Long = null;
	//结果集封装成Array
	@Test
	public void ArrayHandleFun() throws SQLException {
		QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_class1";
		Object[] obj=qr.query(sql, new ArrayHandler());
		System.out.println(Arrays.toString(obj));
	}
	/**
	 * 先放到数组里，然后把数组放到List里
	 */
	@Test
	public void ArrayHandleFun1() throws SQLException {
		QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_class1";
		List<Object[]> list=qr.query(sql, new ArrayListHandler());
		for(Object[] obj:list) {

			System.out.println(Arrays.toString(obj));
		}
	}
	@Test
	public void ScalarHandleFun() throws SQLException {
		QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
		String sql = "select count(*) from t_class1";
		//不谢泛型也可以出来
		Object obj= qr.query(sql, new ScalarHandler());
		System.out.println(obj.getClass().getTypeName());
		int i =((BigDecimal)obj).intValue();
		System.out.println(obj);

	}
	@Test//
	public void MapHandleFun() throws SQLException {
		QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_class1";

		java.util.Map<String, Object> map = qr.query(sql, new MapHandler());

		System.out.println(map);

	}
	@Test//
	public void MapHandleFun1() throws SQLException {
		QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_class1";

		List<Map<String, Object>> map= qr.query(sql, new MapListHandler());

		System.out.println(map);

	}

	@Test
	public void KeyedHandleFun() throws SQLException {
		QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_class1";
		Map<Object,Map<String,Object>> map=
				(Map<Object, Map<String, Object>>) qr.query(sql, new KeyedHandler<>("cname"));
		System.out.println(map);
	}

}
