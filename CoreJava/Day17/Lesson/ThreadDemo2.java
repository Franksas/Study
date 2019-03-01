/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
实现线程的第二种方式：实现Runnable接口
@author yinhansong
@version  1.0
*/


public class ThreadDemo2 implements Runnable {
	public void run() {
		for(int i = 0;i <10;i++) {
			System.out.println(Thread.currentThread().getName() + "：盖房子 " );
		}
	}
}
class Test1 {
	public static void main(String[] args) {
		ThreadDemo2 a1 = new ThreadDemo2();
		ThreadDemo2 a2 = new ThreadDemo2();
		Thread t1 = new Thread(a1,"小松");
		Thread t2 = new Thread(a2,"小赵");
		t1.start();//启动线程：能否直接调用run()?能，但是没有了线程的效果哦
		t2.start();
	}
}
