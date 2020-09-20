package com.test.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.Admin;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String sdt;
	private String password;
	Map<String, Object> session = ActionContext.getContext().getSession();
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {
		Admin s = AdminBO.dangnhap(sdt, password) ;
		if (s != null) {
			session.put("adname", s.getHoten());
			session.put("ademail", s.getEmail());
			session.put("adphone", sdt);
			return SUCCESS;
		} else {
			request.put("thongbaodangnhap", "Số điện thoại hoặc mật khẩu không đúng!");
			return ERROR;
		}
	}

	@SuppressWarnings("rawtypes")
	public String logout() {
		session.clear();
		((org.apache.struts2.dispatcher.SessionMap) session).invalidate();
		return SUCCESS;
	}

}
