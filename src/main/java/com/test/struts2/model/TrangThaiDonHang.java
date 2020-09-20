package com.test.struts2.model;

public class TrangThaiDonHang {
	private int ttdhid;
	private String trangthaidonhang;
	
	public TrangThaiDonHang() {
		super();
	}

	public TrangThaiDonHang(int ttdhid, String trangthaidonhang) {
		super();
		this.ttdhid = ttdhid;
		this.trangthaidonhang = trangthaidonhang;
	}

	public int getTtdhid() {
		return ttdhid;
	}

	public void setTtdhid(int ttdhid) {
		this.ttdhid = ttdhid;
	}

	public String getTrangthaidonhang() {
		return trangthaidonhang;
	}

	public void setTrangthaidonhang(String trangthaidonhang) {
		this.trangthaidonhang = trangthaidonhang;
	}

	@Override
	public String toString() {
		return "TrangThaiDonHang [ttdhid=" + ttdhid + ", trangthaidonhang=" + trangthaidonhang + "]";
	}
	
}
