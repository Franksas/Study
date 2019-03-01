/*
英才汇硕信息科技有限公司版权所有
*/

/**
请使用for循环完成控制台输出1——100，并求出数据之和
  @author yinhansong
  @version 1.0
*/
public class Demo9 {

    public static void main (String [] args){
        int sum = 0;
        for(int i = 1;i<=100;i++){
          System.out.print(i + " ");
          sum+=i;
        }
        System.out.println( );
        System.out.println("sum="+sum);
    }
}
