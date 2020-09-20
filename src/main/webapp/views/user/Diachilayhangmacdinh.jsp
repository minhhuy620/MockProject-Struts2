<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="list" class="com.test.struts2.dao.QuanHuyenDAO" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,700,700italic,400italic,900,900italic,300italic,300,100italic,100'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../../default/css/print.css" media="print">
<!-- Core CSS -->
<title>Địa chỉ lấy hàng mặc định | Shipbee.vn</title>
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
                <div class="page-smalltitle-wellcome">Sổ địa chỉ</div>
                <div class="page-title-desc">Bạn nên nhập thông tin chính xác. Thông tin của bạn sẽ được bảo mật tuyệt đối và sẽ được sử dụng để nhận quà và khuyến mại từ shipbee.vn</div>
            </div><!-- col -->
        </div><!-- row -->
    </div><!-- page-smalltitle -->
    <div id="main-content-address">
                    <div class="row row-medium">
                <div class="col-lg-6 group-content">
                    <div class="panel panel-custom customer-info" data-id="2120721">
                        <div class="panel-heading">
                            <div class="small-text">ĐỊA CHỈ LẤY HÀNG MẶC ĐỊNH </div>
                            <div class="panel-heading-right">
                                                            </div>
                        </div>
                        <div class="panel-body local-storage-destination no-initialize">
                        <c:if test="${requestScope.thongbaothanhcong == 1}">
    			<div class="alert alert-success">
                      Cập nhật thành công!
                 </div>
			</c:if>
			<c:if test="${requestScope.thongbaothatbai == 2}">
    			<div class="alert alert-danger">
                      Cập nhật thất bại!
                 </div>
			</c:if>
                            <form action="capnhatdiachimacdinh" method="post">
                            <div class="form form-horizontal">
                                <div class="form-group">
                                    <label class="control-label col-lg-4 col-sm-3">Số điện thoại người gửi:</label>
                                    <div class="col-lg-8 col-sm-9">
                                        <input type="text" name="sdtnguoigui" class="form-control phone" value="${sdtnguoigui }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4 col-sm-3">Họ tên người gửi:</label>
                                    <div class="col-lg-8 col-sm-9">
                                        <input type="text" name="hoten" class="form-control phone" value="${hoten }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4 col-sm-3">Tỉnh/ thành phố:</label>
                                    <div class="col-lg-8 col-sm-9">
                                        <input type="text" class="form-control phone" value="Đà Nẵng" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4 col-sm-3">Quận/ huyện:</label>
                                    <div class="col-lg-8 col-sm-9">
                                        <select class="form-control district lsDistrictSender" name="" id="quanhuyen">
                                        <c:forEach var="list" items="${list.allquanhuyen}"> 
                                        <c:choose>
                                          <c:when test="${ idquanhuyen == list.idquanhuyen}">
                                        <option selected value="${idquanhuyen }">${quan_huyen }</option>       
                                        </c:when>
                                         <c:otherwise>
                                           <option 
                                        value="${list.idquanhuyen }">
                                                    ${list.quanhuyen }      
                                                     </option> 
                                         </c:otherwise>
                                        </c:choose> 
                                         </c:forEach>
                                          </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4 col-sm-3">Phường/ xã:</label>
                                    <div class="col-lg-8 col-sm-9">
                                        <select class="form-control ward lsWard" name="idphuongxa" id="phuongxa">
                                         <c:choose>
                                          <c:when test="${ phuong_xa == null}">
                                      <option value="0">Vui lòng chọn quận / huyện trước </option> 
                                        </c:when>
                                         <c:otherwise>
                                           <option selected value="${idphuongxa }">
                                                    ${phuong_xa }      
                                            </option>                                         					
                                         </c:otherwise>
                                        </c:choose> 
                                      </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4 col-sm-3">Địa chỉ:</label>
                                    <div class="col-lg-8 col-sm-9">
                                        <input type="text" name="diachi" class="form-control address" value="${diachi }">
                                    </div>
                                </div>
                                <hr>
                                <div class="form-group text-right">
                                    <div class="col-xs-12">
                                        <button type="submit" class="btn btn-info text-uppercase save-address">Cập nhật</button>
                                    </div>
                                </div>
                            </div><!-- form --></form>
                        </div><!-- panel-body -->
                    </div><!-- panel -->
                </div><!-- col -->
                <div class="col-lg-6 group-content">
                	<div class="mapouter">
                		<div class="gmap_canvas">
                			<iframe width="450" height="350" id="gmap_canvas" src="https://maps.google.com/maps?q=${diachi}%2C%20danang&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
               			</div>
                                <style>
                                .mapouter{padding-top: 30px;position:relative;text-align:center;height:500px;width:600px;}
                                .gmap_canvas {overflow:hidden;background:none!important;height:500px;width:600px;}
                                </style>
                          </div>
                                
                     </div>
                </div><!-- row -->    
          </div><!-- main-content-address -->
</div><!-- container -->


<script type="text/javascript">
$(document).ready(function (){
	var idQuanhuyen = $(this).val();
    $("#quanhuyen").change(function (){
        var idQuanhuyen = $(this).val();
         $.get("diachimacdinh",function(){
        	 if(idQuanhuyen == 1 ){
                 $("#phuongxa").html("${data1}");
        	 }else if(idQuanhuyen == 2){
                 $("#phuongxa").html("${data2}");
        	 }else if(idQuanhuyen == 3){
                 $("#phuongxa").html("${data3}");
        	 }else if(idQuanhuyen == 4){
                 $("#phuongxa").html("${data4}");
        	 }else if(idQuanhuyen == 5){
                 $("#phuongxa").html("${data5}");
        	 }else if(idQuanhuyen == 6){
                 $("#phuongxa").html("${data6}");
        	 }else{
                 $("#phuongxa").html("${data7}");
        	 }
         });
     });
 })
</script>
</div>
			<%@ include file="layout/Footer.jsp"%>
		</div>
	</div>
</body>
</html>
