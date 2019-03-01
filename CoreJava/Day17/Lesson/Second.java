/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
第一个取款人
@author yinhansong
@version  1.0
*/


public class Second implements Runnable {
	Account ab;//账户

	public Second(Account ab) {
		this.ab = ab;//给账户初始化
	}

	public void run() {
		ab.withDraw(1000);//取款方法
	}
}
