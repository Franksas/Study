/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
账户类，同步，方法前面同步
@author yinhansong
@version  1.0
*/

public class Account {
	private int balance;//账户余额
	public Account(int balance) {
		this.balance = balance;
	}
	/**
	 * 取款方法
	 * @param amount 要取出的金额
	 */
	public synchronized void withDraw(int amount) {
		System.out.println(Thread.currentThread().getName() + "进入取款方法，准备取出：" + amount + ":当前余额" + balance);
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() +"余额足够，开始取款....");
			balance = balance - amount;
			System.out.println(Thread.currentThread().getName() + "取出" + amount + "; 账户结余：" + balance);
		} else {
			System.out.println(Thread.currentThread().getName() +"账户余额不足！不能取款！");
	}
	}
}
