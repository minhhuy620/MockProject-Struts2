<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">

<link rel="stylesheet" href="default/css/print.css" media="print">
<!-- Core CSS -->
<title>Danh sách tài khoản bị khóa | Shipbee.vn</title>
<meta charset="UTF-8">
<script type="text/javascript"
	src="default/js/library/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="default/js/library/bootstrap.min.js"></script>
<link
	href="https://static.proship.vn/f/default/css/??bootstrap.min.css,font-awesome.min.css,owl.carousel.min.css,select2.min.css,animate.css,swiper.min.css,custom.css?v65"
	media="screen" rel="stylesheet" type="text/css">
<link href="default/css/khachhang.css" media="screen" rel="stylesheet"
	type="text/css">
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
							<div class="col-lg-8">
								<div class="page-smalltitle-wellcome">
									<h1>Thông tin Account Lock </h1>
								</div>
							</div>

						</div>
					</div>
					<c:if test="${requestScope.thongbao != null}">
						<div class="alert alert-success">${thongbao}</div>
					</c:if>
					<div class="panel panel-custom">
						<div class="panel-body">
							<div class="table-responsive table-main">
								<table class="table table-striped">
									<thead>
										<tr>
											<th width="5%" class="text-left">ID</th>
											<th width="15%" class="text-left">Họ và Tên</th>
											<th width="25%" class="text-left">Số Điện Thoại/Địa Chỉ</th>
											<th width="20%">Email</th>
											<th width="15%" class="text-left">Số tài khoản</th>
											<th width="11%">Loại Xe</th>
											<th width="15%">Biển số xe</th>
											<th width="10%">Chức năng</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="dataLockshipper">
											<tr>
												<td><s:property value="sid" /></td>
												<td><s:property value="hoten" /></td>
												<td><s:property value="sdt" />-<s:property value="diachi" /></td>
												<td><s:property value="email" /></td>
												<td><s:property value="stknganhang" /></td>
												<td><s:property value="loaixe" /></td>
												<td><s:property value="biensoxe" /></td>
												<td><a href="openshipper?sid=<s:property value="sid"/>">
														<img width="35px" height="35px"
														src="https://img.icons8.com/color/48/000000/lock.png" />
												</a></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
