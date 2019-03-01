/*
   英才科技公司版权所有
*/
/**
用户输入秒数，输出X小时X分X秒
 @author yinhansong
 @version  1.0
*/
import java .util.Scanner;
public class Time {
    public static void main(String [] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("输入秒数：");
        int a = Sc.nextInt();
        System.out.println((a / 3600) + "小时" + (a % 3600 / 60) + "分" + (a % 3600 % 60) + "秒");
      }
}
