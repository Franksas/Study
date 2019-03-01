/*
* 英才汇硕信息科技有限公司版权所有  @2018
*/
package com.ychs168.corejava;
import java.util.Scanner;

 /**
  * 键盘录入一个数据n(1<=n<=9)，输出对应的nn乘法表
  * @author yinhansong
  *
  */

 public class  Demo13{
   /*
    * 创建一个方法
    * 返回乘法表
    */private  static Scanner sc;
     public void Multiplication(){
       System.out.println("请输入一个正整数n（1<=n<=9)：");
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         for(int i = 1;i <= n;i++){
              for(int j = 1;j <= i;j++){
                   System.out.print(i + "*" + j + "=" +i * j + " ");
                 }
                 System.out.println();
               }

   }
     public static void main (String [] args){
       Demo13 b = new Demo13();
       b.Multiplication();


     }

 }
