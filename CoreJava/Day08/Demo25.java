/*
英才汇硕信息科技有限公司版权所有
*/

/**
输出所有四叶玫瑰数
  @author yinhansong
  @version 1.0
*/
public class  Demo25{

    public static void main (String [] args){
      for(int i =1000;i<10000;i++){
          int a = i / 1000;
          int b = i % 1000 /100;
          int c = i % 100/10;
          int d = i%10;
          int f = a*a*a*a + b*b*b*b + c*c*c*c+d*d*d*d;
        if (i == f){
            System.out.print(i+" ");
        }
      }
      }
  }
