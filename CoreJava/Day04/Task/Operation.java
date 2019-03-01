/*
   英才汇硕科技公司版权所有 2018
*/
/**
package com.ychs168.corejava;
基本运算操作类
 @author yinhansong
 @version  1.0
*/
import java.util.Scanner;
public class Operation {

    public static void main (String [] args) {
        double o1 = 0;
        double o2 = 0;
        String symbol;
        double result;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一个操作数：");
        o1 = sc.nextDouble();
        System.out.println("输入操作符：");
        symbol = sc.next();
        System.out.println("输入第二个操作数：");
        o2 = sc.nextDouble();
        Operation op = new Operation();
        switch (symbol) {
            case "+":
                result = op.add(o1, o2);
                break;
            case "-":
                result = op.minus(o1, o2);
                break;
            case "*":
                result = op.multiply(o1, o2);
                break;
            case "/":
                result = op.divide(o1, o2);
                break;
            default:
                result = 0;
                break;
        }
        System.out.println("运算结果为：" + result);
    }
    public double add(double o1, double o2) {
        return o1 + o2;
    }
    public double minus(double o1, double o2) {
        return o1 - o2;
    }
    public double multiply(double o1, double o2) {
        return o1 * o2;
    }
    public double divide(double o1, double o2) {
        return o1 / o2;
    }
}
