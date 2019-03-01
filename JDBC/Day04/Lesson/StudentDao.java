package com.ychs.dao;
/*
 * 学生的dao
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import org.junit.Test;

import com.ychs.bean.Clazz;
import com.ychs.bean.Student;
import com.ychs.util.DBUtil;

public class StudentDao {
	/**
	 * 查询学生列表
	 * @throws SQLException
	 */
	@ Test
	public void getStudent() throws SQLException {
		QueryRunner qr= new QueryRunner(DBUtil.getDataSource());
		String sql = "select s.* ,c.* from t_student1 s left join t_class1 c on s.cno=c.id";
		//List<Student> list = qr.query(sql, new BeanListHandler<>(Student.class));
		List<Student> list = qr.query(sql, new ResultSetHandler<List<Student>>() {
			@Override
			public List<Student> handle(ResultSet rs) throws SQLException {
				List<Student> list2= new ArrayList<Student>();
				while(rs.next()) {
					Student stu=new Student();
					stu.setSid(rs.getInt("sid"));
					stu.setSname(rs.getString("sname"));
					stu.setSex(rs.getString("sex"));
					stu.setAddr(rs.getString("addr"));
					stu.setCno(rs.getInt("cno"));
					Clazz clazz= new Clazz();
					clazz.setId(rs.getInt("id"));
					clazz.setCname(rs.getString("cname"));
					stu.setClazz(clazz);
					list2.add(stu);
				}
				return list2;
			}
		});
		System.out.println(list);

	}
}
