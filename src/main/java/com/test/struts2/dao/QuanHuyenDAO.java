package com.test.struts2.dao;
import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.struts2.model.DanhSachPhuongXa;
import com.test.struts2.model.DanhSachQuanHuyen;

public class QuanHuyenDAO implements DBinfo{
	
	public ArrayList<DanhSachQuanHuyen> getAllquanhuyen() {
        ArrayList<DanhSachQuanHuyen> arr = new ArrayList<>();
        try {
        	Connection con = getConnectDB();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_quan_huyen, quan_huyen from danhsach_quan_huyen");
            while (rs.next()) {
                int id_quan_huyen = rs.getInt(1);
                String quan_huyen = rs.getString(2);
                arr.add(new DanhSachQuanHuyen(id_quan_huyen, quan_huyen));
            }   
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DanhSachQuanHuyen.class.getName()).log(Level.SEVERE, null, ex);

        }
        return arr;
    }
	public ArrayList<DanhSachPhuongXa> getPhuongxa(int idquanhuyen) {
		ArrayList<DanhSachPhuongXa> arr = new ArrayList<>();
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select id_phuong_xa, phuong_xa from danhsach_phuong_xa where id_quan_huyen ="+idquanhuyen);
			while (rs.next()) {
				int id_phuong_xa = rs.getInt(1);
				String phuong_xa = rs.getString(2);
				arr.add(new DanhSachPhuongXa(id_phuong_xa, phuong_xa));
			}   
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(DanhSachQuanHuyen.class.getName()).log(Level.SEVERE, null, ex);
			
		}
		return arr;
	}
//	public static void main(String[] args) {
//		QuanHuyenDAO dd = new QuanHuyenDAO();
//		System.out.println(dd.getPhuongxa(1));
//	}
}
