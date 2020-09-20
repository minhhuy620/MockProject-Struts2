package com.test.struts2.model;

public class DanhSachQuanHuyen {
	private int idquanhuyen;
	private String quanhuyen;
	public DanhSachQuanHuyen() {
		super();
	}
	public DanhSachQuanHuyen(int idquanhuyen, String quanhuyen) {
		super();
		this.idquanhuyen = idquanhuyen;
		this.quanhuyen = quanhuyen;
	}
	public int getIdquanhuyen() {
		return idquanhuyen;
	}
	public void setIdquanhuyen(int idquanhuyen) {
		this.idquanhuyen = idquanhuyen;
	}
	public String getQuanhuyen() {
		return quanhuyen;
	}
	public void setQuanhuyen(String quanhuyen) {
		this.quanhuyen = quanhuyen;
	}
	@Override
	public String toString() {
		return "DanhSachQuanHuyen [idquanhuyen=" + idquanhuyen + ", quanhuyen=" + quanhuyen + "]";
	}
	
}
