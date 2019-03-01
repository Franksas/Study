/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;

import java.io.File ;
import java.io.IOException ;

/**

@author yinhansong
@version  1.0
*/
public class FileDemo6 {
	public static long getFileSize(String filename) {
	      File file = new File(filename);
	      if (!file.exists() || !file.isFile()) {
	         System.out.println("文件不存在.");
	         return -1;
	      }
	      return file.length();
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long size = getFileSize("d:/ychs.png");
	      System.out.println("文件大小是： " + size + "字节。");
	      System.out.println("文件大小是： " + (size / 1024.0) + "K");
		//是否是目录的判断
		File f5 = new File("D:\\Test.java") ;// 实例化File类的对象
		if(f5.isDirectory()){	// 判断是否是目录
			System.out.println(f5.getPath() + "路径是目录。") ;
		}else{
			System.out.println(f5.getPath() + "路径不是目录。") ;
		}
		File oldName = new File("D:\\1.txt");
	    File newName = new File("D:\\java.txt");

	    if(oldName.renameTo(newName)) {
	       System.out.println("Renamed");
	    } else {
	       System.out.println("Error");
	    }
	}

}
