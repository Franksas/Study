/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
 ***
 循环输入商品编号和购买数量，当输入n结账，结账时计算应付金额并找回零钱。
 * @author yinhansong
 * @version  1.0
 */
public class Demo32{

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
    int money1 = 0;
    int money2 = 0;
    int money3 = 0;
    int money4 = 0;
    for(int i=1;i<4;i++){
      	System.out.print("请输入商品编号：");
        System.out.println(i);
        System.out.println("是否继续(y/n)");
          String f = sc.nextLine();
          if (f.equals(n)){
             break;
    }
    }
   w:for(int g = 1; g < 4;g++){
      System.out.println("请输入购买数量");
      System.out.println(g);
      System.out.println("是否继续(y/n)");
      String b = sc.nextLine();
      if (b.equals(n)){
           System.out.print(" 程序结束！");
           switch(g){
           case 1: {
               money1 = g * 100;
               System.out.println("T恤    ￥" + money1);
               break w;
           }
           case 2: {
               money2 = g * 200;
               System.out.println("网球鞋    ￥" + money2);
               break w;
           }
           case 3: {
                money3 = g * 300;
                System.out.println("网球拍     ￥" + money3);
                break w;

           }

       }
      }
    }
    	money4 = money1 + money2 + money3  ;
       System.out.println("应付：" + money4);
       System.out.println("输入实付金额：");
       int money5 = sc.nextInt();
       System.out.println("找零：" + (money5-money4));



    }

	}
