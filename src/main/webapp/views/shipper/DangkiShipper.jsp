<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>Đăng ký | Shipbee.vn</title>
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
	
</head>

<body>
	<div class="page-bg"></div>
	<div class="page-inside">
		<div class="login-logo"></div>
		<div class="login-sologan">Hệ thống quản lý đơn hàng của riêng
			bạn</div>
		<div class="register-box">
			<div class="form local-storage-destination">
				<c:if test="${requestScope.thongbao != null}">
					<div class="alert alert-danger">${thongbao}</div>
				</c:if>
				<form id="frmRegister" action="dangkishipper" name="" method="post"
					class="form-2" enctype="multipart/form-data">
					<div class="form-group text-center">
						<p class="form-control-static">Vui lòng điền đầy đủ các thông
							tin dưới đây:</p>
					</div>

					<div class="form-group">
						<input type="text" class="form-control" id="shipName" name="hoten"
							value="" placeholder="Nhập họ và tên "  />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="sdt" id="phone"
							value="" placeholder="Số điện thoại của bạn (*)" pattern="[0][0-9]{9}" />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="email" id="email"
							value="" placeholder="Email của bạn (*)"  />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="matkhau"
							id="password" value="" placeholder="Mật khẩu truy cập (*)" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="rematkhau"
							id="rePassword" value="" placeholder="Nhập lại mật khẩu (*)" />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="diachi" id="address"
							value=""
							placeholder="Địa chỉ liên lạc: Số nhà,ngõ/hẻm,đường,quận/huyện...(*)" />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="stknganhang"
							id="stkNganhang" value="" placeholder="Số tài khoản Ngân hàng(*)" />
					</div>
					<div class="form-group">
						<select class="form-control" name="lid" id="lid">
							<option value="0">Chọn loại xe</option>
							<option value="1">Xe Máy</option>
							<option value="2">Xe tải dưới 3,5 tấn</option>
							<option value="3">Xe Tải trên 3,5 tấn</option>
						</select>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="biensoxe"
							id="biensoxe" value="" placeholder="Biển số xe(*)" />
					</div>
					<!--  -->
					<div class="form-group">
						<label class="reg">Add CMND Image</label>
						 <input class="form-control" type="file" name="file" /> 
						<label class="reg">Add Bang Lai Xe Image</label> 
						<input class="form-control" type="file" name="file1" />
					</div>
					<!--  -->
					<div class="form-group">
						<div class="checkbox-inline">
							<label class="reg"><input type="checkbox" name="confirmreg">
								Tôi đồng ý với chính sách dịch vụ của Shipbee.vn </label>
						</div>
					</div>
					<div class="form-group">
						<button type="submit"
							class="btn btn-info text-uppercase btn-block btn-lg">Đăng
							ký</button>
					</div>
				</form>
			</div>
			<!-- form -->
			<div class="login-social">
				<div class="login-line"></div>
				<div class="login-signup">
					Bạn đã có tài khoản? <a href="Dangnhap.jsp">Đăng nhập ngay</a>
				</div>
			</div>
		</div>
		<!-- login-box -->
		<div class="login-footer">Shipbee.vn - Cổng giao hàng , thu tiền
			toàn quốc của riêng bạn</div>
	</div>
<script type="text/javascript">
$(function() {
	$.validator.addMethod("valueNotEquals", function(value, element, arg){
		  return arg !== value;
		 }, "Chon Loai Xe");
	$.validator.addMethod('strongPWD', function(value, element) {
		return this.optional(element)
		|| value.length >=8 && /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
	}, 'Mật khẩu của bạn phải dài ít nhất 6 ký tự và chứa ít nhất một số và một ký tự\'.')
	$.validator.addMethod("phoneVN", function(phone_number, element) {
phone_number = phone_number.replace(/\s+/g, "");
return this.optional(element) || phone_number.length > 9 && 
phone_number.match(/^0(1\d{9}|9\d{8})$/);
}, "Vui lòng chỉ định một số điện thoại hợp lệ")
	$("#frmRegister").validate({
		errorClass: 'errors',
		rules: {
			hoten: {
				required: true		
			},
			email: {
				required: true,
				email: true
			},
			matkhau: {
				required: true,	
				strongPWD: true
			},
			rematkhau: {
				required: true,
				equalTo: "#password"
			},
			sdt: {
				required: true,
				phoneVN: true
				
			},
			diachi: {
				required: true
			},
			lid:{
				valueNotEquals: "default" 
			},	
			stknganhang: {
				required: true,
				number: true
			},
			biensoxe: {
				required: true
			}
		},
		messages:{
			email: {
				required: 'Vui lòng nhập email',
				email: 'Vui lòng nhập email hợp lệ'
			},
			hoten: {
				required:  'Vui lòng nhập họ tên',
			},
			matkhau: {
				required: 'Vui lòng nhập mật khẩu',	
			},
			rematkhau: {
				required:  'Vui lòng nhập lại mật khẩu',
			},
			sdt: {
				required: 'Vui lòng nhập số điện thoại',
				
			},
			diachi: {
				required:  'Vui lòng nhập địa chỉ'
			},
			stknganhang: {
				required: 'Vui lòng nhập số tài khoản ngân hàng'
			},
			biensoxe: {
				required: 'Vui lòng nhập biển số xe'

			},
			highlight: function (element) {
	            $(element).parent().addClass('error')
	        },
	        unhighlight: function (element) {
	            $(element).parent().removeClass('error')
	        }
		}
	})
})</script>
</body>
<style>
.register-box .form label{
color:red;
}
.reg{
color:#fff !important;
}
.error {
      color: red;
   }</style>
</html>
