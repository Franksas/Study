/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**

    @author yinhansong
    @version  1.0
*/

 class People {
	 	int num = 1;
		public void test() {
			System.out.println("hi");
		}
}
class Child extends People {
	int num = 2;
	String name = "zzz";
	public void  fun() {
		System.out.println("子类的fun方法");
	}
}
class Child2 extends People {
	public void  fun() {
		System.out.println("2子类的fun方法");

	}
}
	class Test1 {
		public static void main(String[] args) {
			People p = new Child();//向上转型
			//System.out.println(p.num);
			//p.test();
			if(p instanceof Child) {
				Child c = (Child)p;//向下转型
				c.fun();
			}else {
				System.out.println("类型转换错误");
			}
			Child2 c2 = (Child2)p;
			c2.fun();
			//p.name;
			Child c = new Child();
			System.out.println(c2.num);


		}
	}
