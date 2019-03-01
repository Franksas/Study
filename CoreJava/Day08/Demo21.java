/*
英才汇硕信息科技有限公司版权所有
*/
package com.ychs168.corejava;
import java.util.Scanner;

/**
末次程序大赛，s1班有4名同学参加，学员的成绩由用户输入计算该班参赛学员的平均分
  @author yinhansong
  @version 1.0
*/
public class  Demo21{
    public static void main (String [] args){
      int [] score= new int[5];
      Scanner sc = new Scanner(System.in);
      for(int i=1;i<5;i++){
          System.out.print("第"+ i+"位学员的成绩：");
          int a = sc.nextInt();
          score[i] = a;

      }
      double average= (score[1]+score[2]+score[3]+score[4])/4;
      System.out.println("参赛学员的平均分是："+average);

      }
  }
