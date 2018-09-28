package com.rohith.app.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MySQLDataSourceFactory {
	
	
	private static  DataSource dataSource;
	
	
	static{
		
		loadDataSource();
	}

	private static void loadDataSource() {
		Properties props = new Properties();
		InputStream fis = null;
		MysqlDataSource mysqlDS = null;
		try {
			fis = MySQLDataSourceFactory.class.getClassLoader().getResourceAsStream("mysqldb.properties");
			props.load(fis);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		dataSource = mysqlDS;
	}
	
	
	public static Connection getConnection(){
		
		if(null!=dataSource){
			
			try {
				return dataSource.getConnection();
			} catch (SQLException e) {
				System.out.println("Exception while obtaining connection"+ e.getMessage());
			}
		}
		return null;
	}

}
