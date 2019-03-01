/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
控制台接收张浩的 Java 成绩，如果张浩的Java考试成绩大于98分，
张浩就能获得一个MP4作为奖励
  @author yinhansong
  @version 1.0
*/
public class IfDemo {
  /**
  根据成绩奖励学生
  @param score java成绩
  @return 是否奖励，奖励的结果
  */
    public String award(int score) {
        if (score > 98) {
            return "奖励张浩MP4一个";
        }
        return "没有奖励";
    }
    public static void main (String [] args){
        IfDemo b = new IfDemo();
        System.out.println("请输入张浩的Java成绩：");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String result = b.award(score);
        System.out.println(result);
        /*Scanner sc = new Scanner(System.in);
        System.out.println("张浩的成绩是:");
        int a = sc.nextInt();

        if (a > 98)  {
            System.out.println("获得MP4奖励");
        } else {
            System.out.println("没有奖励");
        }*/


    }


}
