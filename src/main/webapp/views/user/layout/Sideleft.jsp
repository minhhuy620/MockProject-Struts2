
<%@page contentType="text/html" pageEncoding="utf-8"%>
<div class="sideleft">
	<div class="side-scroll">
		<button class="menu-mobile-close" type="button">
			<span></span>
		</button>
		<div class="side-avatar">
			<div class="side-avatar-thumb">
				<img src="https://static.proship.vn/f/customer/images/no_image.jpg"
					alt="avatar" />
			</div>
			<div class="side-avatar-name">Xin chào, ${cusname}</div>
		</div>
		<!-- side-avatar -->
		<div class="side-menu">
			<ul>
				<li class=""><a href="Bangtin.jsp"> <img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-dashboard.png"
						alt="dashboard" /> <span class="sm-hidetext">Bảng tin -
							Báo cáo</span>
				</a></li>
				<li class="li-submenu active"><a href="#"><img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-setting-user.png"
						alt="setting user" /><span class="sm-hidetext">Tài khoản</span> <i
						class="fa fa-caret-up"></i> </a>
					<ul>
						<li class="active"><a href="Thongtinkhachhang.jsp"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-user.png"
								alt="user" /><span class="sm-hidetext">Thông tin tài
									khoản</span></a></li>
						<li class=""><a href="diachimacdinh"><img class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-place.png"
								alt="place" /><span class="sm-hidetext">Địa chỉ lấy hàng
									mặc định</span></a></li>
						<li class=""><a href="Thaydoimatkhaukhachhang.jsp"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-system.png"
								alt="system" /><span class="sm-hidetext"> Thay đổi mật
									khẩu</span></a></li>
					</ul></li>
				<li class="li-submenu closed"><a href="#"><img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-creat-bill.png"
						alt="creat bill" /><span class="sm-hidetext">Tạo vận đơn</span> <i
						class="fa fa-caret-down"></i> </a>
					<ul style="display: none;">
						<li class=""><a href="thongtindauvaotaodonhangmoi"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-bolt.png"
								alt="bolt" /><span class="sm-hidetext">Tạo vận đơn nhanh</span></a></li>
					</ul></li>
				<li class=""><a href="Quanlyvandon.jsp"><img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-setting-bill.png"
						alt="setting bill" /><span class="sm-hidetext">Quản lý vận
							đơn</span></a></li>
				<li class=""><a href="Danhgiashipper.jsp"> <img
						class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-support.png"
						alt="support" /> <span class="sm-hidetext">Đánh giá
							Shipper</span>
				</a></li>
			</ul>
		</div>
		<!-- side-menu -->
	</div>
	<!-- side-scroll -->
</div>
<!-- sideleft -->
