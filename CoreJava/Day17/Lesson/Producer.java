/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
  生产者线程类
@author yinhansong
@version  1.0
*/
public class Producer implements Runnable {
  private Clerk clerk;

  public Producer(Clerk clerk) {
      this.clerk = clerk;
  }

  public void run() {
      System.out.println(
              "厨师（生产者）开始炒制菜品......");

      for(int product = 1; product <= 10; product++) { // 生产1到10的整数
          try {
              Thread.sleep((int) Math.random() * 3000);  // 暂停随机时间
          }
          catch(InterruptedException e) {
              e.printStackTrace();
          }
          clerk.setProduct(product); // 将产品交给店员
      }
  }
}
