/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.util.Scanner;
/**
 *创建一个方法,完成两个整数之和的功能， 在主方法中调用此方法
 * @author yinhansong
 *
 */
public class Demo5 {
	int sum =0;
	private  static Scanner sc;
	public void Max(){
		System.out.println("请输入两个整数：");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sum = a+b;
        System.out.println("最大值："+ sum);
	}
	public static void main(String[] args) {
		Demo5 d = new Demo5();
        d.Max();
	}

}
