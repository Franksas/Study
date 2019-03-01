/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
  继承分析控制符: ：private,--,protected,public
    @author yinhansong
    @version  1.0
*/


class Persion {
	String name;
	String sex;
	protected int salary;
	public Persion() {}
	public Persion(String n,String s,int sal){
		name = n;
		sex = s;
		salary = sal;
	}
	public void say(int x) {
	 	//private int age = 19;
	}
	private void add() {}
	}

public class Student extends Persion {
	 int grade;
	 public static void main(String [] args) {
		 System.out.println(new Student().salary);
	 }


}
