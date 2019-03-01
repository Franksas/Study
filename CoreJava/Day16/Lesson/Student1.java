/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;



/**
 equals方法分析
@author yinhansong
@version  1.0
*/

public class Student1 {
    String name;
    int age;
    int grade;
    static Student1 s = new Student1();

    public Student1() {System.out.println("ffff");}

    protected void finalize() {
    	System.out.println("11111");

	}
    public static void main(String[] args) {
		Student1 s1 = new Student1();
		/*Student1 = null;
		System.gc();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++ ) {

		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);*/


	}

}
