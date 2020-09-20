package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.DanhGiaShipperBO;
import com.test.struts2.bo.ShipperBO;
import com.test.struts2.model.DanhGiaShipper;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class XemdanhgiaShipperAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	Map<String, Object> session = ActionContext.getContext().getSession();
	public ArrayList<DanhGiaShipper> dataList = new ArrayList<>();
	int sid = (int) session.get("cusid");


	public String execute() {
		DanhGiaShipperBO kBo = new DanhGiaShipperBO();
		dataList = kBo.getDanhgia(sid);
		if (dataList != null) {
			return SUCCESS;
		}
		return ERROR;
	}
}
