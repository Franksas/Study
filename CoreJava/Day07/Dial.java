/*
英才汇硕信息科技有限公司版权所有
*/

package com.ychs168.corejava;
import java.util.Scanner;
/**
张三为他的手机设定了自动拨号
			按1：拨爸爸的号
			按2：拨妈妈的号
			按3：拨爷爷的号
			按4：拨奶奶的号
  @author yinhansong
  @version 1.0
*/
public class Dial {

    public static void main (String [] args){
        System.out.println("自动拨号：");
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        switch (b) {
            case 1:
                System.out.println("拨爸爸的号");
                break;
            case 2:
                System.out.println("拨妈妈的号");
                break;
            case 3:
                System.out.println("拨爷爷的号");
                break;
            case 4:
                System.out.println("拨奶奶的号");
                break;
        }
    }
}
