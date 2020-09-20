package com.test.struts2.bo;

import com.test.struts2.dao.KhachHangDAO;
import com.test.struts2.model.Khachhang;

public class KhachHangBO {
	public KhachHangDAO d = new KhachHangDAO();

	public boolean addNewKhachHang(String hoten, String sdt, String email,String matkhau, String diachi) {
		Khachhang k = new Khachhang(hoten, sdt,email,matkhau, diachi);
		return d.addNewKhachHang(k);
	}
	
	public static Khachhang dangnhap(String sdt, String password) {
		return KhachHangDAO.dangnhap(sdt, password);
	}
	
	public boolean updateKhachhang(String hoten, String email,String diachi,int kid) {
		return KhachHangDAO.updateKhachhang(hoten,email, diachi,kid);
	}
	public boolean changePass(String sdt, String matkhaucu, String matkhaumoi) {
		return d.changePass(sdt, matkhaucu,matkhaumoi);
	}
	public boolean forgotPass(String sdt, String matkhaumoi) {
		return d.forgotPass(sdt,matkhaumoi);
	}
	/*
	 * public boolean updateInfoUser(String hoTen, String sDT, String email, String
	 * diaChi,int kid) { Khachhang k1 = new Khachhang(hoTen,sDT,email,diaChi,kid);
	 * return r.updateUser(k1); }
	 */
	
}
