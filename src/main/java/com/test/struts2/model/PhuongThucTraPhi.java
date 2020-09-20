package com.test.struts2.model;

public class PhuongThucTraPhi {
	private int tid;
	private String nguoitraphi;
	public PhuongThucTraPhi() {
		super();
	}
	public PhuongThucTraPhi(int tid, String nguoitraphi) {
		super();
		this.tid = tid;
		this.nguoitraphi = nguoitraphi;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getNguoitraphi() {
		return nguoitraphi;
	}
	public void setNguoitraphi(String nguoitraphi) {
		this.nguoitraphi = nguoitraphi;
	}
	@Override
	public String toString() {
		return "PhuongThucTraPhi [tid=" + tid + ", nguoitraphi=" + nguoitraphi + "]";
	}
	
}
