/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**

    @author yinhansong
    @version  1.0
*/
public class Student {
	private String name;
	private int age;
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		if(obj instanceof Student) {
			Student stu = (Student)obj;
			return stu.name.equals(this.name)&&this.age == stu.age;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
class Task5 {
	public static void main(String[] args) {
		Student stu1 = new Student("zs",12);
		Student stu2 = new Student("zs",12);
		System.out.println(stu1==stu2);
		System.out.println(stu1.equals(stu2));
		System.out.println(stu1);
	}
}
