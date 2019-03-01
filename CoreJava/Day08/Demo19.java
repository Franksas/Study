/*
英才汇硕信息科技有限公司版权所有
*/
package com.ychs168.corejava;
import java.util.Scanner;

/**
打印倒三角图形
  @author yinhansong
  @version 1.0
*/
public class  Demo19{
    public static void main (String [] args){
        for(int i = 5;i > 0;i--){
            for(int j = 0;j < i;j++){
              System.out.print("*");
            }
            System.out.println();
          }


  }
}
