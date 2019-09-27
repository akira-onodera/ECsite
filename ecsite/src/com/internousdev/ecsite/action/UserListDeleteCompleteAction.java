package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{
	public Map<String,Object> session;
	UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();

	public String execute() throws SQLException{
		String ret = SUCCESS;

		dao.deleteUserInfo();
		return ret;
	}



}
