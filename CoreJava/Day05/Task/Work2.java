/*
   英才科技公司版权所有
*/
/**
从控制台输入学员王浩3门课程成绩，编写程序实现
1.Java课和SQL课分数之差
2.3门课的平均分
 @author yinhansong
 @version  1.0
*/
import java .util.Scanner;
public class Work2{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("STB的成绩是:");
        double a = sc.nextInt();
        System.out.println("Java的成绩:");
        double b = sc.nextInt();
        System.out.println("SQL的成绩：");
        double c = sc.nextInt();
        System.out.println("Java和SQL的成绩差：" +(b - c));
        System.out.println("33门课的平均分:" + ((a + b + c) / 3));

      }
}
