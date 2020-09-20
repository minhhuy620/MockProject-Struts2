package com.test.struts2.model;

public class DiaChiLayHang {
	private int madiachi;
	private String sdtnguoigui;
	private String hoten;
	private String diachi;
	private int idphuongxa;
	public DiaChiLayHang() {
		super();
	}
	public DiaChiLayHang(int madiachi, String sdtnguoigui, String hoten, String diachi, int idphuongxa) {
		super();
		this.madiachi = madiachi;
		this.sdtnguoigui = sdtnguoigui;
		this.hoten = hoten;
		this.diachi = diachi;
		this.idphuongxa = idphuongxa;
	}
	public DiaChiLayHang(String sdtnguoigui, String hoten, String diachi, int idphuongxa) {
		this.sdtnguoigui = sdtnguoigui;
		this.hoten = hoten;
		this.diachi = diachi;
		this.idphuongxa = idphuongxa;
	}
	public int getMadiachi() {
		return madiachi;
	}
	public void setMadiachi(int madiachi) {
		this.madiachi = madiachi;
	}
	public String getSdtnguoigui() {
		return sdtnguoigui;
	}
	public void setSdtnguoigui(String sdtnguoigui) {
		this.sdtnguoigui = sdtnguoigui;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getIdphuongxa() {
		return idphuongxa;
	}
	public void setIdphuongxa(int idphuongxa) {
		this.idphuongxa = idphuongxa;
	}
	@Override
	public String toString() {
		return "DiaChiLayHang [madiachi=" + madiachi + ", sdtnguoigui=" + sdtnguoigui + ", hoten=" + hoten + ", diachi="
				+ diachi + ", idphuongxa=" + idphuongxa + "]";
	}
	
}
