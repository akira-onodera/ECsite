package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{
	ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();

	public String execute() throws SQLException{
		String ret = SUCCESS;

		dao.deleteItemInfo();
		return ret;
	}



}
