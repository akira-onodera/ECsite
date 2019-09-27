package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class BuyItemConfirmDAO {


	public int howManyStock(int id) throws SQLException{
		DBConnector db= new DBConnector();
		Connection con = db.getConnection();
		int stock = 0;

		String sql="SELECT item_stock FROM item_info_transaction WHERE id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				stock = rs.getInt("item_stock");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return stock;
	}
}
