package com.test.struts2.dao;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.test.struts2.model.Admin;
import com.test.struts2.model.Khachhang;
import com.test.struts2.model.PhuongTien;
import com.test.struts2.model.Shipper;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class AdminDAO implements DBinfo {
	
	public ArrayList<Khachhang> listAllUser() {
		ArrayList<Khachhang> v = new ArrayList<Khachhang>();
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con
					.prepareStatement("Select kid,hoten,SDT,email,diachi,lock from KhachHang where lock = 0");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int kid = rs.getInt(1);
				String hoten = rs.getString(2);
				String SDT = rs.getString(3);
				String email = rs.getString(4);
				String diachi = rs.getString(5);
				int lock = rs.getInt(6);
				v.add(new Khachhang(kid, hoten, SDT, email, diachi, lock));
			}
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(Khachhang.class.getName()).log(Level.SEVERE, null, ex);
		}
		return v;
	}

	public ArrayList<Khachhang> listAllUser1() {
		ArrayList<Khachhang> v = new ArrayList<Khachhang>();
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con
					.prepareStatement("Select kid,hoten,SDT,email,diachi,lock from KhachHang where lock = 1");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int kid = rs.getInt(1);
				String hoten = rs.getString(2);
				String SDT = rs.getString(3);
				String email = rs.getString(4);
				String diachi = rs.getString(5);
				int lock = rs.getInt(6);
				v.add(new Khachhang(kid, hoten, SDT, email, diachi, lock));
			}
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(Khachhang.class.getName()).log(Level.SEVERE, null, ex);
		}
		return v;
	}

	public ArrayList<Shipper> listAllShipper() {
		ArrayList<Shipper> v = new ArrayList<Shipper>();
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select s.sid,s.hoten,s.SDT,s.email,s.diachi,s.stkNganHang,t.loaixe,s.biensoxe,s.imgCMND,s.imgBangLaiXe from Shipper s inner join PhuongTien t on s.lid = t.lid where lock = 0");
			while (rs.next()) {
				int sid = rs.getInt(1);
				String hoten = rs.getString(2);
				String SDT = rs.getString(3);
				String email = rs.getString(4);
				String diachi = rs.getString(5);
				String stknganhang = rs.getString(6);
				String lid = rs.getString(7);
				String biensoxe = rs.getString(8);
				String imgcmnd = rs.getString(9);
				String imgblx = rs.getString(10);
				v.add(new PhuongTien(sid, hoten, SDT, email, diachi, stknganhang, lid, biensoxe,imgcmnd,imgblx));
			}
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(Shipper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return v;
	}
	public ArrayList<Shipper> listAllShipper1() {
		ArrayList<Shipper> v = new ArrayList<Shipper>();
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select s.sid,s.hoten,s.SDT,s.email,s.diachi,s.stkNganHang,t.loaixe,s.biensoxe,s.imgCMND,s.imgBangLaiXe  from Shipper s inner join PhuongTien t on s.lid = t.lid where lock = 1");
			while (rs.next()) {
				int sid = rs.getInt(1);
				String hoten = rs.getString(2);
				String SDT = rs.getString(3);
				String email = rs.getString(4);
				String diachi = rs.getString(5);
				String stknganhang = rs.getString(6);
				String lid = rs.getString(7);
				String biensoxe = rs.getString(8);
				String imgcmnd = rs.getString(9);
				String imgblx = rs.getString(10);
				v.add(new PhuongTien(sid, hoten, SDT, email, diachi, stknganhang, lid, biensoxe,imgcmnd,imgblx));
			}
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(Shipper.class.getName()).log(Level.SEVERE, null, ex);
		}
		return v;
	}

	public Admin getAdminfromPhone(String sdt) {
		Admin s = null;
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select hoten,email,matkhau from Admin where sdt='" + sdt + "'");
			if (rs.next()) {
				String hoten = rs.getString(1);
				String email = rs.getString(2);
				String matkhau = rs.getString(3);
				String sdtt = sdt;
				s = new Admin(hoten,sdtt,email,matkhau);
			}
			con.close();
			return s;
		} catch (Exception ex) {
			Logger.getLogger(Khachhang.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public Admin dangnhap(String sdt, String password) {
		try {
			Admin s = getAdminfromPhone(sdt);
			if (s.getMatkhau().equals(password)) {
				return s;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public boolean keyLock(int kid) {
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con.prepareStatement("Update KhachHang set lock=1 where kid='" + kid + "'");
			while (true) {
				int rc = stmt.executeUpdate();
				con.close();
				return rc == 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean keyOpen(int kid) {
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con.prepareStatement("Update KhachHang set lock=0 where kid='" + kid + "'");
			while (true) {
				int rc = stmt.executeUpdate();
				con.close();
				return rc == 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean keyLockShipper(int sid) {
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con.prepareStatement("Update Shipper set lock=1 where sid='" + sid + "'");
			while (true) {
				int rc = stmt.executeUpdate();
				con.close();
				return rc == 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean keyOpenShipper(int sid) {
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con.prepareStatement("Update Shipper set lock=0 where sid='" + sid + "'");
			while (true) {
				int rc = stmt.executeUpdate();
				con.close();
				return rc == 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
//	public int soDonHang() {
//		ArrayList<Khachhang> v = new ArrayList<Khachhang>();
//		try {
//			Class.forName(driverName);
//			Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select s.sid,s.hoten,s.SDT,s.email,s.diachi,s.stkNganHang,t.loaixe,s.biensoxe,s.imgCMND,s.imgBangLaiXe from Shipper s inner join PhuongTien t on s.lid = t.lid where lock = 0");
//			while (rs.next()) {
//				int sid = rs.getInt(1);
//				String hoten = rs.getString(2);
//				String SDT = rs.getString(3);
//				String email = rs.getString(4);
//				String diachi = rs.getString(5);
//				String stknganhang = rs.getString(6);
//				String lid = rs.getString(7);
//				String biensoxe = rs.getString(8);
//				String imgcmnd = rs.getString(9);
//				String imgblx = rs.getString(10);
//				v.add(new PhuongTien(sid, hoten, SDT, email, diachi, stknganhang, lid, biensoxe,imgcmnd,imgblx));
//			}
//			con.close();
//		} catch (Exception ex) {
//			Logger.getLogger(Shipper.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return v;
//	}
	public ArrayList<ThongTinDonHangKhachHang> getThongTinDonHangTuUser() {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.ngaytaodon,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,\r\n" + 
            		"t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi,t5.hoten from DonHang_KHang t1 left join \r\n" + 
            		"TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join diachi_layhang t3 on t1.lmadiachi = t3.madiachi left join \r\n" + 
            		"diachi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join KhachHang t5 on t1.kid = t5.kid where t1.ttdhid =1");
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
                String hotenuser = rs.getString(16);
                arr.add(new ThongTinDonHangKhachHang(iddonhang, madonhang,tenhanghoa,kluong,ghichu,ngaytaodon,pvanchuyen,pthuho,trangthaidonhang,sdtnguoigui,hotennguoigui,diachinguoigui,sdtnguoinhan,hotennguoinhan,diachinguoinhan,hotenuser));
            }   
            con.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
            Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
	public boolean UpdateXacnhandon(int iddonhang) {
        try {
        	Connection con = getConnectDB();
            PreparedStatement stmt = con.prepareStatement("Update DonHang_KHang set ttdhid=2 where id_donhang ="+iddonhang);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	public boolean updateTuChoiDonHang(int iddonhang) {
        try {
        	Connection con = getConnectDB();
            PreparedStatement stmt = con.prepareStatement("Update DonHang_KHang set ttdhid=6 where id_donhang ="+iddonhang);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	public static String getDoanhthuAdmin() throws ClassNotFoundException {
		Gson gsonObj = new Gson();
		Map<Object, Object> map = null;
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		String dataPoints = null;

		try {
			Connection con = getConnectDB();
			Statement statement = con.createStatement();
			ResultSet rs = statement
			.executeQuery("select ngaytaodon,SUM(Pvanchuyen) from DonHang_KHang d left join TrangThaiDonHang t on d.ttdhid = t.ttdhid where t.ttdhid = 5 group by ngaytaodon");
			while (rs.next()) {
				Date ngay = rs.getDate(1);
				double doanhthu = rs.getDouble(2);
				map = new HashMap<Object, Object>();
				map.put("x", ngay.getTime());
				map.put("y", doanhthu * 0.2);
				list.add(map);
				dataPoints = gsonObj.toJson(list);
			}
			con.close();
		} catch (SQLException e) {
			dataPoints = null;
		}
		return dataPoints;
	}

	public ArrayList<ThongTinDonHangKhachHang> getAlldonhangkhachhang() {
		ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.ngaytaodon,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi,t5.sdt,t5.hoten,t6.hoten	 from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join diachi_layhang t3 on t1.lmadiachi = t3.madiachi left join diachi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join shipper t5 on t1.sid = t5.sid left join KhachHang t6 on t1.kid = t6.kid where t1.ttdhid !=1");
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
				String hotenuser = rs.getString(18);
				arr.add(new ThongTinDonHangKhachHang(iddonhang, madonhang, tenhanghoa, kluong, ghichu, ngaytaodon,
						pvanchuyen, pthuho, trangthaidonhang, sdtnguoigui, hotennguoigui, diachinguoigui, sdtnguoinhan,
						hotennguoinhan, diachinguoinhan, sdtshipper, hotenshipper,hotenuser));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
		}
		return arr;
	}
	
	public ArrayList<ThongTinDonHangKhachHang> getdonmadon_admin(String madonhang) {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.ngaytaodon,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi,t5.sdt,t5.hoten,t6.hoten	 from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join diachi_layhang t3 on t1.lmadiachi = t3.madiachi left join diachi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join shipper t5 on t1.sid = t5.sid left join KhachHang t6 on t1.kid = t6.kid where t1.ttdhid !=1 and t1.madonhang = '"+madonhang+"'");
            while (rs.next()) {
            	int iddonhang = rs.getInt(1);
				String madonhang1 = rs.getString(2);
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
				String hotenuser = rs.getString(18);
				arr.add(new ThongTinDonHangKhachHang(iddonhang, madonhang1, tenhanghoa, kluong, ghichu, ngaytaodon,
						pvanchuyen, pthuho, trangthaidonhang, sdtnguoigui, hotennguoigui, diachinguoigui, sdtnguoinhan,
						hotennguoinhan, diachinguoinhan, sdtshipper, hotenshipper,hotenuser));
            }   
            con.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
            Logger.getLogger(ThongTinDonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
