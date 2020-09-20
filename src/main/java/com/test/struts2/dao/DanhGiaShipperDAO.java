package com.test.struts2.dao;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.struts2.model.DanhGiaShipper;
import com.test.struts2.model.Khachhang;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class DanhGiaShipperDAO implements DBinfo{

	public boolean danhgiashipper(int sao, int kid, int sid, String comment, int iddonhang) {
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con.prepareStatement("Insert into Danhgia_shipper(sao,kid,sid,comment,id_donhang) values(?,?,?,?,?)");
			stmt.setInt(1, sao);
			stmt.setInt(2, kid);
			stmt.setInt(3, sid);
			stmt.setString(4, comment);
			stmt.setInt(5, iddonhang);
			stmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(Khachhang.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		return true;
	}
	
	public ArrayList<DanhGiaShipper> getDanhgia(int sid) {
        ArrayList<DanhGiaShipper> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select sao, comment, d.madonhang, k.hoten from DanhGia_Shipper s left join KhachHang k on s.kid = k.kid left join DonHang_KHang d on s.id_donhang=d.id_donhang where s.sid ="+sid);
            while (rs.next()) {
            	int sao = rs.getInt(1);
                String cmt = rs.getString(2);
                String madonhang = rs.getString(3);
                String hotenkhach = rs.getString(4);
                
                arr.add(new DanhGiaShipper(sao, cmt, hotenkhach, madonhang));
            }   
            con.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
            Logger.getLogger(DanhGiaShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
	
}
