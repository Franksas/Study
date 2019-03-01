/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
/**
存款取款类
@author yinhansong
@version  1.0
*/
public class CheckingAccount {
	private double balance;//账户余额
	private int number;
	public CheckingAccount(int number) {
		this.number = number;
	}
	/**
	 * 存款方法
	 * @param amount
	 *    存款金额
	 */
	public void deposit(double amount) {
		balance += amount;
	}

	/**
	 * 取款方法
	 * @param amount
	 *   取款金额
	 * @throws InsufficientFundsException
	 *             余额不足时抛出该异常
	 */
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount <= balance) {
			balance -= amount;
		} else {
			double needs = amount - balance;// 不足的金额
			throw new InsufficientFundsException(needs);// 抛出余额不足异常
		}
	}
	/**
	 * 获取账户余额
	 * @return
	 */
	public double getBalance() {
		return balance;
	}
	public int getNumber() {
		return number;
	}
}
