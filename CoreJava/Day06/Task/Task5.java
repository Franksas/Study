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

public class Task5 {

	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		System.out.println("------------------------商城库存清单-----------" );
		System.out.println("品种型号     \t尺寸\t价格\t库存数");
		System.out.println("MacBookAir   \t13.3\t6988.88\t"+a);
		System.out.println("Thinkpadt450 \t14.0\t5999.99\t"+b);
		System.out.println("ASUS-FL580   \t15.6\t4988.5\t"+c);
		System.out.println("----------------------------------------------");
	    System.out.println("总库存数：" +(a + b + c));
	    System.out.println("库存商品总金额：" + (6988.88*a + 5999.99*b + 4999.5*c));
	}
}
