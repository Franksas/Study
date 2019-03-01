/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
从控制台输入一个正整数，要求输出每位数字，且求数字的和
  @author yinhansong
  @version 1.0
*/
public class  Demo15{
    public static void main (String [] args){
      Demo15 b = new Demo15();
      System.out.println("请输入一个正整数：");
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      int sum = 0;
      while(num!=0){
          int temp = num%10;
          num = num/10;
          sum +=temp;

      }

        System.out.println("sum等于"+sum);




    }

}
