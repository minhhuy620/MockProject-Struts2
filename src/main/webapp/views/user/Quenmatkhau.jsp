<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
 <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

        <title>Quên Mật Khẩu | Shipbee.vn</title>
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
        <form id="frmRegister" action="quenmatkhau" name="" method="post" class="form-2">
            <div class="form-group text-center">
            	<h1><p class="form-control-static">Quên Mật Khẩu</p></h1>
            </div>
            
            <div class="form-group">
                <input type="text" class="form-control"  name="sdt"  placeholder="Nhập số điện thoại đăng kí" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="mail"  placeholder="Số email đăng kí" />
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-info text-uppercase btn-block btn-lg">Xác Thực Thông Tin</button>
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
            <style>
            label {
  display: inline-block;
  width:100%;
  background: linear-gradient(to right, #999 6em, red 5em);
  border: 2px solid #ccc;
  font-family: monospace;/* less surprise about length of text at screen */
}
input {
  font-weight: bold;
  width: 100%;
  height:20px;
  padding:10px;
  border: none;
  display: block;
outline:none;

}
input:invalid {/* color part of text only when placeholder is shown */
  mix-blend-mode: screen;
}
            </style>
</html>
