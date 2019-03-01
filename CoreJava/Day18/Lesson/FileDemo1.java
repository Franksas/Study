/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.io.*;
import java.io.IOException;
/**

@author yinhansong
@version  1.0
*/


public class FileDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:\\test1.txt");//实例化File类的对象
		try {
			f.createNewFile();//创建文件，根据给定的路径创建
			System.out.println("success");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("fail");
			e.printStackTrace();//输出异常信息
		}
	}

}
