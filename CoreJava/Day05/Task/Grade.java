/*
   英才科技公司版权所有
*/
/**
package com.yhs168.corejava;
从控制台输入张三同学的成绩，与李四的成绩（80分）比较，输出“张三的成绩比李四的成绩高吗？”的判断结果
 @author yinhansong
 @version  1.0
*/
import java .util.Scanner;
public class Grade {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入学员张三的成绩：");
        int a = sc.nextInt();
        int b = 80;
            if(a >= b)
            System.out.println("张三的成绩比李四高");
            else
            System.out.println("张三的成绩比李四低");


    }
}
