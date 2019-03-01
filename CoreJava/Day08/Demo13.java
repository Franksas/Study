/*
英才汇硕信息科技有限公司版权所有
*/

/**
解决斐波那数列前40项问题
  @author yinhansong
  @version 1.0
*/
public class Demo13 {

    public static void main (String [] args){
        int f0 = 0;
        int f1 = 1;
        System.out.print(f0+ "," +f1);
        for(int i=0;i<38/2;i++){
          f0 = f0 + f1;
          f1 = f0 + f1;
          System.out.print("," + f0 +"," + f1);
        }

    }
}
