package com.test.struts2.bo;

import java.util.ArrayList;

import com.test.struts2.dao.QuanHuyenDAO;
import com.test.struts2.model.DanhSachPhuongXa;

public class QuanHuyenBO {
	public QuanHuyenDAO d = new QuanHuyenDAO();
	public ArrayList<DanhSachPhuongXa> getPhuongxa(int idquanhuyen) {
		return d.getPhuongxa(idquanhuyen);
	}
//	public static void main(String[] args) {
//		QuanHuyenBO kbo = new QuanHuyenBO();
//		ArrayList<DanhSachPhuongXa> phuongxaarr1 = kbo.getPhuongxa(1);
//		ArrayList<DanhSachPhuongXa> phuongxaarr2 = kbo.getPhuongxa(2);
//		ArrayList<DanhSachPhuongXa> phuongxaarr3 = kbo.getPhuongxa(3);
//		ArrayList<DanhSachPhuongXa> phuongxaarr4 = kbo.getPhuongxa(4);
//		ArrayList<DanhSachPhuongXa> phuongxaarr5 = kbo.getPhuongxa(5);
//		ArrayList<DanhSachPhuongXa> phuongxaarr6 = kbo.getPhuongxa(6);
//		ArrayList<DanhSachPhuongXa> phuongxaarr7 = kbo.getPhuongxa(7);
//		String data1 ="";
//		for (DanhSachPhuongXa phuong : phuongxaarr7) {
//			int idphuong = phuong.getIdphuongxa();
//			String tenphuong = phuong.getPhuongxa();
//			String data ="<option value='"+idphuong+"'>"+tenphuong+"</option>";
//			data1 = data1.concat(data);
//			System.out.println(data1);
//		}
//
//	}

}
