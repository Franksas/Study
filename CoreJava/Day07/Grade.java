/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
控制台接收张浩的 Java 成绩，音乐成绩。当张浩Java成绩大于98分，
而且音乐成绩大于80分，老师奖励他；或者Java成绩等于100分，音乐
成绩大于70分，老师也可以奖励他

  @author yinhansong
  @version 1.0
*/
public class Grade {
  /**
  根据成绩奖励学生
  @param score java成绩  chengji 音乐成绩
  @return 是否奖励，奖励的结果
  */
public String award(int score,int chengji) {
    if (score > 98 & chengji > 80) {
        return "老师奖励他";

    }else if (score == 100 & chengji > 70) {
      return "老师奖励他";
    }
      return "没有奖励";
}
    public static void main (String [] args){
      Grade a = new Grade();
      System.out.println("请输入张浩的Java成绩：");
      System.out.println("请输入张浩的音乐成绩：");
      Scanner sc = new Scanner(System.in);
      int score = sc.nextInt();
      int chengji = sc.nextInt();
      String result = a.award(score,chengji);
      System.out.println(result);
  
      /*  Scanner sc = new Scanner(System.in);
        System.out.println("张浩的java成绩是:");
            int a = sc.nextInt();
        System.out.println("张浩的音乐成绩是:");
            int b = sc.nextInt();
            if(a > 98 & b > 80)  {
                System.out.println("获得奖励");
            }
            if(a == 100 & b > 70)  {
                System.out.println("获得奖励");
            }*/
      }
}
