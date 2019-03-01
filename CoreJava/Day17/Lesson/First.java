/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import javax.security.auth.login.AccountNotFoundException;
/**
第一个取款人
@author yinhansong
@version  1.0
*/

public class First implements Runnable {
	Account ab;//账户

	public First(Account ab) {
		this.ab = ab;//给账户初始化
	}
	public void run() {
		ab.withDraw(800);//调用取款方法
	}
}
