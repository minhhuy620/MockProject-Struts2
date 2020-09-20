package com.test.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.struts2.dao.DiaChiMacDinhDAO;
import com.test.struts2.dao.LayKhoangCachDAO;

public class LayphuongxaAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int quanhuyen;
	private String phuongxa;
	Map<String, Object> session = ActionContext.getContext().getSession();
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	
	public int getQuanhuyen() {
		return quanhuyen;
	}

	public void setQuanhuyen(int quanhuyen) {
		this.quanhuyen = quanhuyen;
	}

	public String getPhuongxa() {
		return phuongxa;
	}

	public void setPhuongxa(String phuongxa) {
		this.phuongxa = phuongxa;
	}

	@SuppressWarnings("rawtypes")
	public String execute() {
		session.put("data1", "<option value='1'>Bình Hiên</option><option value='2'>Bình Thuận</option><option value='3'>Hải Châu I</option><option value='4'>Hải Châu II</option><option value='5'>Hòa Cường Bắc</option><option value='6'>Hòa Cường Nam</option><option value='7'>Hòa Thuận Đông</option><option value='8'>Hòa Thuận Tây</option><option value='9'>Nam Dương</option><option value='10'>Phước Ninh</option><option value='11'>Thạch Thang</option><option value='12'>Thanh Bình</option><option value='13'>Thuận Phước</option>");
		session.put("data2", "<option value='14'>Hòa An</option><option value='15'>Hòa Phát</option><option value='16'>Hòa Thọ Đông</option><option value='17'>Hòa Thọ Tây</option><option value='18'>Hòa Xuân</option><option value='19'>Khuê Trung</option>");
		session.put("data3", "<option value='20'>An Khê </option><option value='21'>Chính Gián</option><option value='22'>Hòa Khê</option><option value='23'>Tam Thuận</option><option value='24'>Tân Chính</option><option value='25'>Thạc Gián</option><option value='26'>Thanh Khê Đông</option><option value='27'>Thanh Khê Tây</option><option value='28'>Vĩnh Trung</option><option value='29'>Xuân Hà</option>");
		session.put("data4", "<option value='30'>Hòa Hiệp Bắc</option><option value='31'>Hòa Hiệp Nam</option><option value='32'>Hòa Khánh Bắc</option><option value='33'>Hòa Khánh Nam</option><option value='34'>Hòa Minh</option>");
		session.put("data5", "<option value='35'>Hòa Hải</option><option value='36'>Hòa Quý</option><option value='37'>Khuê Mỹ</option><option value='38'>Mỹ An</option>");
		session.put("data6", "<option value='39'>An Hải Bắc</option><option value='40'>An Hải Đông</option><option value='41'>An Hải Tây</option><option value='42'>Mân Thái</option><option value='43'>Nại Hiên Đông</option><option value='44'>Phước Mỹ</option><option value='45'>Thọ Quang</option>");
		session.put("data7", "<option value='46'>Hòa Bắc</option><option value='47'>Hòa Châu</option><option value='48'>Hòa Khương</option><option value='49'>Hòa Liên</option><option value='50'>Hòa Nhơn</option><option value='51'>Hòa Ninh</option><option value='52'>Hòa Phong</option><option value='53'>Hòa Phú</option><option value='54'>Hòa Phước</option><option value='55'>Hòa Sơn</option><option value='56'>Hòa Tiến</option>");
		try {
			LayKhoangCachDAO lkm = new LayKhoangCachDAO();
			session.put("gquanhuyen", lkm.getAllkhoangcach());
		} catch (Exception e) {
			// TODO: handle exception
		}
		DiaChiMacDinhDAO kbo = new DiaChiMacDinhDAO();
		int kid = 0;
		try {
			 kid = (int) session.get("cusid");
			}
		catch (Exception e) {
			// TODO: handle exceptionreturn
		}
		try {
			int thongbaothanhcong = (int) session.get("thongbaothanhcong");
			request.put("thongbaothanhcong", thongbaothanhcong);
			session.remove("thongbaothanhcong");
		}catch (Exception e) {
		}
		try {
			int thongbaotaodonhang = (int) session.get("thongbaotaodonhang");
			request.put("thongbaotaodonhang", thongbaotaodonhang);
			session.remove("thongbaotaodonhang");

		} catch (Exception e) {
			// TODO: handle exception
		}
		ArrayList info = kbo.getDiachimacdinh(kid);
		try {
			session.put("sdtnguoigui", info.get(0));
			session.put("hoten", info.get(1));
			session.put("diachi", info.get(2));
			session.put("idquanhuyen", info.get(5));
			session.put("quan_huyen", info.get(6));
			session.put("idphuongxa", info.get(3));
			session.put("phuong_xa", info.get(4));
		}
		catch (Exception e) {
			return "error";
		}
        return "success";
	}

}
