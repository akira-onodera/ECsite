package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector db= new DBConnector();
	private Connection con=db.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id, String user_master_id) throws SQLException{
		ArrayList<MyPageDTO> dto = new ArrayList<MyPageDTO>();
		String sql=
				"SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY insert_date DESC";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto1 = new MyPageDTO();
				dto1.setId(rs.getString("id"));
				dto1.setItemName(rs.getString("item_name"));
				dto1.setTotalPrice(rs.getString("total_price"));
				dto1.setTotalCount(rs.getString("total_count"));
				dto1.setPayment(rs.getString("pay"));
				dto1.setInsert_date(rs.getString("insert_date"));
				dto.add(dto1);

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return dto;
	}

	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{
		String sql="DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";
		PreparedStatement ps;
		int result = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}
