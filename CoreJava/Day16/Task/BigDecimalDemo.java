/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

import java.math.* ;
/**

@author yinhansong
@version  1.0
*/
public class BigDecimalDemo{
	public double add(double d1,double d2) {   //进行加法计算
		BigDecimal b1 = new BigDecimal(d1) ;
		BigDecimal b2 = new BigDecimal(d2) ;
		return b1.add(b2).doubleValue() ;
	}
	public double sub1(double d1,double d2){		// 进行减法计算
		BigDecimal b1 = new BigDecimal(d1) ;
		BigDecimal b2 = new BigDecimal(d2) ;
		return b1.subtract(b2).doubleValue() ;
	}
	public double sub(String d1,String d2){		// 进行减法计算
		BigDecimal b1 = new BigDecimal(d1) ;
		BigDecimal b2 = new BigDecimal(d2) ;
		return b1.subtract(b2).doubleValue() ;
	}

	public static void main(String [] args){
		System.out.println(1-0.9);
		BigDecimalDemo b = new BigDecimalDemo();
		System.out.println("加法运算：" + b.add(1.0,0.9)) ;
		System.out.println("减法运算：" + b.sub1(1.0,0.9)) ;//不能实现精确计算
	    System.out.println("减法运算：" + b.sub("1","0.9")) ;



	}
}
