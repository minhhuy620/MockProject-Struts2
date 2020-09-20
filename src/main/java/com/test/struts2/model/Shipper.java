package com.test.struts2.model;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Shipper{
	
	private int sid;
	private String hoten;
	private String sdt;
	private String email;
	private String matkhau;
	private String diachi;
	private String stknganhang;
	private int lid;
	private String biensoxe;
	private String imgcmnd;
	private String imgbanglaixe;
	private int lock;
	
	public Shipper() {
		super();
	}

	
	
	public Shipper(String sdt) {
		Shipper sh = Shipper.getShipperfromPhone(sdt);
		this.hoten = sh.hoten;
		this.sdt = sh.sdt;
		this.email = sh.email;
		this.diachi = sh.diachi;
		this.lock = sh.lock;
	}

	public Shipper(int sid, String hoten, String sdt, String email, String matkhau, String diachi, String stknganhang,
			int lid, String biensoxe, String imgcmnd, String imgbanglaixe, int lock) {
		super();
		this.sid = sid;
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.matkhau = matkhau;
		this.diachi = diachi;
		this.stknganhang = stknganhang;
		this.lid = lid;
		this.biensoxe = biensoxe;
		this.imgcmnd = imgcmnd;
		this.imgbanglaixe = imgbanglaixe;
		this.lock = lock;
	}
	public Shipper(String hoten, String sdt, String email, String matkhau, String diachi, String stknganhang,
			int lid, String biensoxe, String imgcmnd, String imgbanglaixe) {
		super();
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.matkhau = matkhau;
		this.diachi = diachi;
		this.stknganhang = stknganhang;
		this.lid = lid;
		this.biensoxe = biensoxe;
		this.imgcmnd = imgcmnd;
		this.imgbanglaixe = imgbanglaixe;
	}
	public Shipper(int sid, String hoten, String sdt, String email, String matkhau, String diachi, String stknganhang,
			int lid, String biensoxe,int lock) {
		super();
		this.sid = sid;
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.matkhau = matkhau;
		this.diachi = diachi;
		this.stknganhang = stknganhang;
		this.lid = lid;
		this.biensoxe = biensoxe;
		this.lock = lock;
	}
	public Shipper(int sid, String hoten, String sdt, String email, String diachi, String stknganhang,
			String biensoxe, String imgcmnd, String imgbanglaixe) {
		super();
		this.sid = sid;
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.diachi = diachi;
		this.stknganhang = stknganhang;
		this.biensoxe = biensoxe;
		this.imgcmnd = imgcmnd;
		this.imgbanglaixe = imgbanglaixe;
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public String getStknganhang() {
		return stknganhang;
	}

	public void setStknganhang(String stknganhang) {
		this.stknganhang = stknganhang;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getBiensoxe() {
		return biensoxe;
	}

	public void setBiensoxe(String biensoxe) {
		this.biensoxe = biensoxe;
	}

	public String getImgcmnd() {
		return imgcmnd;
	}

	public void setImgcmnd(String imgcmnd) {
		this.imgcmnd = imgcmnd;
	}

	public String getImgbanglaixe() {
		return imgbanglaixe;
	}

	public void setImgbanglaixe(String imgbanglaixe) {
		this.imgbanglaixe = imgbanglaixe;
	}

	public int getLock() {
		return lock;
	}

	public void setLock(int lock) {
		this.lock = lock;
	}
	
	public static Shipper getShipperfromPhone(String sdt) {
		Shipper s = null;
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select sid, hoten,email,matkhau,diachi,stkNganHang,lid,biensoxe,lock from Shipper where sdt='" + sdt + "'");
            if (rs.next()) {
            	int sid = rs.getInt(1);
                String hoten = rs.getString(2);
                String email = rs.getString(3);
                String passs = rs.getString(4);
                String diachi = rs.getString(5);
                String stkNganHang = rs.getString(6);
                int lid = rs.getInt(7);
                String biensoxe = rs.getString(8);
                int lock = rs.getInt(9);
                s = new Shipper(sid, hoten, sdt, email, passs, diachi,stkNganHang,lid,biensoxe,lock);
            }
            con.close();
            return s;
        } catch (Exception ex) {
            Logger.getLogger(Shipper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
	public static Shipper forgot(String sdt, String mail){
        Shipper sh = new Shipper(sdt);
        if( sh.email.equals(mail)){
            return sh;
        } else {
            return null;
        }
    }
	@Override
	public String toString() {
		return "Shipper [sid=" + sid + ", hoten=" + hoten + ", sdt=" + sdt + ", email=" + email + ", matkhau=" + matkhau
				+ ", diachi=" + diachi + ", stknganhang=" + stknganhang + ", lid=" + lid + ", biensoxe="
				+ biensoxe + ", imgcmnd=" + imgcmnd + ", imgbanglaixe=" + imgbanglaixe + ", lock=" + lock + "]";
	}

	
	

	
}
