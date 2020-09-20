package com.test.struts2.model;

public class DanhGiaShipper {
	private int iddanhgia;
	private int sao;
	private int kid;
	private int sid;
	private String comment;
	private String hotenkhach;
	private String madonhang;
	public DanhGiaShipper() {
		super();
	}
	public DanhGiaShipper(int iddanhgia, int sao, int kid, int sid, String comment) {
		super();
		this.iddanhgia = iddanhgia;
		this.sao = sao;
		this.kid = kid;
		this.sid = sid;
		this.comment = comment;
	}
	public DanhGiaShipper(int sao, String comment, String hotenkhach, String madonhang) {
		super();
		this.sao = sao;
		this.comment = comment;
		this.hotenkhach = hotenkhach;
		this.madonhang = madonhang;
	}
	public String getMadonhang() {
		return madonhang;
	}
	public void setMadonhang(String madonhang) {
		this.madonhang = madonhang;
	}
	public String getHotenkhach() {
		return hotenkhach;
	}
	public void setHotenkhach(String hotenkhach) {
		this.hotenkhach = hotenkhach;
	}
	public int getIddanhgia() {
		return iddanhgia;
	}
	public void setIddanhgia(int iddanhgia) {
		this.iddanhgia = iddanhgia;
	}
	public int getSao() {
		return sao;
	}
	public void setSao(int sao) {
		this.sao = sao;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "DanhGiaShipper [iddanhgia=" + iddanhgia + ", sao=" + sao + ", kid=" + kid + ", sid=" + sid
				+ ", comment=" + comment + "]";
	}
	
}
