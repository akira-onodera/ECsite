package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	private DBConnector db= new DBConnector();
	private Connection con=db.getConnection();

	public ArrayList<ItemInfoDTO> getItemInfo() throws SQLException{
		ArrayList<ItemInfoDTO> dtoList = new ArrayList<ItemInfoDTO>();
		String sql=
				"SELECT * FROM item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setPrice(rs.getInt("item_price"));
				dto.setStock(rs.getInt("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
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
