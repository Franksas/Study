/*
英才汇硕信息科技有限公司版权所有
*/

/**
请使用for循环完成控制台输出20-1的偶数（降序形式），并求出偶数和
  @author yinhansong
  @version 1.0
*/
public class Demo10 {

    public static void main (String [] args){
        int sum = 0;
        for(int i = 20;i>=1;i--){
          if(i%2==0){
            System.out.print(i + " ");
            sum+=i;
          }
        }
        System.out.println( );
        System.out.println("sum="+sum);
    }
}
