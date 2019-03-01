/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
   多态的演示程序
    @author yinhansong
    @version  1.0
*/

public interface Apple {
	 void a();
}
class AX implements Apple {
	public void a() {System.out.println("111");}
}
class FuShi implements Apple {
	public void a() {System.out.println("ychs");}
	void b() {}
	public static void main(String[] args) {
		Apple ap = new AX();//new FuShi();
		ap.a();
		//ap.b
	}
}
