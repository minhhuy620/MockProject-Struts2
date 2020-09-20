package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.Shipper;

public class LockShipperAction extends ActionSupport implements ModelDriven<Shipper> {

	private static final long serialVersionUID = 1L;
	private ArrayList<Shipper> datashipper = new ArrayList<Shipper>();
	
	
	public ArrayList<Shipper> getDatashipper() {
		return datashipper;
	}

	public void setDatashipper(ArrayList<Shipper> datashipper) {
		this.datashipper = datashipper;
	}

	private Shipper s = new Shipper();
	@SuppressWarnings("unchecked")
	Map<String, Object> request2 = (Map<String, Object>) ActionContext.getContext().get("request");

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		AdminBO a = new AdminBO();
		if (a.lockShipper(Integer.parseInt(request.getParameter("sid"))) == true) {
			request2.put("thongbao", "Khóa account shipper thành công");
			datashipper = a.getAllShipper();
			return SUCCESS;
		} else {
			request2.put("thongbao2", "Hệ thông bận");
			return ERROR;
		}
	}

	@Override
	public Shipper getModel() {
		// TODO Auto-generated method stub
		return s;
	}

}
