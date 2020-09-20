package com.test.struts2.dao;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.struts2.model.DiaChiLayHangMacDinh;

public class DiaChiMacDinhDAO implements DBinfo {

	public boolean savediachimacdinh(int kid, String sdtnguoigui, String hoten, String diachi, int idphuongxa) {
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select kid,sdtnguoigui,hoten,diachi,id_phuong_xa from DiaChiLayHangmacdinh where kid=" + kid);
			if (rs.next()) {
				PreparedStatement stmt1 = con.prepareStatement(
						"Update DiaChiLayHangmacdinh set sdtnguoigui=?,hoten=?,diachi=?,id_phuong_xa=? where kid="
								+ kid);
				stmt1.setString(1, sdtnguoigui);
				stmt1.setString(2, hoten);
				stmt1.setString(3, diachi);
				stmt1.setInt(4, idphuongxa);
				stmt1.executeUpdate();
			} else {
				PreparedStatement stmt1 = con.prepareStatement(
						"insert into DiaChiLayHangmacdinh(kid,sdtnguoigui,hoten,diachi,id_phuong_xa) values(?,?,?,?,?)");
				stmt1.setInt(1, kid);
				stmt1.setString(2, sdtnguoigui);
				stmt1.setString(3, hoten);
				stmt1.setString(4, diachi);
				stmt1.setInt(5, idphuongxa);
				stmt1.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList getDiachimacdinh(int kid) {
		ArrayList arr = new ArrayList();
		try {
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(dbURL, userDB, passDB);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"Select DiaChiLayHangmacdinh.sdtnguoigui,DiaChiLayHangmacdinh.hoten,DiaChiLayHangmacdinh.diachi,DiaChiLayHangmacdinh.id_phuong_xa,Danhsach_phuong_xa.phuong_xa,Danhsach_phuong_xa.id_quan_huyen,Danhsach_quan_huyen.quan_huyen from DiaChiLayHangmacdinh INNER JOIN Danhsach_phuong_xa on DiaChiLayHangmacdinh.id_phuong_xa = Danhsach_phuong_xa.id_phuong_xa INNER JOIN Danhsach_quan_huyen on Danhsach_phuong_xa.id_quan_huyen = Danhsach_quan_huyen.id_quan_huyen where kid="
							+ kid);
			if (rs.next()) {
				String sdtnguoigui = rs.getString(1);
				String hoten = rs.getString(2);
				String diachi = rs.getString(3);
				int id_phuong_xa = rs.getInt(4);
				String phuong_xa = rs.getString(5);
				int id_quan_huyen = rs.getInt(6);
				String quan_huyen = rs.getString(7);
				arr.add(sdtnguoigui);
				arr.add(hoten);
				arr.add(diachi);
				arr.add(id_phuong_xa);
				arr.add(phuong_xa);
				arr.add(id_quan_huyen);
				arr.add(quan_huyen);
			}
			con.close();
			return arr;
		} catch (Exception ex) {
			Logger.getLogger(DiaChiLayHangMacDinh.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}


}
