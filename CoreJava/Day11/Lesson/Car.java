/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**

    @author yinhansong
    @version  1.0
*/
/*
 * 方法重写示例 super示例
 */
public class Car {
	String cname = "dazhing";
	void drive(int a,String b) {
		System.out.println("有人驾驶汽车");
	}//1.方法名字相同；2.参数列表相同;
	//3.访问控制符相同或越来越宽松

}
class BaiduCar extends Car {
	String cname = "baiduCar";
	public void drive(int c,String b) {
		 System.out.println(new Car().cname);
	     System.out.println(super.cname);
	      super.drive(1,"d");
		System.out.println("new car().cname");
		System.out.println("有人驾驶汽车+无人驾驶汽车");
	}//super：super(),super.属性或方法
public static void main(String [] args) {
		//super.drive();在主方法不能使用super
	new BaiduCar();
	}
}
