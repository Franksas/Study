/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
 *throws使用：位置：方法声明处出现;当前方法存在的异常由调用者处理;throws抛出运行时异常没有意义
@author yinhansong
@version  1.0
*/

public class ThrowsDemo {
	public static void test()  throws ArithmeticException,ClassNotFoundException {
		Class.forName("");
		int c = 3 / 0;
		}
		public static void main(String[] args) {
			try {
				test();
				//System.out.println("HELLO");
				}  catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
	}
}
