package com.test.struts2.bo;


import java.util.ArrayList;

import com.test.struts2.dao.DiaChiMacDinhDAO;

public class DiaChiMacDinhBO {
	DiaChiMacDinhDAO d = new DiaChiMacDinhDAO();
	public boolean savediachimacdinh(int kid, String sdtnguoigui, String hoten, String diachi, int idphuongxa ) {
		return d.savediachimacdinh(kid, sdtnguoigui, hoten, diachi, idphuongxa);
	} 
	public ArrayList getDiachimacdinh(int kid) {
		return d.getDiachimacdinh(kid);
	}
}
