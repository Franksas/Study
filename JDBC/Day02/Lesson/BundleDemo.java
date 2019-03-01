package com.ychs.demo;

import java.util.ResourceBundle;

import javax.annotation.Resource;

public class BundleDemo {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

}
