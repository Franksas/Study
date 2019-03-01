/*
英才汇硕信息科技有限公司版权所有
*/
package com.ychs168.corejava;
import java.util.Scanner;

/**
打印三角形
  @author yinhansong
  @version 1.0
*/
public class  Demo29{
    public static void main (String [] args){
        for(int i = 1;i < 6;i++){
            for(int j = 0;j<10-2*i;j++){
              System.out.print(" ");
            }
            for (int k = 0;k<2*i-1;k++){
              System.out.print("*"+ " ");
            }
            System.out.println();
          }


  }
}
