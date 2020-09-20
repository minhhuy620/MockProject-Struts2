package com.test.struts2.action;



import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.struts2.bo.KhachHangBO;
import com.test.struts2.model.Khachhang;


public class DangkikhachhangAction extends ActionSupport implements ModelDriven<Khachhang>{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	
	public Khachhang khachhang = new Khachhang();

	public Khachhang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public String execute() throws Exception {
		KhachHangBO kbo = new KhachHangBO();
		System.out.println("oke");
		if(!khachhang.getHoten().equals("") && !khachhang.getSdt().equals("") && !khachhang.getEmail().equals("") && !khachhang.getDiachi().equals("")) {
			kbo.addNewKhachHang(khachhang.getHoten(),khachhang.getSdt(),khachhang.getEmail(),khachhang.getMatkhau(),khachhang.getDiachi());
			request.put("thongbao", "Đăng kí thành công!");
			 return SUCCESS;
		}
		request.put("thongbao", "Không hợp lệ");
       return ERROR;
	}

	public Khachhang getModel() {
		return khachhang;
	}

}
