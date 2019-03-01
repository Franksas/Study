/*
* 英才汇硕信息科技有限公司版权所有  @2018
*/
package com.ychs168.corejava;
import java.util.Scanner;

 /**
  * 求圆的面积(使用调用方法完成)
  * @author yinhansong
  *
  */
 public class Demo8 {
   double r;
   double PI=3.14;
   private static Scanner sc;
   /*
    * 创建一个圆 Yuan
    *
    */
   public void Yuan() {
     System.out.println("圆的半径是：");
     sc = new Scanner(System.in);
         r = sc.nextDouble();
     System.out.println("圆的面积是："+r*r*PI);
   }


   public static void main(String [] args){
     Demo8 d = new Demo8();
     d.Yuan();
   }
 }
