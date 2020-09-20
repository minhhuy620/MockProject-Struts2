package com.test.struts2.dao;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.struts2.model.Khachhang;

public class KhachHangDAO implements DBinfo{

	public boolean addNewKhachHang(Khachhang s) {
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con.prepareStatement("Insert into KhachHang(hoten,SDT,email,matkhau,diachi) values(?,?,?,?,?)");
			stmt.setString(1, s.getHoten());
			stmt.setString(2, s.getSdt());
			stmt.setString(3, s.getEmail());
			stmt.setString(4, s.getMatkhau());
			stmt.setString(5, s.getDiachi());
			stmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(Khachhang.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		return true;
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
	
	public static Khachhang dangnhap(String sdt, String password) {
		try {
			Khachhang s = getUserfromPhone(sdt);
	        if (s.getMatkhau().equals(password)) {
	            return s;
	        } else {
	            return null;
	        }
		} catch (Exception e) {
			return null;
		}
    }
	
	public static boolean updateKhachhang(String hoten, String email, String diachi, int kid) {
        try {
        	Connection con = getConnectDB();
            PreparedStatement stmt = con.prepareStatement("Update Khachhang set hoten=?,email=?,diachi=? where kid="+kid);
            stmt.setString(1, hoten);
            stmt.setString(2, email);
            stmt.setString(3, diachi);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public static boolean updatePass(String sdt, String matkhau) {
        try {
        	Connection con = getConnectDB();
            PreparedStatement stmt = con.prepareStatement("Update Khachhang set matkhau=? where sdt='"+sdt+"'");
            stmt.setString(1, matkhau);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
    public boolean changePass(String sdt,  String oldP, String newP) {
    	Khachhang s = getUserfromPhone(sdt);
        if (s.getMatkhau().equals(oldP)) {
        	updatePass(sdt, newP);
            return true;
    	}
        return false;
    }
    public boolean forgotPass(String sdt, String newP) {
        	updatePass(sdt, newP);
        return true;
    }
	public static void main(String[] args) {
	}
}
