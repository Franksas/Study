package com.ychs.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * dbcp连接池（配置文件）
 * @author asus
 *
 */
public class DBCPPropertiesDemo {
	public static void main(String[] args) {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/dbcp.properties"));
			//通过datasourcefactoy获取数据源
			DataSource ds =BasicDataSourceFactory.createDataSource(properties);
			System.out.println(ds.getConnection());

		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
}
