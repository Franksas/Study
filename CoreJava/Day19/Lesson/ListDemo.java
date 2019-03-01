/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sun.org.glassfish.external.statistics.Statistic;



/**

@author yinhansong
@version  1.0
*/


public class ListDemo {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("hello");
		strList.add("china");
		strList.add("hello");
		//System.out.println(strList);//

		for (String s : strList) {
			System.out.println(s);
		}
		for (int i = 0; i < strList.size();i++) {
			System.out.println(strList.get(i));
		}


		Set strSet = new HashSet();
		strSet.add("hello");
		strSet.add("world");
		strSet.add("hello");
		strSet.add(200);
		//System.out.println(strSet);
	}

}
