package com.test.struts2.model;

import java.sql.Timestamp;

public class ThongTinDonHangKhachHang {
	private int iddonhang ,sid;
	private double kluong, pvanchuyen, pthuho;
	private String madonhang, tenhanghoa, ghichu, trangthaidonhang, sdtnguoigui, hotennguoigui, diachinguoigui,
			sdtnguoinhan, hotennguoinhan, diachinguoinhan, sdtshipper, hotenshipper,imgbanglaixe,imgcmnd;
	private java.sql.Timestamp ngaytaodon;
	private int lid;
	private String hotenuser;

	public ThongTinDonHangKhachHang(int iddonhang, double kluong, double pvanchuyen, double pthuho, String madonhang,
			String tenhanghoa, String ghichu, String trangthaidonhang, String sdtnguoigui, String hotennguoigui,
			String diachinguoigui, String sdtnguoinhan, String hotennguoinhan, String diachinguoinhan,
			String sdtshipper, String hotenshipper, java.sql.Timestamp ngaytaodon) {
		super();
		this.iddonhang = iddonhang;
		this.kluong = kluong;
		this.pvanchuyen = pvanchuyen;
		this.pthuho = pthuho;
		this.madonhang = madonhang;
		this.tenhanghoa = tenhanghoa;
		this.ghichu = ghichu;
		this.trangthaidonhang = trangthaidonhang;
		this.sdtnguoigui = sdtnguoigui;
		this.hotennguoigui = hotennguoigui;
		this.diachinguoigui = diachinguoigui;
		this.sdtnguoinhan = sdtnguoinhan;
		this.hotennguoinhan = hotennguoinhan;
		this.diachinguoinhan = diachinguoinhan;
		this.sdtshipper = sdtshipper;
		this.hotenshipper = hotenshipper;
		this.ngaytaodon = ngaytaodon;
	}

	public ThongTinDonHangKhachHang(int iddonhang, String madonhang, String tenhanghoa, double kluong, String ghichu,
			java.sql.Timestamp ngaytaodon, double pvanchuyen, double pthuho, String trangthaidonhang,
			String sdtnguoigui, String hotennguoigui, String diachinguoigui, String sdtnguoinhan, String hotennguoinhan,
			String diachinguoinhan, String sdtshipper, String hotenshipper) {
		this.iddonhang = iddonhang;
		this.madonhang = madonhang;
		this.tenhanghoa = tenhanghoa;
		this.kluong = kluong;
		this.ghichu = ghichu;
		this.ngaytaodon = ngaytaodon;
		this.pvanchuyen = pvanchuyen;
		this.pthuho = pthuho;
		this.trangthaidonhang = trangthaidonhang;
		this.sdtnguoigui = sdtnguoigui;
		this.hotennguoigui = hotennguoigui;
		this.diachinguoigui = diachinguoigui;
		this.sdtnguoinhan = sdtnguoinhan;
		this.hotennguoinhan = hotennguoinhan;
		this.diachinguoinhan = diachinguoinhan;
		this.sdtshipper = sdtshipper;
		this.hotenshipper = hotenshipper;
		// TODO Auto-generated constructor stub
	}

	public ThongTinDonHangKhachHang(int iddonhang, String madonhang, String tenhanghoa, double kluong, String ghichu,
			java.sql.Timestamp ngaytaodon, double pvanchuyen, double pthuho, String trangthaidonhang,
			String sdtnguoigui, String hotennguoigui, String diachinguoigui, String sdtnguoinhan, String hotennguoinhan,
			String diachinguoinhan, String sdtshipper, String hotenshipper,String hotenuser) {
		this.iddonhang = iddonhang;
		this.madonhang = madonhang;
		this.tenhanghoa = tenhanghoa;
		this.kluong = kluong;
		this.ghichu = ghichu;
		this.ngaytaodon = ngaytaodon;
		this.pvanchuyen = pvanchuyen;
		this.pthuho = pthuho;
		this.trangthaidonhang = trangthaidonhang;
		this.sdtnguoigui = sdtnguoigui;
		this.hotennguoigui = hotennguoigui;
		this.diachinguoigui = diachinguoigui;
		this.sdtnguoinhan = sdtnguoinhan;
		this.hotennguoinhan = hotennguoinhan;
		this.diachinguoinhan = diachinguoinhan;
		this.sdtshipper = sdtshipper;
		this.hotenshipper = hotenshipper;
		this.hotenuser = hotenuser;
		// TODO Auto-generated constructor stub
	}
	
	public ThongTinDonHangKhachHang(int iddonhang, String madonhang, String tenhanghoa, double kluong, String ghichu,
			double pvanchuyen, double pthuho, String trangthaidonhang, String sdtnguoigui, String hotennguoigui,
			String diachinguoigui, String sdtnguoinhan, String hotennguoinhan, String diachinguoinhan) {
		this.iddonhang = iddonhang;
		this.madonhang = madonhang;
		this.tenhanghoa = tenhanghoa;
		this.kluong = kluong;
		this.ghichu = ghichu;
		this.pvanchuyen = pvanchuyen;
		this.pthuho = pthuho;
		this.trangthaidonhang = trangthaidonhang;
		this.sdtnguoigui = sdtnguoigui;
		this.hotennguoigui = hotennguoigui;
		this.diachinguoigui = diachinguoigui;
		this.sdtnguoinhan = sdtnguoinhan;
		this.hotennguoinhan = hotennguoinhan;
		this.diachinguoinhan = diachinguoinhan;
	}
	public ThongTinDonHangKhachHang(int iddonhang, String madonhang, String tenhanghoa, double kluong, String ghichu,
			Timestamp ngaytaodon,double pvanchuyen, double pthuho, String trangthaidonhang, String sdtnguoigui, String hotennguoigui,
			String diachinguoigui, String sdtnguoinhan, String hotennguoinhan, String diachinguoinhan, String hotenuser) {
		this.iddonhang = iddonhang;
		this.madonhang = madonhang;
		this.tenhanghoa = tenhanghoa;
		this.kluong = kluong;
		this.ghichu = ghichu;
		this.pvanchuyen = pvanchuyen;
		this.pthuho = pthuho;
		this.trangthaidonhang = trangthaidonhang;
		this.sdtnguoigui = sdtnguoigui;
		this.hotennguoigui = hotennguoigui;
		this.diachinguoigui = diachinguoigui;
		this.sdtnguoinhan = sdtnguoinhan;
		this.hotennguoinhan = hotennguoinhan;
		this.diachinguoinhan = diachinguoinhan;
		this.ngaytaodon =ngaytaodon;
		this.hotenuser = hotenuser;
	}
	
	

	public ThongTinDonHangKhachHang(int iddonhang, String madonhang, int sid, String sdtshipper, String hotenshipper,
			String imgbanglaixe) {
		super();
		this.iddonhang = iddonhang;
		this.madonhang = madonhang;
		this.sid = sid;
		this.sdtshipper = sdtshipper;
		this.hotenshipper = hotenshipper;
		this.imgbanglaixe = imgbanglaixe;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getImgbanglaixe() {
		return imgbanglaixe;
	}

	public void setImgbanglaixe(String imgbanglaixe) {
		this.imgbanglaixe = imgbanglaixe;
	}

	public String getImgcmnd() {
		return imgcmnd;
	}

	public void setImgcmnd(String imgcmnd) {
		this.imgcmnd = imgcmnd;
	}

	public String getHotenuser() {
		return hotenuser;
	}

	public void setHotenuser(String hotenuser) {
		this.hotenuser = hotenuser;
	}

	public int getIddonhang() {
		return iddonhang;
	}

	public void setIddonhang(int iddonhang) {
		this.iddonhang = iddonhang;
	}

	public double getKluong() {
		return kluong;
	}

	public void setKluong(double kluong) {
		this.kluong = kluong;
	}

	public double getPvanchuyen() {
		return pvanchuyen;
	}

	public void setPvanchuyen(double pvanchuyen) {
		this.pvanchuyen = pvanchuyen;
	}

	public double getPthuho() {
		return pthuho;
	}

	public void setPthuho(double pthuho) {
		this.pthuho = pthuho;
	}

	public String getMadonhang() {
		return madonhang;
	}

	public void setMadonhang(String madonhang) {
		this.madonhang = madonhang;
	}

	public String getTenhanghoa() {
		return tenhanghoa;
	}

	public void setTenhanghoa(String tenhanghoa) {
		this.tenhanghoa = tenhanghoa;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public String getTrangthaidonhang() {
		return trangthaidonhang;
	}

	public void setTrangthaidonhang(String trangthaidonhang) {
		this.trangthaidonhang = trangthaidonhang;
	}

	public String getSdtnguoigui() {
		return sdtnguoigui;
	}

	public void setSdtnguoigui(String sdtnguoigui) {
		this.sdtnguoigui = sdtnguoigui;
	}

	public String getHotennguoigui() {
		return hotennguoigui;
	}

	public void setHotennguoigui(String hotennguoigui) {
		this.hotennguoigui = hotennguoigui;
	}

	public String getDiachinguoigui() {
		return diachinguoigui;
	}

	public void setDiachinguoigui(String diachinguoigui) {
		this.diachinguoigui = diachinguoigui;
	}

	public String getSdtnguoinhan() {
		return sdtnguoinhan;
	}

	public void setSdtnguoinhan(String sdtnguoinhan) {
		this.sdtnguoinhan = sdtnguoinhan;
	}

	public String getHotennguoinhan() {
		return hotennguoinhan;
	}

	public void setHotennguoinhan(String hotennguoinhan) {
		this.hotennguoinhan = hotennguoinhan;
	}

	public String getDiachinguoinhan() {
		return diachinguoinhan;
	}

	public void setDiachinguoinhan(String diachinguoinhan) {
		this.diachinguoinhan = diachinguoinhan;
	}

	public String getSdtshipper() {
		return sdtshipper;
	}

	public void setSdtshipper(String sdtshipper) {
		this.sdtshipper = sdtshipper;
	}

	public String getHotenshipper() {
		return hotenshipper;
	}

	public void setHotenshipper(String hotenshipper) {
		this.hotenshipper = hotenshipper;
	}

	public java.sql.Timestamp getNgaytaodon() {
		return ngaytaodon;
	}

	public void setNgaytaodon(java.sql.Timestamp ngaytaodon) {
		this.ngaytaodon = ngaytaodon;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	@Override
	public String toString() {
		return "ThongTinDonHangKhachHang [iddonhang=" + iddonhang + ", kluong=" + kluong + ", pvanchuyen=" + pvanchuyen
				+ ", pthuho=" + pthuho + ", madonhang=" + madonhang + ", tenhanghoa=" + tenhanghoa + ", ghichu="
				+ ghichu + ", trangthaidonhang=" + trangthaidonhang + ", sdtnguoigui=" + sdtnguoigui
				+ ", hotennguoigui=" + hotennguoigui + ", diachinguoigui=" + diachinguoigui + ", sdtnguoinhan="
				+ sdtnguoinhan + ", hotennguoinhan=" + hotennguoinhan + ", diachinguoinhan=" + diachinguoinhan
				+ ", sdtshipper=" + sdtshipper + ", hotenshipper=" + hotenshipper + ", ngaytaodon=" + ngaytaodon + "]";
	}

}
