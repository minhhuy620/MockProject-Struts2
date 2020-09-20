package com.test.struts2.bo;

import java.util.ArrayList;

import com.test.struts2.dao.AdminDAO;
import com.test.struts2.model.Admin;
import com.test.struts2.model.Shipper;
import com.test.struts2.model.ThongTinDonHangKhachHang;
import com.test.struts2.model.Khachhang;

public class AdminBO {
	public static AdminDAO d = new AdminDAO();
	
	public ArrayList<Khachhang> getAllUser(){
		return d.listAllUser();
	}
	public ArrayList<Khachhang> getLockUser(){
		return d.listAllUser1();
	}
	
	public ArrayList<Shipper> getAllShipper(){
		return d.listAllShipper();
	}
	public ArrayList<Shipper> getLockShipper(){
		return d.listAllShipper1();
	}
	public static Admin dangnhap(String sdt, String password) {
		return d.dangnhap(sdt, password);
	}
	public boolean lockUser(int kid) {
		return d.keyLock(kid);		
	}
	public boolean openUser(int kid) {
		return d.keyOpen(kid);		
	}
	public boolean lockShipper(int sid) {
		return d.keyLockShipper(sid);		
	}
	public boolean openShipper(int sid) {
		return d.keyOpenShipper(sid);		
	}
	public ArrayList<ThongTinDonHangKhachHang> getThongTinDonHangTuUser(){
		return d.getThongTinDonHangTuUser();
	}
	public boolean UpdateXacnhandon(int iddonhang) {
		return d.UpdateXacnhandon(iddonhang);
	}
	public boolean updateTuChoiDonHang(int iddonhang) {
		return d.updateTuChoiDonHang(iddonhang);
	}
	public ArrayList<ThongTinDonHangKhachHang> getAlldonhangkhachhang(){
		return d.getAlldonhangkhachhang();
	}
	public ArrayList<ThongTinDonHangKhachHang> getdonmadon_admin(String madonhang){
		return d.getdonmadon_admin(madonhang);
	}
}
