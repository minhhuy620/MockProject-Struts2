<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">

<link rel="stylesheet" href="default/css/print.css" media="print">
<!-- Core CSS -->
<title>Danh sách Shipper | Shipbee.vn</title>
<meta charset="UTF-8">
<link
	href="https://static.proship.vn/f/default/css/??bootstrap.min.css,font-awesome.min.css,owl.carousel.min.css,select2.min.css,animate.css,swiper.min.css,custom.css?v65"
	media="screen" rel="stylesheet" type="text/css">
<link href="default/css/khachhang.css" media="screen" rel="stylesheet"
	type="text/css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css"
	media="screen" type="text/css">
<link rel="stylesheet" href="default/css/zoomify.css" media="screen"
	type="text/css">
<link
	href="https://static.proship.vn/f/default/css/??bootstrap-switch.min.css?v65"
	media="screen" rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://static.proship.vn/f/default/js/library/??jquery-1.12.4.min.js,bootstrap.min.js,owl.carousel.min.js,select2.min.js,bootbox.min.js,jquery.slimscroll.min.js,local-storage.js,local-not-storage.js,jquery.inputmask.bundle.min.js,jquery.validate.min.js,jquery.redirect.js,swiper.min.js?v65"></script>
<script type="text/javascript"
	src="https://static.proship.vn/f/customer/js/library/??common.js?v65"></script>
<script type="text/javascript"
	src="https://static.proship.vn/f/default/js/library/??jquery.tagsinput.js,Nileupload-min.js,notify.min.js,bootstrap-switch.min.js?v65"></script>
<script type="text/javascript"
	src="https://static.proship.vn/f/default/js/my/??customer.js?v65"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="default/js/library/zoomify.js"></script>
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
									<h1>Quản lý thông tin Shipper</h1>
								</div>
							</div>

						</div>
					</div>
					<c:if test="${requestScope.thongbao != null}">
						<div class="alert alert-success">${thongbao}</div>
					</c:if>
					<div class="panel panel-custom" >
						<div class="panel-body" >
							<div class="table-responsive table-main">
								<table id="dtBasicExample"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th width="6%" class="text-left">ID</th>
											<th width="15%" class="text-left">Họ và Tên</th>
											<th width="15%" class="text-left">Số Điện Thoại/Địa Chỉ</th>
											<th width="15%" class="text-left">Email</th>
											<th width="15%" class="text-left">Số tài khoản</th>
											<th width="11%" class="text-left">Loại Xe</th>
											<th width="11%" class="text-left">Biển số xe</th>
											<th width="11%" class="text-left">Ảnh CMND</th>
											<th width="11%" class="text-left">Ảnh Bằng Lái Xe</th>
											<th width="8%" class="text-left">Chức Năng</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="datashipper">
											<tr>
												<td><s:property value="sid" /></td>
												<td><s:property value="hoten" /></td>
												<td><s:property value="sdt" />-<s:property value="diachi" /></td>
												<td class=""><s:property value="email"/></td>
												<td><s:property value="stknganhang" /></td>
												<td><s:property value="loaixe" /></td>
												<td><s:property value="biensoxe" 	/></td>
												<td><img width="70" height="70" class="img"
													src="images/<s:property value="imgcmnd" />"></td>
												<td><img width="70" height="70" class="img"
													src="images/<s:property value="imgbanglaixe" />"></td>
												<td><a href="lockshipper?sid=<s:property value="sid"/>">
														<img width="35px" height="35px"
														src="https://img.icons8.com/color/48/000000/unlock.png" />
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
	<script type="text/javascript">
		$(document).ready(function() {
			$('#dtBasicExample').DataTable({
				"pagingType" : "first_last_numbers"
			});
			$('.dataTables_length').addClass('bs-select');
		});
		$('.img').zoomify({

			duration : 300,

			easing : 'linear',

			scale : 0.6

		});
	</script>
</body>
</html>
