#第十七天笔记
#### 包装类 封装类，Wrapper Class
- 8种简单类型，都有一个类与他们对应
Boolean-------------Boolean
char----------------Character
short---------------Short
byte----------------Byte
long----------------Long
int-----------------Integer
double--------------Double
float---------------Float
#### 多线程
- 程序、线程与进程的区别
 程序：代码
 进程：执行中的程序 独占系统资源（CPU，内存）
 线程：程序执行的最小单位，一个进程可能包含多个线程，多个线程并执行，程序执行效率高，速度快；线程之间共享资源。
 - java语言中如何创建线程？面试题
 第一种方式：继承Thread类
 第二种方式：实现Runnable接口
 - 操作系统Windows、 Linux、Unix、Mac OS；Android、iOS、VxWorks
迅雷是典型多线程程序
- 线程的状态有哪些？5态
创建， 就绪，运行，阻塞，消亡
- 线程的常用方法？
Thread:start();run();sleep();yield();join();
- 同步和死锁
synchronized 同步

- 线程的通信-生产者和消费者问题
