/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;

/**
   冒泡排序
    @author yinhansong
    @version 1.0
*/
 	import java.util.Arrays;

 	public class SortDemo {
 	    public static void main(String [] args) {
 	        int [] a = {80,60,10,5};
 	        Arrays.sort(a);//数组排序方法
 	        for (int x : a) {
 	            System.out.print(x + ",  ");
 	        }
 	    }
 	}
