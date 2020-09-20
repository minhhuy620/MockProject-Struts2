
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
			<div class="side-avatar-name">Xin chào, ${adname}</div>
		</div>
		<!-- side-avatar -->
		<div class="side-menu">
			<ul>
				<li class="li-submenu active"><a href="#"><img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-setting-user.png"
						alt="setting user" /><span class="sm-hidetext">Tài khoản</span> <i
						class="fa fa-caret-up"></i> </a>
					<ul>
						<li class="active"><a href="admins"><img class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-user.png"
								alt="user" /><span class="sm-hidetext">Thông tin admin</span></a></li>
					</ul></li>
				<li class="li-submenu active"><a href="#"><img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-creat-bill.png"
						alt="creat bill" /><span class="sm-hidetext">QL tài
							khoản User</span> <i class="fa fa-caret-down"></i> </a>
					<ul style="display: none;">
						<li class="active"><a href="listuser"><img class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-bolt.png"
								alt="bolt" /><span class="sm-hidetext">Quản lí User</span></a></li>
					</ul>
					<ul style="display: none;">
						<li class="active"><a href="listlockuser"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-bolt.png"
								alt="bolt" /><span class="sm-hidetext">Tài khoản khóa</span></a></li>
					</ul></li>
				<li class="li-submenu active"><a href="#"><img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-creat-bill.png"
						alt="creat bill" /><span class="sm-hidetext">QL tài
							khoản Shipper</span> <i class="fa fa-caret-down"></i> </a>
					<ul style="display: none;">
						<li class="active"><a href="listshipper"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-bolt.png"
								alt="bolt" /><span class="sm-hidetext">Quản lí Shipper</span></a></li>
					</ul>
					<ul style="display: none;">
						<li class="active"><a href="listlockshipper"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-bolt.png"
								alt="bolt" /><span class="sm-hidetext">Tài khoản khóa</span></a></li>
					</ul></li>
					
					
					<li class="li-submenu active"><a href="#"><img class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-setting-bill.png"
						alt="setting bill" /><span class="sm-hidetext">Quản lý vận đơn</span> <i class="fa fa-caret-down"></i> </a>
					<ul style="display: none;">
						<li class="active"><a href="acceptDonHangUser"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-bolt.png"
								alt="bolt" /><span class="sm-hidetext">Xác nhận đơn</span></a></li>
					</ul>
					<ul style="display: none;">
						<li class="active"><a href="quanlytinhtrangdon"><img
								class="icon"
								src="https://static.proship.vn/f/customer/images/icons/icon24-bolt.png"
								alt="bolt" /><span class="sm-hidetext">Quản lý tình trạng đơn</span></a></li>
					</ul></li>
				
				<li class=""><a href="doanhthu"> <img
						class="icon"
						src="https://static.proship.vn/f/customer/images/icons/icon24-dashboard.png"
						alt="dashboard" /> <span class="sm-hidetext">Báo cáo thống
							kê</span>
				</a></li>


			</ul>
		</div>
		<!-- side-menu -->
	</div>
	<!-- side-scroll -->
</div>

<!-- sideleft -->
