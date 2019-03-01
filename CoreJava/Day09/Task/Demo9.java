/*
* 英才汇硕信息科技有限公司版权所有  @2018
*/
package com.ychs168.corejava;
import java.util.Scanner;

 /**
  * 创建一个方法，可以从控制上输入一个正整数，可以完成输出每位数字，且求数字和的功能
  * @author yinhansong
  *
  */

 public class  Demo9{
   /*
    * 创建一个方法Sum
    */
   int sum = 0;
   private  static Scanner sc;
   public void Everynum(){
     System.out.println("请输入一个正整数：");
         Scanner sc = new Scanner(System.in);
         int num = sc.nextInt();
         while(num!=0){
             int temp = num%10;
             System.out.println(" " + temp);
             num = num/10;
             sum +=temp;

         }

           System.out.println("和等于"+sum);

   }
     public static void main (String [] args){
       Demo9 b = new Demo9();
       b.Everynum();


     }

 }
