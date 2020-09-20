package com.test.struts2.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.Khachhang;

public class ListUserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public ArrayList<Khachhang> dataList = new ArrayList<>();

	public ArrayList<Khachhang> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<Khachhang> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String execute() throws Exception {
		AdminBO a = new AdminBO();
		dataList = a.getAllUser();
		if (dataList != null) {
			return SUCCESS;
		}
		return ERROR;
	}
}
