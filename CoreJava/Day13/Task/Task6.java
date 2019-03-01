/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;

/**
	 创建一个抽象类Animal，有吃喝玩耍的抽象方法，再创建一个Dog类和一个Cat类，
	 继承Animal，分别实现Animal的抽象方法。
    @author yinhansong
    @version  1.0
*/
 abstract class Animal {
	public abstract void eat();
	public abstract void drink();
	public abstract void play();
	}
 class Cat extends Animal {
	public  void eat(){
		 System.out.println("猫吃鱼");
	}
	public  void drink(){
		 System.out.println("猫喝水");
	}
	public  void play(){
		 System.out.println("猫玩球");
    }
 }
 class Dog extends Animal{
    public  void eat(){
		 System.out.println("狗吃肉");
	}
	public  void drink(){
	System.out.println("狗喝水");
	}
	public  void play(){
		System.out.println("狗玩骨头");
	}
}

public class Task6{
    public static void main(String[] args){
		Cat c = new Cat();
		c.eat();
		c.drink();
		c.play();
		Dog d = new Dog();
		d.eat();
		d.drink();
		d.play();
	}
}
