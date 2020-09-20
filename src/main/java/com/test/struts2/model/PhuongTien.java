package com.test.struts2.model;

public class PhuongTien extends Shipper{
	private int lid;
	private String loaixe;
	public PhuongTien() {
		super();
	}
	public PhuongTien(int lid, String loaixe) {
		super();
		this.lid = lid;
		this.loaixe = loaixe;
	}
	
	public PhuongTien(int sid, String hoten, String sdt, String email, String diachi,
			String stknganhang, String loaixe,String biensoxe, String imgcmnd, String imgbanglaixe) {
		super(sid, hoten, sdt, email, diachi, stknganhang, biensoxe, imgcmnd, imgbanglaixe);
		this.loaixe = loaixe;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLoaixe() {
		return loaixe;
	}
	public void setLoaixe(String loaixe) {
		this.loaixe = loaixe;
	}
	@Override
	public String toString() {
		return "PhuongTien [lid=" + lid + ", loaixe=" + loaixe + "]";
	}
	
}
