package com.test.struts2.model;

public class Admin {
	private int aid;
	private String hoten;
	private String sdt;
	private String email;
	private String matkhau;
	
	public Admin() {
		super();
	}

	public Admin(String sdt, String matkhau) {
		super();
		this.sdt = sdt;
		this.matkhau = matkhau;
	}
	
	public Admin(String hoten, String sdt, String email, String matkhau) {
		super();
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.matkhau = matkhau;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", hoten=" + hoten + ", sdt=" + sdt + ", email=" + email + ", matkhau=" + matkhau
				+ "]";
	}

	
	
}
