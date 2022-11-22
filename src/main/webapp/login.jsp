<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login</title>
<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/css/material-design-iconic-font.min.css">
<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="main">
		<!-- Sign in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/logo_hcmute.jpg" alt="sing up image">
						</figure>
					</div>
					<div class="signin-form">
						<h2 class="form-title">Sign up</h2>
						<form method="" action="" class="register-form" id="login-form">
							<div class="form-group">
								<!-- Ô nhập tài khoản -->
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="username"
									placeholder="Your Name" />
							</div>
							<div class="form-group">
								<!-- Ô nhập mật khẩu -->
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" />
							</div>
							<div class="form-group">
								<!-- Checkbox nhớ tài khoản -->
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<!-- Nút nộp -->
							<input type="submit" name="signin" id="signin"
								class="form-submit" value="Log in" />
							<div class="form-group form-button"></div>
						</form>
					</div>
				</div>
				</div>
			</div>
		</section>
	</div>
	<!-- JS -->
</body>
</html>