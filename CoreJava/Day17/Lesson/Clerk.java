/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**
   多线程 服务员类，其对象被生产者和消费者共享
@author yinhansong
@version  1.0
*/

public class Clerk {     // -1 表示目前服务员手里没有产品
    private int product = -1;

     // 这个方法由厨师（生产者）调用，该方法往服务员手里放产品
    public synchronized void setProduct(int p) {
        if(this.product != -1) {      //服务员手里有东西
            try {
               wait(); // 服务员手里有东西，厨师需等待

            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.product = p;
        System.out.printf("厨师（生产者）炒出(%d)%n", this.product);
        // 通知等待区中的一个吃货（消费者）可以继续工作了
        notifyAll();
    }
    // 这个方法由吃货（消费者）调用，该方法从服务员手里取产品
    public synchronized int getProduct() {
        if(this.product == -1) { //服务员手里没东西
            try {
                wait(); // 吃货需等待
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf(
                  "吃货（消费者）吃掉 (%d)%n", this.product);
        System.out.println("");
        this.product = -1; // 取走产品，-1表示目前店员手上无产品

        notifyAll(); // 通知等待区中的一个生产者可以继续工作了
        return p;
    }
}
