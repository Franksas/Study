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
public class FileDemo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("D:\\tit") ;		// 实例化File类的对象
		f1.mkdir() ;	// 创建文件夹
		File f = new File("D:\\test1.txt") ;// 实例化File类的对象
		if(f.exists()){	// 如果文件存在则删除
			f.delete() ;	// 删除文件
		}else{
			try{
				f.createNewFile() ;// 创建文件，根据给定的路径创建
			}catch(IOException e){
				e.printStackTrace() ;	// 输出异常信息
			}
		}
		File f2 = new File("D:\\") ;		// 实例化File类的对象
		String str[] = f2.list() ;	// 列出给定目录中的内容
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]) ;
		}
		File f3 = new File("D:\\") ;// 实例化File类的对象
		File files[] = f3.listFiles() ;	// 列出全部内容
		for(int i=0;i<files.length;i++){
			System.out.println(files[i]) ;
		}
	}

}
