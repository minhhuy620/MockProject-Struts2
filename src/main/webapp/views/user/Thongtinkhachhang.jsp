<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,700,700italic,400italic,900,900italic,300italic,300,100italic,100'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../../default/css/print.css" media="print">
<!-- Core CSS -->
<title>Thông tin tài khoản | Shipbee.vn</title>
<meta charset="UTF-8">
<link
	href="https://static.proship.vn/f/default/css/??bootstrap.min.css,font-awesome.min.css,owl.carousel.min.css,select2.min.css,animate.css,swiper.min.css,custom.css?v65"
	media="screen" rel="stylesheet" type="text/css">
<link
	href="../../default/css/khachhang.css"
	media="screen" rel="stylesheet" type="text/css">
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
					<div class="container-inner">

						<div class="cover">
							<div class="cover-img"
								style='background-image: url("https://img.freepik.com/free-vector/gradient-geometric-shape-background_78532-374.jpg?size=626&ext=jpg")'>
								<div class="cover-img-content">
									<div class="cover-img-row">
										<div class="cover-img-name">${cusname }</div>
									</div>
									<div class="cover-img-row">
										<div class="cover-img-job">Đà Nẵng</div>
									</div>
								</div>
								<!-- cover-img-content -->
							</div>
							<!-- cover-img -->
							<div class="cover-bar">
								<ul class="clearfix">
									<li><a href="Quanlyvandon.jsp"><i
											class="icon24-setting-bill"></i>Quản lý vận đơn</a></li>
									<li></li>
									<li class="text-center"></li>	
									<li class=""><a
										href="thongtindauvaotaodonhangmoi"><i
											class="icon24-clock"></i>Tạo vận đơn mới</a></li>
								</ul>
							</div>
							<!-- cover-bar -->
						</div>
						<!-- cover -->
						<div class="panel panel-custom">
							<div class="panel-heading">
								<div class="big-text">Thông tin cá nhân</div>
								<div class="panel-heading-right">
									<a class="btn btn-info btn-sm" data-toggle="modal"
										data-target="#ModalEdit"><i class="fa fa-edit icon-left"></i>Sửa
										thông tin</a>
								</div>
							</div>
							<div class="panel-body">
								<div class="info">
									<div class="info-title">
										<i class="icon24-user"></i>Thông tin cơ bản:
									</div>
									<div class="info-row">
										<label>Họ tên:</label>
										<div class="info-text">${cusname }</div>
									</div>
									<div class="info-row">
										<label>Email:</label>
										<div class="info-text">${cusemail }</div>
									</div>
									<div class="info-row">
										<label>Điện thoại:</label>
										<div class="info-text">${cusphone }</div>
									</div>
									<br />
									<div class="info-title">
										<i class="icon24-place"></i>Thông tin liên hệ:
									</div>
									<div class="info-row">
										<label>Địa chỉ:</label>
										<div class="info-text">${cusaddress }</div>
									</div>
								</div>
								<!-- info -->
							</div>
							<!-- panel-body -->
						</div>
						<!-- panel -->
					</div>
					<!-- container-inner -->
				</div>
				<!-- container -->
			</div>
			<%@ include file="layout/Footer.jsp"%>
		</div>
	</div>


	<!-- ModalEditUser -->
	<div class="modal fade" id="ModalEdit" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<i class="fa fa-times-circle"></i>
					</button>
					<h4 class="modal-title">Sửa thông tin</h4>
				</div>
				<div class="modal-body">
					<div class="local-storage-destination">
						<form class="form form-horizontal" id="frmEditCustomerInfo"
							method="post" action="capnhatthongtinkhachang">
							<div class="form-group">
								<label class="control-label col-sm-3">Họ tên:</label>
								<div class="col-sm-7">
									<input type="text" name="newhoten" class="form-control"
										value="${cusname }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Email:</label>
								<div class="col-sm-7">
									<input type="text" name="newemail" class="form-control"
										value="${cusemail }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Điện thoại:</label>
								<div class="col-sm-7">
									<input type="text" name="customerPhone" class="form-control"
										value="${cusphone }" disabled="disabled" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Địa chỉ:</label>
								<div class="col-sm-7">
									<input type="text" name="newdiachi" class="form-control"
										value="${cusaddress }" />
								</div>
							</div>
							<hr />
							<div class="form-group">
								<div class="col-sm-7 col-sm-offset-3">
									<button type="submit" id="customer-edit-info"
										class="btn btn-info text-uppercase">Lưu lại</button>
								</div>
							</div>
						</form>
					</div>
					<!-- form -->
				</div>
				<!-- modal-body -->
			</div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	<!-- ModalEditUser -->
	<!-- End Modal -->
</body>
</html>
