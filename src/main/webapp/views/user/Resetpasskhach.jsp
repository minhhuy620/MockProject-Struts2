<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
 <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

        <title>Reset Mật Khẩu | Shipbee.vn</title>
        <link href="../../default/css/bootraps.css" media="screen" rel="stylesheet" type="text/css">
<link href="../../default/css/customer.css" media="screen" rel="stylesheet" type="text/css"><script type="text/javascript" src="https://static.proship.vn/f/default/js/library/??jquery-1.12.4.min.js,bootstrap.min.js,owl.carousel.min.js,select2.min.js,bootbox.min.js,jquery.slimscroll.min.js,local-storage.js,local-not-storage.js,jquery.inputmask.bundle.min.js,jquery.validate.min.js,jquery.redirect.js,swiper.min.js?v65"></script>
<script type="text/javascript" src="https://static.proship.vn/f/customer/js/library/??common.js?v65"></script>
<script type="text/javascript" src="https://static.proship.vn/f/default/js/library/??jquery.tagsinput.js,Nileupload-min.js,notify.min.js,bootstrap-switch.min.js?v65"></script>
<script type="text/javascript" src="https://static.proship.vn/f/default/js/my/??customer.js?v65"></script>

    </head>

    <body>
    	<div class="page-bg"></div>
        <div class="page-inside">
            <div class="login-logo"></div>
            <div class="login-sologan">Hệ thống quản lý đơn hàng của riêng bạn</div>
<div class="register-box">
    <div class="form local-storage-destination">
    <c:if test="${requestScope.thongbao != null}">
    			<div class="alert alert-success">
                      ${thongbao}
                 </div>
			</c:if>
			<c:if test="${requestScope.thongbaodangnhap != null}">
    			<div class="alert alert-danger">
                      ${thongbaodangnhap}
                 </div>
			</c:if>
        <form id="frm-change-password"
										class="form form-horizontal form-maxsize"
										action="quenpasskhach" method="post">
										<div class="form-group">
											<label class="control-label col-lg-4 col-sm-3">SĐT Đăng Kí Tài Khoản:</label>
											<div class="col-lg-8 col-sm-9">
												<input type="text" class="form-control input-lg" name="sdt" value="${cussdt}" readonly  />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-lg-4 col-sm-3">Mật
												khẩu mới:</label>
											<div class="col-lg-8 col-sm-9">
												<input id="passwordNew" name="matkhaumoi"
													class="form-control ignore" type="password"
													placeholder="Nhập mật khẩu mới" autocomplete="off">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-lg-4 col-sm-3">Nhập
												lại mật khẩu mới:</label>
											<div class="col-lg-8 col-sm-9">
												<input id="passwordNewRep" name="rematkhaumoi"
													class="form-control ignore" type="password"
													placeholder="Nhập lại mật khẩu mới" autocomplete="off">
											</div>
										</div>
										<div class="form-group text-right">
											<div class="col-xs-12">
												<button type="submit" id="btn-change-password"
													class="btn btn-info text-uppercase">Cập nhật</button>
											</div>
										</div>
									</form>
    </div><!-- form -->
    <div class="login-social">
    <div class="login-line"></div>
    <div class="login-signup">Bạn đã có tài khoản? <a href="Dangnhap.jsp">Đăng nhập ngay</a></div>
</div></div><!-- login-box -->
<div class="login-footer">Shipbee.vn - Cổng giao hàng , thu tiền toàn quốc của riêng bạn</div>
        </div>

            </body>
</html>
