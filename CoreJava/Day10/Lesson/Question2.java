/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;

/**


    @author yinhansong
    @version 1.0
*/
 class Student {
	 	    String name;
	 	    int age;
	 	    public Student(String s, int a) {
	 	        name = s;
	 	        age = a;
	 	    }
	 	}


public class Question2 {
	public static void main(String [] args) {
		Student [] s = new Student[3];
		s[0] = new Student("zhangsan",20);
		s[0] = new Student("lisi",19);
		s[0] = new Student("wangwu",22);
		Student [] x = s;
		x[1] = new Student("other",11);
		System.out.println(s[1].name);
	}

}
