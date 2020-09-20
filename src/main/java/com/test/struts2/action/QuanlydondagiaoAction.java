package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.ShipperBO;
import com.test.struts2.bo.TimKiemDonHangKhachHangBO;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class QuanlydondagiaoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	Map<String, Object> session = ActionContext.getContext().getSession();
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	@SuppressWarnings("unchecked")
	Map<String, Object> request2 = (Map<String, Object>) ActionContext.getContext().get("request");
	private String madonhang;
	TimKiemDonHangKhachHangBO bo = new TimKiemDonHangKhachHangBO();
	public String getMadonhang() {
		return madonhang;
	}
	public void setMadonhang(String madonhang) {
		this.madonhang = madonhang;
	}
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
		dataList = a.getDondagiao(lid,sid);
		if (dataList != null) {
			return SUCCESS;
		}
		return ERROR;
	}
	public String dontheomacuashipper() {
	    if (madonhang!="") {
	      dataList =  bo.getDonhangmadontushipper(sid, madonhang);
	      System.out.println("ok1");
	        return SUCCESS;
	    }
	    return ERROR;
	}
}
