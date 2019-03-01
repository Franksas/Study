/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
抽奖活动，控制台接收4位数会员号，会员号的百位数字、
等于产生的随机数字即为幸运会员

  @author yinhansong
  @version 1.0
*/
public class Luck {
  /**
  根据会员号产生幸运会员
  @param a b a是会员号，b是随机数字
  @return 是否是幸运会员
  */
    public String award(int a,int b) {
        if ((a%1000 /100) == b) {
            return "幸运会员";
        }
        return "无";
    }
    public static void main (String [] args){
        Luck c = new Luck();
        System.out.println("4位会员号：");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("随机数字：");
        Scanner s = new Scanner(System.in);
        int b = s.nextInt();
        String result = c.award(a,b);
        System.out.println(result);


    }


}
