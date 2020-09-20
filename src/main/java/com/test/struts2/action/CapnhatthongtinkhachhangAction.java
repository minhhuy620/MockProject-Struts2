package com.test.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.KhachHangBO;
//import com.test.struts2.model.Khachhang;

public class CapnhatthongtinkhachhangAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String newhoten;
	private String newemail;
	private String newdiachi;
	Map<String, Object> session = ActionContext.getContext().getSession();
	public String getNewhoten() {
		return newhoten;
	}
	public void setNewhoten(String newhoten) {
		this.newhoten = newhoten;
	}
	public String getNewemail() {
		return newemail;
	}
	public void setNewemail(String newemail) {
		this.newemail = newemail;
	}
	public String getNewdiachi() {
		return newdiachi;
	}
	public void setNewdiachi(String newdiachi) {
		this.newdiachi = newdiachi;
	}
	public String execute() {
		KhachHangBO kbo = new KhachHangBO();
		int kid = (int) session.get("cusid");
        if (kbo.updateKhachhang(newhoten, newemail, newdiachi, kid) ==true) {
                session.put("cusname", newhoten);
                session.put("cusemail", newemail);
                session.put("cusaddress", newdiachi);
//                session.put("read", read);
                return "success";
        }
//        request.put("thongbaodangnhap", "Số điện thoại hoặc mật khẩu không đúng!");
        return "error";
	}

}
