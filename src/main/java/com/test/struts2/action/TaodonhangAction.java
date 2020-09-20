package com.test.struts2.action;



import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.bo.TaoDonHangBO;


public class TaodonhangAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	Map<String, Object> session = ActionContext.getContext().getSession();
	private String sdtnguoigui;
	private String hotengui;
	private String diachigui;
	private int idphuongxagui;
	private String sdtnguoinhan;
	private String hotennhan;
	private String diachinhan;
	private int idphuongxanhan;
	private String tenhanghoa;
	private double kluong;
	private String ghichu;
	private double pvanchuyen;
	private double pthuho;
	private int lid;
	private int tid;
	private int vid;

	public String getSdtnguoigui() {
		return sdtnguoigui;
	}

	public void setSdtnguoigui(String sdtnguoigui) {
		this.sdtnguoigui = sdtnguoigui;
	}

	public String getHotengui() {
		return hotengui;
	}

	public void setHotengui(String hotengui) {
		this.hotengui = hotengui;
	}

	public String getDiachigui() {
		return diachigui;
	}

	public void setDiachigui(String diachigui) {
		this.diachigui = diachigui;
	}

	public int getIdphuongxagui() {
		return idphuongxagui;
	}

	public void setIdphuongxagui(int idphuongxagui) {
		this.idphuongxagui = idphuongxagui;
	}

	public String getSdtnguoinhan() {
		return sdtnguoinhan;
	}

	public void setSdtnguoinhan(String sdtnguoinhan) {
		this.sdtnguoinhan = sdtnguoinhan;
	}

	public String getHotennhan() {
		return hotennhan;
	}

	public void setHotennhan(String hotennhan) {
		this.hotennhan = hotennhan;
	}

	public String getDiachinhan() {
		return diachinhan;
	}

	public void setDiachinhan(String diachinhan) {
		this.diachinhan = diachinhan;
	}

	public int getIdphuongxanhan() {
		return idphuongxanhan;
	}

	public void setIdphuongxanhan(int idphuongxanhan) {
		this.idphuongxanhan = idphuongxanhan;
	}

	public String getTenhanghoa() {
		return tenhanghoa;
	}

	public void setTenhanghoa(String tenhanghoa) {
		this.tenhanghoa = tenhanghoa;
	}

	public Double getKluong() {
		return kluong;
	}

	public void setKluong(Double kluong) {
		this.kluong = kluong;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Double getPvanchuyen() {
		return pvanchuyen;
	}

	public void setPvanchuyen(Double pvanchuyen) {
		this.pvanchuyen = pvanchuyen;
	}

	public Double getPthuho() {
		return pthuho;
	}

	public void setPthuho(Double pthuho) {
		this.pthuho = pthuho;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String execute() throws Exception {
		TaoDonHangBO kbo = new TaoDonHangBO();
		try {		
			int kid = (int) session.get("cusid");
			if(kbo.addNewDiaChiLayHang(sdtnguoigui, hotengui, diachigui, idphuongxagui)==true && kbo.addNewDiaChiNhanHang(sdtnguoinhan, hotennhan, diachinhan, idphuongxanhan)==true) {
				kbo.addNewDonHang(tenhanghoa, kluong, ghichu, pvanchuyen, pthuho, lid, tid, vid, kid);
				System.out.println("ok");
				request.put("thongbaotaodonhang", 1);		
			}
			return "success";
					
		} catch (Exception e) {
			e.printStackTrace();
			session.put("thongbaotaodonhang", 2);
			return "error";
			// TODO: handle exception
		}
		
	}


}
