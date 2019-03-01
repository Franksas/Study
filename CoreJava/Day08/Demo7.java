public class  Demo7{
    public static void main(String [] args){
        int i = 1;
        int sum = 0;
        do{

          sum+=i;
          i++;
        }while(i<=10);
        System.out.println("sum="+sum);
        /*while (i<1){
            sum+=1;
            i++;
        }
        System.out.println("sum="+sum);*/
    }
}
