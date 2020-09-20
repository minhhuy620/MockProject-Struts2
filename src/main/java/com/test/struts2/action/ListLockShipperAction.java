package com.test.struts2.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.Shipper;

public class ListLockShipperAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public ArrayList<Shipper> dataLockshipper = new ArrayList<>();

	public ArrayList<Shipper> getDataLockshipper() {
		return dataLockshipper;
	}

	public void setDataLockshipper(ArrayList<Shipper> dataLockshipper) {
		this.dataLockshipper = dataLockshipper;
	}

	@Override
	public String execute() throws Exception {
		AdminBO a = new AdminBO();
		dataLockshipper = a.getLockShipper();
		if (dataLockshipper != null) {
			return SUCCESS;
		}
		return ERROR;
	}

}
