package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;


	private UserListDAO dao = new UserListDAO();
	private ArrayList<UserInfoDTO> list = new ArrayList<UserInfoDTO>();

	public String execute() throws SQLException{
		String ret = SUCCESS;
		list = dao.getUserInfo();
		session.put("UserList", list);

		return ret;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}