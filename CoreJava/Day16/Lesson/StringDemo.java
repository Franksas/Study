/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**

@author yinhansong
@version  1.0
*/

public class StringDemo {
	//String 是不可变字符串类；StringBuffer，StringBuilder可变字符串类
	// StringBuffer是同步的，线程安全的；Stringbuffer 是非同步，非线程安全
	public static void main(String[] args) {
		String s1 = "ychs";
		String s2 = new String("xdf");
		String s3 = "ychs";
		//System.out.println(s3.equals(s1));
				s3 = "太原工业学院";
		String s4 = s3.toUpperCase();
		//System.out.println(s3);//yckj

		StringBuffer str1 = new StringBuffer("xdf");
		str1.reverse();
		StringBuffer str2 = new StringBuffer("xdf");
		str1.append("tit").append("ychs");//链式编程风格
		//"xdf" + "tit" + "ychs"
		System.out.println(str1.toString());
		String str4 = str1.toString();

		StringBuilder str3 = new StringBuilder("xdf");
		System.out.println(str2 == str1);
		System.out.println(str2.equals(str1));
	}
}

