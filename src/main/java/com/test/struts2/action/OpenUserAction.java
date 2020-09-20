package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.Khachhang;

public class OpenUserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<Khachhang> dataLock = new ArrayList<Khachhang>();
	
	public ArrayList<Khachhang> getDataLock() {
		return dataLock;
	}
	public void setDataLock(ArrayList<Khachhang> dataLock) {
		this.dataLock = dataLock;
	}
	@SuppressWarnings("unchecked")
	Map<String, Object> request2 = (Map<String, Object>) ActionContext.getContext().get("request");
	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		AdminBO a = new AdminBO();
		if (a.openUser(Integer.parseInt(request.getParameter("kid"))) == true) {
			request2.put("thongbao", "Mở khóa tài khoản thành công");
			dataLock = a.getLockUser();
			return SUCCESS;
		} else {
			request2.put("thongbao2", "Hệ thông bận");
			return ERROR;
		}
	}
}
