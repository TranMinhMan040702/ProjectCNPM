<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Management</title>
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
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">

    </script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link href="../assets/css/style.css" rel="stylesheet">
    <script src="../assets/js/main.js">
    </script>
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
                    <li class="nav-item"><a class="nav-link active" href="#"></a>
                    </li>
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
            <h2 class="form-title">Cập nhập thông tin</h2>
            <form action="./account/edit" method="post">
                <div class="form-group">
                    <div class="form-row">
                        <div class="col">
                            <input type="hidden"  name="username" value=${user.username}>
                            <label>Họ tên</label> <input type="text" class="form-control"
                                                         placeholder="Tên của bạn" required name="fullname" value="${user.fullname}">
                        </div>
                        <div class="col" >
                            <label>Giới tính:</label> <br>
                            <c:set var = "male" scope = "session" value = "${user.male}"/>
                            <label><input type="radio" value="Nam" name="male" <c:if  test="${male =='Nam'}">checked</c:if>> Nam</label>
                            <label><input type="radio" name="male" value="Nu" <c:if  test="${male !='Nam'}">checked</c:if>> Nữ</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label>Email</label> <input type="email" class="form-control"
                                                placeholder="Email của bạn" required name="email" value="${user.email}">
                </div>
                <div class="form-group">
                    <label>Ngày sinh</label> <input type="date" class="form-control"
                                                    placeholder="Ngày sinh của bạn" required name="birthday" value="${date1}">
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col">
                            <label>Địa chỉ</label>
                            <select class="form-control" name="address" type="">
<%--                            <option value="" selected>Nơi sống của bạn</option>--%>
<%--                            <option value="${user.address}" selected disabled hidden>${user.address}</option>--%>
                            <c:set var = "address" scope = "session" value = "${user.address}"/>
                            <option value="TPHCM" <c:if test="${address =='TPHCM'}">selected</c:if>>TPHCM</option>
                            <option value="HN" <c:if test="${address =='HN'}">selected</c:if>>Hà Nội</option>
                            <option value="KHAC" <c:if test="${address =='KHAC'}">selected</c:if>>Khác</option>
                        </select>
                        </div>
                        <div class="col">
                            <label>SĐT</label> <input type="tel" class="form-control"
                                                      placeholder="Số điện thoại" required name="phone" value="${user.phone}">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col">
                            <label>Khóa học</label> <input type="text"
                                                                class="form-control" placeholder="Năm vào trường" required
                                                                name="schoolyear" value="${user.schoolyear}">
                        </div>
                        <div class="col">
                            <label>Khoa</label>
                            <select id="departments" class="form-control" name="department">
<%--                            <option value="${user.department}" selected disabled hidden>${user.department}</option>--%>
                            <c:set var = "department" scope = "session" value = "${user.department}"/>
                            <option value="cntt" <c:if test="${department =='cntt'}">selected</c:if>>Công nghệ thông tin</option>
                            <option value="kt" <c:if test="${department =='kt'}">selected</c:if>>Kinh tế</option>
                            <option value="xd" <c:if test="${department =='xd'}">selected</c:if>>Xây dựng</option>
                        </select> <a href="#" role="button" class="mt-5"
                                     onclick="btnAddDepartment()">Thêm khoa khác</a>
                        </div>
                    </div>
                </div>
                <!-- <div class="form-group">
                    <label> Chức vụ</label> <br> <label><input
                        type="radio" value="sinhvien" name="chuc-vu" checked>
                        Sinh viên</label> <label><input type="radio" name="chuc-vu"
                        value="giangvien"> Giảng viên</label> <label><input
                        type="radio" name="chuc-vu" value="truongbomon"> Trưởng
                        bộ môn</label> <label><input type="radio" name="chuc-vu"
                        value="admin"> Admin</label>
                </div> -->
                <div class="form-group">
                    <input type="checkbox" required name=""> <label>Xác
                    nhận thay đổi</label>
                </div>
                <div class="form-group">
                    <button class="btn btn-success" type="submit">Cập nhập</button>
                    <button style="padding-left: 20px; padding-right: 20px;"
                            class="btn btn-danger" type="reset">Hủy</button>
                    <a style="margin-left: 52%;" href="ChangePassword.jsp"><i
                            class="btn btn-warning">Đổi mật khẩu</i></a>
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