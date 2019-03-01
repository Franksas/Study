/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**

    @author yinhansong
    @version  1.0
*/
public class Animal {
	String name;
	public Animal(String n) {name = n;}

}
class Dog extends Animal {
	public Dog() {
		super("小黄");//调用父类带一个参数的构造方法
    System.out.println("小黄");
	}
	public static void main(String  [] args) {
		new Dog();
	}
}
