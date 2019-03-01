package com.ychs168.corejava;/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
import java.util.TimerTask ;
import java.util.Date ;
import java.text.SimpleDateFormat ;
/**
 //完成具体任务操作
@author yinhansong
@version  1.0
*/

class MyTask extends TimerTask{//任务调度类都要继承TimerTask

	public void run(){
		SimpleDateFormat s = null ;
		s = new SimpleDateFormat("yyyyyy-MM-dd HH:mm:ss.SSSss") ;
		System.out.println("当前系统时间为：" + s.format(new Date())) ;

	}

}
