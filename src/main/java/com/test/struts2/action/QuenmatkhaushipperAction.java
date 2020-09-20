package com.test.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.model.Khachhang;
import com.test.struts2.model.Shipper;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
public class QuenmatkhaushipperAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String sdt, mail;
    Map<String, Object> session = ActionContext.getContext().getSession();
    Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
   public QuenmatkhaushipperAction() {
   }

   public QuenmatkhaushipperAction(String sdt, String mail) {
       this.sdt = sdt;
       this.mail = mail;
   }

   public String getSdt() {
       return sdt;
   }

   public void setSdt(String sdt) {
       this.sdt = sdt;
   }

   public String getMail() {
       return mail;
   }

   public void setMail(String mail) {
       this.mail = mail;
   }

  
   public Map<String, Object> getSession() {
       return session;
   }

   public void setSession(Map<String, Object> session) {
       this.session = session;
   }
   
   public String execute() throws Exception {
       Shipper sh = Shipper.forgot(sdt, mail);
       if (sh != null) {
    	   session.put("shipsdt", sh.getSdt());
    	   request.put("thongbao", "Thông tin hợp lệ, Vui lòng cập nhật lại mật khẩu !!");
           return SUCCESS;
      
   }
       request.put("thongbaodangnhap", "Số điện thoại hoặc Email Không Trùng Nhau !!");
       return ERROR;
   }
 
}

