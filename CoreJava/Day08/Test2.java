/*
英才汇硕信息科技有限公司版权所有
*/

/**
统计1-100之间能被7整除的数，并打印，每行打印5个
  @author yinhansong
  @version 1.0
*/
public class  Test2{
    public static void main (String [] args){
      int count = 0;
        for(int i=1;i<=100;i++){
            if(i%7==0){
                System.out.print(i + " ");
                if(i%5==0){
                    System.out.println();
                }
            }
        }

    }

}
