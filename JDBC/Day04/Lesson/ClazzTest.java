package com.ychs.test;

import java.util.List;

import org.junit.Test;

import com.ychs.bean.Clazz;
import com.ychs.dao.ClazzDao;

public class ClazzTest {
	public static void main(String[] args) {
		ClazzDao clazzDao = new ClazzDao();
		Clazz clazz = new Clazz();
		clazz.setId(2);
		clazz.setCname("三班");
		int res = clazzDao.insertClszz(clazz);
		if(res>0) {
			System.out.println("插入成功");

		}else {
			System.out.println("插入失败");
		}
	}
	@Test
	public void selectClazz() {
		ClazzDao clazzDao = new ClazzDao();
		Clazz clazz = clazzDao.getClazzById();
		System.out.println(clazz);
	}
	@Test
	public void selectAllClazz() {
		ClazzDao clazzDao= new ClazzDao();
		List<Clazz> list= clazzDao.getClazz();
		System.out.println(list);
	}

}
