/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

import java.io.BufferedWriter;
import java.io.File ;
import java.io.FileWriter;
import java.io.IOException;

/**
创建临时文件
@author yinhansong
@version  1.0
*/
public class FileDemo7 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File temp = File.createTempFile ("order", ".temp");

	      BufferedWriter out = new BufferedWriter (new FileWriter(temp));
	      out.write("你好");
	      System.out.println("临时文件被创建  " + temp.getAbsolutePath());
	      temp.deleteOnExit();
	      out.close();


	      try {
	         File f1 = File.createTempFile("product", ".tmp");
	    	   System.out.println("临时文件 : " + f1.getAbsolutePath());
	      } catch(IOException e) {
	         e.printStackTrace();
	      }

	}

}
