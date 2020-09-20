package com.test.struts2.model;

public class PhuongThucVanChuyen {
	private int vid;
	private String goivanchuyen;
	public PhuongThucVanChuyen() {
		super();
	}
	public PhuongThucVanChuyen(int vid, String goivanchuyen) {
		super();
		this.vid = vid;
		this.goivanchuyen = goivanchuyen;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getGoivanchuyen() {
		return goivanchuyen;
	}
	public void setGoivanchuyen(String goivanchuyen) {
		this.goivanchuyen = goivanchuyen;
	}
	@Override
	public String toString() {
		return "PhuongThucVanChuyen [vid=" + vid + ", goivanchuyen=" + goivanchuyen + "]";
	}
	
}
