package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.ShipperBO;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class XacnhangiaohangAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	@SuppressWarnings("unchecked")
	Map<String, Object> request2 = (Map<String, Object>) ActionContext.getContext().get("request");
	Map<String, Object> session = ActionContext.getContext().getSession();
	public ArrayList<ThongTinDonHangKhachHang> dataList = new ArrayList<>();
	int lid = (int) session.get("cusrangeofvehicle");
	int sid = (int) session.get("cusid");

	public ArrayList<ThongTinDonHangKhachHang> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<ThongTinDonHangKhachHang> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String execute() throws Exception {
		ShipperBO a = new ShipperBO();
		dataList = a.getDondalay(lid,sid);
		if (dataList != null) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String giaohang() throws Exception{
		ShipperBO s = new ShipperBO();
		if (s.UpdateGiaohang(Integer.parseInt(request.getParameter("iddonhang"))) == true) {
			request2.put("thongbao", "Lấy hàng thành công");
			dataList = s.getDondalay(lid,sid);
			return SUCCESS;
		} else {
			request2.put("thongbao", "Hệ thông bận");
			return ERROR;
		}
	}

}
