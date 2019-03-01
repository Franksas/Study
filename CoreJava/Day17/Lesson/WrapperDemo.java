/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

import java.util.Random;
import java.util.zip.Adler32;

/**

@author yinhansong
@version  1.0
*/
public class WrapperDemo {
	public void test() {
		Integer a1 = new Integer(100);
		Integer a2 = new Integer("200");
		Integer a3 = new Integer("200");
		int a4 = 200;
		Integer a5 = 200;//自动装箱机制
		int a6 = a5;//自动拆箱机制
		/*System.out.println(a4 == a5);//true
		System.out.println(a3 == a4);//true
		System.out.println(a3 == a2);//false
		System.out.println(a3.equals(a2));//true
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);*/

		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("请输入两个数字：");
		String input1 = sc.next();
		String input2 = sc.next();
		int a7 = 800;
		String str7 = a7 + "";//"800"
		System.out.println(Integer.parseInt(input1) + Integer.parseInt(input2));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WrapperDemo wb = new WrapperDemo();
		wb.test();
	}

}
