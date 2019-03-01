/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
  编写两个线程实现左手写A右手写B的效果
@author yinhansong
@version  1.0
*/
public class Hand {
	public static void main(String[] args) {
		RunningObject1 r = new RunningObject1();
		Thread t1 = new Thread(r,"左手：A");
		Thread t2 = new Thread(r,"右手：B");
		t1.start();
		t2.start();

	}
}
class RunningObject1 implements Runnable {
	public void run() {
		for (int i = 0; i < 10;i++) {
			String name = Thread.currentThread().getName();
			System.out.println(name);

		}
	}

}
