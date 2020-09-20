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
<title>Thay đổi mật khẩu | Shipbee.vn</title>
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
					<div class="row row-medium">
						<div class="col-lg-12">
							<div class="panel panel-custom">
								<div class="panel-heading">
									<div class="big-text">Thay đổi mật khẩu</div>
								</div>
								<div class="panel-body">
									<c:if test="${requestScope.loithaydoimatkhau != null}">
										<div class="alert alert-danger">${loithaydoimatkhau}</div>
									</c:if>
									<c:if test="${requestScope.thaydoimatkhauthanhcong != null}">
										<div class="alert alert-success">${thaydoimatkhauthanhcong}</div>
									</c:if>
									<form id="frm-change-password"
										class="form form-horizontal form-maxsize"
										action="thaydoimatkhaukhachhang" method="post">
										<div class="form-group">
											<label class="control-label col-lg-4 col-sm-3">Mật
												khẩu hiện tại:</label>
											<div class="col-lg-8 col-sm-9">
												<input id="passwordOld" name="matkhaucu"
													class="form-control ignore" type="password"
													placeholder="Nhập mật khẩu đang sử dụng" autocomplete="off">
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
				<!-- container -->
			</div>
		</div>
	</div>
</body>
</html>
