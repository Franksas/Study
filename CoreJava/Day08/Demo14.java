/*
英才汇硕信息科技有限公司版权所有
*/
package com.ychs168.corejava;
import java.util.Scanner;
/**
循环输入某同学结业考试的5门课的成绩，并计算平均值
  @author yinhansong
  @version 1.0
*/
public class Demo14 {

    public static void main (String [] args){
      int [] score= new int[6];
      Scanner sc = new Scanner(System.in);
      for(int i=1;i<6;i++){
          System.out.print("5门课的成绩：");
          int a = sc.nextInt();
          score[i] = a;
      }
      double average= (score[1]+score[2]+score[3]+score[4]+score[5])/5;
      System.out.println("平均分是："+average);

        }
  }
