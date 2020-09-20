package com.test.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.KhachHangBO;
import com.test.struts2.model.Khachhang;

public class DangnhapkhachhangAction extends ActionSupport {

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
		Khachhang s = KhachHangBO.dangnhap(sdt, password);
//        String read = "readonly";
        if (s != null) {
        	if(s.getLock() == 0) {
                session.put("cusid", s.getKid());
                session.put("cusname", s.getHoten());
                session.put("cusemail", s.getEmail());
                session.put("cusphone", sdt);
                session.put("cusaddress", s.getDiachi());
                session.put("cuslevels", s.getLevels());
                System.out.println(s.getKid());
//                session.put("read", read);
                return "success";
        	}
        	else {
        		request.put("thongbaodangnhap", "Tài khoản của bạn đã bị khóa do vi phạm điều khoản sử dụng!");
                return "error";
        	}
        }
        request.put("thongbaodangnhap", "Số điện thoại hoặc mật khẩu không đúng!");
        return "error";
	}
	@SuppressWarnings("rawtypes")
	public String logout() {
        session.clear();
        ((org.apache.struts2.dispatcher.SessionMap) session).invalidate();    
    return SUCCESS;
}



}
