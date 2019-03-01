/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

import java.util.Properties;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.File;
import java.io.FileOutputStream ;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 	控制输入用户名和密码，判断登录是否成功；用户名和密码存在文件里
@author yinhansong
@version  1.0
*/
interface IZhuCe {
	public abstract void set();
}
interface IDengLu {
	public abstract void get();
}
/*
 注册类
 */
class In implements IZhuCe {
	 /**
    将输入的信息储存到属性文件中
*/
public void set() {
    Scanner sc = new Scanner(System.in);
    System.out.println("进入注册页面");
    System.out.println("输入用户名：");
    String userName = sc.next();
    System.out.println("输入密码：");
    String pass = sc.next();

    Properties pr = new Properties();
    pr.setProperty(userName,pass);
    File f = new File("H:" + File.separator + "task.properties");
    OutputStream out = null;
    try {
        out = new FileOutputStream(f,true);
        pr.store(out,"userName,passWord");
    } catch(FileNotFoundException e) {
        e.printStackTrace();
    } catch(IOException e) {
        e.printStackTrace();
    } finally {
          try {
              if(out != null) {
                  out.flush();
                  out.close();
              }
          } catch(IOException e) {
                  e.printStackTrace();
              }
        }
    }
}

/**
登陆类
*/
class Out implements IDengLu {
public static String x;
/**
    读取属性文件判断用户是否登陆成功
*/
public void get() {
  Scanner sc = new Scanner(System.in);
  System.out.println("进入登录页面");
  System.out.println("输入用户名：");
  String userName1 = sc.next();
  System.out.println("输入密码：");
  String pass1 = sc.next();

  Properties pr1 = new Properties();
  File f1 = new File("H:" + File.separator + "task.properties");
  InputStream input = null;
  try {
      input = new FileInputStream(f1);
      pr1.load(input);
  } catch(FileNotFoundException e) {
      e.printStackTrace();
  } catch(IOException e) {
      e.printStackTrace();
  } finally {
        try {
            if(input != null) {
                input.close();
            }
        } catch(IOException e) {
                e.printStackTrace();
            }
      }
  if(pass1.equals(pr1.getProperty(userName1))) {
      System.out.println("登陆成功！");
      x = "1";
  } else {
        if(pr1.getProperty(userName1) == null) {
            System.out.println("用户名不存在！");
            System.out.println("未注册用户请到注册页面！");
        } else {
              x = "1";
              System.out.println("密码错误!");
          }
      }
  }
}
/*
 * 用户类
 */
class User {
public void inUp() {
      new Out().get();
      Scanner s = new Scanner(System.in);
      if(!("1".equals(Out.x))) {
          System.out.println("输入yes进入注册页面！"+ "\n" + "输入no退出");
          String des = s.next();
          if("yes".equals(des)) {
              new In().set();
              new Out().get();
          } else if("no".equals(des)) {
              System.out.println("退出程序~ _ ~||");
          }
      }
}
}

/**
测试类
*/
public class Signln {
public static void main(String [] args) {
    User u= new User();
    u.inUp();
}
}
