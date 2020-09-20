package com.test.struts2.bo;

import com.test.struts2.dao.TaoDonHangDAO;
import com.test.struts2.model.DiaChiLayHang;
import com.test.struts2.model.DiaChiNhanHang;
import com.test.struts2.model.DonHangKhachHang;

public class TaoDonHangBO {
	public TaoDonHangDAO d = new TaoDonHangDAO();
	
	public boolean addNewDiaChiLayHang(String sdtnguoigui, String hoten, String diachi, int idphuongxa) {
		DiaChiLayHang k = new DiaChiLayHang(sdtnguoigui,hoten,diachi,idphuongxa);
		return d.addNewDiaChiLayHang(k);
	}
	public boolean addNewDiaChiNhanHang(String sdtnguoinhan, String hoten, String diachi, int idphuongxa) {
		DiaChiNhanHang k = new DiaChiNhanHang(sdtnguoinhan,hoten,diachi,idphuongxa);
		return d.addNewDiaChiNhanHang(k);
	}
	public boolean addNewDonHang(String tenhanghoa, double kluong, String ghichu, double pvanchuyen,double phithuho,int lid, int tid,int vid, int kid) {
		DonHangKhachHang k = new DonHangKhachHang(tenhanghoa,kluong,ghichu,pvanchuyen,phithuho,lid,tid,vid,kid);
		return d.addNewDonHang(k);
	}
	
}
