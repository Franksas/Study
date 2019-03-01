package com.ychs.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * 通过Properties读取数据库文件
 * @author yinhansong
 */
public class PropertiesDemo {
public static void main(String[] args) throws FileNotFoundException, IOException {
	Properties prop = new Properties();
	//加载数据文件
	prop.load(new FileInputStream("src/db.properties"));
	String driver = prop.getProperty("driver");
	String url = prop.getProperty("url");
	String  username = prop.getProperty("username");
	String password = prop.getProperty("password");

	System.out.println(driver);
	System.out.println(url);
	System.out.println(username);
	System.out.println(password);
}

}
