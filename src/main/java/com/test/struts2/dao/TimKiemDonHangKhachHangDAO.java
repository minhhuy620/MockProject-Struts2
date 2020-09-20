package com.test.struts2.dao;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.struts2.model.ThongTinDonHangKhachHang;

public class TimKiemDonHangKhachHangDAO implements DBinfo {
    
	public ArrayList<ThongTinDonHangKhachHang> getDonhangkhachhang_madonhang(int kid, String madonhang) {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.ngaytaodon,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi,t5.sdt,t5.hoten	 from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join DiaChi_layhang t3 on t1.lmadiachi = t3.madiachi left join DiaChi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join Shipper t5 on t1.sid = t5.sid where t1.madonhang = '"+madonhang+"' and t1.kid ="+kid);
            while (rs.next()) {
            	int iddonhang = rs.getInt(1);
                String madonhang2 = rs.getString(2);
                String tenhanghoa = rs.getString(3);
                double kluong = rs.getDouble(4);
                String ghichu = rs.getString(5);
                java.sql.Timestamp ngaytaodon = rs.getTimestamp(6);
                double pvanchuyen = rs.getDouble(7);
                double pthuho = rs.getDouble(8);
                String trangthaidonhang = rs.getString(9);
                String sdtnguoigui = rs.getString(10);
                String hotennguoigui = rs.getString(11);
                String diachinguoigui = rs.getString(12);
                String sdtnguoinhan = rs.getString(13);
                String hotennguoinhan = rs.getString(14);
                String diachinguoinhan = rs.getString(15);
                String sdtshipper = rs.getString(16);
                String hotenshipper = rs.getString(17);
                arr.add(new ThongTinDonHangKhachHang(iddonhang, madonhang2,tenhanghoa,kluong,ghichu,ngaytaodon,pvanchuyen,pthuho,trangthaidonhang,sdtnguoigui,hotennguoigui,diachinguoigui,sdtnguoinhan,hotennguoinhan,diachinguoinhan,sdtshipper,hotenshipper));
            }   
            con.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
            Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
	
	
	
	public ArrayList<ThongTinDonHangKhachHang> getDonhangkhachhang_ngaytaodon(int kid, String ngaytaodonfrom, String ngaytaodonto) {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.ngaytaodon,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi,t5.sdt,t5.hoten	 from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join DiaChi_layhang t3 on t1.lmadiachi = t3.madiachi left join DiaChi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join Shipper t5 on t1.sid = t5.sid where t1.ngaytaodon between '"+ngaytaodonfrom+"' and DATEADD(DAY, 1, '"+ngaytaodonto+"') and kid ="+kid);
            while (rs.next()) {
            	int iddonhang = rs.getInt(1);
                String madonhang2 = rs.getString(2);
                String tenhanghoa = rs.getString(3);
                double kluong = rs.getDouble(4);
                String ghichu = rs.getString(5);
                java.sql.Timestamp ngaytaodon = rs.getTimestamp(6);
                double pvanchuyen = rs.getDouble(7);
                double pthuho = rs.getDouble(8);
                String trangthaidonhang = rs.getString(9);
                String sdtnguoigui = rs.getString(10);
                String hotennguoigui = rs.getString(11);
                String diachinguoigui = rs.getString(12);
                String sdtnguoinhan = rs.getString(13);
                String hotennguoinhan = rs.getString(14);
                String diachinguoinhan = rs.getString(15);
                String sdtshipper = rs.getString(16);
                String hotenshipper = rs.getString(17);
                arr.add(new ThongTinDonHangKhachHang(iddonhang, madonhang2,tenhanghoa,kluong,ghichu,ngaytaodon,pvanchuyen,pthuho,trangthaidonhang,sdtnguoigui,hotennguoigui,diachinguoigui,sdtnguoinhan,hotennguoinhan,diachinguoinhan,sdtshipper,hotenshipper));
            }   
            con.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
            Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
	public ArrayList<ThongTinDonHangKhachHang> getDonhangkhachhang_trangthaidonhang(int kid, int ttdhid) {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join DiaChi_layhang t3 on t1.lmadiachi = t3.madiachi left join DiaChi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join Shipper t5 on t1.sid = t5.sid where t1.ttdhid = '"+ttdhid+"' and t1.kid ="+kid);
            while (rs.next()) {
            	int iddonhang = rs.getInt(1);
                String madonhang = rs.getString(2);
                String tenhanghoa = rs.getString(3);
                double kluong = rs.getDouble(4);
                String ghichu = rs.getString(5);
                double pvanchuyen = rs.getDouble(6);
                double pthuho = rs.getDouble(7);
                String trangthaidonhang = rs.getString(8);
                String sdtnguoigui = rs.getString(9);
                String hotennguoigui = rs.getString(10);
                String diachinguoigui = rs.getString(11);
                String sdtnguoinhan = rs.getString(12);
                String hotennguoinhan = rs.getString(13);
                String diachinguoinhan = rs.getString(14);
                arr.add(new ThongTinDonHangKhachHang(iddonhang, madonhang,tenhanghoa,kluong,ghichu,pvanchuyen,pthuho,trangthaidonhang,sdtnguoigui,hotennguoigui,diachinguoigui,sdtnguoinhan,hotennguoinhan,diachinguoinhan));
            }   
            con.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
            Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
	
	public ArrayList<ThongTinDonHangKhachHang> getDonhangmadonhangtushipper(int sid, String madonhang) {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.ngaytaodon,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi,t5.sdt,t5.hoten	 from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join DiaChi_layhang t3 on t1.lmadiachi = t3.madiachi left join DiaChi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join Shipper t5 on t1.sid = t5.sid where t1.madonhang = '"+madonhang+"' and t1.sid ="+sid);
            while (rs.next()) {
            	int iddonhang = rs.getInt(1);
                String madonhang2 = rs.getString(2);
                String tenhanghoa = rs.getString(3);
                double kluong = rs.getDouble(4);
                String ghichu = rs.getString(5);
                java.sql.Timestamp ngaytaodon = rs.getTimestamp(6);
                double pvanchuyen = rs.getDouble(7);
                double pthuho = rs.getDouble(8);
                String trangthaidonhang = rs.getString(9);
                String sdtnguoigui = rs.getString(10);
                String hotennguoigui = rs.getString(11);
                String diachinguoigui = rs.getString(12);
                String sdtnguoinhan = rs.getString(13);
                String hotennguoinhan = rs.getString(14);
                String diachinguoinhan = rs.getString(15);
                String sdtshipper = rs.getString(16);
                String hotenshipper = rs.getString(17);
                arr.add(new ThongTinDonHangKhachHang(iddonhang, madonhang2,tenhanghoa,kluong,ghichu,ngaytaodon,pvanchuyen,pthuho,trangthaidonhang,sdtnguoigui,hotennguoigui,diachinguoigui,sdtnguoinhan,hotennguoinhan,diachinguoinhan,sdtshipper,hotenshipper));
            }   
            con.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
            Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
	
	public static void main(String[] args) {
//		TimKiemDonHangKhachHangDAO dao = new TimKiemDonHangKhachHangDAO();
//		System.out.println(dao.getDonhangkhachhang_ngaytaodon(1, "2020-08-24", "2020-08-27"));
	}
}
