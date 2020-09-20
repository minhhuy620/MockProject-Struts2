package com.test.struts2.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.Khachhang;

public class ListLockAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public ArrayList<Khachhang> dataLock = new ArrayList<>();

	public ArrayList<Khachhang> getDataLock() {
		return dataLock;
	}

	public void setDataLock(ArrayList<Khachhang> dataLock) {
		this.dataLock = dataLock;
	}

	@Override
	public String execute() throws Exception {
		AdminBO a = new AdminBO();
		dataLock = a.getLockUser();
		if (dataLock != null) {
			return SUCCESS;
		}
		return ERROR;
	}

}
