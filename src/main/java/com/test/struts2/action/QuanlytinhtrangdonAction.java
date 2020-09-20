package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class QuanlytinhtrangdonAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	@SuppressWarnings("unchecked")
	Map<String, Object> request2 = (Map<String, Object>) ActionContext.getContext().get("request");
	Map<String, Object> session = ActionContext.getContext().getSession();
	private ArrayList<ThongTinDonHangKhachHang> listdonhang = new ArrayList<ThongTinDonHangKhachHang>();
	private String madonhang;
	public String getMadonhang() {
		return madonhang;
	}

	public void setMadonhang(String madonhang) {
		this.madonhang = madonhang;
	}

	public ArrayList<ThongTinDonHangKhachHang> getListdonhang() {
		return listdonhang;
	}

	public void setListdonhang(ArrayList<ThongTinDonHangKhachHang> listdonhang) {
		this.listdonhang = listdonhang;
	}

	@Override
	public String execute() throws Exception {
		AdminBO a = new AdminBO();
		listdonhang = a.getAlldonhangkhachhang();
		if (listdonhang != null) {
			return SUCCESS;
		}
		return ERROR;
	}
	public String timdontheomadon() throws Exception {
		AdminBO a = new AdminBO();
		listdonhang = a.getdonmadon_admin(madonhang);
		if (listdonhang != null) {
			return SUCCESS;
		}
		return ERROR;
	}


}
