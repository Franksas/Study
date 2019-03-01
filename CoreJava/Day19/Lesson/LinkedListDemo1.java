/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

import java.util.LinkedList;
;

/**

@author yinhansong
@version  1.0
*/

public class LinkedListDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> link = new LinkedList<String>();
		link.add("A");
		link.add("B");
		link.add("C");
		link.add("X") ;	// 增加元素
		link.add("Y") ;	// 增加元素
		link.add("Z") ;	// 增加元素
		System.out.println("初始化链表：" + link);
		link.addFirst("X");
		link.addLast("Y");
		System.out.println("增加头和尾后的链表" + link);

		System.out.println("1-1、element()方法找到表头：" + link.element()) ;
		System.out.println("1-2、找完之后的链表的内容：" + link) ;
		System.out.println("2-1、peek()方法找到表头：" + link.peek()) ;
		System.out.println("2-2、找完之后的链表的内容：" + link) ;
		System.out.println("3-1、poll()方法找到表头：" + link.poll()) ;
		System.out.println("3-2、找完之后的链表的内容：" + link) ;
	}

}
