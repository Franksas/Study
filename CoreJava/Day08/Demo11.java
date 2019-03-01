/*
英才汇硕信息科技有限公司版权所有
*/

/**
统计1-100直接是7的倍数的数的个数，并打印输出
  @author yinhansong
  @version 1.0
*/
public class Demo11 {

    public static void main (String [] args){
        int j= 0;
        for(int i = 1;i<=100;i++){
          if(i%7==0){
            System.out.print(i + " ");
            j++;
          }
        }
        System.out.println('\n'+"一共有"+ j +"个7的倍数");
    }
}
