/*
英才汇硕信息科技有限公司版权所有
*/


/**
输出100-1000之间的水仙花数（水仙花数是指一个 n 位数（n≥3 ），
它的每个位上的数字的 n 次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。）
  @author yinhansong
  @version 1.0
*/
public class  Demo24{

    public static void main (String [] args){
      for(int i =100;i<1000;i++){
          int a = i / 100;
          int b = i % 100 /10;
          int c = i % 10;
          int d = a*a*a + b*b*b + c*c*c;
        if (i == d){
            System.out.print(i+" ");
        }
      }
      }
  }
