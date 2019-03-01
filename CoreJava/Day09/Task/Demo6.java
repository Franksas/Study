/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.util.Scanner;
/**
 *创建一个方法判断一个数是素数吗？
 * @author yinhansong
 *
 */
public class Demo6 {
	private  static Scanner sc;
	/*
	 * 定义一个方法
	 * 输入一个整数判断是否为素数
	 */
	public void Prime(){
		System.out.println("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i = 2;i < a;i++){
        	if(a % i == 0){

        		System.out.println("不是素数");
        		return;
        	}

        }
        System.out.println("是素数");
	}
	public static void main(String[] args) {
		Demo6 d = new Demo6();
        d.Prime();
	}

}
