/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.io.*;
/**

@author yinhansong
@version  1.0
*/


public class BufferedReaderDemo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader	br = new BufferedReader(new FileReader(new File("test1.txt"))) ;	// 将字节流变为字符流
		String str = null ;	// 接收输入内容
		//System.out.print("请输入内容：") ;
		try{
			while ((str = br.readLine()) != null){
			    System.out.println(str);
			}
				// 读取一行数据
		}catch(IOException e){
			e.printStackTrace() ;// 输出信息
		} finally {
		    if(br != null){
		       br.close();
		    }
		}
	}

}
