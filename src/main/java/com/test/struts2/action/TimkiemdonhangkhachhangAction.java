package com.test.struts2.action;

import java.sql.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.TimKiemDonHangKhachHangBO;

public class TimkiemdonhangkhachhangAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String madonhang;
	private Date createddatefrom,createddateto;
	private int  loaitimkiem, radiotrangthai;
	Map<String, Object> session = ActionContext.getContext().getSession();
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	TimKiemDonHangKhachHangBO bo = new TimKiemDonHangKhachHangBO();
	int kid = (int) session.get("cusid");
	public String getMadonhang() {
		return madonhang;	
	}

	public void setMadonhang(String madonhang) {
		this.madonhang = madonhang;
	}


	public Date getCreateddatefrom() {
		return createddatefrom;
	}

	public void setCreateddatefrom(Date createddatefrom) {
		this.createddatefrom = createddatefrom;
	}

	public Date getCreateddateto() {
		return createddateto;
	}

	public void setCreateddateto(Date createddateto) {
		this.createddateto = createddateto;
	}


	public int getLoaitimkiem() {
		return loaitimkiem;
	}

	public void setLoaitimkiem(int loaitimkiem) {
		this.loaitimkiem = loaitimkiem;
	}

	public int getRadiotrangthai() {
		return radiotrangthai;
	}

	public void setRadiotrangthai(int radiotrangthai) {
		this.radiotrangthai = radiotrangthai;
	}
@Override
	public String execute() {
		System.out.println(loaitimkiem);
        if (loaitimkiem == 1 && madonhang!="") {
          request.put("timkiemtheomadonhang", bo.getDonhangkhachhang_madonhang(kid, madonhang));
          System.out.println("ok1");
            return "success";
        }
        else if (loaitimkiem == 2 && createddatefrom!=null && createddateto!=null) {
        	request.put("timkiemtheongaytaodon", bo.getDonhangkhachhang_ngaytaodon(kid, createddatefrom.toString(), createddateto.toString()));
            System.out.println("ok2");
        	return "success";
        }
        else if (loaitimkiem == 3 && radiotrangthai!=0) {
        	request.put("timkiemtheotrangthai", bo.getDonhangkhachhang_trangthaidonhang(kid, radiotrangthai));
            System.out.println("ok3");
        	return "success";
        }
        return "error";
	}
}
