<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<title>Đăng nhập | ShipBee.vn</title>
<meta charset="UTF-8">
<link href="../../default/css/bootraps.css" media="screen"
	rel="stylesheet" type="text/css">
<link href="../../default/css/customer.css" media="screen"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="https://static.proship.vn/f/default/js/library/??jquery-1.12.4.min.js,bootstrap.min.js,owl.carousel.min.js,select2.min.js,bootbox.min.js,jquery.slimscroll.min.js,local-storage.js,local-not-storage.js,jquery.inputmask.bundle.min.js,jquery.validate.min.js,jquery.redirect.js,swiper.min.js?v65"></script>
<script type="text/javascript"
	src="https://static.proship.vn/f/customer/js/library/??common.js?v65"></script>
<script type="text/javascript"
	src="https://static.proship.vn/f/default/js/library/??jquery.tagsinput.js,Nileupload-min.js,notify.min.js,bootstrap-switch.min.js?v65"></script>
<script type="text/javascript"
	src="https://static.proship.vn/f/default/js/my/??customer.js?v65"></script>
<meta name="viewport"
	content="user-scalable=no, width=device-width, initial-scale=1">


</head>

<body>
	<div class="page-bg"></div>
	<div class="page-inside">
		<div class="login-logo">
			<a href="/Login"></a>
		</div>
		<div class="login-sologan">Hệ thống quản lý đơn hàng của riêng
			bạn</div>
		<div class="login-box">
			<div class="login-box-circle">
				<i class="icon72-user-white"></i>
			</div>
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
			<c:if test="${requestScope.thaydoimatkhauthanhcong != null}">
    			<div class="alert alert-success">
                      ${thaydoimatkhauthanhcong}
                 </div>
			</c:if>
			<c:if test="${requestScope.loithaydoimatkhau != null}">
    			<div class="alert alert-danger">
                      ${loithaydoimatkhau}
                 </div>
			</c:if>
			<div class="form">
				<form id="frm" action="dangnhapkhachhang" method="POST">
					<div class="form-group">
						<label class="reg">Tên đăng nhập</label> <input
							type="text" class="form-control input-lg" name="sdt" id="email"
							placeholder="Vui lòng nhập số điện thoại" />
					</div>
					<div class="form-group">
						<label class="reg">Mật khẩu</label> <input
							type="password" class="form-control input-lg" id="password"
							name="password" placeholder="Vui lòng nhập mật khẩu" />
					</div>
					<div class="login-line"></div>
					<div class="form-group">
						<button type="submit"
							class="btn btn-info text-uppercase btn-block btn-lg btn-login">Đăng
							nhập</button>
					</div>
					<div class="form-group">
						<div class="checkbox-inline"></div>
						<div class="login-forgot"> <a href="Quenmatkhau.jsp">Quên
							mật khẩu?</a>
							</div>
					</div>
				</form>
			</div>
			<!-- form -->
			<div class="login-social">
				<div class="login-signup">
					Bạn chưa có tài khoản? <a href="Dangkikhachhang.jsp">Đăng kí
						ngay</a>
				</div>
			</div>
		</div>
		<!-- login-box -->
		<div class="login-footer">Shipbee.vn - Cổng giao hàng , thu tiền
			toàn Đà Nẵng của riêng bạn</div>
	</div>
<script type="text/javascript">
$(function() {
	$("#frm").validate({
		errorClass: 'errors',
		rules: {
			sdt: {
				required: true		
			},
			password: {
				required: true
			
			}
		},
		messages: {
			sdt: {
				required: 'Vui lòng nhập số điện thoại'
			},
			password: {
				required: "Vui lòng nhập mật khẩu"
			}
			
		},
		highlight: function (element) {
            $(element).parent().addClass('error')
        },
        unhighlight: function (element) {
            $(element).parent().removeClass('error')
        }
		
		})
	})</script>
	
</body>
<style>  
.register-box .form label,.login-box .form label{
color:red;
}
.reg{
color:#fff !important;
}
.error {
      color: red;
   }</style>
</html>

