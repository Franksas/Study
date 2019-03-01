/*
* 英才汇硕信息科技有限公司版权所有  @2018
*/
package com.ychs168.corejava;
import java.util.Scanner;
/**
*创建一个判断两个数的最大值的方法
* @author yinhansong
*
*/
public class Demo4 {
 int a;
 int b;
 private  static Scanner sc;
 public int Max(int a,int b){
   if(a>b){
     this.a = a;
   }else{
     this.b = a;
   }
   return a;
 }
 public static void main(String[] args) {
   Demo4 d = new Demo4();
       System.out.println("请输入两个整数：");
       Scanner sc = new Scanner(System.in);
       int s = sc.nextInt();
       int y = sc.nextInt();
       System.out.println("最大值："+ d.Max(s,y));
 }

}
