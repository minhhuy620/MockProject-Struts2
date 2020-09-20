package com.test.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.ShipperBO;
//import com.test.struts2.model.Khachhang;

public class CapnhatthongtinShipperAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String newhoten;
	private String newemail;
	private String newdiachi;
	private String newstk;
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
	public String getNewstk() {
		return newstk;
	}
	public void setNewstk(String newstk) {
		this.newstk = newstk;
	}
	public String execute() {
		ShipperBO kbo = new ShipperBO();
		int sid = (int) session.get("cusid");
        if (kbo.updateShipper(newhoten, newemail, newdiachi,newstk, sid) ==true) {
                session.put("cusname", newhoten);
                session.put("cusemail", newemail);
                session.put("cusaddress", newdiachi);
                session.put("cusbankcard", newstk);
//                session.put("read", read);
                return "success";
        }
//        request.put("thongbaodangnhap", "Số điện thoại hoặc mật khẩu không đúng!");
        return "error";
	}

}
