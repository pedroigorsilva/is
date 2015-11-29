package com.pedro.dao;  

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.pedro.dao.JDBCUtil;

public class LoginDao {
	public static boolean validate(String name, String pass) { 
		boolean status = false;
		
		try {
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement("select * from cliente where login=? and senha=?");
			qb.setString(1, name);
			qb.setString(2, pass);

			ResultSet res = qb.executeQuery();
			status = res.next();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBCUtil.closeConnection();
		}
		return status;
	}
}