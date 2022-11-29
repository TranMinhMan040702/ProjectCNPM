<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <!-- Font Icon -->
    <link rel="stylesheet"
          href="../assets/fonts/css/material-design-iconic-font.min.css">
    <!-- Main css -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
          rel="stylesheet">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">

    </script>

    <script
            src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">

    </script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link href="../assets/css/style.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
</head>
<body>
<div class="boxcenter">
    <header>
        <img class="img-header" src="../assets/images/head.png"/>
    </header>
    <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarResponsive">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="./user/Account_Management_User.jsp">Tài khoản</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Đăng nhập</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <aside>
        <div style="padding: 20px 50px 50px 50px">
            <div class="signin-form">
                <h2 class="form-title">Đăng nhập</h2>
                <form method="post" class="register-form" id="login-form">
                    <div class="form-group">
                        <label>Tài khoản</label>
                        <input
                            type="text" class="form-control" placeholder="Tài khoản của bạn"
                            required name="username" value="">
                    </div>
                    <div class="form-group">
                        <label>Mật khẩu</label>
                        <input type="password"
                               class="form-control"
                               placeholder="Mật khẩu của bạn"
                               required name="password" value="">
                    </div>
                    <div class="form-group">
                        <label>
                            <iconify-icon icon="material-symbols:work"></iconify-icon>
                            Chức vụ</label> <br>
                        <label><input type="radio" name="role" value="sinhvien" > Sinh viên</label>
                        <label><input type="radio" name="role" value="giangvien"> Giảng viên</label>
                        <label><input type="radio" name="role" value="truongbomon"> Trưởng bộ môn</label>
                        <label><input type="radio" name="role" value="admin"> Admin</label>
                    </div>
                    <div class="form-group">
                        <!-- Checkbox nhớ tài khoản -->
                        <input type="checkbox" name="remember-me" id="remember-me" class="agree-term"/>
                        <label for="remember-me" class="label-agree-term"><span><span></span></span>
                            Ghi nhớ
                        </label>
                    </div>
                    <!-- Nút nộp -->
                    <div class="form-group">
                        <button class="btn btn-success" formaction="<c:url value="/login"/> ">Đăng nhập</button>
                        <button style="padding-left: 20px; padding-right: 20px;"
                                class="btn btn-danger" onclick="Back(event)">Hủy
                        </button>
                        <a style="margin-left: 52%;" href="#"><i class="btn btn-warning">Quên mật khẩu</i></a>
                    </div>
                </form>
            </div>
        </div>
    </aside>
    <footer>
        <a style="color: red; padding-bottom: 20px;">Khoa Công nghệ Thông
            tin - Đại học Sư phạm Kỹ thuật TP. Hồ Chí Minh Số 1, Võ Văn Ngân,
            Thủ Đức, TP. Hồ Chí Minh</a>
    </footer>
</div>
<script>
    function Back(e) {
        e.preventDefault();
        history.go(-1);
    }
</script>
</body>
</html>