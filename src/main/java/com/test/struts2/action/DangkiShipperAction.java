package com.test.struts2.action;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.struts2.bo.ShipperBO;
import com.test.struts2.dao.FileUtil;
import com.test.struts2.model.Shipper;

public class DangkiShipperAction extends ActionSupport implements ModelDriven<Shipper>, ServletContextAware {

	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private File file;
	private String fileContentType;
	private String fileFileName;
	private File file1;
	private String file1ContentType;
	private String file1FileName;
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");

	public Shipper shipper = new Shipper();

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFile1ContentType() {
		return file1ContentType;
	}

	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}

	public String getFile1FileName() {
		return file1FileName;
	}

	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public File getFile1() {
		return file1;
	}

	public void setFile1(File file1) {
		this.file1 = file1;
	}

	public String execute() throws Exception {
		ShipperBO kbo = new ShipperBO();
		if(!shipper.getHoten().equals("") && !shipper.getSdt().equals("") && !shipper.getEmail().equals("") && !shipper.getMatkhau().equals("") && !shipper.getDiachi().equals("")
				&& !shipper.getStknganhang().equals("") && (shipper.getLid() != 0)
				&& !shipper.getBiensoxe().equals("") && !shipper.getBiensoxe().equals("")){
			kbo.addNewShipper(shipper.getHoten(), shipper.getSdt(), shipper.getEmail(), shipper.getMatkhau(),
					shipper.getDiachi(), shipper.getStknganhang(), shipper.getLid(), shipper.getBiensoxe(),
					getFileFileName(), getFile1FileName());
			FileUtil.saveFile(getFile(), getFileFileName(), "C:\\Users\\Dell\\Desktop\\OJT\\Mock Project\\Project\\Shipbee\\src\\main\\webapp\\images");
			FileUtil.saveFile(getFile1(), getFile1FileName(), "C:\\Users\\Dell\\Desktop\\OJT\\Mock Project\\Project\\Shipbee\\src\\main\\webapp\\images");
			request.put("thongbao", "Đăng kí thành công!");
			return SUCCESS;
		}
		request.put("thongbao", "Không hợp lệ!");
		return ERROR;
	}

	public Shipper getModel() {
		return shipper;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.setContext(context);

	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

}
