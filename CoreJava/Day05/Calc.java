/*
   YCKJ版权所有
*/
/**

 @author yinhansong
 @version  1.0
*/
public class Calc {
    public static void main(String [] args) {
        //  +  _ * / % ++ --
        short s = 6;
        /*s = s + 1;
        system.out.println("s = " + s);*/
        s += 1;
        System.out.println("s = " + s);

        int a = 2;
        int b = 3;
        int c = a++ - ++b + --a;
        System.out.println("c = " + c);

        int num1 = 15;
        int n1 = num1++;
        System.out.println(n1);

        int n2 = ++num1;
        System.out.println(n2);

        System.out.println(3 + 2 + "tit");
        System.out.println(3 + "tit" + 2);
        System.out.println("tit" + 2 + 3);
        System.out.println("ab" + 23 + "");
          String str1 = 23 + "";
          //--------------------

          System.out.println(3 / 2);
          System.out.println(-3.0 / 2);
          System.out.println(-2 / 3);
          System.out.println(2.0 / 3);
          System.out.println(2.0 / 0);
          //System.out.println(2 / 0);

          System.out.println(3 % 2);
          System.out.println(-3.0 % 2);
          System.out.println(2 % 3);
          System.out.println(2.0 % 3);
          System.out.println(2.0 % 0);
          //System.out.println(2 % 0);

    }

}
