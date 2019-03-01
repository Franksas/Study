package com.ychs.dao.inter;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Clazz;

/**
 * 班级的接口
 * @author asus
 *
 */
public interface IClassDao {
	//添加班级
	public int  insertClass(Clazz clazz);
	//修改班级
	public int  updateClazz(Clazz clazz);
	//删除班级
	public int delClazz(int id);
	//查询班级
	public List<Clazz> getClazz(Map<String, Object> map);
}
