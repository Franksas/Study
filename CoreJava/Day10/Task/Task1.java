/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;

/**
    给定一个数组，输出重复出现的数字和次数
   [2,3,2,4,5,3] 2
    @author yinhansong
    @version 1.0
*/

public class Task1 {

	 public static void main(String [] args) {
     int i = 2;
 		 int d = 0;
 	     int [] a = {2,3,2,4,2,5,3};
 	     for (int x : a) {
 	    	 if (x == i) {
 	    		 d +=1;
 	    	 }
    	      }
 	     System.out.print("出现次数：" + d );
 	    }
 }
