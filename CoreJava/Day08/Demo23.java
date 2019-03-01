/*
英才汇硕信息科技有限公司版权所有
*/
package com.ychs168.corejava;
import java.util.Scanner;

/**
给定年份，输出当年是平年还是闰年
  @author yinhansong
  @version 1.0
*/
public class  Demo23{
  /**
  根据年份判断是闰年还是平年
  @param year   year是年份
  @return 平年或闰年
  */
    public String award(int year) {
        if (year%400 ==0 || year%100!=0 || year%4==0)  {
            return "是闰年";
        }
        return "是平年";
    }
    public static void main (String [] args){
      Demo23 b = new Demo23();
      System.out.println("请输入年份：");
      Scanner sc = new Scanner(System.in);
      int year= sc.nextInt();
      String result = b.award(year);
      System.out.println(result);

      }
  }
