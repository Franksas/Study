/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
   多线程
@author yinhansong
@version  1.0
*/
public class MultiThread {
	public static void main(String[] args) {
		RunningObject ro = new RunningObject();
		Thread t1 = new Thread(ro,"芙蓉");
		Thread t2 = new Thread(ro,"赵本山");
		t1.start();
		t2.start();


	}
}
class RunningObject implements Runnable {
	public void run() {
		for (int i = 0; i < 20; i++) {
			String name = Thread.currentThread().getName();
			System.out.println(name  + ": " + i);

		}
	}

}
