<%@page contentType="text/html" pageEncoding="utf-8"%>
<div class="navigator">
	<div class="navigator-inner">
		<button class="expand-menu" type="button">
			<span></span>
		</button>
		<button class="expand-menu-mobile" type="button">
			<span></span>
		</button>
		<button class="mobile-search expand-search" type="button">
			<i class="fa fa-search"></i>
		</button>
		<div class="logo">
			<a href="/ShipBee"> <img
				src="default/images/logo.png"
				alt="logo" />
			</a>
		</div>
		<div class="box-search">
			<div class="box-search-inner">
				<form method="Post" action="timdontheomadon">
				<input type="text" name="madonhang" class="form-control"
					placeholder="Mã đơn hàng" />
				<button type="submit" class="btn-search">
					<i class="fa fa-search"></i>
				</button>
				</form>
			</div>
		</div>
		<!-- box-search -->
		<div class="box-admin">
			<ul>
				<li class="pop-submenu">
					<div class="box-admin-text">
						<div class="box-admin-avatar">
							<img
								src="https://static.proship.vn/f/customer/images/no_image.jpg"
								alt="avatar" />
						</div>
						<i class="fa fa-caret-down"></i>
						<div class="box-admin-content">
							<div class="box-admin-name">
								Xin chào, ${adname} !<i class="fa fa-caret-down"></i>
							</div>
						</div>
					</div>
					<div class="submenu submenu-right">
						<div class="submenu-bottom text-right">
							<a class="logout" href="outadmin"><i
								class="fa fa-sign-out"></i>Đăng xuất</a>
						</div>
						<!-- submenu-bottom -->
					</div>
					<!-- submenu -->
				</li>
			</ul>
		</div>
		<!-- box-admin -->
	</div>
	<!-- navigator-inner -->
</div>
<!-- navigator -->
