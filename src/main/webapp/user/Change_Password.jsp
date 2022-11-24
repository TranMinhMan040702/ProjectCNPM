<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Account Management</title>
<!-- Font Icon -->
<link rel="stylesheet"
	href="../fonts/css/material-design-iconic-font.min.css">
<!-- Main css -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<div class="boxcenter">
		<header></header>
		<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
			<div class="container-fluid">
				<!-- <a class="navbar-branch" href="#"> <img
					src="../images/hcmute.png">
				</a> -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="#">Tài
								khoản</a></li>
						<li class="nav-item"><a class="nav-link" href="../login.jsp">Đăng
								nhập</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div id="aside">
			<div class="container-fluid">
				<div class="row">
					<table>
						<tr>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<article>
			<div id="menu">
				<ul>
					<li><a href="../index.jsp">Trang chủ</a></li>
					<li><a href="#">Tài Khoản</a></li>
					<li><a href="#">Đăng ký đề tài</a></li>
					<li><a href="#">Tìm kiếm</a></li>
				</ul>
			</div>
		</article>
		<aside>
			<div style="padding: 20px 50px 50px 50px">
				<h2 class="form-title">Đổi mật khẩu</h2>
				<form>
					<div class="form-group">
						<label>Mật khẩu hiện tại</label> <input type="text"
							class="form-control" placeholder="Nhập mật khẩu hiện tại"
							required name="">
					</div>
					<div class="form-group">
						<label>Mật khẩu mới</label> <input type="password"
							class="form-control" placeholder="Nhập mật khẩu mới" required
							name="">
					</div>
					<div class="form-group">
						<label>Xác nhận mật khẩu</label> <input type="password"
							class="form-control" placeholder="Nhập lại mật khẩu" required
							name="">
					</div>
					<div class="form-group">
						<button class="btn btn-success" type="submit">Cập nhập</button>
						<button style="padding-left: 20px; padding-right: 20px;"
							class="btn btn-danger" type="reset">Hủy</button>
					</div>
				</form>
			</div>
		</aside>
		<footer>
			<a style="color: red; padding-bottom: 20px;">Khoa Công nghệ Thông
				tin - Đại học Sư phạm Kỹ thuật TP. Hồ Chí Minh Số 1, Võ Văn Ngân,
				Thủ Đức, TP. Hồ Chí Minh</a>
		</footer>
	</div>
</body>
</html>
