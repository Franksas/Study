/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**

    @author yinhansong
    @version  1.0
*/


public class Mobile {
	public Mobile() {
		System.out.println("3333");
	}
	public int getprice() {
		System.out.println("111");
		return 2000;
	}

{//游离语句块；代码块；自由块
	System.out.println("2222");
}
  	int price = getprice();//默认赋值；显示赋值；构造方法赋值
    /*public static void main(String [] args) {
	new Mobile();
}*/
}
 class HuaWei extends Mobile{
	  public HuaWei() {
		  System.out.println("444");
	  }
	  public  int getprice1() {
		  System.out.println("555");
		  return 2000;
	  }
	  {//游离语句块；代码块，自由块
	      System.out.println("6666");
	  }
	   int price1 = getprice1();//默认赋值；显式赋值；构造方法赋值
 public static void main(String[] args) {
		 	new HuaWei();
		 }

}
