/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
/**
 * 单子设计模式（单例设计模式）
*一个类只能创建一个对象
*1.构造方法私有2.提供私有、静态属性且是当前类 类型
*3.提供公共的、静态方法，返回当前类对象
@author yinhansong
@version  1.0
*/
public class Apple {
    double num;
    private static Apple app = null;
    private Apple{
      num = Math.random();
    }
    public static Apple getApple() {
      if(app == null) {
        app = new Apple();
      }
      return app;
    }
    public double getNum() {return num;}
}
class Test {
  public static void main(String [] args) {
    Apple a1 = apple.getApple();
    System.out.println(a1.getNum());
    Apple a2 = apple.getApple();
    System.out.println(a2.getNum());
  }
}
