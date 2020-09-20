package com.test.struts2.dao;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.test.struts2.model.DonHangKhachHang;
import com.test.struts2.model.Shipper;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class ShipperDAO implements DBinfo{

	public boolean addNewShipper(Shipper s) {
		try {
			Connection con = getConnectDB();
			PreparedStatement stmt = con.prepareStatement("Insert into Shipper(hoten,SDT,email,matkhau,diachi,stkNganHang,lid,biensoxe,imgCMND,imgBangLaiXe) values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, s.getHoten());
			stmt.setString(2, s.getSdt());
			stmt.setString(3, s.getEmail());
			stmt.setString(4, s.getMatkhau());
			stmt.setString(5, s.getDiachi());
			stmt.setString(6, s.getStknganhang());
			stmt.setInt(7, s.getLid());
			stmt.setString(8, s.getBiensoxe());
			stmt.setString(9, s.getImgcmnd()); 
			stmt.setString(10, s.getImgbanglaixe());
			stmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(Shipper.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		return true;
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
	
	public static Shipper dangnhap(String sdt, String password) {
		try {
			Shipper s = getShipperfromPhone(sdt);
	        if (s.getMatkhau().equals(password)) {
	            return s;
	        } else {
	            return null;
	        }
		} catch (Exception e) {
			return null;
		}
    }
	
	public boolean updateShipper(String hoten, String email, String diachi,String stkNganhang, int sid) {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("Update Shipper set hoten=?,email=?,diachi=?,stkNganHang=? where sid="+sid);
            stmt.setString(1, hoten);
            stmt.setString(2, email);
            stmt.setString(3, diachi);
            stmt.setString(4, stkNganhang);
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
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
            PreparedStatement stmt = con.prepareStatement("Update Shipper set matkhau=? where sdt='"+sdt+"'");
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
    	Shipper s = getShipperfromPhone(sdt);
        if (s.getMatkhau().equals(oldP)) {
        	updatePass(sdt, newP);
            return true;
    	}
        return false;
    }
    
    public ArrayList<ThongTinDonHangKhachHang> getDonhangmoi(int lid) {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join diachi_layhang t3 on t1.lmadiachi = t3.madiachi left join diachi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join Shipper t5 on t1.sid = t5.sid where t1.ttdhid =2 and t1.lid = "+lid);
            while (rs.next()) {
            	int iddonhang = rs.getInt(1);
                String madonhang = rs.getString(2);
                String tenhanghoa = rs.getString(3);
                Double kluong = rs.getDouble(4);
                String ghichu = rs.getString(5);
                Double pvanchuyen = rs.getDouble(6);
                Double pthuho = rs.getDouble(7);
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
    public ArrayList<DonHangKhachHang> ListTrangthaidon(int sid) {
        ArrayList<DonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select sid, ttdhid from DonHang_KHang where (ttdhid =3 or ttdhid =4 )and sid ="+sid);
            while (rs.next()) {
            	int ssid = rs.getInt(1);
                int ttdhid = rs.getInt(2);
                arr.add(new DonHangKhachHang(ssid,ttdhid));
            }   
            con.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
            Logger.getLogger(DonHangKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    public ArrayList<ThongTinDonHangKhachHang> getDondanhan(int lid,int sid) {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join diachi_layhang t3 on t1.lmadiachi = t3.madiachi left join diachi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join Shipper t5 on t1.sid = t5.sid where t1.ttdhid =3 and t1.lid ="+lid+" and t5.sid = "+sid);
            while (rs.next()) {
            	int iddonhang = rs.getInt(1);
                String madonhang = rs.getString(2);
                String tenhanghoa = rs.getString(3);
                Double kluong = rs.getDouble(4);
                String ghichu = rs.getString(5);
                Double pvanchuyen = rs.getDouble(6);
                Double pthuho = rs.getDouble(7);
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
    public ArrayList<ThongTinDonHangKhachHang> getDondalay(int lid, int sid) {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join diachi_layhang t3 on t1.lmadiachi = t3.madiachi left join diachi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join Shipper t5 on t1.sid = t5.sid where t1.ttdhid =4 and t1.lid = "+lid+" and t5.sid="+sid);
            while (rs.next()) {
            	int iddonhang = rs.getInt(1);
                String madonhang = rs.getString(2);
                String tenhanghoa = rs.getString(3);
                Double kluong = rs.getDouble(4);
                String ghichu = rs.getString(5);
                Double pvanchuyen = rs.getDouble(6);
                Double pthuho = rs.getDouble(7);
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
    public ArrayList<ThongTinDonHangKhachHang> getDondagiao(int lid,int sid) {
        ArrayList<ThongTinDonHangKhachHang> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select t1.id_donhang,t1.madonhang,t1.tenhanghoa,t1.kluong,t1.ghichu,t1.pvanchuyen,t1.pthuho,t2.trangthaidonhang,t3.sdtnguoigui,t3.hoten,t3.diachi,t4.sdtnguoinhan,t4.hoten,t4.diachi from DonHang_KHang t1 left join TrangThaiDonHang t2 on t1.ttdhid = t2.ttdhid left join diachi_layhang t3 on t1.lmadiachi = t3.madiachi left join diachi_nhanhang t4 on t1.nmadiachi = t4.madiachi left join Shipper t5 on t1.sid = t5.sid where t1.ttdhid =5 and t1.lid = "+lid+" and t5.sid="+sid);
            while (rs.next()) {
            	int iddonhang = rs.getInt(1);
                String madonhang = rs.getString(2);
                String tenhanghoa = rs.getString(3);
                Double kluong = rs.getDouble(4);
                String ghichu = rs.getString(5);
                Double pvanchuyen = rs.getDouble(6);
                Double pthuho = rs.getDouble(7);
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
    public boolean UpdateNhandon(int iddonhang, int sid) {
        try {
        	Connection con = getConnectDB();
            PreparedStatement stmt = con.prepareStatement("Update DonHang_KHang set sid=?,ttdhid=3 where id_donhang ="+iddonhang);
            stmt.setInt(1, sid);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean UpdateLayhang(int iddonhang) {
        try {
        	Connection con = getConnectDB();
            PreparedStatement stmt = con.prepareStatement("Update DonHang_KHang set ttdhid=4 where id_donhang ="+iddonhang);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean forgotPass(String sdt, String newP) {
    	updatePass(sdt, newP);
    	return true;
    	}
    public boolean UpdateGiaohang(int iddonhang) {
        try {
        	Connection con = getConnectDB();
            PreparedStatement stmt = con.prepareStatement("Update DonHang_KHang set ttdhid=5 where id_donhang ="+iddonhang);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static String getDoanhthuShipper(int sid) throws ClassNotFoundException {
		Gson gsonObj = new Gson();
		Map<Object, Object> map = null;
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		String dataPoints = null;

		try {
			Connection con = getConnectDB();
			Statement statement = con.createStatement();
			ResultSet rs = statement
			.executeQuery("select ngaytaodon,Pvanchuyen from DonHang_KHang d left join TrangThaiDonHang t on d.ttdhid = t.ttdhid where t.ttdhid = 5 and sid="+sid+" group by ngaytaodon,PVanchuyen");
			while (rs.next()) {
				Date ngay = rs.getDate(1);
				double doanhthu = rs.getDouble(2);
				map = new HashMap<Object, Object>();
				map.put("x", ngay.getTime());
				map.put("y", doanhthu * 0.8);
				list.add(map);
				dataPoints = gsonObj.toJson(list);
			}
			con.close();
		} catch (SQLException e) {
			dataPoints = null;
		}
		return dataPoints;
	}

}
