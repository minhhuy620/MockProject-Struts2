<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.test.struts2.model.PhamViKhoangCach"%>
<jsp:useBean id="list" class="com.test.struts2.dao.QuanHuyenDAO" scope="session" />
<jsp:useBean id="listkhoangcach" class="com.test.struts2.dao.LayKhoangCachDAO" scope="session"  />/

<!DOCTYPE html>
<html lang="en-US" > 
<head>
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,700,700italic,400italic,900,900italic,300italic,300,100italic,100'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../../default/css/print.css" media="print">
<!-- Core CSS -->
<title>Tạo đơn hàng mới | Shipbee.vn</title>
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
					<form method="post" action="taodonhangmoi" id="frm"
						class="form-7 receiver-form" novalidate="novalidate">
						<div class="page-smalltitle invoice-sidebar">
						<c:if test="${requestScope.thongbaotaodonhang == 2}">
                      <div class="alert alert-danger">Tạo đơn hàng thất bại, vui lòng thử lại!</div>
						</c:if>
							<div class="row row-medium">
								<div class="col-lg-12">
									<div class="page-smalltitle-wellcome">Tạo vận đơn mới</div>
								</div>
								<!-- col -->
							</div>
							<!-- row -->
						</div>
						<!-- page-smalltitle -->
						<div class="panel panel-custom">
							<div class="panel-body">
								<div class="row row-medium">
									<div class="col-lg-4">
										<div class="create-title">1, Địa chỉ</div>
										<div class="form form-horizontal form-create">
											<div class="form-group">
												<div class="col-sm-12">
													<b>Địa chỉ lấy hàng</b>
												</div>
											</div>
											<div class="show-infor">
												<div class="form-group">
													<label class="control-label col-sm-3">Số điện
														thoại:</label>
													<div class="col-sm-9">
														<input value="${sdtnguoigui }" type="text" name="sdtnguoigui"
															id="sdtgui" class="form-control receiverPhone phone"
															placeholder="Vui lòng nhập số điện thoại người gửi">
													</div>
												</div>
												<div class="form-group sender-address-default">
													<label class="control-label col-sm-3">Họ tên:</label>
													<div class="col-sm-9">
														<input type="text" class="form-control phone"
															value="${hoten }" name="hotengui">
													</div>
												</div>
												<div class="form-group sender-address-default">
													<label class="control-label col-sm-3">Địa chỉ:</label>
													<div class="col-sm-9">
														<input type="text" class="form-control phone"
															value="${diachi }" name="diachigui">
													</div>
												</div>
												<div class="form-group sender-address-default">
													<label class="control-label col-sm-3">Quận/ huyện:</label>
													<div class="col-sm-9">
														<select
															class="form-control district lsDistrict select-fix-address tinhtien"
															name="" id="quanhuyen"
															data-target="receiver-district">
															<c:forEach var="list" items="${list.allquanhuyen}">
																<c:choose>
																	<c:when test="${ idquanhuyen == list.idquanhuyen}">
																		<option selected value="${idquanhuyen }">${quan_huyen }</option>
																	</c:when>
																	<c:otherwise>
																		<option value="${list.idquanhuyen }">
																			${list.quanhuyen }</option>
																	</c:otherwise>
																</c:choose>
															</c:forEach>

														</select>
													</div>

												</div>
												<div class="form-group sender-address-default">
													<label class="control-label col-sm-3">Phường/ xã:</label>
													<div class="col-sm-9">
														<select
															class="form-control price-preview ward lsWard select-fix-address"
															name="idphuongxagui" id="phuongxa"
															data-target="receiver-ward">
															<c:choose>
																<c:when test="${ phuong_xa == null}">
																	<option value="0">Vui lòng chọn quận / huyện
																		trước</option>
																</c:when>
																<c:otherwise>
																	<option selected value="${idphuongxa }">
																		${phuong_xa }</option>
																	</option>
																</c:otherwise>
															</c:choose>

														</select>
													</div>
												</div>

											</div>
											<div class="form-group">
												<div class="col-sm-12">
													<b>Địa chỉ nhận hàng</b>
												</div>
											</div>
											<div class="block-address" data-allow-delivery="1">
												<div class="form-group">
													<label class="control-label col-sm-3">Số điện
														thoại:</label>
													<div class="col-sm-9">
														<input type="text" name="sdtnguoinhan"
															class="form-control receiverPhone phone"
															placeholder="Vui lòng nhập số điện thoại người nhận">
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-3">Họ tên:</label>
													<div class="col-sm-9">
														<input type="text" name="hotennhan" id="hotennhan"
															class="form-control receiverName"
															placeholder="Vui lòng nhập họ tên người nhận">
													</div>
												</div>


												<!-- office -->

												<div
													class="receiver-address-c-d-w local-storage-destination">
													<div class="form-group receiver-address-default">
														<label class="control-label col-sm-3">Địa chỉ:</label>
														<div class="col-sm-9">
															<input type="text" name="diachinhan" id="diachinhan"
																class="form-control receiverAddress"
																placeholder="Vui lòng nhập địa chỉ nhận"
																data-target="receiver-address">
														</div>
													</div>
													<div class="form-group">
														<label class="control-label col-sm-3">Quận/ huyện:</label>
														<div class="col-sm-9">
															<select
																class="form-control district lsDistrict select-fix-address tinhtien"
																name="" id="quanhuyennhan"
																data-target="receiver-district">
																<option value="0"> Choose an option </option>
																<c:forEach var="list" items="${list.allquanhuyen}">																
																	<option value="${list.idquanhuyen }">
																		${list.quanhuyen }</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="form-group">
														<label class="control-label col-sm-3">Phường/ xã:</label>
														<div class="col-sm-9">
															<select
																class="form-control price-preview ward lsWard select-fix-address"
																name="idphuongxanhan" id="phuongxanhan"
																data-target="receiver-ward">
																<option value="0"></option>
															</select>
														</div>
													</div>
												</div>
											</div>
										</div>
										<!-- form -->
									</div>
									<!-- col -->
									<div class="col-lg-4">
										<div class="create-title">2, Hàng hóa</div>
										<div class="form form-horizontal form-create">
											<div class="form-group">
												<label class="control-label col-sm-3">Tên hàng hóa:</label>
												<div class="col-sm-9">
													<input type="text" name="tenhanghoa" id="tenhanghoa"
														class="form-control " placeholder="Ví dụ: Tên sản phẩm">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3">Người trả phí:</label>
												<div class="col-sm-9">
													<select class="form-control price-preview"
														name="tid" id="nguoitraphi">
														<option value="1">Người gửi trả phí</option>
														<option value="2">Người nhận trả phí</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3">Khối lượng:</label>
												<div class="col-sm-9">
													<input lang="en" type="number" min="0" max="50" step="0.1"
														name="kluong" id="khoiluong"
														class="form-control text-small  price-preview weigh tinhtien"
														value="" placeholder="KG" > <span class="text-desc">KG</span>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3">Ghi chú:</label>
												<div class="col-sm-9">
													<input type="text" name="ghichu" id="ghichu"
														class="form-control" placeholder="Ví dụ: hàng dễ vỡ">
												</div>
											</div>
											<div class="form-group">
												<label for="copperTestService"
													class="control-label col-sm-3"></label>
												<div class="col-sm-9">
													<label> <input id="copperTestService"
														type="checkbox" value="5" name="additionService[]">
														Cho người nhận xem hàng
													</label>
												</div>
											</div>
										</div>
										<!-- form -->
									</div>
									<!-- col -->
									<div class="col-lg-4">
										<div class="create-title">3, Dịch vụ</div>
										<div class="form form-horizontal form-create">
											<div class="form-group">
												<label class="control-label col-sm-3">Phương tiện
													vận chuyển:</label>
												<div class="col-sm-9">
													<select class="form-control price-preview tinhtien" name="lid"
														id="loaixe">
														<option value="1">Xe máy</option>
														<option value="2">Xe tải dưới 3,5 tấn</option>
														<option value="3">Xe tải trên 3,5 tấn</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3">Gói vận
													chuyển:</label>
												<div class="col-sm-9">
													<select class="form-control price-preview tinhtien"
														name="vid" id="goivanchuyen">
														<option value="1">Tiêu chuẩn</option>
														<option value="2">Nhanh chóng</option>
														<option value="3">Hỏa tốc (tối đa 4h)</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-3">Thu hộ (COD):</label>
												<div class="col-sm-9">
													<input type="number" step="500" name=""
														id="phithuho"
														class="form-control toggle-input  price-preview price-mask tinhtien"
														value="" placeholder="Vui lòng nhập giá trị tiền (VNĐ)">
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-9" id="inputpvanchuyen">
													
												</div>
											</div>
											<div class="text-center" id="xemgiatien">
                <button  class="btn btn-info text-uppercase btn-lg" onclick="tinhtien();(function thaydoi(){$('.tinhtien').change(function() {var foo = tinhtien();foo.thaydoitien();});})()">
                                	Xem giá tiền
            	            	</button>
            								</div>
											<div class="get-item block-price block-price-1">
												<div class="get-content" style="display: block;"
													id="phivanchuyen">
													</div>
											</div>
										</div>
										<!-- get-box -->
									</div>
									<!-- col -->
								</div>
								<!-- row -->
							</div>
							<!-- panel-body -->
						</div>
						<!-- panel -->
					</form>

				</div>
				<script type="text/javascript">
					$(document).ready(function() {
						$("#quanhuyen").change(function() {
							var idQuanhuyen = $(this).val();
							$.get("diachimacdinh", function() {
								if (idQuanhuyen == 1) {
									$("#phuongxa").html("${data1}");
								} else if (idQuanhuyen == 2) {
									$("#phuongxa").html("${data2}");
								} else if (idQuanhuyen == 3) {
									$("#phuongxa").html("${data3}");
								} else if (idQuanhuyen == 4) {
									$("#phuongxa").html("${data4}");
								} else if (idQuanhuyen == 5) {
									$("#phuongxa").html("${data5}");
								} else if (idQuanhuyen == 6) {
									$("#phuongxa").html("${data6}");
								} else {
									$("#phuongxa").html("${data7}");
								}
							});
						});
					})
				</script>
				<script type="text/javascript">
					$(document).ready(function() {
						$("#quanhuyennhan").change(function() {
							var idQuanhuyen = $(this).val();
							$.get("diachimacdinh", function() {
								if (idQuanhuyen == 0){
									$("#phuongxanhan").html("");
								}
								else if (idQuanhuyen == 1) {
									$("#phuongxanhan").html("${data1}");
								} else if (idQuanhuyen == 2) {
									$("#phuongxanhan").html("${data2}");
								} else if (idQuanhuyen == 3) {
									$("#phuongxanhan").html("${data3}");
								} else if (idQuanhuyen == 4) {
									$("#phuongxanhan").html("${data4}");
								} else if (idQuanhuyen == 5) {
									$("#phuongxanhan").html("${data5}");
								} else if (idQuanhuyen == 6) {
									$("#phuongxanhan").html("${data6}");
								} else {
									$("#phuongxanhan").html("${data7}");
								}
							});
						});
					})
				</script>
				<script>
					function tinhtien() {
						var quanhuyengui = $("#quanhuyen").val();
						var quanhuyennhan = $("#quanhuyennhan").val();
						var khoiluong = $("#khoiluong").val();
						var loaixe = $("#loaixe").val();
						var goivanchuyen = $("#goivanchuyen").val();
						var phithuho = $("#phithuho").val();
						if(phithuho == ''){
							phithuho = 0;
						}
						var arrkid = ${listkhoangcach.kid};
						var arrgquanhuyen = ${listkhoangcach.gquanhuyen};
						var arrnquanhuyen = ${listkhoangcach.nquanhuyen};
						var arrkm = ${listkhoangcach.km};
						var index;
						for (index = 0; index < arrkid.length; ++index) {
							if (quanhuyengui == arrgquanhuyen[index]
									&& quanhuyennhan == arrnquanhuyen[index]) {
								var km = arrkm[index];
							}
						}
						if (goivanchuyen == 3) {
							goivanchuyen = goivanchuyen * 5
						} else if (goivanchuyen == 2) {
							goivanchuyen = goivanchuyen * 2
						}
						var phivanchuyen = km * 1500 + khoiluong * 4000
								* loaixe * goivanchuyen
						if (phivanchuyen < 12000) {
							phivanchuyen = 12000;
						}				
					document.getElementById("xemgiatien").innerHTML=("");
					document.getElementById("phivanchuyen").innerHTML = ("<div class='get-content-gray'><p class='p-icon'><i class='fa fa-check-square-o'></i>Phí vận chuyển:  "
								+ phivanchuyen + "  VNĐ</p>"+"<p class='p-icon'><i class='fa fa-check-square-o'></i>Phí thu hộ:  "+phithuho+"  VNĐ</p>"+"<p class='p-icon'><i class='fa fa-check-square-o'></i>Phí đã bao gồm VAT </p>"+"<div class='text-center'><button  class='btn btn-info text-uppercase btn-lg' type='submit' >Tạo vận đơn ngay </button>");
					document.getElementById("inputpvanchuyen").innerHTML=("<input type='hidden' name='pvanchuyen' value='"+phivanchuyen+"'><input type='hidden' name='pthuho' value='"+phithuho+"'>");
										
					function thaydoitien(){
							document.getElementById("phivanchuyen").innerHTML = ("<div class='get-content-gray'><p class='p-icon'><i class='fa fa-check-square-o'></i>Phí vận chuyển:  "
									+ phivanchuyen + "  VNĐ</p>"+"<p class='p-icon'><i class='fa fa-check-square-o'></i>Phí thu hộ:  "+phithuho+"  VNĐ</p>"+"<p class='p-icon'><i class='fa fa-check-square-o'></i>Phí đã bao gồm VAT </p>"+"<div class='text-center'><button  class='btn btn-info text-uppercase btn-lg' type='submit' >Tạo vận đơn ngay </button>");
						document.getElementById("inputpvanchuyen").innerHTML=("<input type='hidden'  name='pvanchuyen' value='"+phivanchuyen+"'><input type='hidden' name='pthuho' value='"+phithuho+"'>");
								}
					}
				</script>
<script type="text/javascript">
				$(function() {
					 $.validator.addMethod("valueNotEquals", function(value, element, arg){
						  return arg !== value;
						 }, "Chon Quan Huyen");
					$.validator.addMethod("phoneVN", function(phone_number, element) {
			    phone_number = phone_number.replace(/\s+/g, "");
			    return this.optional(element) || phone_number.length > 9 && 
			    phone_number.match(/^0(1\d{9}|9\d{8})$/);
			}, "Vui lòng chỉ định một số điện thoại hợp lệ")
					$("#frm").validate({
						errorClass: 'errors',
						rules: {
							hotennhan: {
								required: true		
							},
							sdtnguoinhan: {
								required: true,
								phoneVN: true
								
							},
							diachinhan: {
								required: true
							},
							quanhuyennhan: {
								 valueNotEquals: "0" 
							},
							tenhanghoa: {
								required: true
							},
							kluong: {
								required: true,
								number: true
							},
							phithuho: {
								required: true,
								number: true
							}
						},
						messages: {
							hotennhan: {
								required: 'Vui lòng nhập họ tên người nhận.'
							},
							sdtnguoinhan: {
								required: "Vui lòng nhập số điện thoại người nhận."
							},
							diachinhan: {
								required: "Vui lòng nhập địa chỉ người nhận."
							},
							quanhuyennhan: {
								required: "Vui lòng nhập quận huyện."
							},
							tenhanghoa: {
								required: "Vui lòng nhập tên hàng hóa."
							},
							kluong: {
								required: "Vui lòng nhập khối lượng."
							}
						},
						highlight: function (element) {
			                $(element).parent().addClass('error')
			            },
			            unhighlight: function (element) {
			                $(element).parent().removeClass('error')
			            }
					})
				})
				</script>
			</div>
			<%@ include file="layout/Footer.jsp"%>
		</div>
	</div>
</body>
<style>  .error {
      color: red;
   }</style>
</html>


