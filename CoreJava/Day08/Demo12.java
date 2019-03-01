/*
英才汇硕信息科技有限公司版权所有
*/

/**
求出1-1000之间同时能被3、5、7整除的数
  @author yinhansong
  @version 1.0
*/
public class Demo12 {

    public static void main (String [] args){
        for(int i = 1;i<=1000;i++){
          if(i%3==0 & i%5==0 & i%7==0){
            System.out.print(i + " ");
          }
        }
    }
}
