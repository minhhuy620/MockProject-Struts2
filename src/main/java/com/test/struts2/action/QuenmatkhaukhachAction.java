package com.test.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.model.Khachhang;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
public class QuenmatkhaukhachAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String sdt, mail;
    Map<String, Object> session = ActionContext.getContext().getSession();
    Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");

   public QuenmatkhaukhachAction() {
   }

   public QuenmatkhaukhachAction(String sdt, String mail) {
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
       Khachhang kh = Khachhang.forgot(sdt, mail);
       if (kh != null) {
    	   session.put("cussdt", kh.getSdt());
    	   request.put("thongbao", "Thông tin hợp lệ, Vui lòng cập nhật lại mật khẩu !!");
           return SUCCESS;
      
   }
       request.put("thongbaodangnhap", "Số điện thoại hoặc Email Không Trùng Nhau !!");
       return ERROR;
   }
 
}

