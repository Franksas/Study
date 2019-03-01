/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
会员购物时，根据积分的不同享受不同的折扣，计算会员购物时获得的折扣
  会员积分           折扣
  x<2000            9折
2000=< x <4000      8折
4000=< x <8000      7折
  x>8000            6折
  @author yinhansong
  @version 1.0
*/
public class Discount{
  /**
  根据积分享受折扣
  @param integral 积分
  @return 打折多少
  */
    public String award(int integral) {
        if (integral < 2000) {
            return "9折";
        }else if(integral >= 2000 &integral < 4000) {
            return "8折";
        }else if (integral >= 4000 & integral < 8000) {
            return "7折";
        }
        return "6折";
    }

    public static void main (String [] args){
        Discount b = new Discount();
        System.out.println("会员积分：");
        Scanner sc = new Scanner(System.in);
        int integral = sc.nextInt();
        String result = b.award(integral);
        System.out.println(result);
    }
}
