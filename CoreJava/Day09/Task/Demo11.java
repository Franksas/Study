/*
* 英才汇硕信息科技有限公司版权所有  @2018
*/
package com.ychs168.corejava;
import java.util.Scanner;

 /**
  * 创建一个方法可以找出三个数的最大值
  * @author yinhansong
  *
  */

 public class  Demo11 {
   /*
    * 创建一个方法Max
    * 返回最大值
    */
   int max = 0;
   private  static Scanner sc;
   public int Max(){
     System.out.println("请输入三个正整数：");
         Scanner sc = new Scanner(System.in);
         int a = sc.nextInt();
         int b = sc.nextInt();
         int c = sc.nextInt();
         if(a >= b){
         max = a;
         if(max >= c){
           System.out.println(max);
         }else{
           System.out.println(c);
         }
       }else{
         max = b;
         if(max >= c){
           System.out.println(max);
         }else{
           System.out.println(c);
         }
       }
       return 0;
     }

     public static void main (String [] args){
       Demo11 b = new Demo11();
       b.Max();


     }

 }
