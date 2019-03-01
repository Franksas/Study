/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.util.ArrayList ;
import java.util.List ;
import java.util.Collection ;
/**

@author yinhansong
@version  1.0
*/
public class ArrayListDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> allList = new ArrayList<String>() ;//多态

		allList.add("Hello") ;//向集合里添加对象
		allList.add("World") ;
		allList.add(1,"微信") ;
		System.out.println(allList) ;

	  List<String>  mylist = new ArrayList<String>(2);
		mylist.add("1");
		mylist.add("1");
		mylist.add("1");
		System.out.println(mylist.size());

	    System.out.println("allList中元素的个数是：" + allList.size());
	}

}
