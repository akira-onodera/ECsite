package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private String itemName;
	private int price;
	private int stock;
	public Map<String,Object> session;

	private ItemCreateCompleteDAO dao=new ItemCreateCompleteDAO();

	public String execute() throws SQLException{
		dao.createItem(session.get("itemName").toString(),
				Integer.parseInt(session.get("price").toString()),
				Integer.parseInt(session.get("stock").toString())
				);

		String result=SUCCESS;

		return result;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setSession(Map<String,Object>session){
		this.session=session;
	}


}