/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
/**
测试自定义异常
@author yinhansong
@version  1.0
*/
public class BankDemo {

	public static void main(String[] args) {
		CheckingAccount c = new CheckingAccount(101);
		System.out.println("存入 500...");
		c.deposit(500.00);

		try {
			System.out.println("取款  100...");
			c.withdraw(100.00);
			System.out.println("取款  600...");
			c.withdraw(600.00);
		} catch (InsufficientFundsException e) {
			System.out.println("对不起，取款不成功，余额不足，您账户差： " + e.getAmount());
			e.printStackTrace();
		}
	}
}
