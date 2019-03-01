/*
英才汇硕信息科技有限公司版权所有
*/
package com.ychs168.corejava;
import java.util.Scanner;

/**
猜数游戏：生成一个[0，100）之间的随机整数，提示用户输入猜测的数字，
如果不相等提示用户大了还是小了，输出用户共猜测了多少次。
 (int)(Math.random()*100)
  @author yinhansong
  @version 1.0
*/
public class  Demo18{
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int a = (int)(Math.random()*100);
        for(int count = 0;;count++) {
          System.out.println("请输入随机整数：");
          double s= sc.nextDouble();
          if (s > a){
              System.out.println("大了");
          }
          if (s < a){
              System.out.println("小了");
          }
          if (s==a){
              System.out.println("经过" + count +"次输入您猜中了");
              break;
          }
        }

    }
}
