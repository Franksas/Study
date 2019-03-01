/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

/**

@author yinhansong
@version  1.0
*/
public class Test4 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread producerThread = new Thread(new Producer(clerk));  // 生产者线程
        Thread consumerThread = new Thread(new Consumer(clerk)); //消费者线程
        producerThread.start();
        consumerThread.start();
    }
}
 
