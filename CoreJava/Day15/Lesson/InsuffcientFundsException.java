/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
/**
自定义异常，继承Exception或其它已经存在的异常类
@author yinhansong
@version  1.0
*/


public class InsufficientFundsException extends Exception {
	private double amount;

	public InsufficientFundsException(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
}
