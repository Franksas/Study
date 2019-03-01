/*
* 英才汇硕信息科技有限公司版权所有  @2018
*/
package com.ychs168.corejava;
import java.util.Scanner;

 /**
  * 创建一个方法键盘录入两个数据，比较两个数是否相等
  * @author yinhansong
  *
  */

 public class  Demo12 {
   /*
    * 创建一个方法Deng
    *
    */
   private  static Scanner sc;
   public void Deng(){
     System.out.println("请输入两个数据：");
         Scanner sc = new Scanner(System.in);
         double a = sc.nextDouble();
         double b = sc.nextDouble();
         if(a == b){
           System.out.println("相等");

       }else{
           System.out.println("不相等");

       }

     }

     public static void main (String [] args){
       Demo12 b = new Demo12();
       b.Deng();


     }

 }
