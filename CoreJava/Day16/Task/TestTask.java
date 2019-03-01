/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.util.Timer ;
/**

@author yinhansong
@version  1.0
*/

public class TestTask {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t = new Timer();//建立Timer类的对象
		MyTask m = new MyTask() ;	//定义任务
		t.schedule(m,0,1000);//设置任务的执行，1秒后开始，每2秒重复


	}

}
