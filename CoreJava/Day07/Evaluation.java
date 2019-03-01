/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
对学员的结业考试成绩评测，
成绩>=80 ：良好， 成绩>=60 ：中等，
成绩<60   ：差

  @author yinhansong
  @version 1.0
*/
public class Evaluation {
  /**
  根据成绩评测学生
  @param score 成绩
  @return 评测
  */
    public String award(int score) {
        if (score >= 80) {
            return "良好";
        }else if (score >= 60 & score < 80) {
            return "中等";
        }
        return "差";
    }
    public static void main (String [] args){
        Evaluation b = new  Evaluation();
        System.out.println("请输入学员的结业考试成绩：");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String result = b.award(score);
        System.out.println(result);
    }
}
