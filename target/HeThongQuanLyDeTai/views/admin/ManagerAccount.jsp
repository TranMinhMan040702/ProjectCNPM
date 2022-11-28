<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Admin</title>
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
  <script src="../assets/js/main.js"></script>
  <!-- Font Icon -->
  <link rel="stylesheet"
        href="fonts/css/material-design-iconic-font.min.css">
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
  <script src="../../assets/js/main.js"></script>
  <link href="../../assets/css/style.css" rel="stylesheet">
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
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
          <li class="nav-item"><a class="nav-link" href="../index.jsp">Đăng
            xuất</a></li>
        </ul>
      </div>
    </div>
  </nav>
  <article>
    <div id="menu">
      <ul>
        <li><a href="../index.jsp">Trang chủ</a></li>
        <li><a href="#">Tạo tài khoản</a></li>
        <li><a href="#">Đăng ký đề tài</a></li>
        <li><a href="#">Tìm kiếm</a></li>
      </ul>
    </div>
  </article>
  <aside>
    <div style="padding: 20px 50px 50px 50px">
      <h2 class="form-title">Tạo tài khoản</h2>
      <form action="./create" method="post">
        <div class="form-group">
          <div class="form-row">
            <div class="col">
              <label>Tài khoản</label> <input id="a" type="text"
                                              class="form-control" placeholder="Tên tài khoản" required
                                              name="username">
            </div>
            <div class="col">
              <label>Mật khẩu</label> <input id="b" type="text" class="form-control"
                                             placeholder="Mật khẩu" required name="password">
            </div>
          </div>
        </div>
        <div class="form-group">
          <div class="form-row">
            <div class="col">
              <label>Họ tên</label> <input id="name" type="text"
                                           class="form-control" placeholder="Tên của bạn" required name="fullname">
            </div>
            <div class="col">
              <label>Giới tính:</label> <br>
              <label><input type="radio" value="nam" name="male" checked> Nam</label>
              <label><input type="radio" name="male" value="nu"> Nữ</label>
            </div>
          </div>
        </div>
        <div class="form-group">
          <label>Email</label> <input type="email" class="form-control"
                                      placeholder="Email của bạn" required name="email">
        </div>
        <div class="form-group">
          <label>Ngày sinh</label> <input id="dob" type="date"
                                          class="form-control" placeholder="Ngày sinh của bạn" required
                                          name="birthday">
        </div>
        <div class="form-group">
          <div class="form-row">
            <div class="col">
              <label>Địa chỉ</label>
              <select class="form-control" name="address">
              <option value="" selected>Nơi sống của bạn</option>
              <option value="TPHCM">TPHCM</option>
              <option value="HN">Hà Nội</option>
              <option value="KHAC">Khác</option>
            </select>
            </div>
            <div class="col">
              <label>SĐT</label> <input type="tel" class="form-control"
                                        placeholder="Số điện thoại" required name="phone">
            </div>
          </div>
        </div>
        <div class="form-group">
          <div class="form-row">
            <div class="col">
              <label>Năm hoạt động</label> <input type="text"
                                                  class="form-control" placeholder="Năm vào trường" required
                                                  name="schoolyear">
            </div>
            <div class="col">
              <label>Khoa</label> <select id="departments"
                                          class="form-control" name="department">
              <option value="cntt">Công nghệ thông tin</option>
              <option value="kt">Kinh tế</option>
              <option value="xd">Xây dựng</option>
            </select> <a href="#" role="button" class="mt-5"
                         onclick="btnAddDepartment()">Thêm khoa khác</a>
            </div>
          </div>
        </div>
        <div class="form-group">
          <label> Chức vụ</label> <br>
          <label><input type="radio" value="sinhvien" name="role" checked>Sinh viên</label>
          <label><input type="radio" name="role" value="giangvien"> Giảng viên</label>
          <label><input type="radio" name="role" value="truongbomon"> Trưởng bộ môn</label>
          <label><input type="radio" name="role" value="admin"> Admin</label>
        </div>
        <div class="form-group">
          <button style="padding-left: 20px; padding-right: 20px;"
                  id="btnAddEmployee" class="btn btn-primary" type="submit">Tạo</button>
          <script>
            document.getElementById("btnAddEmployee")
                    .addEventListener('click', function(event) {
                      btnAddEmployee(event)
                    })
          </script>
          <button style="padding-left: 20px; padding-right: 20px;"
                  class="btn btn-danger" type="reset">Hủy</button>
        </div>
      </form>
      <div style="padding-bottom: 20px">
        <table style="width: 100%" id="tblEmployees"
               class="table ">
          <thead class="thead-dark">
          <tr>
            <th>Tài khoản</th>
            <th>Mật khẩu</th>
            <th>Họ tên</th>
            <th>Khoa</th>
            <th>Giới tính</th>
            <th>Email</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Năm học</th>
            <th>SĐT</th>
            <th>Role</th>
          </tr>
          <c:forEach var="user" items="${userModelList}">
            <tr>
              <form>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.fullname}</td>
                <td>${user.department}</td>
                <td>${user.male}</td>
                <td>${user.email}</td>
                <td>${user.birthday}</td>
                <td>${user.address}</td>
                <td>${user.schoolyear}</td>
                <td>${user.phone}</td>
                <td>${user.role}</td>
              </form>
            </tr>
          </c:forEach>
          </thead>
        </table>
      </div>
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