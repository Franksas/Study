/*
   英才科技公司版权所有
*/
/**
用户从键盘接收商店折扣，并判断商品享受此折扣后价格是否低于100
 @author yinhansong
 @version  1.0
*/

import java.util.Scanner;
public class Discount {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入折扣：");
        double a = sc.nextDouble();
        double b = 245;
        System.out .print("T桖折扣价低于100吗？");
        boolean f = (b * a) < 100;
        System.out.println(f);
        double c = 570;
        System.out .print("网球鞋折扣价低于100吗？");
        boolean g = (c * a) < 100;
        System.out.println(g);
        double d = 320;
        System.out .print("网球拍折扣价低于100吗？");
        boolean h = (d * a) < 100;
        System.out.println(h);
        }
}
