/*
   YCKJ版权所有
*/
/**

 @author yinhansong
 @version  1.0
*/
public class Logic {
    public static void main(String [] args) {
        //逻辑运算符 & ,|，&&，||
        //关系运算符：>,<,>=,<=;

        int a = 10;
        int b = 20;
        int c = 30;
        System.out.println(a != b);
        System.out.println(a >= b & b < c++);
        System.out.println("c = " + c);
        System.out.println(a >= b | b < c);
        System.out.println(a >= b && b++ < c);
        System.out.println("b = " + b);
        System.out.println(a >= b || b < c);




      }
}
