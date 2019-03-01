/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs.demo;

import java.util.Scanner;
/**
 *
 * @author yinhansong
 * @version  1.0
 */
import java.util.Scanner;
public class Task4 {
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("矩形的宽是:");
        double a = sc.nextDouble();
		System.out.println("矩形的高是:");
        double b = sc.nextDouble();
	    System.out.println("面积：" +(a * b));
	    System.out.println("周长：" + 2*(a + b));
	}
}
