package com.my.spring.util;

import java.sql.Connection;

public class ConnUtil {

	static{
		try {
			Class.forName("com.postgrsql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    static String url = "jdbc:mysql://localhost:5432/test" ;    
    static String username = "root" ;   
    static String password = "root" ;   
	public static Connection getConn(){
		Connection conn = null;
		
		return conn;
	}
}
