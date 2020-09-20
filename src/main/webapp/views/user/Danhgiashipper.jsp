<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="list2" class="com.test.struts2.dao.LayTatCaDonHangDAO"
	scope="session" />
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,700,700italic,400italic,900,900italic,300italic,300,100italic,100'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../../default/css/print.css" media="print">
<!-- Core CSS -->
<title>Đánh giá Shipper | Shipbee.vn</title>
<meta charset="UTF-8">
<link
	href="https://static.proship.vn/f/default/css/??bootstrap.min.css,font-awesome.min.css,owl.carousel.min.css,select2.min.css,animate.css,swiper.min.css,custom.css?v65"
	media="screen" rel="stylesheet" type="text/css">
<link href="../../default/css/khachhang.css" media="screen"
	rel="stylesheet" type="text/css">
<link
	href="https://static.proship.vn/f/default/css/??bootstrap-switch.min.css?v65"
	media="screen" rel="stylesheet" type="text/css">
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
	<div id="loading-mask" class="loading" style="display: none;">
		<div class="loading-inner">
			<i class="fa fa-cog fa-spin fa-3x fa-fw"></i> <span
				class="loading-text">Loading...</span>
		</div>
		<!-- loading-inner -->
	</div>
	<!-- loading -->
	<div class="page-site page-app">
		<%@ include file="layout/Header.jsp"%>
		<%@ include file="layout/Sideleft.jsp"%>

		<div class="page-content page-dashboard">
			<%@ include file="layout/Title.jsp"%>
			<div class="page-inner">
				<div class="container">
					<div class="page-smalltitle">
						<div class="row row-medium">
							<div class="col-lg-12">
								<div class="page-smalltitle-wellcome">Những đơn hàng chờ
									đánh giá</div>
								<div class="page-title-desc">Bạn nên nhập đánh giá chính
									xác. Đánh giá của bạn sẽ ảnh hưởng trực tiếp đến Shipper !!!</div>
							</div>
							<!-- col -->
						</div>
						<!-- row -->
					</div>

					<div class="row row-medium">
						<div class="col-lg-12">
							<c:if test="${requestScope.danhgiathatbai != null}">
								<div class="alert alert-danger">${danhgiathatbai}</div>
							</c:if>
							<c:if test="${requestScope.danhgiathanhcong != null}">
								<div class="alert alert-success">${danhgiathanhcong}</div>
							</c:if>

						</div>
					</div>
				</div>
				<c:forEach var="list"
					items="${list2.getAlldonhangdahoanthanh(cusid) }">
					<div class="container">
						<div class="row row-medium">
							<div class="col-lg-12">
								<div class="panel panel-custom">
									<div class="panel-heading">
										<div class="big-text">Đánh giá shipper</div>
									</div>
									<div class="panel-body">
										<form id="" class="form form-horizontal form-maxsize"
											action="danhgiashipper" method="post">
											<div class="form-group">
												<label class="control-label col-lg-4 col-sm-3">Mã
													đơn hàng:</label>
												<div class="col-lg-8 col-sm-9">
													<input name="madonhang" value="${list.madonhang }"
														class="form-control ignore" type="text" autocomplete="off"
														readonly> <input type="hidden" name="iddonhang"
														value="${list.iddonhang }">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-lg-4 col-sm-3">Thông
													tin shipper:</label>
												<div class="col-lg-8 col-sm-9">
													<input name="matkhaumoi" readonly
														class="form-control ignore" type="text" autocomplete="off"
														value="${list.hotenshipper } - ${list.sdtshipper}">
													<input type="hidden" name="sid" value="${list.sid }">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-lg-4 col-sm-3">Ảnh
													shipper:</label>
												<div class="col-lg-8 col-sm-9">
													<img width="100px" height="100px"
														src="../../images/${list.imgbanglaixe }">

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-lg-4 col-sm-3">Đánh
													giá:</label>
												<div class="col-lg-8 col-sm-9 rate">
													<div class="${list.madonhang}">
														<span> <input type="radio" name="${list.madonhang}"
															id="${list.madonhang}1" value="1"> <label
															for="${list.madonhang }1"></label></span> <span> <input
															type="radio" name="${list.madonhang}"
															id="${list.madonhang}2" value="2"> <label
															for="${list.madonhang }2"></label></span> <span> <input
															type="radio" name="${list.madonhang}"
															id="${list.madonhang}3" value="3"><label
															for="${list.madonhang}3"></label></span> <span><input
															type="radio" name="${list.madonhang}"
															id="${list.madonhang}4" value="4"><label
															for="${list.madonhang}4"></label></span> <span><input
															type="radio" name="${list.madonhang}"
															id="${list.madonhang}5" value="5" checked="checked"><label
															for="${list.madonhang}5"></label></span><span class="sao"><input type='hidden' name='sao' value='5'>
															</span>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-lg-4 col-sm-3">Nhận
													xét:</label>
												<div class="col-lg-8 col-sm-9">
													<input name="nhanxet" class="form-control ignore"
														type="text" autocomplete="off">
												</div>
											</div>
											<div class="form-group text-right">
												<div class="col-xs-12">
													<button type="submit" id="btn-change-password"
														class="btn btn-info text-uppercase">Đánh giá</button>
												</div>
											</div>
										</form>
										<!-- form -->
									</div>
									<!-- panel-body -->
								</div>
								<!-- panel -->
							</div>
							<!-- col -->
						</div>
						<!-- row -->
					</div>

					<script>
						$(document)
								.ready(
										function() {
											// Check Radio-box
											$('.${list.madonhang } input')
													.click(
															function() {
																$(".${list.madonhang } span")
																		.removeClass(
																				'checked');
																$(this)
																		.parent()
																		.addClass(
																				'checked');
															});
											$('.${list.madonhang } input:radio')
													.change(
															function() {
																var userRating = this.value;
																$(".${list.madonhang } .sao")
																		.html("<input type='hidden' name='sao' value='"+userRating+"'>");
															});
										});
					</script>
					<style>
.${
list


.madonhang


}
{
float


:left


;
width


:


300px


;
}
.${
list


.madonhang




}
span {
	float: inherit;
	position: relative;
}

.${
list


.madonhang




 




}
span input {
	position: absolute;
	top: 0px;
	left: 0px;
	opacity: 0;
}

.${
list








.madonhang




 




}
span label {
	display: inline-block;
	width: 30px;
	height: 30px;
	text-align: center;
	color: #FFF;
	background: #F90;
	font-size: 30px;
	margin-right: 2px;
	line-height: 30px;
	border-radius: 50%;
	-webkit-border-radius: 50%;
}

.${
list








.madonhang




 




}
span








:hover




 




~
span




 




label
,
.${
list








.madonhang




 




}
span








:hover




 




label
,
.${
list








.madonhang




 




}
span








.checked




 




label
,
.${
list








.madonhang




 




}
span.checked ~ span label {
	background: #ccc;
	color: #FFF;
}
</style>


				</c:forEach>
				<!-- container -->
			</div>
			<%@ include file="layout/Footer.jsp"%>
		</div>
	</div>
</body>
</html>
