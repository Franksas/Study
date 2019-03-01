/*
英才汇硕信息科技有限公司版权所有
*/
package com.ychs168.corejava;
import java.util.Scanner;

/**
打印9*9乘法表
  @author yinhansong
  @version 1.0
*/
public class  Demo20{
    public static void main (String [] args){
        for(int i = 1;i < 10;i++){
            for(int j = 1;j <= i;j++){
              System.out.print(i + "*" + j + "=" +i * j + " ");
            }
            System.out.println();
          }


  }
}
