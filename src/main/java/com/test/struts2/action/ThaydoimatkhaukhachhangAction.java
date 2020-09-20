package com.test.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.KhachHangBO;

public class ThaydoimatkhaukhachhangAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String matkhaucu;
	private String matkhaumoi;
	private String rematkhaumoi;
	Map<String, Object> session = ActionContext.getContext().getSession();
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");

	public String getMatkhaucu() {
		return matkhaucu;
	}

	public void setMatkhaucu(String matkhaucu) {
		this.matkhaucu = matkhaucu;
	}

	public String getMatkhaumoi() {
		return matkhaumoi;
	}

	public void setMatkhaumoi(String matkhaumoi) {
		this.matkhaumoi = matkhaumoi;
	}

	public String getRematkhaumoi() {
		return rematkhaumoi;
	}

	public void setRematkhaumoi(String rematkhaumoi) {
		this.rematkhaumoi = rematkhaumoi;
	}

	public String execute() {
		KhachHangBO kbo = new KhachHangBO();
		String sdt = (String) session.get("cusphone");
		if (kbo.changePass(sdt, matkhaucu, matkhaumoi) == true) {
			if (rematkhaumoi.equals(matkhaumoi)) {
		        request.put("thaydoimatkhauthanhcong", "Thay đổi mật khẩu thành công!");
				return "success";
			}        
			request.put("loithaydoimatkhau", "Nhập lại mật khẩu mới không chính xác!");
			return "error";
		}
        request.put("loithaydoimatkhau", "Mật khẩu hiện tại không chính xác!");
		return "error";
	}
}
