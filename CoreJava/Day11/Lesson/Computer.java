/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
   super和this调用构造方法时，不能同时出现，因为
 	他们都要占据第一行
    @author yinhansong
    @version  1.0
*/


public class Computer {
	String type = "x269";
	public Computer(String type) {
		this.type = type;
	}
}
class NotePad extends Computer {
    float weight;
    public NotePad() {super("bq");
}
    public NotePad(float weight) {
    	super("Lenovo");
        // this();
    	this.weight = weight;
 	 }
   public static void main(String [] args) {
    	new NotePad();
     }
 }
