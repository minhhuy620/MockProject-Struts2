package com.test.struts2.dao;

import static com.test.struts2.dao.DBinfo.getConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.struts2.model.PhamViKhoangCach;

public class LayKhoangCachDAO implements DBinfo {

	public ArrayList<PhamViKhoangCach> getAllkhoangcach() {
		ArrayList<PhamViKhoangCach> arr = new ArrayList<>();
		try {
			Connection con = getConnectDB();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select kcode,NQuanHuyen,GQuanHuyen,km from phamvi_khoangcach");
			while (rs.next()) {
				int kcode = rs.getInt(1);
				int nquanhuyen = rs.getInt(2);
				int gquanhuyen = rs.getInt(3);
				int km = rs.getInt(4);
				arr.add(new PhamViKhoangCach(kcode, nquanhuyen, gquanhuyen, km));
			}
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(PhamViKhoangCach.class.getName()).log(Level.SEVERE, null, ex);
		}
		return arr;
	}

	public ArrayList getKid() {
		ArrayList kidarr = new ArrayList();
		ArrayList gquanhuyenarr = new ArrayList();
		ArrayList nquanhuyenarr = new ArrayList();
		ArrayList kmarr = new ArrayList();
		LayKhoangCachDAO lkmCachDAO = new LayKhoangCachDAO();
		ArrayList<PhamViKhoangCach> list = lkmCachDAO.getAllkhoangcach();
		for (PhamViKhoangCach item : list) {
			kidarr.add(item.getKcode());
			gquanhuyenarr.add(item.getGquanhuyen());
			nquanhuyenarr.add(item.getNquanhuyen());
			kmarr.add(item.getKm());
		}
		return kidarr;
	}

	public ArrayList<Integer> getNquanhuyen() {
		ArrayList<Integer> nquanhuyenarr = new ArrayList<Integer>();
		LayKhoangCachDAO lkmCachDAO = new LayKhoangCachDAO();
		ArrayList<PhamViKhoangCach> list = lkmCachDAO.getAllkhoangcach();
		for (PhamViKhoangCach item : list) {
			nquanhuyenarr.add(item.getNquanhuyen());
		}
		return nquanhuyenarr;
	}

	public ArrayList getGquanhuyen() {
		ArrayList gquanhuyenarr = new ArrayList();
		LayKhoangCachDAO lkmCachDAO = new LayKhoangCachDAO();
		ArrayList<PhamViKhoangCach> list = lkmCachDAO.getAllkhoangcach();
		for (PhamViKhoangCach item : list) {
			gquanhuyenarr.add(item.getGquanhuyen());
		}
		return gquanhuyenarr;
	}

	public ArrayList getKm() {
		ArrayList kmarr = new ArrayList<Integer>();
		LayKhoangCachDAO lkmCachDAO = new LayKhoangCachDAO();
		ArrayList<PhamViKhoangCach> list = lkmCachDAO.getAllkhoangcach();
		for (PhamViKhoangCach item : list) {
			kmarr.add(item.getKm());
		}
		return kmarr;
	}

}
