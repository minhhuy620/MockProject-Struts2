package com.test.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.dao.DiaChiMacDinhDAO;

public class CapnhatdiachimacdinhAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String sdtnguoigui;
	private String hoten;
	private String diachi;
	private int idphuongxa;
	Map<String, Object> session = ActionContext.getContext().getSession();
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	
	public String getSdtnguoigui() {
		return sdtnguoigui;
	}

	public void setSdtnguoigui(String sdtnguoigui) {
		this.sdtnguoigui = sdtnguoigui;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public int getIdphuongxa() {
		return idphuongxa;
	}

	public void setIdphuongxa(int idphuongxa) {
		this.idphuongxa = idphuongxa;
	}

	public String execute() {
		DiaChiMacDinhDAO kbo = new DiaChiMacDinhDAO();
		int kid = (int) session.get("cusid");
        if (kbo.savediachimacdinh(kid, sdtnguoigui, hoten, diachi, idphuongxa) ==true) {
//                session.put("cusname", newhoten);
//                session.put("cusemail", newemail);
//                session.put("cusaddress", newdiachi);
                session.put("thongbaothanhcong", 1);
//            request.put("thongbaothanhcong", "Cập nhật thành công!");
            return "success";
        }
        session.put("thongbaothanhcong", 2);
//        request.put("thongbaothatbai", "Cập nhật thất bại!");
        return "error";
	}
}
