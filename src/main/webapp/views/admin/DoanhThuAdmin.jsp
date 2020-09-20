<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,java.sql.*"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="com.test.struts2.dao.AdminDAO"%>
<%
String dataPoints = AdminDAO.getDoanhthuAdmin();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
<!-- Core CSS -->
<title>Doanh thu | Shipbee.vn</title>
<meta charset="UTF-8">
<link
	href="https://static.proship.vn/f/default/css/??bootstrap.min.css,font-awesome.min.css,owl.carousel.min.css,select2.min.css,animate.css,swiper.min.css,custom.css?v65"
	media="screen" rel="stylesheet" type="text/css">
<link href="default/css/khachhang.css" media="screen" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="default/css/print.css" media="print">
<link
	href="https://static.proship.vn/f/default/css/??bootstrap-switch.min.css?v65"
	media="screen" rel="stylesheet" type="text/css">

<script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>

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

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</head>
<body>

	<div class="page-site page-app">
		<%@ include file="layout/Header.jsp"%>
		<%@ include file="layout/Sideleft.jsp"%>
		<div class="page-content page-dashboard">
			<%@ include file="layout/Title.jsp"%>
			<div id="chartContainer"
				style="height: 400px; width: 95%; margin: 5rem auto"></div>
			<%@ include file="layout/Footer.jsp"%>
		</div>
	</div>
	<script type="text/javascript">
		window.onload = function() {
	<%if (dataPoints != null) {%>
		var chart = new CanvasJS.Chart("chartContainer", {
				theme : "light2",
				animationEnabled : true,
				exportEnabled : true,
				title : {
					text : "Tổng Doanh Thu "
				},
				axisX : {
					title: "Mốc thời gian"
				},
				axisY : {
					title: "Thu nhập",
					valueFormatString: "0.00đ",
				},
				data : [ {
					type : "spline",
					name: "CPU Utilization",
					connectNullData: true,
					xValueType: "dateTime",
					xValueFormatString: "DD MMM hh:mm TT",
					yValueFormatString: "0.00đ",
					dataPoints :
	<%out.print(dataPoints);%>
		} ]
			});
			chart.render();
	<%}%>
		}
	</script>
</body>
</html>
