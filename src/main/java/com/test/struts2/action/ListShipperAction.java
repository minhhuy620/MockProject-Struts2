package com.test.struts2.action;


import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.dao.AdminDAO;
import com.test.struts2.model.Shipper;

public class ListShipperAction extends ActionSupport {

private static final long serialVersionUID = 1L;
	
	private ArrayList<Shipper> datashipper = new ArrayList<Shipper>() ;

	@Override
	public String execute() throws Exception {
		AdminDAO dd = new AdminDAO();
		datashipper = dd.listAllShipper();
		if(datashipper != null) {
			return SUCCESS;	
		}
		return ERROR;
	}
	public ArrayList<Shipper> getDatashipper() {
		return datashipper;
	}
	public void setDatashipper(ArrayList<Shipper> datashipper) {
		this.datashipper = datashipper;
	}
	
}
