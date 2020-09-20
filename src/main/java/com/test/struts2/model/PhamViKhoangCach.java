package com.test.struts2.model;

public class PhamViKhoangCach {
	private int kcode;
	private int nquanhuyen;
	private int gquanhuyen;
	private int km;
	public PhamViKhoangCach() {
		super();
	}
	public PhamViKhoangCach(int kcode, int nquanhuyen, int gquanhuyen, int km) {
		super();
		this.kcode = kcode;
		this.nquanhuyen = nquanhuyen;
		this.gquanhuyen = gquanhuyen;
		this.km = km;
	}
	public int getKcode() {
		return kcode;
	}
	public void setKcode(int kcode) {
		this.kcode = kcode;
	}
	public int getNquanhuyen() {
		return nquanhuyen;
	}
	public void setNquanhuyen(int nquanhuyen) {
		this.nquanhuyen = nquanhuyen;
	}
	public int getGquanhuyen() {
		return gquanhuyen;
	}
	public void setGquanhuyen(int gquanhuyen) {
		this.gquanhuyen = gquanhuyen;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	@Override
	public String toString() {
		return "PhamViKhoangCach [kcode=" + kcode + ", nquanhuyen=" + nquanhuyen + ", gquanhuyen=" + gquanhuyen
				+ ", km=" + km + "]";
	}
	
}
