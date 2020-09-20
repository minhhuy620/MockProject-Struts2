package com.test.struts2.bo;

import java.util.ArrayList;

import com.test.struts2.dao.ShipperDAO;
import com.test.struts2.model.Shipper;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class ShipperBO {
	public ShipperDAO s = new ShipperDAO();
	
	public boolean addNewShipper(String hoten, String sdt, String email,String matkhau, String diachi,String stkNganhang,int lid,String biensoxe,String imgCMND,String imgBanglaixe) {
		Shipper k = new Shipper(hoten, sdt,email,matkhau, diachi,stkNganhang,lid,biensoxe,imgCMND,imgBanglaixe);
		return s.addNewShipper(k);
	}
	
	public static Shipper dangnhap(String sdt, String password) {
		return ShipperDAO.dangnhap(sdt, password);
	}
	
	public boolean updateShipper(String hoten, String email,String diachi,String stkNganhang,int sid) {
		return s.updateShipper(hoten,email, diachi,stkNganhang,sid);
	}
	public boolean changePass(String sdt, String matkhaucu, String matkhaumoi) {
		return s.changePass(sdt, matkhaucu,matkhaumoi);
	}
	public ArrayList<ThongTinDonHangKhachHang> getDonhangmoi(int lid){
		return s.getDonhangmoi(lid);
	}
	public boolean UpdateNhandon(int iddonhang, int sid) {
		return s.UpdateNhandon(iddonhang,sid);
	}
	public ArrayList<ThongTinDonHangKhachHang> getDondanhan(int lid,int sid){
		return s.getDondanhan(lid,sid);
	}
	public boolean UpdateLayhang(int iddonhang) {
		return s.UpdateLayhang(iddonhang);
	}
	public ArrayList<ThongTinDonHangKhachHang> getDondalay(int lid,int sid){
		return s.getDondalay(lid,sid);
	}
	public boolean UpdateGiaohang(int iddonhang) {
		return s.UpdateGiaohang(iddonhang);
	}
	public ArrayList<ThongTinDonHangKhachHang> getDondagiao(int lid,int sid){
		return s.getDondagiao(lid,sid);
	}
	public boolean forgotPass(String sdt, String matkhaumoi) {
		return s.forgotPass(sdt,matkhaumoi);
	}
}
