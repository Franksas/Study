/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
 *throw使用，人工抛出（引发）异常
@author yinhansong
@version  1.0
*/

public class ThrowDemo {
	public void calc() {
		int a = 9;
		int b = 3;
		double c = 0.0;
		if(b == 0) {
			throw  new ArithmeticException();//人工抛出异常，throw + 异常对象
		} else {
				c = a / b;
		}
		System.out.println(c);
	}
	public static void main(String[] args) {
		ThrowDemo d = new ThrowDemo();
		d.calc();
	}
}
