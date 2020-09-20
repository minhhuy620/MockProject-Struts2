package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.ShipperBO;
import com.test.struts2.dao.ShipperDAO;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class ListDonhangmoiAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	Map<String, Object> session = ActionContext.getContext().getSession();
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	@SuppressWarnings("unchecked")
	Map<String, Object> request2 = (Map<String, Object>) ActionContext.getContext().get("request");
	public ArrayList<ThongTinDonHangKhachHang> dataList = new ArrayList<>();

	public ArrayList<ThongTinDonHangKhachHang> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<ThongTinDonHangKhachHang> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String execute() throws Exception {
		ShipperBO a = new ShipperBO();
		int lid = (int) session.get("cusrangeofvehicle");
		dataList = a.getDonhangmoi(lid);
		if (dataList != null) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String nhandon() throws Exception{
		ShipperBO s = new ShipperBO();
		ShipperDAO sh = new ShipperDAO();
		int lid = (int) session.get("cusrangeofvehicle");
		int sid = (int) session.get("cusid");
			if(!sh.ListTrangthaidon(sid).isEmpty()) {
				request2.put("thongbao", "Bạn phải hoàn thành đơn trước khi nhận đơn mới");
				dataList = s.getDonhangmoi(lid);
				return ERROR;
			}else if (s.UpdateNhandon(Integer.parseInt(request.getParameter("iddonhang")), sid) == true) {
					request2.put("thongbao", "Nhận đơn thành công");
					dataList = s.getDonhangmoi(lid);
					return SUCCESS;
				} else {
					request2.put("thongbao", "Hệ thông bận");
					return ERROR;
			}
	}
}
