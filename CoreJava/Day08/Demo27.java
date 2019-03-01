/*
英才汇硕信息科技有限公司版权所有
*/


/**
求1！ + 2！+3！+4！+5！
  @author yinhansong
  @version 1.0
*/
public class  Demo27{
    public static int factorial(int i) {  //求阶乘
      int f = 0;
      if (i == 0)
      f = 1;
      if (i >= 1)
      f = i * factorial(i - 1);
      return f;
      }
      public static void main(String[] args) {
      int sum = 0;
      for (int i = 1; i <= 5; i++)
      sum += factorial(i);
      System.out.println("1！+2！+3！+4！+5！=" + sum);

      }
}
