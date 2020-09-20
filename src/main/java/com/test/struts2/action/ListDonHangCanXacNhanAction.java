package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.AdminBO;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class ListDonHangCanXacNhanAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	@SuppressWarnings("unchecked")
	Map<String, Object> request2 = (Map<String, Object>) ActionContext.getContext().get("request");
	Map<String, Object> session = ActionContext.getContext().getSession();
	private ArrayList<ThongTinDonHangKhachHang> listdonhang = new ArrayList<ThongTinDonHangKhachHang>();

	public ArrayList<ThongTinDonHangKhachHang> getListdonhang() {
		return listdonhang;
	}

	public void setListdonhang(ArrayList<ThongTinDonHangKhachHang> listdonhang) {
		this.listdonhang = listdonhang;
	}

	@Override
	public String execute() throws Exception {
		AdminBO a = new AdminBO();
		listdonhang = a.getThongTinDonHangTuUser();
		if (listdonhang != null) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String xacnhandon() throws Exception {
		AdminBO s = new AdminBO();
		if (s.UpdateXacnhandon(Integer.parseInt(request.getParameter("iddonhang"))) == true) {
			request2.put("thongbao", "Xác nhận thành công");
			listdonhang = s.getThongTinDonHangTuUser();
			return SUCCESS;
		} else {
			request2.put("thongbao", "Hệ thông bận");
			return ERROR;
		}
	}

	public String tuchoinhandon() throws Exception {
		AdminBO s = new AdminBO();
		if (s.updateTuChoiDonHang(Integer.parseInt(request.getParameter("iddonhang"))) == true) {
			request2.put("thongbao", "Thành công");
			listdonhang = s.getThongTinDonHangTuUser();
			return SUCCESS;
		} else {
			/* request2.put("thongbao", "Hệ thông bận"); */
			return ERROR;
		}
	}

}
