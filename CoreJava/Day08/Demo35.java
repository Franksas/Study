/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
   编写程序，提示用户输入学生的个数，每个学生的名字及其分数，最后显示获得最高分的学生和第二高的学生
    @author yinhansong
    @version 1.0
*/
public class Demo35{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生个数");
        int y = sc.nextInt();
        int i = 1;
        int j = 0;
        int k = 0;
        String a = "aa";
        String b = "aa";
        while(i <= y){
            System.out.println("请输入学生姓名：");
            String name = sc.next();
            System.out.println("请输入学生分数");
            int grade = sc.nextInt();
            if(j<grade){
                k = j;
                a = b;
                j = grade;
                b = name;

            }
            i++;
        }
        System.out.println("最高成绩为：" + j + ". 姓名为：" + b);
        System.out.println("第二高成绩为：" + k + ". 姓名为：" + a);
    }
}
