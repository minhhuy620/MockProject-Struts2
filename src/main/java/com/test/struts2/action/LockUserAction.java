package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.Khachhang;

public class LockUserAction extends ActionSupport implements ModelDriven<Khachhang> {

	private static final long serialVersionUID = 1L;
	private ArrayList<Khachhang> dataList = new ArrayList<Khachhang>();
	
	public ArrayList<Khachhang> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<Khachhang> dataList) {
		this.dataList = dataList;
	}

	private Khachhang s = new Khachhang();
	@SuppressWarnings("unchecked")
	Map<String, Object> request2 = (Map<String, Object>) ActionContext.getContext().get("request");

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		AdminBO a = new AdminBO();
		if (a.lockUser(Integer.parseInt(request.getParameter("kid"))) == true) {
			request2.put("thongbao", "Khóa thành công");
			dataList = a.getAllUser();
			return SUCCESS;
		} else {
			request2.put("thongbao2", "Hệ thông bận");
			return ERROR;
		}
	}

	@Override
	public Khachhang getModel() {
		// TODO Auto-generated method stub
		return s;
	}

}
