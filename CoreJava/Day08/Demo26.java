/*
英才汇硕信息科技有限公司版权所有
*/

/**
输入一个四位数，求出所有分段和平方数
  @author yinhansong
  @version 1.0
*/
public class  Demo26{

    public static void main (String [] args){
      for(int i =1000;i<10000;i++){
      int a = i /100;
      int d = i % 100;
        int c = a*a+d*d;
        if (i == c){
            System.out.print(i+" ");
        }
      }
      }
  }
