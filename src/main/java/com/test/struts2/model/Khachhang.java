package com.test.struts2.model;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.struts2.dao.KhachHangDAO;

public class Khachhang{
	private int kid;
	private String hoten;
	private String sdt;
	private String email;
	private String matkhau;
	private String diachi;
	private int levels;
	private int lock;

	public Khachhang() {
		super();
	}

	public Khachhang(int kid, String hoten, String sdt, String email, String matkhau, String diachi, int levels,
			int lock) {
		super();
		this.kid = kid;
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.matkhau = matkhau;
		this.diachi = diachi;
		this.levels = levels;
		this.lock = lock;
	}


	public Khachhang(String hoten, String sdt, String email, String matkhau, String diachi) {
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.matkhau = matkhau;
		this.diachi = diachi;
		// TODO Auto-generated constructor stub
	}

	public Khachhang(String hoten, String sdt, String email, String matkhau, String diachi, int levels, int lock) {
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.matkhau = matkhau;
		this.diachi = diachi;
		this.levels = levels;
		this.lock = lock;
		// TODO Auto-generated constructor stub
	}
	public Khachhang(String sdt) {
		Khachhang kh = Khachhang.getUserfromPhone(sdt);
		this.hoten = kh.hoten;
		this.sdt = kh.sdt;
		this.email = kh.email;
		this.diachi = kh.diachi;
		this.lock = kh.lock;
	}

	public Khachhang(String hoten, String email, String diachi) {
		this.hoten = hoten;
		this.email = email;
		this.diachi = diachi;
		// TODO Auto-generated constructor stub
	}
	
	//phan Admin dung Khachhang
		public Khachhang(int kid, String hoten, String sdt, String email, String diachi, int lock) {
			super();
			this.kid = kid;
			this.hoten = hoten;
			this.sdt = sdt;
			this.email = email;
			this.diachi = diachi;
			this.lock = lock;
		}
	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}


	public int getLock() {
		return lock;
	}

	public void setLock(int lock) {
		this.lock = lock;
	}
	public static Khachhang forgot(String sdt, String mail){
        Khachhang s = new Khachhang(sdt);
        if( s.email.equals(mail)){
            return s;
        } else {
            return null;
        }
    }
	public static Khachhang getUserfromPhone(String sdt) {
		Khachhang s = null;
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select kid, hoten,email,matkhau,diachi,levels,lock from Khachhang where sdt='" + sdt + "'");
            if (rs.next()) {
            	int kid = rs.getInt(1);
                String hoten = rs.getString(2);
                String email = rs.getString(3);
                String passs = rs.getString(4);
                String diachi = rs.getString(5);
                int levels = rs.getInt(6);
                int lock = rs.getInt(7);
                String sdtt = sdt;
                s = new Khachhang(kid, hoten, sdtt, email, passs, diachi,levels,lock);
            }
            con.close();
            return s;
        } catch (Exception ex) {
            Logger.getLogger(Khachhang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
	@Override
	public String toString() {
		return "Khachhang [kid=" + kid + ", hoten=" + hoten + ", sdt=" + sdt + ", email=" + email + ", matkhau="
				+ matkhau + ", diachi=" + diachi + ", levels=" + levels + ", lock=" + lock + "]";
	}


	
}
