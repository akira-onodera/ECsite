package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	private DBConnector db= new DBConnector();
	private Connection con=db.getConnection();

	public ArrayList<UserInfoDTO> getUserInfo() throws SQLException{
		ArrayList<UserInfoDTO> dtoList = new ArrayList<UserInfoDTO>();
		String sql=
				"SELECT * FROM login_user_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				UserInfoDTO dto = new UserInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setLogin_id(rs.getString("login_id"));
				dto.setLogin_pass(rs.getString("login_pass"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdated_date(rs.getString("updated_date"));
				dto.setAdmin_flg(rs.getString("admin_flg"));
				dtoList.add(dto);

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return dtoList;
	}



}