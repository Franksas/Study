/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
   //this使用的注意事项
    @author yinhansong
    @version  1.0
*/

public class Cup {
	String name;
	int capacity;
	public Cup(String name,int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
public static void main(String [] args) {
		Cup cp = new Cup("富光",350);
		System.out.println(cp.name + "  " + cp.capacity);
 } //super与this的区别是什么
}
