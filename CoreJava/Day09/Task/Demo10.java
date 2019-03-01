/*
* 英才汇硕信息科技有限公司版权所有  @2018
*/
package com.ychs168.corejava;
import java.util.Scanner;

 /**
  * 创建一个方法可以求出1~100累加和的方法
  * @author yinhansong
  *
  */

 public class  Demo10 {
   /*
    * 创建一个方法Sum
    * 返回和的值
    */
   int sum = 0;
   public void Sum(){
     for(int i = 1;i <= 100;i++){
       sum += i;
     }
   System.out.println(sum);
   }
     public static void main (String [] args){
       Demo10 b = new Demo10();
       b.Sum();


     }

 }
