<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="list2" class="com.test.struts2.dao.LayTatCaDonHangDAO"
	scope="session" />
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,700italic,400italic,900,900italic,300italic,300,100italic,100" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="../../default/css/print.css" media="print">
        <!-- Core CSS -->
        <title>Danh sách vận đơn | Proship.vn</title><meta charset="UTF-8"><link href="https://static.proship.vn/f/default/css/??bootstrap.min.css,font-awesome.min.css,owl.carousel.min.css,select2.min.css,animate.css,swiper.min.css,custom.css?v65" media="screen" rel="stylesheet" type="text/css">
<link href="https://static.proship.vn/f/customer/css/??bootstrap-datetimepicker.min.css?v65" media="screen" rel="stylesheet" type="text/css"><script type="text/javascript" async="" src="https://www.google-analytics.com/analytics.js"></script><script id="facebook-jssdk" src="https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js"></script><script async="" src="https://www.googletagmanager.com/gtm.js?id=GTM-KPJLC9L"></script><script async="" src="//www.google-analytics.com/analytics.js"></script><script type="text/javascript" src="https://static.proship.vn/f/default/js/library/??jquery-1.12.4.min.js,bootstrap.min.js,owl.carousel.min.js,select2.min.js,bootbox.min.js,jquery.slimscroll.min.js,local-storage.js,local-not-storage.js,jquery.inputmask.bundle.min.js,jquery.validate.min.js,jquery.redirect.js,swiper.min.js?v65"></script>
<script type="text/javascript" src="https://static.proship.vn/f/customer/js/library/??common.js?v65"></script>
<script type="text/javascript" src="https://static.proship.vn/f/default/js/library/moment.min.js?v65"></script>
<script type="text/javascript" src="https://static.proship.vn/f/default/js/library/moment-with-locales.min.js?v65"></script>
<script type="text/javascript" src="https://static.proship.vn/f/default/js/library/bootstrap-datetimepicker.min.js?v65"></script>
<script type="text/javascript" src="https://static.proship.vn/f/default/js/library/notify.min.js?v65"></script>
<link
	href="https://static.proship.vn/f/default/css/??bootstrap.min.css,font-awesome.min.css,owl.carousel.min.css,select2.min.css,animate.css,swiper.min.css,custom.css?v65"
	media="screen" rel="stylesheet" type="text/css">
<link href="../../default/css/khachhang.css" media="screen"
	rel="stylesheet" type="text/css">
<meta name="viewport"
	content="user-scalable=no, width=device-width, initial-scale=1">
	<style>
	.shipperimg { display: none; }    
	.parent:hover .shipperimg { display: block; }
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
								<div class="page-smalltitle-wellcome">Quản lý vận đơn</div>
							</div>
							<!-- col -->
							<div class="col-lg-4 text-right">
								<a class="btn btn-info text-uppercase"
									href="thongtindauvaotaodonhangmoi"> <i
									class="fa fa-plus icon-left"></i>Tạo vận đơn
								</a>
							</div>
							<!-- col -->
						</div>
						<!-- row -->
					</div>
					<!-- page-smalltitle -->
					<div class="panel panel-custom">
						<div class="panel-body">
							<c:if test="${requestScope.thongbaotaodonhang == 1}">
								<div class="alert alert-success">Bạn đã tạo đơn hàng thành
									công!</div>
							</c:if>
							<div class="main-filter">
								<div class="form">
									<form method="Post" action="timkiemdonhangkhachhang">
										<div class="row row-medium">
											<div class="col-md-6">
												<div class="form-group">
													<input type="text" name="madonhang" id="generalInfo"
														class="form-control" value="" placeholder="Mã vận đơn ...">
												</div>
											</div>
											<!-- col 			onfocus="(this.type='date')"
 --> 
											<div class="col-md-3 col-sm-6">
												<div class="form-group date-picker">
													<input type="text" id="createdDateFrom"
														name="createddatefrom" class="form-control" value=""
														placeholder="Ngày tạo vận đơn ( từ ngày )">
												</div>
											</div>
											<!-- col -->
											<div class="col-md-3 col-sm-6">
												<div class="form-group date-picker">
													<input type="text" name="createddateto" id="createdDateTo"
														class="form-control" value=""
														placeholder="Ngày tạo vận đơn ( đến ngày )">
												</div>
											</div>
											<!-- col -->
										</div>
										<!-- row -->
										<div class="form-group multiple-choose">
											<div class="checkbox-inline">
												<label> <input type="radio" name="radiotrangthai"
													class="multiple-item" value="1 "> Chờ xác nhận
												</label>
											</div>
											<div class="checkbox-inline">
												<label> <input type="radio" name="radiotrangthai"
													name="radiotrangthai" class="multiple-item" value="2">
													Đã xác nhận & Chờ nhận đơn
												</label>
											</div>
											<div class="checkbox-inline">
												<label> <input type="radio" name="radiotrangthai"
													class="multiple-item" value="3"> Đã nhận đơn & chờ
													lấy hàng
												</label>
											</div>
											<div class="checkbox-inline">
												<label> <input type="radio" name="radiotrangthai"
													class="multiple-item" value="4"> Đã lấy hàng & Đang
													giao hàng
												</label>
											</div>
											<div class="checkbox-inline">
												<label> <input type="radio" name="radiotrangthai"
													class="multiple-item" value="5"> Đã giao hàng
												</label>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-3 col-sm-6">
												<select name="loaitimkiem" class="form-control"
													id="loaitimkiem">
													<option value="1" selected>Theo mã đơn hàng</option>
													<option value="2">Theo ngày tạo đơn</option>
													<option value="3">Theo trạng thái đơn hàng</option>
												</select>

											</div>
											<button type="submit"
												class="btn btn-info btn-md text-uppercase">
												<i class="icon-left fa fa-search"></i>Tìm kiếm
											</button>
										</div>
									</form>
								</div>
								<!-- form -->
							</div>
							<!-- main-filter -->
							<div class="table-responsive table-main">
								<table class="table table-striped">
									<thead>
										<tr>
											<th width="12%" class="text-center"><i
												class="fa fa-barcode"></i>Mã vận đơn</th>
											<th width="15%" class="text-center"><i
												class="fa fa-clock-o"></i>Thời gian tạo</th>
											<th width="15%" class="text-center"><i
												class="fa fa-map-marker"></i>Người nhận</th>
											<th width="15%" class="text-center"><i
												class="fa fa-archive"></i>Thông tìn hàng hóa</th>
											<th width="12%" class="text-center"><i
												class="fa fa-money"></i>Phí vận chuyển</th>
											<th width="9%" class="text-center"><i class="fa fa-usd"></i>Tiền
												thu hộ</th>
											<th width="12%" class="text-center"><i
												class="fa fa-sticky-note"></i>Ghi chú</th>
											<th width="12%" class="text-center">Trạng thái</th>
											<th width="10%" class="text-center"><i
												class="fa fa-archive"></i>Thông tin Shipper</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											
											<c:when test="${timkiemtheomadonhang != null }">
												<c:forEach var="list" items="${timkiemtheomadonhang }">
													<tr>
														<td width="12%" class="text-center">${list.madonhang }</td>
														<td width="15%" class="text-center">${list.ngaytaodon }</td>
														<td width="15%" class="text-center">${list.sdtnguoinhan }
															- ${list.hotennguoinhan } - ${list.diachinguoinhan }</td>
														<td width="15%" class="text-center">${list.tenhanghoa }
															- ${list.kluong } KG</td>
														<td width="12%" class="text-center">${list.pvanchuyen }</td>
														<td width="9%" class="text-center">${list.pthuho }</td>
														<td width="12%" class="text-center">${list.ghichu }</td>
														<td width="12%" class="text-center">${list.trangthaidonhang }</td>
														<c:choose>
															<c:when test="${list.sdtshipper == null }">
																<td width="10%" class="text-center">Trống</td>
															</c:when>
															<c:otherwise>
																<td width="10%" class="text-center">${list.sdtshipper }
																	- ${list.hotenshipper }</td>

															</c:otherwise>

														</c:choose>
													</tr>

												</c:forEach>
											</c:when>
											<c:when test="${timkiemtheotrangthai != null }">
												<c:forEach var="list" items="${timkiemtheotrangthai }">
													<tr>
														<td width="12%" class="text-center">${list.madonhang }</td>
														<td width="15%" class="text-center">${list.ngaytaodon }</td>
														<td width="15%" class="text-center">${list.sdtnguoinhan }
															- ${list.hotennguoinhan } - ${list.diachinguoinhan }</td>
														<td width="15%" class="text-center">${list.tenhanghoa }
															- ${list.kluong } KG</td>
														<td width="12%" class="text-center">${list.pvanchuyen }</td>
														<td width="9%" class="text-center">${list.pthuho }</td>
														<td width="12%" class="text-center">${list.ghichu }</td>
														<td width="12%" class="text-center">${list.trangthaidonhang }</td>
														<c:choose>
															<c:when test="${list.sdtshipper == null }">
																<td width="10%" class="text-center">Trống</td>
															</c:when>
															<c:otherwise>
																<td width="10%" class="text-center">${list.sdtshipper }
																	- ${list.hotenshipper }</td>

															</c:otherwise>

														</c:choose>
													</tr>

												</c:forEach>
											</c:when>
											<c:when test="${timkiemtheongaytaodon != null }">
												<c:forEach var="list" items="${timkiemtheongaytaodon }">
													<tr>
														<td width="12%" class="text-center">${list.madonhang }</td>
														<td width="15%" class="text-center">${list.ngaytaodon }</td>
														<td width="15%" class="text-center">${list.sdtnguoinhan }
															- ${list.hotennguoinhan } - ${list.diachinguoinhan }</td>
														<td width="15%" class="text-center">${list.tenhanghoa }
															- ${list.kluong } KG</td>
														<td width="12%" class="text-center">${list.pvanchuyen }</td>
														<td width="9%" class="text-center">${list.pthuho }</td>
														<td width="12%" class="text-center">${list.ghichu }</td>
														<td width="12%" class="text-center">${list.trangthaidonhang }</td>
														<c:choose>
															<c:when test="${list.sdtshipper == null }">
																<td width="10%" class="text-center">Trống</td>
															</c:when>
															<c:otherwise>
																<td width="10%" class="text-center">${list.sdtshipper }
																	- ${list.hotenshipper }</td>

															</c:otherwise>

														</c:choose>
													</tr>

												</c:forEach>
											</c:when>
											<c:otherwise>

												<c:forEach var="list"
													items="${list2.getAlldonhangkhachhang(cusid) }">
													<tr>
														<td width="12%" class="text-center">${list.madonhang }</td>
														<td width="15%" class="text-center">${list.ngaytaodon }</td>
														<td width="15%" class="text-center">${list.sdtnguoinhan }
															- ${list.hotennguoinhan } - ${list.diachinguoinhan }</td>
														<td width="15%" class="text-center">${list.tenhanghoa }
															- ${list.kluong } KG</td>
														<td width="12%" class="text-center">${list.pvanchuyen }</td>
														<td width="9%" class="text-center">${list.pthuho }</td>
														<td width="12%" class="text-center">${list.ghichu }</td>
														<td width="12%" class="text-center">${list.trangthaidonhang }</td>
														<c:choose>
															<c:when test="${list.sdtshipper == null }">
																<td width="10%" class="text-center">Trống</td>
															</c:when>
															<c:otherwise>
																<td width="10%" class="text-center parent">
																<p style="text-align: center;"><img style="witdh: 100px;height:100px;" class="shipperimg" src="../../default/images/trungpv.jpg"></p>
																<p style="text-align: center;">${list.sdtshipper }
																	- ${list.hotenshipper }</p>
																	</td>

															</c:otherwise>

														</c:choose>
													</tr>

												</c:forEach>

											</c:otherwise>
										</c:choose>
										<!--                                 <td colspan="15" class="text-center">Hiện tại chưa có vận đơn nào</td> -->
									</tbody>
								</table>
							</div>
							<!-- table-responsive -->
						</div>
						<!-- panel-body -->
					</div>
					<!-- panel -->
				</div>
			</div>
			<script type="text/javascript">
				$(':radio:not(:checked)').attr('disabled', true);
				$('#createdDateFrom').attr('readonly', true);
				$('#createdDateTo').attr('readonly', true);
				$("#loaitimkiem").change(function() {
					var loaitimkiem = $(this).val();
					if (loaitimkiem == 1) {
						$('#generalInfo').attr('readonly', false);
						$(':radio:not(:checked)').attr('disabled', true);
						$('#createdDateFrom').attr('readonly', true);
						$('#createdDateTo').attr('readonly', true);
					} else if (loaitimkiem == 2) {
						$(':radio:not(:checked)').attr('disabled', true);
						$('#generalInfo').attr('readonly', true);
						$('#createdDateFrom').attr('readonly', false);
						$('#createdDateTo').attr('readonly', false);
					} else {
						$(':radio:not(:checked)').attr('disabled', false);
						$('#createdDateFrom').attr('readonly', true);
						$('#createdDateTo').attr('readonly', true);
						$('#generalInfo').attr('readonly', true);
					}
				});
				// });
			</script>
			<%@ include file="layout/Footer.jsp"%>
		</div>
	</div>
</body>
</html>
