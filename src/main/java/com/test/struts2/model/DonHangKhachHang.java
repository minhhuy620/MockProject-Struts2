package com.test.struts2.model;

import java.sql.Timestamp;

public class DonHangKhachHang {
	private int iddonhang;
	private String madonhang;
	private String tenhanghoa;
	private double kluong;
	private String ghichu;
	private Timestamp ngaytaodon;
	private double pvanchuyen;
	private double pthuho;
	private int ttdhid;
	private int nmadiachi;
	private int lmadiachi;
	private int lid;
	private int tid;
	private int sid;
	private int vid;
	private int kid;
	public DonHangKhachHang() {
		super();
	}
	public DonHangKhachHang(int iddonhang, String madonhang, String tenhanghoa, double kluong, String ghichu,
			Timestamp ngaytaodon, double pvanchuyen, double pthuho, int ttdhid, int nmadiachi, int lmadiachi, int lid,
			int tid, int sid, int vid, int kid) {
		super();
		this.iddonhang = iddonhang;
		this.madonhang = madonhang;
		this.tenhanghoa = tenhanghoa;
		this.kluong = kluong;
		this.ghichu = ghichu;
		this.ngaytaodon = ngaytaodon;
		this.pvanchuyen = pvanchuyen;
		this.pthuho = pthuho;
		this.ttdhid = ttdhid;
		this.nmadiachi = nmadiachi;
		this.lmadiachi = lmadiachi;
		this.lid = lid;
		this.tid = tid;
		this.sid = sid;
		this.vid = vid;
		this.kid = kid;
	}
	public DonHangKhachHang(int sid,int ttdhid) {
		super();
		this.ttdhid = ttdhid;
		this.sid = sid;
	}
	public DonHangKhachHang(String tenhanghoa, double kluong, String ghichu, double pvanchuyen,
			double pthuho, int lid, int tid, int vid, int kid) {
		super();
		this.tenhanghoa = tenhanghoa;
		this.kluong = kluong;
		this.ghichu = ghichu;
		this.pvanchuyen = pvanchuyen;
		this.pthuho = pthuho;
		this.lid = lid;
		this.tid = tid;
		this.vid = vid;
		this.kid = kid;
		
	}
	public int getIddonhang() {
		return iddonhang;
	}
	public void setIddonhang(int iddonhang) {
		this.iddonhang = iddonhang;
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
	public double getKluong() {
		return kluong;
	}
	public void setKluong(double kluong) {
		this.kluong = kluong;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public Timestamp getNgaytaodon() {
		return ngaytaodon;
	}
	public void setNgaytaodon(Timestamp ngaytaodon) {
		this.ngaytaodon = ngaytaodon;
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
	public int getTtdhid() {
		return ttdhid;
	}
	public void setTtdhid(int ttdhid) {
		this.ttdhid = ttdhid;
	}
	public int getNmadiachi() {
		return nmadiachi;
	}
	public void setNmadiachi(int nmadiachi) {
		this.nmadiachi = nmadiachi;
	}
	public int getLmadiachi() {
		return lmadiachi;
	}
	public void setLmadiachi(int lmadiachi) {
		this.lmadiachi = lmadiachi;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	@Override
	public String toString() {
		return "DonHangKhachHang [iddonhang=" + iddonhang + ", madonhang=" + madonhang + ", tenhanghoa=" + tenhanghoa
				+ ", kluong=" + kluong + ", ghichu=" + ghichu + ", ngaytaodon=" + ngaytaodon + ", pvanchuyen="
				+ pvanchuyen + ", pthuho=" + pthuho + ", ttdhid=" + ttdhid + ", nmadiachi=" + nmadiachi + ", lmadiachi="
				+ lmadiachi + ", lid=" + lid + ", tid=" + tid + ", sid=" + sid + ", vid=" + vid + ", kid=" + kid + "]";
	}
    public String randommdh() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            int index
                    = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}
