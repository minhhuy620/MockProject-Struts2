package com.test.struts2.model;

public class DiaChiNhanHang {
	private int madiachi;
	private String sdtnguoinhan;
	private String hoten;
	private String diachi;
	private int idphuongxa;
	public DiaChiNhanHang() {
		super();
	}
	public DiaChiNhanHang(int madiachi, String sdtnguoinhan, String hoten, String diachi, int idphuongxa) {
		super();
		this.madiachi = madiachi;
		this.sdtnguoinhan = sdtnguoinhan;
		this.hoten = hoten;
		this.diachi = diachi;
		this.idphuongxa = idphuongxa;
	}
	public DiaChiNhanHang(String sdtnguoinhan, String hoten, String diachi, int idphuongxa) {
		this.sdtnguoinhan = sdtnguoinhan;
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
	public String getSdtnguoinhan() {
		return sdtnguoinhan;
	}
	public void setSdtnguoinhan(String sdtnguoinhan) {
		this.sdtnguoinhan = sdtnguoinhan;
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
		return "DiaChiNhanHang [madiachi=" + madiachi + ", sdtnguoinhan=" + sdtnguoinhan + ", hoten=" + hoten
				+ ", diachi=" + diachi + ", idphuongxa=" + idphuongxa + "]";
	}
	
}
