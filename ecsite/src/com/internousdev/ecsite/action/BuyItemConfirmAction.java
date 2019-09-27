package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private BuyItemCompleteDAO dao = new BuyItemCompleteDAO();

	public String execute() throws SQLException{
		String count = session.get("count").toString();
		String id = session.get("id").toString();
		int intId = Integer.parseInt(id);
		int intCount = Integer.parseInt(count);
		int intStock = Integer.parseInt(session.get("stock").toString());

		dao.buyItemInfo(
				id,
				session.get("total_price").toString(),
				count,
				session.get("login_user_id").toString(),
				session.get("pay").toString()
				);

		dao.updateStock(intId, intStock - intCount);


		String result=SUCCESS;
		return result;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
