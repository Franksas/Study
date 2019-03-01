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
public class Task2 {
	public static void main (String [] args){
		int a = 4;
		int b = a++;
		int c = --b+a++;
		boolean d = c<10&&a-->5&b++>++c;
	    System.out.println(a);
	    System.out.println(b);
	    System.out.println(c);
	    System.out.println(d);
	}
}
