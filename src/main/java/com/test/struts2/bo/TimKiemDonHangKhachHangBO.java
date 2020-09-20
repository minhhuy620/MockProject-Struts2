package com.test.struts2.bo;

import java.util.ArrayList;

import com.test.struts2.dao.TimKiemDonHangKhachHangDAO;
import com.test.struts2.model.ThongTinDonHangKhachHang;

public class TimKiemDonHangKhachHangBO {
	public TimKiemDonHangKhachHangDAO d = new TimKiemDonHangKhachHangDAO();

	public ArrayList<ThongTinDonHangKhachHang> getDonhangkhachhang_madonhang(int kid, String madonhang) {

		return d.getDonhangkhachhang_madonhang(kid, madonhang);
	}

	public ArrayList<ThongTinDonHangKhachHang> getDonhangmadontushipper(int sid, String madonhang) {

		return d.getDonhangmadonhangtushipper(sid, madonhang);
	}

	public ArrayList<ThongTinDonHangKhachHang> getDonhangkhachhang_ngaytaodon(int kid, String ngaytaodonfrom,
			String ngaytaodonto) {

		return d.getDonhangkhachhang_ngaytaodon(kid, ngaytaodonfrom, ngaytaodonto);
	}

	public ArrayList<ThongTinDonHangKhachHang> getDonhangkhachhang_trangthaidonhang(int kid, int ttdhid) {

		return d.getDonhangkhachhang_trangthaidonhang(kid, ttdhid);
	}

}
