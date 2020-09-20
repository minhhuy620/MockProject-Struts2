package com.test.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.DanhGiaShipperBO;

public class DanhgiaShipperAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int sao, sid, iddonhang;
	private String nhanxet;
	Map<String, Object> session = ActionContext.getContext().getSession();
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");


	public int getSao() {
		return sao;
	}


	public void setSao(int sao) {
		this.sao = sao;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public int getIddonhang() {
		return iddonhang;
	}


	public void setIddonhang(int iddonhang) {
		this.iddonhang = iddonhang;
	}


	public String getNhanxet() {
		return nhanxet;
	}


	public void setNhanxet(String nhanxet) {
		this.nhanxet = nhanxet;
	}


	public String execute() {
		DanhGiaShipperBO kBo = new DanhGiaShipperBO();
		int kid = (int) session.get("cusid");
		if (kBo.danhgiashipper(sao, kid, sid, nhanxet, iddonhang) == true) {
	        request.put("danhgiathanhcong", "Đánh giá shipper thành công!");
			return SUCCESS;
		}
        request.put("danhgiathatbai", "Đánh giá shipper không thành công!");
		return ERROR;
	}
}
