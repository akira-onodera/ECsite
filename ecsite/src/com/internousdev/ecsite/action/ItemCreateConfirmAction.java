package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private int price;
	private int stock;
	private String errorMessage;

	//フォームから受け取った内容が不正かどうかを判定します。
	private String validate(String name, String price, String stock) {
		StringBuilder sb = new StringBuilder();

		if(name.equals("")){
			sb.append("【商品名】の項目が空白です。<br>");
		}
		if(price.equals("")){
			sb.append("【価格】の項目が空白です。<br>");
		}
		if(stock.equals("")){
			sb.append("【在庫数】の項目が空白です。<br>");
		}
		if(price.matches("0[0-9]*")){
			sb.append("【価格】の項目は０から始まらない整数で入力してください。<br>");
		}
		if(!(price.matches("[0-9]*"))){
			sb.append("【価格】の項目は整数で入力し、記号や文字は入力しないで下さい。<br>");
		}
		if(stock.matches("0[0-9]*")){
			sb.append("【在庫数】の項目は０から始まらない整数で入力してください。<br>");
		}
		if(!(stock.matches("[0-9]*"))){
			sb.append("【在庫数】の項目は整数で入力し、記号や文字は入力しないで下さい。<br>");
		}

		return sb.toString();
	}

	private boolean isEmpty(Object o) {
		if (o == null) return true;;
		if (o instanceof String) {
			if ("".equals(o.toString())) return true;
		}
		return false;
	}


	public String execute(){
		String ret = ERROR;
		//入力値が不正の場合、errorFlgがtrueになります。
		boolean errorFlg = true;

		errorMessage = validate(itemName, itemPrice, itemStock);
		if (isEmpty(errorMessage)) {
			errorFlg = false;
		}

		//errorFlgに応じて処理を実行
		if(errorFlg == true){
			ret = ERROR;
		}else{
			ret = SUCCESS;
			price = Integer.parseInt(itemPrice);
			stock = Integer.parseInt(itemStock);
			session.put("price", price);
			session.put("stock", stock);
			session.put("itemName", itemName);
		}

		return ret;
	}



	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
