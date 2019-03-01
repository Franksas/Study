/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */

 package com.ychs168.corejava;
 import java.util.Scanner;
/**
 ***
   完善石头剪刀布游戏，让用户可以连续玩，直到用户或者计算机连续赢两次
 * @author yinhansong
 * @version  1.0
 */
public class Demo34{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < 3;){
            System.out.println("请输入你要出什么：1.石头   2.剪刀   3.布");
            int a = sc.nextInt();
            int b = (int)(Math.random()*2);
            int j = 0;
            int x = 0;
            switch(a){
                case 1:{
                    switch(b){
                        case 1:{
                            System.out.println("平局");
                            break;
                        }
                        case 2:{
                            System.out.println("赢");
                            j++;
                            break;

                        }

                        case 3:{
                            System.out.println("输");
                            i++;
                            break;
                        }
                    }
                      break;
                  }

                case 2:{
                    switch(b){
                        case 1:{
                            System.out.println("输");
                            i++;
                            break;
                        }
                        case 2:{
                            System.out.println("平局");
                            break;
                        }
                        case 3:{
                            System.out.println("赢");
                            j++;
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    switch(b){
                        case 1:{
                            System.out.println("赢");
                            j++;
                            break;
                        }
                        case 2:{
                            System.out.println("输");
                            i++;
                            break;
                        }
                        case 3:{
                            System.out.println("平局");
                            break;
                        }
                    }
                }
                break;

            }
            if(i>=j){
                x = i;
            }else{
                x =j;
            }
            System.out.println("还有" + (3-i) + "次机会");
        }
    }
}
