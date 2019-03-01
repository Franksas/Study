/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
实现线程的第一种方式：继承Thread类
@author yinhansong
@version  1.0
*/


public class ThreadDemo extends Thread {
	public ThreadDemo(String name) {
		super(name);
	}
	public void run() {
		for(int i = 0;i <10;i++) {
			System.out.println(Thread.currentThread().getName() + ":拆房子");
		}
	}
}
class Test {
	public static void main(String[] args) {
		ThreadDemo t1 = new ThreadDemo("小松");
		ThreadDemo t2 = new ThreadDemo("小明");
		t1.start();//启动线程：能否直接调用run()?能，但是没有了线程的效果
		t2.start();
	}
}
