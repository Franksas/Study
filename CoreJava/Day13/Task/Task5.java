/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
import java.util.Scanner;
/**
	 假如我们开发一个系统时需要对员工进行建模，员工包含3个属性：员工编号，姓名，工资。
	 经理也是员工，除了含有员工的属性外，另外还有一个奖金属性，请使用继承的思想设计出员工类和经理类。
	 要求类中提供必要的方法进行属性访问。
    @author yinhansong
    @version  1.0
*/

abstract class Staff{
    private String name;
    private int number;
    private double wage;
    public void setname(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }
    public void setnumber(int number) {
        this.number = number;
    }
    public int getnumber() {
        return number;
    }
    public void setwage(double wage) {
        this.wage= wage;
    }
    public double getwage() {
        return wage;
    }

}

 class Manager extends Staff{
	 private int reward;
	 public void setreward(int reward) {
	        this.reward= reward;
	    }
	    public int getreward() {
	        return reward;
	    }
     public void Test(){
         System.out.println( "编号是：" + getnumber() + "的" + getname() + "员工 、工资是：" + (getwage() + getreward()));
     }

}

public class Task5{
    public static void main(String [] args){
       Manager sc= new Manager();
       sc.setnumber(123);
       sc.setname("张三");
       sc.setwage(12345);
       sc.setreward(123);
       sc.Test();

    }
}
