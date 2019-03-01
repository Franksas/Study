/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.util.ArrayList;
import java.util.List;
/**
测试取款过程，观察输出结果
@author yinhansong
@version  1.0
*/

public class Test3 {
	public static void main(String[] args) {
		Account account = new Account(1000);//建立账户对象，余额为1000
		First f = new First(account);//第一个取款人，使用account
		Second s = new Second(account);//第二取款人使用account
		Thread a = new Thread(f,"第一个人");//创建第一个取款线程
		Thread b = new Thread(s,"第二个人");//创建第二个取款线程
		a.start();
		b.start();
	}
}
