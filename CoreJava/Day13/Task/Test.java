/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;

/**
	创建一个交通工具接口Ivehicle，定义能使用能停止的方法，
	再创建一个Plane类和一个Train类去实现接口，并写测试类进行测试
    @author yinhansong
    @version  1.0
*/
public class Test {
	public static void main(String[] args) {
		Plane p = new Plane();
		p.use();
		p.stop();
		Train t = new Train();
		t.use();
		t.stop();
	}

}
