/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
输入小明的考试成绩，显示所获奖励
			 成绩==100分，爸爸给他买辆车
			 成绩>=90分，妈妈给他买MP4
			 90分>成绩>=60分，妈妈给他买本参考书
			 成绩<60分，什么都不买
  @author yinhansong
  @version 1.0
*/
public class Award{
  /**
  根据成绩奖励学生
  @param score 成绩
  @return 是否奖励，奖励什么
  */
    public String award(int score) {
        if (score == 100) {
            return "爸爸给他买辆车";
        }else if (score >= 90 & score < 100) {
            return "妈妈给他买MP4";
        }else if (score >= 60 & score < 90) {
            return "妈妈给他买本参考书";
        }
        return "什么都不买";
    }

    public static void main (String [] args){
        Award b = new Award();
        System.out.println("请输入小明的成绩：");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String result = b.award(score);
        System.out.println(result);
    }
}
