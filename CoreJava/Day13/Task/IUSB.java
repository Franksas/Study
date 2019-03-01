/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;

/**
	笔记本电脑的业务
业务介绍
定义USB接口（具备开启功能、关闭功能），笔记本要使用USB设备，
即笔记本在生产时需要预留可以插入USB设备的USB接口，即就是笔记本具备
使用USB设备的功能，但具体是什么USB设备，笔记本并不关心，只要符合USB规格
的设备都可以。鼠标和键盘要想能在电脑上使用，那么鼠标和键盘也必须遵守USB规
范，不然鼠标和键盘的生产出来无法使用
进行描述笔记本类，实现笔记本使用USB鼠标、USB键盘
USB接口，包含开启功能、关闭功能
笔记本类，包含运行功能、关机功能、使用USB设备功能
鼠标类，要符合USB接口
键盘类，要符合USB接口
    @author yinhansong
    @version  1.0
*/

public interface IUSB {
	public void start();
	public void stop();
}
