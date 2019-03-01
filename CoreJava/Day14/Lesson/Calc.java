/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
        异常示例
    @author yinhansong
    @version  1.0
*/

public class Calc {
   /**
    * 除法计算
    * @param 第一个操作数
    * @param 第二个操作数
    * @return 除法计算的结果
    */
	public double div(int a,int b) {
		double c = 0;
		try {
			c = a / b;
			System.out.println("fff");
		} catch (Exception e) {
			System.out.println("除数不能为0！");
		}
		return c;
	}
	public static void main(String [] args) {
		Calc c = new Calc();
		c.div(3,2);
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个数字：");
		int first = sc.nextInt();
	 	System.out.println("请输入第二个数字：");
	 	int second = sc.nextInt();
	 	System.out.println(c.div(first,second));
	}
}
