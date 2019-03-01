/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
   虚方法调用的演示程序
    @author yinhansong
    @version  1.0
*/
public class Device {
	public static void test() {System.out.println("hello");}
}
class Computer extends Device {
	public static void  test() {
		System.out.println("cdf");
	}
}
class Test5 {
	public static void main(String[] args) {
		Device d = new Device();
		d.test();
		Device d1 = new Computer();//实例，对象，创建对象==实例化
		System.out.println(d1 instanceof Device);
		d1.test();
		Computer c = new Computer();
		c.test();
	}
}
