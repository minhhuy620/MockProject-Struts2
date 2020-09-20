package com.test.struts2.dao;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.struts2.model.DiaChiLayHang;
import com.test.struts2.model.DiaChiNhanHang;
import com.test.struts2.model.DonHangKhachHang;

public class TaoDonHangDAO implements DBinfo {
    
    public boolean addNewDiaChiLayHang(DiaChiLayHang s) {
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con.prepareStatement("Insert into diachi_layhang(sdtnguoigui,hoten,diachi,id_phuong_xa) values(?,?,?,?)");
			stmt.setString(1, s.getSdtnguoigui());
			stmt.setString(2, s.getHoten());
			stmt.setString(3, s.getDiachi());
			stmt.setInt(4, s.getIdphuongxa());
			stmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(DiaChiLayHang.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		return true;
	}
    public boolean addNewDiaChiNhanHang(DiaChiNhanHang s) {
    	try {
    		Connection con = getConnectDB();
    		PreparedStatement stmt = con.prepareStatement("Insert into diachi_nhanhang(sdtnguoinhan,hoten,diachi,id_phuong_xa) values(?,?,?,?)");
    		stmt.setString(1, s.getSdtnguoinhan());
    		stmt.setString(2, s.getHoten());
    		stmt.setString(3, s.getDiachi());
    		stmt.setInt(4, s.getIdphuongxa());
    		stmt.executeUpdate();
    		con.close();
    	} catch (Exception ex) {
    		Logger.getLogger(DiaChiNhanHang.class.getName()).log(Level.SEVERE, null, ex);
    		return false;
    	}
    	return true;
    }
    public boolean addNewDonHang(DonHangKhachHang s) {
    	try {
    		Connection con = getConnectDB();
    		Statement stmt = con.createStatement();
    		Statement stmt1 = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT top(1)madiachi FROM DiaChi_nhanhang ORDER BY madiachi DESC");
            ResultSet rs1 = stmt1.executeQuery("SELECT top(1)madiachi FROM DiaChi_layhang ORDER BY madiachi DESC");
            if(rs.next() && rs1.next()) {
            	int Nmdc = rs.getInt(1);
            	int Lmdc = rs1.getInt(1);
    		PreparedStatement stmt2 = con.prepareStatement("Insert into DonHang_KHang(madonhang,tenhanghoa,kluong,ghichu,Pvanchuyen,Pthuho,lid,tid,vid,kid,Nmadiachi,Lmadiachi) values (?,?,?,?,?,?,?,?,?,?,?,?)");
    		stmt2.setString(1, s.randommdh());
    		stmt2.setString(2, s.getTenhanghoa());
    		stmt2.setDouble(3, s.getKluong());
    		stmt2.setString(4, s.getGhichu());
    		stmt2.setDouble(5, s.getPvanchuyen());
    		stmt2.setDouble(6, s.getPthuho());
    		stmt2.setInt(7, s.getLid());
    		stmt2.setInt(8, s.getTid());
    		stmt2.setInt(9, s.getVid());
    		stmt2.setInt(10, s.getKid());
    		stmt2.setInt(11, Nmdc);
    		stmt2.setInt(12, Lmdc);
    		stmt2.executeUpdate();
            }
    		con.close();
    	} catch (Exception ex) {
    		Logger.getLogger(DonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
    		return false;
    	}
    	return true;
    }
public static void main(String[] args) {
//	DonHangKhachHang a = new DonHangKhachHang("fasf",322.33,"fsf",23.33,232.33,1,1,1,1);
//	TaoDonHangDAO dao= new TaoDonHangDAO();
//	System.out.println(dao.addNewDiaChiLayHang(new DiaChiLayHang("0123456789","Ngo","39 nguye nthuat",3)));
}
    
}
