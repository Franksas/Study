/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.io.*;
/**
  读文件，使用BufferedReader
@author yinhansong
@version  1.0
*/

public class Readerdemo {
	public static void main(String[] args) {
		BufferedReader in = null;
		try{
		    in = new BufferedReader(new FileReader("D:\\a.txt"));

		    String line = in.readLine();
		    while(line != null) {
		       System.out.println(line);
			   line = in.readLine();
		    }

	     } catch (Exception e){
	     	   e.printStackTrace();
	     	} finally {
	     		try{
	     		    in.close();
	     	    } catch (Exception e){
	     		     e.printStackTrace();
	     		  }
	     	  }
		}
	}
