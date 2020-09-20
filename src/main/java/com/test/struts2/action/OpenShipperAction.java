package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.Shipper;

public class OpenShipperAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<Shipper> dataLockshipper = new ArrayList<Shipper>();
	
	
	public ArrayList<Shipper> getDataLockshipper() {
		return dataLockshipper;
	}
	public void setDataLockshipper(ArrayList<Shipper> dataLockshipper) {
		this.dataLockshipper = dataLockshipper;
	}
	@SuppressWarnings("unchecked")
	Map<String, Object> request2 = (Map<String, Object>) ActionContext.getContext().get("request");
	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		AdminBO a = new AdminBO();
		if (a.openShipper(Integer.parseInt(request.getParameter("sid"))) == true) {
			request2.put("thongbao", "Mở khóa tài khoản shipper thành công");
			dataLockshipper = a.getLockShipper();
			return SUCCESS;
		} else {
			request2.put("thongbao2", "Hệ thông bận");
			return ERROR;
		}
	}
}
