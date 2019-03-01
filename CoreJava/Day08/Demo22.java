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
public class  Demo22{
    String ID;
    long password;
    Scanner sc = new Scanner(System.in);
    public void login(String I,long p){//定义登录方法
      this.ID = I;
      this.password = p;
    }
    public void username(){//定义用户名方法

          System.out.print("请输入用户名：");
          String username = sc .nextLine();
          if(username.equals(ID)) {
            System.out.println("请输入您的密码");
          }else{
            System.out.println("您输入的用户名不正确");
          }

        }
    public void userpassword(){//定义用户密码方法
        for(int i=3;i>=0;i--){
            long userpassword = sc.nextLong();
            if(userpassword==password){
                System.out.println("登录成功");
                break;
            }else{
            System.out.print("你还有"+ i +"次机会");
            System.out.print("请您再次输入密码：");
            if(i == 0){
                System.out.print("您的账户已被锁定");
                break;
            }
            }

      }
    }
    public static void main(String[] args) {
        Demo22 user= new Demo22();
        user.login("小明",123456);
        user.username();
        user.userpassword();
      }

}
