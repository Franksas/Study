/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

import java.util.List;
import java.util.ArrayList;

/**

@author yinhansong
@version  1.0
*/
public class ArrayListDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> allList = null ;
		allList = new ArrayList<String>() ;	// 指定操作的泛型为String
		allList.add("Hello") ;
		allList.add(0,"World") ;
		allList.add("微信") ;
		allList.add("工业学院") ;
	   System.out.println(allList) ;

		allList.remove(0) ; //删除第一个元素，指定删除的位置
		allList.remove("Hello") ;
		System.out.println(allList) ;
System.out.print("由前向后输出：") ;

		for(int i=0;i<allList.size();i++){
			System.out.print(allList.get(i) + "、") ;
		}

		System.out.print("\n由后向前输出：") ;

		for(int i=allList.size()-1;i>=0;i--){
			System.out.print(allList.get(i) + "、") ;
		}

		System.out.print("\n") ;

		for(String x : allList){//遍历
		   System.out.print(x + " ,");
		}
		System.out.print("\n") ;
	}

}
