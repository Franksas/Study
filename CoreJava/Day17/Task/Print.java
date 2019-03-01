/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

import com.ychs168.corejava.Print.Thread1;
import com.ychs168.corejava.Print.Thread2;

/**
  编写两个线程分别打印A和B，输出效果是ABABAB
@author yinhansong
@version  1.0
*/
public class Print {
    private Object o = new Object(); // 共享资源
    private boolean flag = true; // 互斥信号量

    class Thread1 extends Thread {
        public void run() {
            synchronized (o) { // 线程同步
                for (int i = 1; i <= 3; i++) {
                    System.out.print("A");

                    o.notify(); // 唤醒另外一个进程
                    if(flag){
                        flag = false;
                        try {
                            o.wait(); // 当前线程等待
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class Thread2 extends Thread {
        public void run() {
            synchronized (o) { // 线程同步
                for (int i = 1; i <= 3; i++) {
                    System.out.print("B" + " ");

                    o.notify(); // 唤醒另外一个进程
                    if(!flag){
                        flag = true;
                        try {
                            if(i != 10){
                                o.wait(); // 当前线程等待
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public void show(){
        new Thread1().start();
        new Thread2().start();
    }

    public static void main(String[] args) {
        Print t = new Print();
        t.show();
    }

}
