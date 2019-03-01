/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
 equals方法分析
@author yinhansong
@version  1.0
*/
public class MathDemo1 {
	public static void main(String[] args) {
		// Math类中的方法都是静态方法，直接使用“类.方法名称()”的形式调用即可
		//	System.out.println("求平方根：" + Math.sqrt(9.0)) ;
		//	System.out.println("求两数的最大值：" + Math.max(10,30)) ;
		//	System.out.println("求两数的最小值：" + Math.min(10,30)) ;
		//	System.out.println("2的3次方：" + Math.pow(2,3)) ;
		//	System.out.println("四舍五入：" + Math.round(33.6)) ;
			System.out.println("生成随机数：" + (int)(Math.random()*1001)) ;

		/*System.out.println(Math.ceil(11.1));
		System.out.println(Math.ceil(11.0));
		System.out.println(Math.ceil(11.5));
		System.out.println(Math.ceil(11.9));
		System.out.println(Math.ceil(-11.1));
		System.out.println(Math.ceil(-11.5));
		System.out.println(Math.ceil(-11.9));
		System.out.println(Math.floor(-9.9));*/
		System.out.println(Math.round(11.1));//11
		System.out.println(Math.round(11.4));//11
		System.out.println(Math.round(11.5));//12
		/*System.out.println(Math.round(11.6));//12
		System.out.println(Math.round(-11.4));//-11
		System.out.println(Math.round(-11.49));//-11
		System.out.println(Math.round(-11.5));//-11
		System.out.println(Math.round(-11.6));//-12*/
		//	Math.round(2.5) ;
		System.out.println(Math.round(-2.1));
		System.out.println(Math.round(-2.2));
		System.out.println(Math.round(-2.3));
		System.out.println(Math.round(-2.4));
	  System.out.println(Math.round(-2.5));
		System.out.println(Math.round(-2.6));
 	  System.out.println(Math.round(-2.7));
		System.out.println(Math.round(-2.8));
		System.out.println(Math.round(-2.9));

						

	}
}
