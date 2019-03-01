/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
 ***
 循环输入商品编号，显示对应的商品价格，输入n结束循环
 * @author yinhansong
 * @version  1.0
 */
public class Demo28{

	public static void main (String [] args){
    String n = "n";
    String y;
		Scanner sc = new Scanner(System.in);
    Demo32 d = new Demo32();
		System.out.println("MyShopping管理系统>购物结算" );
		System.out.println("********************************************************");
		System.out.println("请选择购买的商品编号：");
		System.out.println("1.T恤   2.网球鞋  3.网球拍");
		System.out.println("********************************************************");
    for(int i=1;i<4;i++){
      	System.out.print("请输入商品编号：");
        System.out.println(i);
        System.out.println("是否继续(y/n)");
          String b = sc.nextLine();
          if (b.equals(n)){
              System.out.print(" 程序结束！");
              break;
          }
    }
  

	}
}
