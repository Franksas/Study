/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**

@author yinhansong
@version  1.0
*/


public class ExecuteTime {
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		for(int i = 0;i < 100;i++) {
			System.out.println(i);

		}
		long end = System.currentTimeMillis();
		System.out.println("执行时间是：" + (end - begin) + "毫秒。");
	}
}
