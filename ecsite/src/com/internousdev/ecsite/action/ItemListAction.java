package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;


	private ItemListDAO dao = new ItemListDAO();
	private ArrayList<ItemInfoDTO> list = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{
		String ret = SUCCESS;
		list = dao.getItemInfo();
		session.put("ItemList", list);

		return ret;
	}


	public ItemListDAO getDao() {
		return dao;
	}


	public void setDao(ItemListDAO dao) {
		this.dao = dao;
	}


	public ArrayList<ItemInfoDTO> getList() {
		return list;
	}


	public void setList(ArrayList<ItemInfoDTO> list) {
		this.list = list;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
