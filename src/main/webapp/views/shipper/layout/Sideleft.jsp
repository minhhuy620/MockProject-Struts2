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
				<li class="li-submenu active"><a href="#"><img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-setting-user.png"
						alt="setting user" /><span class="sm-hidetext">Tài khoản</span> <i
						class="fa fa-caret-up"></i> </a>
					<ul>
						<li class="active"><a href="ThongtinShipper.jsp"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-user.png"
								alt="user" /><span class="sm-hidetext">Thông tin tài
									khoản</span></a></li>
						<li class=""><a href="ThaydoimatkhauShipper.jsp"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-system.png"
								alt="system" /><span class="sm-hidetext"> Thay đổi mật
									khẩu</span></a></li>
					</ul></li>
				<li class="li-submenu closed"><a href="#"><img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-setting-bill.png"
						alt="creat bill" /><span class="sm-hidetext">Tương tác đơn
							hàng</span> <i class="fa fa-caret-down"></i> </a>
					<ul style="display: none;">
						<li class="active"><a href="listdonhangmoi"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-bolt.png"
								alt="bolt" /><span class="sm-hidetext">Nhận đơn hàng mới</span></a></li>
						<li class="active"><a href="xacnhanlayhang"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-support.png"
								alt="bolt" /><span class="sm-hidetext">Xác nhận đã lấy
									hàng</span></a></li>
						<li class="active"><a href="xacnhangiaohang"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-support.png"
								alt="bolt" /><span class="sm-hidetext">Xác nhận đã giao
									hàng</span></a></li>
						<li class="active"><a href="quanlydondagiao"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-support.png"
								alt="bolt" /><span class="sm-hidetext">Quản lý đơn đã
									giao</span></a></li>
						<li class=""><a href="xemdanhgia"><img class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-support.png"
								alt="bolt" /><span class="sm-hidetext">Xem đánh giá</span></a></li>
					</ul></li>
				<li class="active"><a href="doanhthushipper"><img
						class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-setting-money.png"
						alt="setting money" /><span class="sm-hidetext">Kiểm tra
							doanh thu </span></a></li>
			</ul>
		</div>
		<!-- side-menu -->
	</div>
	<!-- side-scroll -->
</div>
<!-- sideleft -->
