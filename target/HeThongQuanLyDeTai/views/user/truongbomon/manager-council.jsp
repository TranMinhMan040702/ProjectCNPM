<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Thông báo khi đủ số lượng || GV trùng với GV hướng dẫn || Đủ số lượng GV--%>
<%--<c:if test="${not empty message}">--%>
<%--    <div class="alert alert-warning alert-dismissible fade show" role="alert">--%>
<%--        <strong></strong>--%>
<%--        <button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
<%--            <span aria-hidden="true">&times;</span>--%>
<%--        </button>--%>
<%--    </div--%>
<%--</c:if>--%>
<c:if test="${not empty message and message == 'danger'}">
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong>Đã có trong danh sách</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
<c:if test="${not empty message and message == 'success'}">
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong>Thêm thành công</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>

<c:set var = "check" scope = "session" value = "${action}"/>
<c:if test="${check == 'list'}">
<div>
    <h5 style="font-weight: bold">Danh sách hội đồng phản biện</h5>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã sinh viên</th>
            <th scope="col">Đề tài phản biện</th>
            <th scope="col">SLGV</th>
            <th scope="col">Ngày phản biện</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach
                var="councilList"
                items="${councilList}"
        >

        <tr>
            <td>${councilList.projectStudent.user.username}</td>
            <td>${councilList.projectStudent.projectLecturers.topic}</td>
            <td>${councilList.numberLecturers}</td>
            <td>${councilList.dateCounterArgument}</td>
            <td>${councilList.status}</td>
            <td>
                <div class="d-flex justify-content-around align-items-center">
                    <a class="btn btn-primary btn-sm"
<%--                       data-toggle="modal" data-target="#chon-giang-vien"--%>
                       href="<c:url value="/truongbomon/council/create?id=${councilList.id}"/>">
                        <c:if test="${councilList.status != 'Đã được phân công'}">
                        Thêm giảng viên
                        </c:if>
                        <c:if test="${councilList.status == 'Đã được phân công'}">
                            Chỉnh sửa
                        </c:if>
                    </a>
                </div>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>
<%--Khi nao bấm thêm mới hiện danh sách giảng viên --%>

<c:if test="${check == 'create'}">


<div>
    <div class="mb-3">
        <h6 style="font-weight: bold">Tìm kiếm GV</h6>
        <form class="form-inline" action="search?id=${councilModel.id}" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
        </form>
    </div>
    <input name ="idCouncil" value="${councilModel.id}" hidden>
    <div class="row">
        <div class="form-group col-6">
            <label>Tên đề tài</label>
            <input class="form-control"  type="text" readonly value="${councilModel.projectStudent.projectLecturers.topic} - ${councilModel.projectStudent.user.username}">
        </div>
        <div class="form-group col-3">
            <label>SL GV yêu cầu</label>
            <input class="form-control" type="number" readonly value="${councilModel.numberLecturers}">
        </div>
        <div class="form-group col-3">
            <label>SL GV đã thêm</label>
            <input class="form-control" type="number" readonly value="${number}">
        </div>
    </div>

    <h6 style="font-weight: bold">Danh sách giảng viên trong hội đồng</h6>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">MGV</th>
            <th scope="col">Tên giảng viên</th>
            <th scope="col">Bộ môn</th>
            <th scope="col">Chức vụ</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${councilModel.leader != null}">
        <form action="delete" method="post">
            <tr>
                <input name="leader" value="yes" hidden>
                <input name="idCouncil" hidden value="${councilModel.id}">
                <td>${councilModel.leader.username}</td>
                <td>${councilModel.leader.fullname}</td>
                <td>${councilModel.leader.department}</td>
                <td>Trưởng hội đồng</td>
                <c:if test=""></c:if>
                <td>
                    <div class="d-flex justify-content-around align-items-center">
                        <button class="btn btn-danger btn-sm" type="submit" >Xoá</button>
                    </div>
                </td>
            </tr>
        </form>
        </c:if>
        <c:forEach
                var="memberCouncilModels"
                items="${memberCouncilModels}"
        >
            <form action="delete" method="post">
                <tr>
                    <input name="leader" value="no" hidden >
                    <input name="idCouncil" hidden value="${councilModel.id}">
                    <input name="id" hidden value="${memberCouncilModels.id}">
                    <td>${memberCouncilModels.user.username}</td>
                    <td>${memberCouncilModels.user.fullname}</td>
                    <td>${memberCouncilModels.user.department}</td>
                    <td>Thành viên</td>
                    <c:if test=""></c:if>
                    <td>
                        <div class="d-flex justify-content-around align-items-center">
                            <button class="btn btn-danger btn-sm" type="submit" >Xoá</button>
                        </div>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>

<%--    <div class="mb-3">--%>
<%--        <h6 style="font-weight: bold">Tìm kiếm GV</h6>--%>
<%--        <form class="form-inline">--%>
<%--            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>--%>
<%--        </form>--%>
<%--    </div>--%>
    <h6 style="font-weight: bold">Danh sách giảng viên</h6>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">MGV</th>
            <th scope="col">Tên giảng viên</th>
            <th scope="col">Bộ môn</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach
                    var="lecturersList"
                    items="${lecturersList}"
            >
            <form action="create/one" method="post">
        <tr>
            <input name="idCouncil" hidden value="${councilModel.id}">
            <input  name="username" hidden value="${lecturersList.username}">
            <td>${lecturersList.username}</td>
            <td>${lecturersList.fullname}</td>
            <td>${lecturersList.department}</td>
            <c:if test=""></c:if>
            <td>
                <div class="d-flex justify-content-around align-items-center">
                    <button class="btn btn-primary btn-sm" type="submit" <c:if test="${number ==councilModel.numberLecturers or ((number ==councilModel.numberLecturers-1) and (councilModel.leader == null))}"> disabled </c:if>>Thêm</button>
                    <c:if test="${councilModel.leader == null}">
                    <a href="./create/one?idCouncil=${councilModel.id}&username=${lecturersList.username}" class="btn btn-primary btn-sm" <c:if test="${number ==councilModel.numberLecturers}"> disabled </c:if>>Thêm trưởng hội đồng</a>
                    </c:if>
<%--GV nào thêm rồi thay nút thêm thành nút hủy--%>
<%--                    <a class="btn btn-danger btn-sm"--%>
<%--                       data-toggle="modal" data-target="#chon-giang-vien"--%>
<%--                       href="">--%>
<%--                        Hủy--%>
<%--                    </a>--%>
                </div>
            </td>
        </tr>
            </form>
            </c:forEach>
        </tbody>
    </table>
    <div class="form-group d-flex justify-content-end">
        <c:if test="${number == councilModel.numberLecturers}">
        <a style="padding-left: 20px; padding-right: 20px; margin-right: 10px;"
                id="btnAddEmployee" class="btn btn-primary" href="./create/complete?idCouncil=${councilModel.id}">
            Hoàn thành
        </a>
        </c:if>
            <a style="padding-left: 20px; padding-right: 20px;"
                    class="btn btn-danger" type="" href="./deleteAll?idCouncil=${councilModel.id}">Hủy
            </a>
    </div>
</div>
</c:if>
<!-- Modal -->
<div class="modal fade" id="xac-nhan" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Bạn chắc chắn thêm giảng viên này vào hội đồng ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                <button type="submit" class="btn btn-primary" >Xác nhận</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
