package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private int count;
	private String pay;
	private String errorMessage;
	private int itemStock;

	public String execute() throws NumberFormatException, SQLException{
		BuyItemConfirmDAO dao = new BuyItemConfirmDAO();

		String result = SUCCESS;

		itemStock = dao.howManyStock(Integer.parseInt(session.get("id").toString()));

		if(itemStock < count){
			result = ERROR;
			setErrorMessage("在庫がありません。"+itemStock+"個以下で選択してください。");
		}else{
			session.put("count",count);
			session.put("stock", itemStock);
			int intCount = Integer.parseInt(session.get("count").toString());
			int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
			session.put("total_price",intCount * intPrice);
			String payment;
			if(pay.equals("1")){
				payment = "現金払い";
				session.put("pay",payment);
			}else{
				payment = "クレジットカード";
				session.put("pay",payment);
			}
		}
		return result;
	}

	public void setCount(int count){
		this.count=count;
	}

	public void setPay(String pay){
		this.pay=pay;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}


