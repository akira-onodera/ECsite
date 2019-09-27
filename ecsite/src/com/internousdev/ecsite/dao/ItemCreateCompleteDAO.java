package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con= db.getConnection();
	private DateUtil date=new DateUtil();
	private String sql="insert into item_info_transaction(item_name,item_price,item_stock,insert_date) values(?,?,?,?)";

	public void createItem(String itemName,int price, int stock)throws SQLException{

		try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, itemName);
				ps.setInt(2, price);
				ps.setInt(3, stock);
				ps.setString(4, date.getDate());

				ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
}
