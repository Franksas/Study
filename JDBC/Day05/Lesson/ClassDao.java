package com.ychs.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ychs.bean.Clazz;
import com.ychs.dao.inter.IClassDao;
import com.ychs.util.DBUtil;

/**
 *
 * @author asus
 *
 */
public class ClassDao implements IClassDao{

	@Override
	public int insertClass(Clazz clazz) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		//shift +回车 下面空一行 ctrl+shift+回车上面空一行 Ctrl+D 是删除空行
		String sql = "insert into t_class1 values(class_seq.nextval,?)";
		int res = 0;
		try {
			res = qr.update(sql, new Object[] {clazz.getCname()});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int updateClazz(Clazz clazz) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "update t_class1 set id=6 where id=?";
		int res = 0;
		try {
			res = qr.update(sql,new Object[] {clazz.getId()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delClazz(int id) {
		int id2;
		id2=id;
		int res=0;
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "delete from t_class1 where id="+id2+"";
		try {
			res = qr.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Clazz> getClazz(Map<String, Object> map) {
		List<Clazz> list =  null;
		try {
			QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
			StringBuffer sql = new StringBuffer("select * from t_class1 where 1 = 1");
			List params = new ArrayList();
			if(map.get("cname")!=null && map.get("cname").equals("")) {
				sql.append("and cname like ?");
				params.add("%"+map.get("cname")+"%");
			}
			list = qr.query(sql.toString(),new BeanListHandler<>(Clazz.class),params.toArray());

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
