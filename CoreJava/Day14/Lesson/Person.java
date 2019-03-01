/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**

    @author yinhansong
    @version  1.0
*/
public class Person {
	int age = 21;
	 public int getAge() {
	        return age;
	    }
}
class Student1 extends Person {
}
class Teacher extends Person { }
class Test2 {
	/*public void a(Student s) {
		System.out.println(s.getAge());
	}
	public void b(Student t) {
		System.out.println(t.getAge());
	}*/
	 public void c(Person p) {
		 System.out.println(p.getAge());
	 }
	public static void main(String [] args) {
		Test2 t = new Test2();
		Student1 s = new Student1();
		t.c(s);
	    t.c(new Person());
	     t.c(new Teacher());
	 }
}
