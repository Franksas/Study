/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.util.Scanner;

/**
在 setAge(int age) 中对年龄进行判断，如果年龄介于1到100直接赋值，否则抛出异常
在测试类中创建对象并调用 setAge(int age) 方法，使用 try-catch 捕获并处理异常
@author yinhansong
@version  1.0
*/

public class Age {
	public static void setAge(int age)  {
		try {
			if(age < 101 && age > 0) {
				System.out.println(age);
			} else {
	        	throw new Exception();
	        }
		} catch (Exception e) {
				e.printStackTrace();
				System.out.println("异常！");
			}
	}
		public static void main(String[] args) {
			Age a = new Age();
			a.setAge(99);

	}

}
