<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,700,700italic,400italic,900,900italic,300italic,300,100italic,100'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="default/css/print.css" media="print">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<!-- Core CSS -->
<title>Giao hàng nhanh - Dịch Vụ ship vận chuyển hàng chuyên
	nghiệp | ShipBee.vn</title>
<meta charset="UTF-8">
<link href="default/css/bootstrap.css" media="screen" rel="stylesheet"
	type="text/css">
<link href="default/css/style.css" media="screen" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="default/js/library/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="default/js/library/common.js"></script>
<script type="text/javascript" src="default/js/library/jquery.inview.js"></script>
<script type="text/javascript"
	src="https://static.proship.vn/f/default/js/library/??jquery.validate.min.js?v65"></script>
<script type="text/javascript" src="default/js/my/comments.js"></script>
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


	<div class="navigator">
		<div class="navigator-top">
			<div class="container">
				<div class="box-admin">
					<ul>
						<li><a href="views/user/Dangnhap.jsp"><i
								class="fa fa-sign-in"></i><span class="hidden-xs">Đăng
									nhập</span></a></li>
						<li><a href="views/user/Dangkikhachhang.jsp"><i
								class="fa fa-edit"></i><span class="hidden-xs">Đăng ký</span></a></li>
						<li><a href="views/shipper/Dangnhap.jsp"><i
								class="fa fa-sign-in"></i><span class="hidden-xs">Đăng
									nhập Shipper</span></a></li>
						<li><a href="views/shipper/DangkiShipper.jsp"><i
								class="fa fa-edit"></i><span class="hidden-xs">Đăng ký
									Shipper</span></a></li>
						<li><a href="tel:19001800"><i class="fa fa-phone"></i>
								CSKH: 1900 1800</a></li>
						<li class="hidden-xs"><a href="tel: 0939999999"><i
								class="fa fa-phone"></i> Kinh doanh: 093 9999 999 </a></li>
						<li><a href="inadmin">Admin<span class="hidden-xs"></span></a></li>
					</ul>
				</div>
				<!-- box-admin -->
			</div>
			<!-- container -->
		</div>
		<!-- navigator-top -->
		<div class="header">
			<div class="header-top">
				<div class="container">
					<div class="logo">
						<a href="#"><img src="default/images/logo.png" alt="" /></a>
					</div>
					<button class="expand-menu" type="button">
						<span></span>
					</button>
					<div class="menu">
						<ul>
							<li class="active"><a href="/ShipBee"><i
									class="icon28-home"></i><span class="mobile-text">Trang
										chủ</span></a></li>
							<li class="li-submenu"><a
								href="#">GIỚI THIỆU<span
									class="btn-submenu fa fa-plus"></span></a></li>
							<li class="li-submenu"><a href="#"
								title="GIAO HÀNG NỘI THÀNH">Giao hàng nội thành<span
									class="btn-submenu fa fa-plus"></span></a>
								<div class="submenu">
									<ul>
										<li><a href="#" title="Hệ thống bảng giá">Hệ thống
												bảng giá</a></li>
										<li><a href="#" title="">Giao hàng toàn Đà Nẵng</a></li>
										<li><a href="#" title="Quy trình giao nhận hàng hóa">Quy
												trình giao nhận hàng hóa</a></li>
									</ul>
								</div></li>
							<li class="li-submenu"><a href="#"
								title="GIAO HÀNG TOÀN QUỐC">Giao hàng toàn quốc<span
									class="btn-submenu fa fa-plus"></span></a>
								<div class="submenu">
									<ul>
										<li><a href="#" title="Hệ thống bảng giá">Hệ thống
												bảng giá</a></li>
										<li><a href="#" title="Quy trình giao nhận hàng hóa">Quy
												trình giao nhận hàng hóa</a></li>
										<li><a href="#" title="Vận chuyển hàng hóa đi Đà Nẵng">Vận
												chuyển hàng hóa đi Đà Nẵng</a></li>
									</ul>
								</div></li>
							<li class="li-submenu"><a href="#" title="CHO THUÊ KHO">Cho
									thuê kho<span class="btn-submenu fa fa-plus"></span>
							</a>
								<div class="submenu">
									<ul>
										<li><a href="#" title="Bảng giá cho thuê kho">Bảng
												giá cho thuê kho</a></li>
										<li><a href="#"
											title="Bảng giá vận chuyển xe tải và bốc xếp">Bảng giá
												vận chuyển xe tải và bốc xếp</a></li>
										<li><a href="#" title="Quy trình vận hành kho">Quy
												trình vận hành kho</a></li>
										<li><a href="#" title="Điều khoản - Điều lệ cho thuê kho">Điều
												khoản - Điều lệ cho thuê kho</a></li>
									</ul>
								</div></li>
							<li class="li-submenu"><a href="#" title="TIN TỨC">Tin
									tức<span class="btn-submenu fa fa-plus"></span>
							</a>
								<div class="submenu">
									<ul>
										<li><a target="_blank" href="#" title="TUYỂN DỤNG">Tuyển
												dụng</a></li>
									</ul>
								</div></li>
							<li><a href="#">Liên hệ</a></li>
						</ul>
					</div>
					<!-- menu -->
					<div class="clearfix"></div>
				</div>
				<!-- container -->
			</div>
			<!-- header-top -->
			<div class="header-bottom">
				<div class="container">
					<div class="header-bottom-inner clearfix">
						<div class="header-bottom-left"></div>
						<div class="header-bottom-center">
							<div class="header-news">
								<i class="icon28-speaker"></i>
								<div class="header-news-slider">
									<div id="hnslider" class="owl-carousel">
										<div class="hn-item">
											<a href="#"><span class="hn-name">ShipBee chung
													tay cùng nhà nước đẩy lùi dịch Covid-19</span></a>
										</div>
										<div class="hn-item">
											<a href="#"><span class="hn-name">Thông báo về
													tình trạng ách tắc hàng không và giải pháp của ShipBee</span></a>
										</div>
										<div class="hn-item">
											<a href="#"><span class="hn-name">Dịch vụ phun khử
													trùng, sát khuẩn phòng chống dịch bệnh Corona</span></a>
										</div>
									</div>
									<!-- owl-carousel -->
								</div>
								<!-- header-news-slider -->
							</div>
							<!-- header-news -->
						</div>
						<!-- header-bottom-center -->
						<div class="header-bottom-right"></div>
					</div>
					<!-- header-bottom-inner -->
				</div>
				<!-- container -->
			</div>
			<!-- header-bottom -->
		</div>
		<!-- header -->
	</div>
	<!-- navigator -->
	<div class="main-slider">
		<section class="home-slider-block js-home-slider-block">
			<div class="slider-container">
				<div class="swiper-wrapper">
					<!-- Slides -->
					<div class="swiper-slide"
						style="background-image: url('default/images/slide1.png')">
						<a class="link" href="#"></a>
					</div>
					<div class="swiper-slide"
						style="background-image: url('https://images.squarespace-cdn.com/content/v1/529fc0c0e4b088b079c3fb6d/1590431539873-4GLK9BJT1R4NY7GO3OIP/ke17ZwdGBToddI8pDm48kFyD7pzB8zoMIVY5aiUuFlp7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0jG2lbcDYBOeMi4OFSYem8DMb5PTLoEDdB05UqhYu-xbnSznFxIRsaAU-3g5IaylIg/ShipperBee_Mar2019_10.jpg')">
						<a class="link" href="#"></a>
					</div>
				</div>

				<div class="swiper-pagination"></div>

				<div class="swiper-button-prev"></div>
				<div class="swiper-button-next"></div>
			</div>

			<div class="container">
				<div class="main-intro">
					<div class="main-intro-block">
						<div class="main-intro-title">
							<ul>
								<li class="active"><a href="javascript:void(0);">Chuyển
										phát nhanh</a></li>
							</ul>
						</div>
						<div class="main-intro-content">
							<div class="main-intro-folow">
								<i class="icon40-file-search"></i>
								<div class="main-intro-desc">
									<div class="main-intro-name">Theo dõi vận đơn</div>
									<div class="main-intro-smallname">Dễ dàng theo dõi hành
										trình</div>
								</div>
								<div class="main-intro-search">

								
								</div>
							</div>
							<!-- main-intro-folow -->
							<div class="main-intro-row">
								<a href="views/user/Dangnhap.jsp"> <i class="icon40-file-create"></i> <i
									class="fa fa-chevron-right"></i> <span class="main-intro-desc">
										<span class="main-intro-name">Tạo Vận đơn</span> <span
										class="main-intro-smallname">Nhanh chóng tạo đơn hàng</span>
								</span>
								</a>
							</div>
							<!-- main-intro-row -->
							<div class="main-intro-row">
								<a href="#"> <i class="icon40-comment"></i> <i
									class="fa fa-chevron-right"></i> <span class="main-intro-desc">
										<span class="main-intro-name">Sự cố đơn hàng</span> <span
										class="main-intro-smallname">Gửi yêu cầu than phiền,
											khiếu nại</span>
								</span>
								</a>
							</div>
							<!-- main-intro-row -->
							<div class="main-intro-row">
								<a href="#"> <i
									class="icon40-money"></i> <i class="fa fa-chevron-right"></i> <span
									class="main-intro-desc"> <span class="main-intro-name">BẢNG
											GIÁ CƯỚC</span> <span class="main-intro-smallname">Rõ ràng và
											chi tiết</span>
								</span>
								</a>
							</div>
							<!-- main-intro-row -->
						</div>
						<!-- main-intro-content -->
					</div>
					<!-- main-intro-block -->
				</div>
			</div>
		</section>
	</div>
	<div class="procedure">
		<div class="procedure-view">
			<div class="container">
				<div class="box">
					<div class="box-title text-center">
						<div class="box-title-name">
							Quy trình <span class="text-info">giao nhận</span>
						</div>
						<div class="box-title-line"></div>
					</div>
					<div class="box-content">
						<div class="procedure-steps">
							<div class="ps-item procedure-fade1">
								<div class="ps-top">BƯỚC 1</div>
								<div class="ps-title">GỬI YÊU CẦU GIAO HÀNG</div>
								<div class="ps-img" style="float: left">
									<img
										src="https://static.proship.vn/f/default/images/procedure-step_1.png"
										alt="step1" />
								</div>
								<div class="ps-content">
									<p>
										<i class="fa fa-check"></i>Quý khách vui lòng gọi điện cho
										tổng đài ShipBee.
									</p>
									<p>
										<i class="fa fa-check"></i>Hoặc đăng nhập vào hệ thống <span
											class="text-info">ShipBee</span> (Web ) tạo đơn hàng.
									</p>
								</div>
							</div>
							<!-- ps-item -->
							<div class="ps-item procedure-fade2">
								<div class="ps-top">BƯỚC 2</div>
								<div class="ps-title">ShipBee nhận hàng của quý khách</div>
								<div class="ps-img">
									<img width="160px" height="160px"
										src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ4iF4NuUU0jJ7jGtyvfpV-LhqAsd0GwIy9xA&usqp=CAU"
										alt="step2" />
								</div>
								<div class="ps-content">
									<p>
										<i class="fa fa-check"></i>Nhân viên ShipBee sẽ đến tận địa
										chỉ của quý khách.
									</p>
									<p>
										<i class="fa fa-check"></i>Hoặc Quý khách vui lòng mang đến
										bưu cục ShipBee gần nhất .
									</p>
								</div>
							</div>
							<!-- ps-item -->
							<div class="ps-item procedure-fade3">
								<div class="ps-top">BƯỚC 3</div>
								<div class="ps-title">ShipBee tiến hành gửi hàng</div>
								<div class="ps-img">
									<img width="160px" height="160px"
										src="default/images/procedure-step_3.png" alt="step3" />
								</div>
								<div class="ps-content">
									<p>
										<i class="fa fa-check"></i>Nhân viên ShipBee sẽ chuyển hàng
										đến địa chỉ gửi.
									</p>
									<p>
										<i class="fa fa-check"></i>Đối với tiền thu hộ vui lòng xem <a
											target="_blank" href="">tại đây</a>.
									</p>
								</div>
							</div>
							<!-- ps-item -->
							<div class="ps-item procedure-fade4">
								<div class="ps-top">BƯỚC 4</div>
								<div class="ps-title">Kết thúc giao dịch</div>
								<div class="ps-img">
									<img
										src="https://static.proship.vn/f/default/images/procedure-step_4.png"
										alt="step1" />
								</div>
								<div class="ps-content">
									<p>
										<i class="fa fa-check"></i>Cảm ơn Quý khách tin tưởng, ShipBee
										luôn nỗ lực đem tới sự hài lòng trong quá trình sử dụng sản
										phẩm.
									</p>
									<p>
										<i class="fa fa-check"></i>Ý kiến thắc mắc hoặc đóng góp về
										sản phẩm dịch vụ <a target="_blank" href="">tại đây</a>
									</p>
								</div>
							</div>
							<!-- ps-item -->
						</div>
						<!-- procedure-steps -->
					</div>
					<!-- box-content -->
				</div>
				<!-- box -->
			</div>
			<!-- container -->
		</div>
		<!-- procedure-view -->
		<div class="procedure-road">
			<div class="container">
				<div class="procedure-road-inner">
					<span class="procedure-road-bike movebike"><img width="151"
						height="156" src="default/images/procedure-bike.png" alt=""></span>
				</div>
				<!-- procedure-road-inner -->
			</div>
			<!-- container -->
		</div>
		<!-- procedure-road -->
		<div class="procedure-ground">
			<div class="container">
				<div class="procedure-namesteps">
					<div class="pn-item procedure-fade1">
						<div class="pn-circle active">
							Bước<br />01
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle">
							Bước<br />02
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle">
							Bước<br />03
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle">
							Bước<br />04
						</div>
					</div>
					<!-- pn-item -->
					<div class="pn-item procedure-fade2">
						<div class="pn-circle">
							Bước<br />01
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle active">
							Bước<br />02
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle">
							Bước<br />03
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle">
							Bước<br />04
						</div>
					</div>
					<!-- pn-item -->
					<div class="pn-item procedure-fade3">
						<div class="pn-circle">
							Bước<br />01
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle">
							Bước<br />02
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle active">
							Bước<br />03
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle">
							Bước<br />04
						</div>
					</div>
					<!-- pn-item -->
					<div class="pn-item procedure-fade4">
						<div class="pn-circle">
							Bước<br />01
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle">
							Bước<br />02
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle">
							Bước<br />03
						</div>
						<div class="pn-line"></div>
						<div class="pn-circle active">
							Bước<br />04
						</div>
					</div>
					<!-- pn-item -->
				</div>
				<!-- procedure-namesteps -->
			</div>
			<!-- container -->
		</div>
		<!-- procedure-ground -->
	</div>
	<!-- procedure -->
	<div class="pro-choose">
		<div class="container">
			<div style="padding-bottom: 150px;" class="pro-choose-img">
				<img width="500px" height="476px"
					src="default/images/choose-img.png" alt="pro-choose-img" />
			</div>
			<div class="pro-choose-content">
				<div class="box">
					<div class="box-title">
						<div class="box-title-name">
							TẠI SAO CHỌN <span class="text-info">SHIPBEE.VN</span>
						</div>
						<div class="box-title-desc">Giải quyết nút thắt cuối cùng
							trong ngành thương mại điện tử.</div>
						<div class="box-title-line"></div>
					</div>
					<div class="box-content">
						<div class="pro-choose-list">
							<div class="row">
								<div class="col-sm-6">
									<div class="pro-choose-item">
										<div class="pro-choose-title">Giao hàng toàn thành phố
											Đà Nẵng</div>
										<div class="pro-choose-desc">Vận chuyển đường bộ đến
											toàn bộ quận/huyện thuộc thành phố Đà Nẵng.</div>
									</div>
									<!-- pro-choose-item -->
								</div>
								<!-- col -->
								<div class="col-sm-6">
									<div class="pro-choose-item">
										<div class="pro-choose-title">Lấy hàng tận nơi</div>
										<div class="pro-choose-desc">Nhân viên của Proship đến
											tận nơi khách hàng yêu cầu để nhận hàng và chuyển hàng đi.</div>
									</div>
									<!-- pro-choose-item -->
								</div>
								<!-- col -->
							</div>
							<!-- row -->
							<div class="row">
								<div class="col-sm-6">
									<div class="pro-choose-item">
										<div class="pro-choose-title">Giao hàng và thu hộ tiền (
											COD)</div>
										<div class="pro-choose-desc">Gia tăng cơ hội bán hàng do
											95% nguời mua thích thanh toán khi nhận sản phẩm với hình
											thức “giao hàng COD”.</div>
									</div>
									<!-- pro-choose-item -->
								</div>
								<!-- col -->
								<div class="col-sm-6">
									<div class="pro-choose-item">
										<div class="pro-choose-title">Theo dõi hành trình vận
											đơn</div>
										<div class="pro-choose-desc">Quản lý giao hàng chuyên
											nghiệp hơn, kiểm soát giao hàng/ship hàng, nhận hàng.</div>
									</div>
									<!-- pro-choose-item -->
								</div>
								<!-- col -->
							</div>
							<!-- row -->
							<div class="row">
								<div class="col-sm-6">
									<div class="pro-choose-item">
										<div class="pro-choose-title">Tính chi phí tự động</div>
										<div class="pro-choose-desc">Xác định phí vận chuyển/phí
											ship trước khi đi giao.</div>
									</div>
									<!-- pro-choose-item -->
								</div>
								<!-- col -->
								<div class="col-sm-6">
									<div class="pro-choose-item">
										<div class="pro-choose-title">Tích hợp với API của
											SHIPBEE</div>
										<div class="pro-choose-desc">Có thể tích hợp với hệ
											thống, website bán hàng của khách hàng.</div>
									</div>
									<!-- pro-choose-item -->
								</div>
								<!-- col -->
							</div>
							<!-- row -->
						</div>
						<!-- pro-choose-list -->
					</div>
					<!-- box-content -->
				</div>
				<!-- box -->
			</div>
			<!-- pro-choose-content -->
		</div>
		<!-- container -->
	</div>
	<!-- pro-choose -->
	<div class="counting">
		<div class="container">
			<div class="row">
				<div class="col-xs-6 col-sm-3">
					<div class="counting-number">
						<span class="count-number" data-to="10000" data-from="0">10000</span><sup>+</sup>
					</div>
					<div class="counting-desc">Khách hàng thân thiết</div>
				</div>
				<!-- col -->
				<div class="col-xs-6 col-sm-3">
					<div class="counting-number">
						<span class="count-number" data-to="68190" data-from="0">68190</span><sup>+</sup>
					</div>
					<div class="counting-desc">Số km mỗi năm</div>
				</div>
				<!-- col -->
				<span class="counting-break"></span>
				<div class="col-xs-6 col-sm-3">
					<div class="counting-number">
						<span class="count-number" data-to="15000" data-from="0">15000</span><sup>+</sup>
					</div>
					<div class="counting-desc">Vận đơn giao thành công</div>
				</div>
				<!-- col -->
				<div class="col-xs-6 col-sm-3">
					<div class="counting-number">
						<span class="count-number" data-to="19068" data-from="0">19068</span><sup>+</sup>
					</div>
					<div class="counting-desc">Vận đơn thu hộ thành công</div>
				</div>
				<!-- col -->
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- counting -->
	<div class="services">
		<div class="container">
			<div class="box">
				<div class="box-title text-center">
					<div class="box-title-name">
						Dịch vụ của <span class="text-info">SHIPBEE.VN</span>
					</div>
					<div class="box-title-desc">Giải quyết nút thắt cuối cùng
						trong ngành thương mại điện tử.</div>
					<div class="box-title-line"></div>
				</div>
				<div class="box-content">
					<div class="services-list">
						<ul class="clearfix">
							<li>
								<div class="service-item">
									<div class="service-item-text">
										Giao hàng nhanh nội tỉnh<br />COD
									</div>
									<div class="service-item-img">
										<img
											src="https://static.proship.vn/f/default/images/service_1.png"
											alt="Giao hàng nhanh nội tỉnh COD" />
									</div>
								</div>
								<!-- service-item -->
							</li>
							<li>
								<div class="service-item">
									<div class="service-item-text">
										Chuyển phát nhanh<br />COD
									</div>
									<div class="service-item-img">
										<img
											src="https://static.proship.vn/f/default/images/service_2.png"
											alt="Chuyển phát nhanh COD" />
									</div>
								</div>
								<!-- service-item -->
							</li>
							<li>
								<div class="service-item">
									<div class="service-item-text">
										Nhận ký gửi hàng hóa<br />hoàn tất đơn hàng
									</div>
									<div class="service-item-img">
										<img
											src="https://static.proship.vn/f/default/images/service_3.png"
											alt="Nhận ký gửi hàng hóa hoàn tất đơn hàng" />
									</div>
								</div>
								<!-- service-item -->
							</li>
							<li>
								<div class="service-item">
									<div class="service-item-text">Kho nhận hàng rộng rãi</div>
									<div class="service-item-img">
										<img
											src="https://static.proship.vn/f/default/images/service_4.png"
											alt="Kho nhận hàng rộng rãi" />
									</div>
								</div>
								<!-- service-item -->
							</li>
						</ul>
					</div>
					<!-- services-list -->
				</div>
				<!-- box-content -->
			</div>
			<!-- box -->
		</div>
		<!-- container -->
	</div>
	<!-- services -->

	<div class="client">
		<div class="container">
			<div class="box">
				<div class="box-title text-center">
					<div class="box-title-name">
						Hơn <span class="text-info">30,000</span> khách hàng đã tin cậy
					</div>
					<div class="box-title-line"></div>
				</div>
				<div class="box-content">
					<div class="client-slider">
						<div id="clientslider" class="owl-carousel">
							<div class="client-item">
								<i class="fa fa-quote-left"></i>
								<div class="client-item-img">
									<img
										src="https://vignette.wikia.nocookie.net/naruto-viet-nam/images/4/49/Naruto_Shipp%C5%ABden_Logo-1.png/revision/latest?cb=20170427074448&path-prefix=vi"
										alt="avatar" />
								</div>
								<div class="client-item-title">
									<p>Uzumaki Naruto</p>
								</div>
								<div class="client-item-desc">“Rất ok!”</div>
								<i class="fa fa-quote-right"></i>
							</div>
							<!-- clients-item -->
							<div class="client-item">
								<i class="fa fa-quote-left"></i>
								<div class="client-item-img">
									<img
										src="https://fandom.vn/wp-content/uploads/2019/04/one-piece-monkey-d-luffy-1.jpg"
										alt="avatar" />
								</div>
								<div class="client-item-title">
									<p>Monkey D. Luffy</p>
								</div>
								<div class="client-item-desc">“Tôi đã tin tưởng và đã chon
									shipbee”</div>
								<i class="fa fa-quote-right"></i>
							</div>
							<!-- clients-item -->
							<div class="client-item">
								<i class="fa fa-quote-left"></i>
								<div class="client-item-img">
									<img
										src="https://www.indiewire.com/wp-content/uploads/2019/08/joker-phoenix-1135161-1280x0.jpeg"
										alt="avatar" />
								</div>
								<div class="client-item-title">
									<p>Arthur Fleck</p>
								</div>
								<div class="client-item-desc">“rất nhanh gọn”</div>
								<i class="fa fa-quote-right"></i>
							</div>
							<!-- clients-item -->
							<div class="client-item">
								<i class="fa fa-quote-left"></i>
								<div class="client-item-img">
									<img
										src="https://media.proprofs.com/images/QM/user_images/2169923/1517751718.jpg"
										alt="avatar" />
								</div>
								<div class="client-item-title">
									<p>Clark Kent</p>
								</div>
								<div class="client-item-desc">“mình mới làm việc với
									shipbee hôm nay. 3 đơn hàng giao nhanh, khách nhận được hàng
									sớm. Lên đây để góp ý đội ngủ nhân viên nhanh gọn lẹ nhiệt
									tình. chuẩn ok. sẽ tiếp tục làm việc”</div>
								<i class="fa fa-quote-right"></i>
							</div>
							<!-- clients-item -->
						</div>
						<!-- clients-item -->
					</div>
					<!-- owl-carousel -->
				</div>
				<!-- clients-slider -->
			</div>
			<!-- box-content -->
		</div>
		<!-- box -->
	</div>
	<!-- container -->
	<!-- clients -->

	<div class="modal fade" id="ModalFeeAuto" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content"></div>
			<!-- modal-content -->
		</div>
		<!-- modal-dialog -->
	</div>
	<!-- modal -->

	<script type="text/javascript">
		CalculateFee.quickCalculate();
	</script>
	<script type="text/javascript">
		var sentMailResetPasswordSuccess = '';
		var customerResetPasswordSuccess = '';
	</script>
	<div class="v2-support">
		<ul>
			<li class="v2-support-li"><span
				class="v2-support-icon v2-support-open"><i
					class="icon40-support"></i></span> <span
				class="v2-support-icon v2-support-close"><i
					class="icon40-support"></i></span>
				<div class="v2-support-content">
					<div class="v2-support-title">Hỗ trợ</div>
					<div class="v2-support-list">
						<div class="grid">
							<div class="img">
								<img src="default/images/baonn.png" alt="Ngô Ngọc Bảo" />
							</div>
							<div class="g-content">
								<div class="g-row">
									<span class="g-title">Ngô Ngọc Bảo</span>
								</div>
							</div>
							<div class="g-row">
								<i class="fa fa-phone"></i>0816 544 828
							</div>
						</div>
						<!-- grid -->
						<div class="grid">
							<div class="img">
								<img
									src="default/images/trungpv.jpg"
									alt="Phan Vĩnh Trung" />
							</div>
							<div class="g-content">
								<div class="g-row">
									<span class="g-title">Phan Vĩnh Trung </span>
								</div>
							</div>
							<div class="g-row">
								<i class="fa fa-phone"></i>0373 185 206
							</div>
						</div>
						<!-- grid -->
					</div>
					<!-- v2-support-list -->
				</div>
				<!-- v2-support-content --></li>
		</ul>
	</div>
	<!-- v2-support -->

	<div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="footer-top-inner clearfix">
					<div class="footer-top-left"></div>
					<div class="footer-top-center">
						COPYRIGHT BY <span class="text-info">SHIPBEE</span> &copy;2020<span
							class="hidden-xs"></span><span class="br-xs"></span>
					</div>
					<div class="footer-top-right"></div>
				</div>
				<!-- footer-top-inner -->
			</div>
			<!-- container -->
		</div>
		<!-- footer-top -->
		<div class="footer-col">
			<div class="container">
				<div class="row md-reset-10">
					<div class="col-md-3 padding-all-10">
						<div class="footer-label">
							Thông tin liên hệ<i class="fa fa-plus"></i>
						</div>
						<div class="footer-content">
							<div class="maincontent">
								<p>Công Ty Cổ Phần SHIPBEE</p>
								<p>Địa chỉ: Hoà Hải, Ngũ Hành Sơn, Đà Nẵng</p>
								<p>
									Email: <a href="#" style="color: #fff;">cskh@shipbee.vn</a>
								</p>
								<p>HotLine: 0816544828</p>
								<br />
							</div>
							<ul class="footer-verify">
								<li><a
									href="#">
										<img
										src="https://static.proship.vn/f/default/images/footer-verify_1.png"
										alt="verify" />
								</a></li>
								<li><a href="#"> <img
										src="https://static.proship.vn/f/default/images/footer-verify_2.png"
										alt="verify" />
								</a></li>
							</ul>
						</div>
						<!-- footer-content -->
					</div>
					<!-- col -->
					<div class="col-md-3 padding-all-10">
						<div class="footer-label">
							<span>SHIPBEE.vn</span><i class="fa fa-plus"></i>
						</div>
						<div class="footer-content">
							<ul class="footer-about-list">
								<li><a href="#" title="Tin tức của Proship">Tin tức của
										SHIPBEE</a></li>
								<li><a href="#" title="Chính sách bồi thường">Chính
										sách bồi thường</a></li>
								<li><a href="#" title="Chính sách bảo mật">Chính sách
										bảo mật</a></li>
							</ul>
						</div>
						<!-- footer-content -->
					</div>
					<!-- col -->
					<div class="col-md-3 padding-all-10">
						<div class="footer-label">
							Về <span class="text-info">SHIPBEE.vn</span><i class="fa fa-plus"></i>
						</div>
						<div class="footer-content">
							<ul class="footer-about-list">
								<li><a href="javascript:void(0);"
									title="Giao hàng nhanh nội thành Đà Nẵng">Giao hàng nội
										thành<span class="fal-btn-submenu fa fa-plus"></span>
								</a>
									<div class="fal-submenu">
										<ul>
											<li><a href="#">Dịch vụ giao hàng toàn thành phố Đà
													Nẵng</a></li>
											<li><a href="#" title="Dịch vụ giao hàng thu hộ tiền">Dịch
													vụ giao hàng thu hộ tiền</a></li>
											<li><a href="#"
												title="Quy trình giao nhận hàng nội thành">Quy trình
													giao nhận hàng nội thành</a></li>
											<li><a href="#	" title="Cách thức thanh toán">Cách
													thức thanh toán</a></li>
										</ul>
									</div>
									<!-- fal-submenu --></li>
							</ul>
						</div>
						<!-- footer-content -->
					</div>
					<!-- col -->
					<div class="col-md-3 padding-all-10">
						<div class="footer-label">
							Đối tác<i class="fa fa-plus"></i>
						</div>
						<div class="footer-content" style="display: block;">
							<div class="gallery-featured">
								<a href="http://procom.com.vn/" target="_blank"> <img
									width="100px" height="83px"
									src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSSFFStyOt2Nn1cFNDrmhM7KM0ChmwIJA2wog&usqp=CAU">
								</a>
							</div>
							<!-- gallery-featured -->
							<div class="gallery-featured">
								<a href="http://www.dhl.com.vn" target="_blank"> <img
									width="100px" height="83px" src="default/images/kyoto.png">
								</a>
							</div>
							<!-- gallery-featured -->
						</div>
						<!-- footer-content -->
					</div>
					<!-- col -->
				</div>
				<!-- row -->
			</div>
			<!-- container -->
		</div>
		<!-- footer-col -->

	</div>
	<!-- footer -->
	<!-- Load Facebook SDK for JavaScript -->
</body>
</html>
