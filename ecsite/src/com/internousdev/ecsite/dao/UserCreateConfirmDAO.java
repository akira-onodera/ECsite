package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {

	private DBConnector db = new DBConnector();
	private Connection con= db.getConnection();

	private String sql="SELECT * FROM login_user_transaction WHERE login_id = ?";

	public boolean checkUser(String loginUserId)throws SQLException{
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			con.close();
		}
	}
}
