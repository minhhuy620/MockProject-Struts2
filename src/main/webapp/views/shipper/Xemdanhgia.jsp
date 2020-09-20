<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="list2" class="com.test.struts2.dao.LayTatCaDonHangDAO"
	scope="session" />
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="../../default/images/favicon-16x16.png">
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,700,700italic,400italic,900,900italic,300italic,300,100italic,100'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../../default/css/print.css" media="print">
<!-- Core CSS -->
<title>Xem đánh giá | Shipbee.vn</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
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
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-rating/1.5.0/bootstrap-rating.js"></script>
<meta name="viewport"
	content="user-scalable=no, width=device-width, initial-scale=1">
<style type="text/css">
	.rating-symbol {
		color: #FFD700;
	}
</style>
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
								<div class="page-smalltitle-wellcome">Xem đánh giá</div>
							</div>
							<!-- col -->
						</div>
						<!-- row -->
					</div>
					<!-- page-smalltitle -->
					<div class="panel panel-custom">
						<div class="panel-body">
							<c:if test="${requestScope.thongbao != null}">
								<div class="alert alert-success">${thongbao}</div>
							</c:if>
						</div>
						<!-- main-filter -->
						<div class="table-responsive table-main">
							<table class="table table-striped">
								<thead>
									<tr>
										<th width="10%" class="text-left"><i
											class="fa fa-barcode"></i>Mã đơn hàng</th>
										<th width="15%" class="text-left"><i class="fas fa-user"></i>Họ
											tên khách hàng</th>
										<th width="20%" class="text-left"><i
											class="fas fa-comment-alt"></i>Nhận xét</th>
										<th width="10%" class="text-left"><i class="fas fa-star"></i>Sao</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="dataList">
										<tr>
											<td><s:property value="madonhang" /></td>
											<td><s:property value="hotenkhach" /></td>
											<td><s:property value="comment" /></td>
											<td><input type="hidden" class="rating"
												value="<s:property value="sao" />" data-readonly></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
						<!-- table-responsive -->
					</div>
					<!-- panel-body -->
				</div>
				<!-- panel -->

				<script>
					$(function() {
						$(".rating").rating();
					});
				</script>

			</div>
			<%@ include file="layout/Footer.jsp"%>
		</div>

	</div>

</body>
</html>
