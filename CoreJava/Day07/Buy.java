/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
我想买车，买什么车决定于我在银行有多少存款
		如果我的存款超过500万，我就买凯迪拉克
   否则，如果我的存款超过100万，我就买帕萨特
   否则， 如果我的存款超过50万，我就买依兰特
   否则， 如果我的存款超过10万，我就买奥托
   否则， 如果我的存款10万以下 ，我买捷安特

  @author yinhansong
  @version 1.0
*/
public class Buy {
  /**
  根据存款买车
  @param deposit  存款
  @return 买不同的车
  */
    public String award(int deposit) {
        if (deposit > 5000000) {
            return "我就买凯迪拉克";
        }else if (deposit >= 1000000 & deposit < 5000000) {
            return "我就买帕萨特";
        }else if (deposit >= 500000 & deposit < 1000000) {
            return "我就买依兰特";
        }else if (deposit >= 100000 & deposit < 500000) {
            return "我就买奥托";
        }
        return "我买捷安特";
    }
    public static void main (String [] args) {
        Buy b = new Buy();
        System.out.println("银行存款：");
        Scanner sc = new Scanner(System.in);
        int deposits = sc.nextInt();
        String result = b.award(deposit);
        System.out.println(result);
    }

}
