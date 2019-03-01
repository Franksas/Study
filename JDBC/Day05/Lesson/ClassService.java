package com.ychs.service;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Clazz;
import com.ychs.dao.ClassDao;
import com.ychs.dao.inter.IClassDao;
import com.ychs.service.inter.IClassService;

public class ClassService implements IClassService{
	private IClassDao classDao = new ClassDao();
	@Override
	public boolean insertClass(Clazz clazz) {
		int res = classDao.insertClass(clazz);
		if(res>0) {
			return true;
		}else {
			return false;
		}


	}
	@Override
	public boolean updateClass(Clazz clazz) {
		int res = classDao.insertClass(clazz);
		if(res>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean delClass(int id) {
		int res = classDao.delClazz(id);
		if(res>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<Clazz> getClass(Map<String, Object> map) {
		return classDao.getClazz(map);
	}

}
