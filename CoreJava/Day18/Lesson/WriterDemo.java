/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.io.*;
/**
   写文件，使用PrintReader
@author yinhansong
@version  1.0
*/

public class WriterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("D:\\a.txt",true)));//true：在文件内容尾部追加,可把true去掉试试
			out.println("英才汇硕信息有限公司");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

}
