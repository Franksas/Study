/*
   英才科技公司版权所有
*/
/**
商城推出幸运抽奖活动
抽奖规则：顾客的四位会员 卡号的各位数字之和大于20，则为幸运顾客。
 @author yinhansong
 @version  1.0
*/
import java .util.Scanner;
public class Activity {
    public static void main(String [] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("请输入4位会员卡号：");
        int a = Sc.nextInt();
        int b = (a / 1000) + (a % 1000 /100) + (a % 100 / 10) + (a % 10);
        System.out.println("会员卡号" + a + "各位之和：" + b );
        System.out .print("是幸运客户吗？");
        boolean f = b > 20;
        System.out.println(f);
      }
}
