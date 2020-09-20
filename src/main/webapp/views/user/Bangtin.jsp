<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="default/images/favicon-16x16.png">
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,700,700italic,400italic,900,900italic,300italic,300,100italic,100'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../../default/css/print.css" media="print">
<!-- Core CSS -->
<title>Bảng tin | Shipbee.vn</title>
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
        <div class="col-lg-6">
            <div class="panel panel-custom">
                <div class="panel-heading no-bottom">
                    <div class="big-text"><i class="icon28-speaker"></i>Thông báo từ Shipbee.vn</div>
                    <div class="panel-heading-right"><a class="more" href="#">Xem tất cả</a></div>
                </div>
                <div class="panel-body">
                    <table class="table tbody-no-top">
                        <tbody>
                                                                <tr>
                                        <td>
                                            <div class="text-time">Tue, 31/03/2020 09:44:31</div>
                                            <a class="text-title" href="#">Shipbee chung tay đẩy lùi dịch Covid-19</a>
                                        </td>
                                    </tr>
                                                                        <tr>
                                        <td>
                                            <div class="text-time">Tue, 31/03/2020 09:29:02</div>
                                            <a class="text-title" href="#">Thông báo về tình trạng ách tắc hàng không và giải pháp của Shipbee</a>
                                        </td>
                                    </tr>
                                                                        <tr>
                                        <td>
                                            <div class="text-time">Fri, 13/03/2020 11:30:22</div>
                                            <a class="text-title" href="#">Dịch vụ phun khử trùng, sát khuẩn phòng chống dịch bệnh Corona</a>
                                        </td>
                                    </tr>
                                                                                            </tbody>
                    </table>
                </div><!-- panel-body -->
            </div><!-- panel -->
        </div><!-- col -->
        
        <div class="col-lg-6">
            <div class="row row-medium">
                                <div class="col-sm-6">
                    <div class="block-pin info-fullbg">
                        <img class="block-pin-img" src="https://static.proship.vn/f/customer/images/icons/icon64-email-money.png" alt="COD">
                        <div class="block-pin-inner">
                            <div class="block-pin-row">Tổng chi tiêu</div>
                            <div class="block-pin-row"><span class="block-pin-number">0 vnđ</span></div>
                        </div>
                    </div><!-- block-pin -->
                </div><!-- col -->
                <div class="col-sm-6">
                    <div class="block-pin warning-fullbg">
                        <img class="block-pin-img" src="https://static.proship.vn/f/customer/images/icons/icon64-pig.png" alt="Fee tranfer">
                        <div class="block-pin-inner">
                            <div class="block-pin-row">Thành Viên Hạng Đồng</div>
                            <div class="block-pin-row"><span class="block-pin-number">Giảm 2% hóa đơn</span></div>
                        </div>
                    </div><!-- block-pin -->
                </div><!-- col -->
                
                <div class="col-sm-6">
                    <div class="block-pin violet-bg">
                        <div class="block-pin-row">
                            <span class="block-pin-number">0</span>
                        </div>
                        <div class="block-pin-row">Vận đơn đợi lấy hàng</div>
                    </div><!-- block-pin -->
                </div><!-- col -->

                <div class="col-sm-6">
                    <div class="block-pin success-bg">
                        <div class="block-pin-row">
                            <span class="block-pin-number">0</span>
                        </div>
                        <div class="block-pin-row">Đơn hàng đang giao</div>
                    </div><!-- block-pin -->
                </div><!-- col -->
                
                <div class="col-sm-6">
                    <div class="block-pin danger-bg">
                        <div class="block-pin-row">
                            <span class="block-pin-number">0</span>
                        </div>
                        <div class="block-pin-row">Vận đơn giao thành công</div>
                    </div><!-- block-pin -->
                </div><!-- col -->
                <div class="col-sm-6">
                    <div class="block-pin primary-bg">
                        <div class="block-pin-row">
                            <span class="block-pin-number">0</span>
                        </div>
                        <div class="block-pin-row">Yêu cầu chuyển hoàn</div>
                    </div><!-- block-pin -->
                </div><!-- col -->
            </div><!-- row -->
        </div><!-- col -->
    </div><!-- row -->
</div><!-- container -->

</div>
			<%@ include file="layout/Footer.jsp"%>
		</div>
	</div>
</body>
</html>
