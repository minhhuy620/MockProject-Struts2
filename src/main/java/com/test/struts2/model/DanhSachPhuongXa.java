package com.test.struts2.model;

public class DanhSachPhuongXa {
	private int idphuongxa;
	private int idquanhuyen;
	private String phuongxa;
	
	public DanhSachPhuongXa() {
		super();
	}

	public DanhSachPhuongXa(int idphuongxa, String phuongxa) {
		super();
		this.idphuongxa = idphuongxa;
		this.phuongxa = phuongxa;
	}
	public DanhSachPhuongXa(int idphuongxa, int idquanhuyen, String phuongxa) {
		super();
		this.idphuongxa = idphuongxa;
		this.idquanhuyen = idquanhuyen;
		this.phuongxa = phuongxa;
	}

	public int getIdphuongxa() {
		return idphuongxa;
	}

	public void setIdphuongxa(int idphuongxa) {
		this.idphuongxa = idphuongxa;
	}

	public int getIdquanhuyen() {
		return idquanhuyen;
	}

	public void setIdquanhuyen(int idquanhuyen) {
		this.idquanhuyen = idquanhuyen;
	}

	public String getPhuongxa() {
		return phuongxa;
	}

	public void setPhuongxa(String phuongxa) {
		this.phuongxa = phuongxa;
	}

	@Override
	public String toString() {
		return "DanhSachPhuongXa [idphuongxa=" + idphuongxa + ", idquanhuyen=" + idquanhuyen + ", phuongxa=" + phuongxa
				+ "]";
	}
	
}
