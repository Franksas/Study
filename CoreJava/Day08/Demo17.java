/*
英才汇硕信息科技有限公司版权所有
*/
package com.ychs168.corejava;
import java.util.Scanner;

/**
从控制台输入5个同学的java成绩，要求统计及格的人数
  @author yinhansong
  @version 1.0
*/
public class  Demo17{
    public static void main (String [] args){
      int count=0;
      Scanner sc = new Scanner(System.in);
      for(int i=1;i<=5;i++){
          System.out.println("请输入5个同学的java成绩：");
          double s = sc.nextDouble();
          if(s>=60){
            count+=1;
            continue;
          }

      }

            System.out.println(count);
        }
  }
