/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Arrays;
/**
    给定一个数组，输出重复出现的数字和次数
   [2,3,2,4,5,3]
    @author yinhansong
    @version  1.0
*/

public class Task4 {

	 public static void main(String [] args) {
		 int [] a = {2,3,2,4,2,5,3};
		 Arrays.sort(a);// 给数组排序
		 int count = 0;
		 int temp = a[0];
		 for(int i = 0;i < a.length;i++){
		 if(temp != a[i]){
			 System.out.println(temp + "出现：" + count + "次");
			 temp = a[i];
			 count = 1;
		 } else {
			 count++;
		 }
		 if(i == a.length - 1){
		 System.out.println(temp + "出现：" + count + "次");
		 }
		 }
	 }
	 }
