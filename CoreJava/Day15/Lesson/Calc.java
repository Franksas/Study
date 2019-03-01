/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.util.Scanner;
/**
 *异常处理的示例
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
			//打开水龙头
			c = a / b;// 抛出异常，JVM自动创建一个异常对象
			//关闭水龙头
			System.out.println("fff");
		} catch (Exception e) {//捕获异常
			//开发环境，生产环境(部署环境），上线
			e.printStackTrace();
			System.out.println("除数不能为0！");
			//切记 此处千万不要为空
		} finally { 
			//释放资源的代码写在这里
			//final finally finalize()区别
			System.out.println("一定要执行的!");
		}
		return c;
	}
	public static void main(String [] args) {
		Calc c = new Calc();
		double result = c.div(3,0);
		System.out.println(result);
	
	}
}