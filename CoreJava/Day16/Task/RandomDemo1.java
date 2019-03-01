/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.util.Random ;
/**

@author yinhansong
@version  1.0
*/

public class RandomDemo1{
	public static void main(String args[]){
		Random r = new Random() ;		// 实例化Random对象
		String x = System.currentTimeMillis()+""+r.nextInt(10000000);
		System.out.println(x);
	long x1 =	System.currentTimeMillis();
		for(int i=0;i<10;i++){
		//	System.out.print(r.nextInt(1000) + "\t") ;
		}
	long x2 = System.currentTimeMillis();
	System.out.println(x2 - x1);
	}
}
