/*
英才汇硕信息科技有限公司版权所有
*/

/**
使用do...while语句实现100到200间奇数的和
  @author yinhansong
  @version 1.0
*/
public class Demo8 {

    public static void main (String [] args){
        int i = 100;
        int sum = 0;
        do{

          if(i%2!=0){
            sum+=i;
          }
          i++;
        }while(i<=200);
        System.out.println("sum="+sum);
    }
}
