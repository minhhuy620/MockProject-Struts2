package com.test.struts2.bo;

import java.util.ArrayList;

import com.test.struts2.dao.DanhGiaShipperDAO;
import com.test.struts2.model.DanhGiaShipper;

public class DanhGiaShipperBO {
	public DanhGiaShipperDAO d = new DanhGiaShipperDAO();
	
	public boolean danhgiashipper(int sao, int kid, int sid, String comment, int iddonhang) {
		return d.danhgiashipper(sao, kid, sid, comment, iddonhang);
	}

	public ArrayList<DanhGiaShipper> getDanhgia(int sid){
		return d.getDanhgia(sid);
	}
}
