/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
按照标准，结算折后购物金额
普通顾客购物满100元 9折
会员购物           8折
会员购物满200元    7.5折
  @author yinhansong
  @version 1.0
*/
public class Shopping{
  /**
  根据成顾客等级和购物金额享受折扣
  @param id  顾客等级 sum 消费金额
  @return 打几折
  */
    public String award(String id,double sum) {
        if (sum >= 100 & id.equals("普通会员")) {
            return "9折";
        }else if (id.equals("会员")) {
            return "8折";
        }else if (sum >= 200 & id.equals("会员")) {
            return "7.5折";
        }
        return "不打折";
    }

    public static void main (String [] args){
      Shopping a = new Shopping();
      Scanner sc = new Scanner(System.in);
      System.out.println("请输入消费金额：");
      Double sum = sc.nextDouble();
      System.out.println("请输入顾客等级：");
        String id = sc.next();
      String result = a.award(id,sum);
      System.out.println(result);
    }
}
