/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
学校举行运动会，百米赛跑跑入10秒内的学生有资格进决赛，
根据性别分别进入男子组和女子组

  @author yinhansong
  @version 1.0
*/
public class Run {
  /**
  根据成绩进决赛
  @param speed 速度，跑步成绩
  @return 是否进决赛
  */
    public String award(int speed) {
        if (speed < 10) {
            return "进决赛";
        }
        return "淘汰";
    }
    public static void main (String [] args) {
        Run b = new Run();
        System.out.println("成绩：");
        Scanner sc = new Scanner(System.in);
        int speed = sc.nextInt();
        String result = b.award(speed);
        System.out.println(result);
        System.out.println("性别：");
        Scanner s = new Scanner(System.in);
        String sex = s.next();
        switch(sex) {
            case "男":
                System.out.println("男子组");
                break;
            case "女":
                System.out.println("女子组");
                break;
        }
    }

}
