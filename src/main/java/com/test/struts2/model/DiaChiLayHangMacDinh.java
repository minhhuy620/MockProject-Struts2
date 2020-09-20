package com.test.struts2.model;

public class DiaChiLayHangMacDinh {
	
	private int id;
	private int kid;
	private String sdtnguoigui;
	private String hoten;
	private String diachi;
	private int idphuongxa;
	
	public DiaChiLayHangMacDinh() {
		super();
	}
	public DiaChiLayHangMacDinh(int id, int kid, String sdtnguoigui, String hoten, String diachi, int idphuongxa) {
		super();
		this.id = id;
		this.kid = kid;
		this.sdtnguoigui = sdtnguoigui;
		this.hoten = hoten;
		this.diachi = diachi;
		this.idphuongxa = idphuongxa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
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
		return "DiaChiLayHangMacDinh [id=" + id + ", kid=" + kid + ", sdtnguoigui=" + sdtnguoigui + ", hoten=" + hoten
				+ ", diachi=" + diachi + ", idphuongxa=" + idphuongxa + "]";
	}
	
}
