/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
  求两个整数最大公约数
    @author yinhansong
    @version 1.0
*/
public class Demo33{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数");
        int  a= sc.nextInt();
        System.out.println("请输入第二个整数");
        int b= sc.nextInt();
        if(a >= b){
        	for( int i = b;i  > 0;i--){
                if(b%i == 0 && a%i == 0){
                	System.out.println("最大公约数为：" + i);
                	break;
                }
             }
        } else {
                 for( int i = a;i  > 0;i--){
                	 if(b%i == 0 && a%i == 0){
                     	System.out.println("最大公约数为：" + i);
                     	break;
                     }
                 }
        }

    }
}
