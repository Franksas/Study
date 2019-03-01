/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
请输入消费金额：
500
1.满50元，加2元换购百事可乐一瓶
2.满100元，加3元换购500ml可乐一瓶
3.满100元，加10元换购5公斤面粉
4.满200元，加10元换购一个苏泊尔炒菜锅
5.满200元，加20元换购欧莱雅爽肤水一瓶
0.不换购
请选择：
4
本次消费总金额：510
成功换购：一个苏泊尔炒菜锅

  @author yinhansong
  @version 1.0
*/
public class Consumption {
  /**
  根据消费金额换购
  @param 消费金额
  @return 换购不同的物品
  */
    public int award(int money) {
        if (money >= 50) {
            return 1;
        }else if (money >= 100) {
            return 2 & 3;
        }else if (money >= 200) {
            return 4 & 5;
        }
        return 0;
    }

    public static void main (String [] args){

        System.out.println("请输入消费金额：");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("1.满50元，加2元换购百事可乐一瓶");
        System.out.println("2.满100元，加3元换购500ml可乐一瓶");
        System.out.println("3.满100元，加10元换购5公斤面粉");
        System.out.println("4.满200元，加10元换购一个苏泊尔炒菜锅");
        System.out.println("5.满200元，加20元换购欧莱雅爽肤水一瓶");
        System.out.println("0.不换购");
        System.out.print("请选择：");
        Scanner s = new Scanner(System.in);
        int b = s.nextInt();
        switch (b) {
            case 1:
                System.out.println("本次消费总金额：" + (a+2) );
                break;
            case 2:
                System.out.println("本次消费总金额：" + (a+3));
                break;
            case 3:
                System.out.println("本次消费总金额：" + (a+10));
                break;
            case 4:
                System.out.println("本次消费总金额：" + (a+10));
                break;
            case 5:
                System.out.println("本次消费总金额：" + (a+20));
                break;
            case 0:
                System.out.println("本次消费总金额：" + a);
                break;
        }
        System.out.print("成功换购：");
        switch (b) {
            case 1:
                System.out.println("百事可乐一瓶");
                break;
            case 2:
                System.out.println("500ml可乐一瓶");
                break;
            case 3:
                System.out.println("5公斤面粉");
                break;
            case 4:
                System.out.println("一个苏泊尔炒菜锅");
                break;
            case 5:
                System.out.println("欧莱雅爽肤水一瓶");
                break;
            case 0:
                System.out.println("不换购");
                break;
        }


    }
}
