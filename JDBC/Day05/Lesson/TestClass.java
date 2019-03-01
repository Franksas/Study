package com.ychs.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ychs.bean.Clazz;
import com.ychs.service.ClassService;
import com.ychs.service.inter.IClassService;

/**
 * class的测试类
 * @author asus
 *
 */
public class TestClass {
	@Test
	public void testInterestClass() {
		IClassService classService = new ClassService();
		Clazz clazz = new Clazz();
		clazz.setCname("一班");
		boolean flag = classService.insertClass(clazz);
		if (flag) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");

		}
	}
	@Test
	public void testupdateClass() {
		IClassService classService = new ClassService();
		Clazz clazz = new Clazz();
		clazz.setId(3);
		boolean flag = classService.updateClass(clazz);
		if (flag) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");

		}
	}
	@Test
	public void testdelClass() {
		IClassService classService = new ClassService();
		Clazz clazz = new Clazz();
		int id=27;
		boolean flag = classService.delClass(id);
		if (flag) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");

		}
	}
	@Test
	public void testgetClass() {
		IClassService classService = new ClassService();
		Map<String, Object> map = new HashMap<>();
		map.put("cname", "班");
		List<Clazz> list = classService.getClass(map);
		System.out.println(list);
	}
}
