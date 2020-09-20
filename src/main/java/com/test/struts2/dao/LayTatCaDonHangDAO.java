package com.test.struts2.dao;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.struts2.model.ThongTinDonHangKhachHang;

public class LayTatCaDonHangDAO implements DBinfo {
	
	
	public ArrayList<ThongTinDonHangKhachHang> getAlldonhangkhachhang(int kid) {
		ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.ngaytaodon,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi,t5.sdt,t5.hoten	 from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join diachi_layhang t3 on t1.lmadiachi = t3.madiachi left join diachi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join shipper t5 on t1.sid = t5.sid where t1.kid ="
							+ kid);
			while (rs.next()) {
				int iddonhang = rs.getInt(1);
				String madonhang = rs.getString(2);
				String tenhanghoa = rs.getString(3);
				Double kluong = rs.getDouble(4);
				String ghichu = rs.getString(5);
				java.sql.Timestamp ngaytaodon = rs.getTimestamp(6);
				Double pvanchuyen = rs.getDouble(7);
				Double pthuho = rs.getDouble(8);
				String trangthaidonhang = rs.getString(9);
				String sdtnguoigui = rs.getString(10);
				String hotennguoigui = rs.getString(11);
				String diachinguoigui = rs.getString(12);
				String sdtnguoinhan = rs.getString(13);
				String hotennguoinhan = rs.getString(14);
				String diachinguoinhan = rs.getString(15);
				String sdtshipper = rs.getString(16);
				String hotenshipper = rs.getString(17);
				arr.add(new ThongTinDonHangKhachHang(iddonhang, madonhang, tenhanghoa, kluong, ghichu, ngaytaodon,
						pvanchuyen, pthuho, trangthaidonhang, sdtnguoigui, hotennguoigui, diachinguoigui, sdtnguoinhan,
						hotennguoinhan, diachinguoinhan, sdtshipper, hotenshipper));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
		}
		return arr;
	}

	public int Demsodonhang(int kid, long ttdhid) {
		int sodonhang = 0;
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("Select count(*) from donhang_khang where ttdhid=" + ttdhid + " and kid=" + kid);
			while (rs.next()) {
				sodonhang = rs.getInt(1);
			}
			con.close();
			return sodonhang;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		}
	}

	public ArrayList<ThongTinDonHangKhachHang> getAlldonhangdahoanthanh(int kid) {
		ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"Select t1.id_donhang,t1.madonhang,t1.sid,t5.hoten,t5.sdt,t5.imgbanglaixe from DonHang_KHang t1 left join shipper t5 on t1.sid = t5.sid left join danhgia_shipper t2 on t1.id_donhang = t2.id_donhang  WHERE not EXISTS (SELECT t2.id_donhang FROM DanhGia_Shipper where t2.id_donhang = t1.id_donhang ) and t1.ttdhid = 5 and t1.kid = "
							+ kid + " ORDER BY t1.ngaytaodon DESC");
			while (rs.next()) {
				int iddonhang = rs.getInt(1);
				String madonhang = rs.getString(2);
				int sid = rs.getInt(3);
				String hotenshipper = rs.getString(4);
				String sdtshipper = rs.getString(5);
				String imgbanglaixe = rs.getString(6);
				arr.add(new ThongTinDonHangKhachHang(iddonhang, madonhang, sid, hotenshipper, sdtshipper,
						imgbanglaixe));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
		}
		return arr;
	}

	public double tongchitieu(int kid) {
		double sodonhang = 0;
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SUM(pvanchuyen) FROM donhang_khang WHERE kid= " + kid);
			while (rs.next()) {
				sodonhang = rs.getDouble(1);
			}
			con.close();
			return sodonhang;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		}
	}
}
