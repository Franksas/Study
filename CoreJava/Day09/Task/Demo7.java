/*
* 英才汇硕信息科技有限公司版权所有  @2018
*/
package com.ychs168.corejava;
import java.util.Scanner;
/**
*  使用方法的重载完成整数的相加，浮点数的相加，参数可以是两个或三个。
* @author yinhansong
*
*/
public class Demo7 {
     public int add(int a,int b) {
       System.out.println("整数相加：");
       return a+b;
     }
    public float add(float a,float b) {
         System.out.println("浮点数相加");
         return a+b;
     }
     public static void main (String [] args){
         Demo7 demo7 = new Demo7();
         System.out.println(demo7.add(3,5));
         System.out.println(demo7.add(3.0f,5.0f));

     }

 }
