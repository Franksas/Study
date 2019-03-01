/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
  消费者线程类
@author yinhansong
@version  1.0
*/
public class Consumer implements Runnable {
  private Clerk clerk;

  public Consumer(Clerk clerk) {
      this.clerk = clerk;
  }

  public void run() {
      System.out.println(
              "吃货（消费者）开始大吃...."); 
      for(int i = 1; i <= 10; i++) { // 消耗10个整数
          try {
              Thread.sleep((int) (Math.random() * 3000)); // 等待随机时间
          }
          catch(InterruptedException e) {
              e.printStackTrace();
          }
          clerk.getProduct(); // 从店员处取走整数
      }
  }
}
