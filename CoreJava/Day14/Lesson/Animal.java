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
public Animal {
    public void a() {}
}
class Dog extends Animal {
    public void b() {}
}
class NoHairDog extends Dog {
    public void c() {}
}
class Test {
    public static void main(String [] args) {
        NoHairDog nhd1 = new NoHairDog();
        Dog nhd2 = new NoHairDog();
        Animal an = new NoHairDog();
        Animal x = new Dog();
    }
}
