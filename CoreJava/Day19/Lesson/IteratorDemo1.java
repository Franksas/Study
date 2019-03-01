/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**

@author yinhansong
@version  1.0
*/
public class IteratorDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> all = new ArrayList<String>() ;
		all.add("你好");
		all.add("微信");
		all.add("世界");
		Iterator<String> iter = all.iterator();//为Iterator接口实例化
		while(iter.hasNext()){    //判断是否有内容
			System.out.println(iter.next());//输出内容
		}

		Student s1 = new Student("zhangsan",21);
		Student s2 = new Student("lisi",20);
		Student s3 = new Student("xiaowang",22);

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);

		Iterator<Student> sit = studentList.iterator();     // 为Iterator接口实例化
		while(sit.hasNext()){	// 判断是否有内容
		    Student s = (Student)sit.next();
			System.out.println(s.getAge() + "  " + s.getName()) ;	// 输出内容
		}
		System.out.println("\n");
		for(Student s: studentList) {
			System.out.println(s.getAge() + " " + s.getName());
		}

	}

}
class Student {
	String name;
	int age;

	public Student(){}
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public int getAge(){return age;}
	public String getName(){return name;}


}
