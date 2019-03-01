/*
   英才科技公司版权所有
*/
/**
需求说明：结算时打印购物小票计算此次购物获得的会员积分
 @author yinhansong
 @version  1.0
*/
import java .util.Scanner;
public class Integral {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int a = 245;
        int b = 570;
        int c = 320;
        double d = 2 * a + b + c;
        int f =(int) (d * 0.8 / 100 * 3);
        System.out.println("实际交费:");
        int e = sc.nextInt();
        System.out.println("火火火火火火火火火*消费单*火火火火火火火火火火火火");
        System.out.println("购买物品       单价       个数           金额  ");
        System.out.println("T恤           ￥245        2             ￥" + (a * 2));
        System.out.println("网球鞋         ￥570        1             ￥" + b);
        System.out.println("网球拍         ￥320        1            ￥" + c);
        System.out.println(" 折扣：      8折 ");
        System.out.println("消费总金额： ￥" + (d * 0.8));
        System.out.println("实际交费：   ￥" + e);
        System.out.println(" 找钱：       ￥" + (e - d * 0.8));
        System.out.println("本次购物所获的积分是:" + f);
      }
}
