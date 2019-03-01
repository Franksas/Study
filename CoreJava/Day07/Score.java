/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
控制台接收 Java 成绩，如果张浩Java考试成绩大于98分，
老师就奖励他一个MP4，否则老师就罚他进行编码
  @author yinhansong
  @version 1.0
*/
public class Score {
  /**
  根据成绩奖励学生
  @param score java成绩
  @return 奖励的结果，惩罚
  */
    public String award(int score) {
        if (score > 98) {
            return "奖励张浩MP4一个";
        }
        return "罚他进行编码";
    }
    public static void main (String [] args){
        Score b = new Score();
        System.out.println("请输入张浩的Java成绩：");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String result = b.award(score);
        System.out.println(result);
    }
}
