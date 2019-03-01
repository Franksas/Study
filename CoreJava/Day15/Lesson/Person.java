/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.io.IOException;

/**
 * 方法重写时的异常
 * @author yinhansong
 * @version 1.0
 */
public class Person {
	public void test() throws ClassNotFoundException,ArithmeticException {
		System.out.println("Person");
	}
	public void set() throws Exception {}
}
class Student extends Person {
	//1.子类方法可以抛出比父类更少的异常 2. 也可以抛出比父类更多的异常，但是：子类异常必须是父类那些异常 的 子类
	public void test() throws ClassNotFoundException,ArithmeticException {
		//错误的原因：IOException在父类方法抛出的异常中不存在，也找不到IOException的父类
	}

	public void set() throws IOException,ClassNotFoundException {}

}
