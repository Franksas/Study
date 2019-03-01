/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
买彩票，如果体彩中了500万，我买车、资助希望工程、去欧洲旅游
如果没中，我买下一期体彩，继续烧高香

  @author yinhansong
  @version 1.0
*/
public class Lottery {
    public static void main (String [] args){
        System.out.println("买彩票中奖结果：");
        Scanner sc = new Scanner(System.in);
        String caipiao = sc.next();
            switch (caipiao) {
                case"中奖了":
                    System.out.println("我买车、资助希望工程、去欧洲旅游");
                    break;
                default:
                      System.out.println("我买下一期体彩，继续烧高香");
            }



    }


}
