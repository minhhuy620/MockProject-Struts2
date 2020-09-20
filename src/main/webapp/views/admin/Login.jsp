<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<link rel="icon" type="image/png" sizes="16x16" href="../../default/images/favicon-16x16.png">
<title>Đăng Nhập Admin | LOGISTICS SYSTEM</title>
<meta charset="UTF-8">
<link href="default/css/admin.css" media="screen" rel="stylesheet"
	type="text/css">
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta name="viewport"
	content="user-scalable=no, width=device-width, initial-scale=1">
</head>

<body>
	<hgroup>
		<h1>Welcome to Shipbee</h1>
		<h3>By ADMIN</h3>
	</hgroup>
	
	<form action="admin" method="POST">
		<c:if test="${requestScope.thongbaodangnhap != null}">
    			<div class="alert alert-danger">
                      ${thongbaodangnhap}
                 </div>
		</c:if>
		<div class=" col-6 col-sm-12 form-group ">
                <label for="">Số Điện Thoại</label>
                <input type="text" name="sdt" id="sdt" class="form-control" placeholder="SDT">
            </div>
            <div class="col-6 col-sm-12 form-group">
                <label for="">Password</label>
                <input type="password" name="password" id="password" class="form-control" placeholder="password">
            </div>
		<button type="submit" class="button buttonBlue">
			Đăng nhập
			<div class="ripples buttonRipples">
				<span class="ripplesCircle"></span>
			</div>
		</button>
	</form>
	<footer>
		<a href="trangchu" target="_blank"><img src="default/images/logo.png"></a>
		<p>
			Admin Gotta Love <a href="#">Shipbee</a>
		</p>
	</footer>
</body>
</html>
