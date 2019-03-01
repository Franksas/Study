/*
英才汇硕信息科技有限公司版权所有
*/
package com.ychs168.corejava;
import java.util.Scanner;

/**
验证用户登录，如果用户名和密码正确则登录成功，
否则重新登录，显示你还有几次机会，最多有三次机会
  @author yinhansong
  @version 1.0
*/
public class  Demo31{
    public static void main(String[] args) {
        System.out.println("请输入您的用户名");
        Scanner sc = new Scanner(System.in);
        String username = "abc";
        String password = "123456";
        for(int i=1;i<=3;i++){
          String username2 = sc.nextLine();
          String password2 = sc.nextLine();
          //确定的值放到equals前面，不确定的之放到equals里//
          if(username.equals(username2)&&password.equals(password2)){
            System.out.println("登录成功");
                break;
            }else{
                if(i==3){
                    System.out.println("输入次数过多，没有机会啦");
                }else{
                    System.out.println("你还有"+(3-i)+"次机会");
                }
                System.out.println("您输入的用户名不正确");
          }
        }
        }
}
