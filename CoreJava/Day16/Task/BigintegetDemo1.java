/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

import java.math.BigInteger ;
/**

@author yinhansong
@version  1.0
*/
public class BigIntegetDemo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger b1 = new BigInteger("123456789") ;	   // 声明BigInteger对象
		BigInteger b2 = new BigInteger("987654321111122222222") ;	// 声明BigInteger对象
		System.out.println("加法操作：" + b2.add(b1)) ;	     // 加法操作
		System.out.println("减法操作：" + b2.subtract(b1)) ;  // 减法操作
		System.out.println("乘法操作：" + b2.multiply(b1)) ;	  // 乘法操作
		System.out.println("除法操作：" + b2.divide(b1)) ;     // 除法操作
		System.out.println("最大数：" + b2.max(b1)) ;          // 求出最大数
		System.out.println("最小数：" + b2.min(b1)) ;	       // 求出最小数
	}

}
