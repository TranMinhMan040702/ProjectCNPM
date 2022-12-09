<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div >
    <h5 style="font-weight: bold;">Danh sách đăng ký</h5>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Sinh viên đăng ký</th>
            <th scope="col">Tên đề tài</th>
            <th scope="col">Chuyên ngành</th>
            <th scope="col">GVHD</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="projS" items="${projectStudentModelList}">
            <c:if test="${projS.status=='Chưa được duyệt'}">
                <c:url value="/truongbomon/browse-project/update?action=tuchoi&id=${projS.id}" var="urlDeny"/>
            <tr>
                <td>${projS.user.fullname}</td>
                <td>${projS.projectLecturers.topic}</td>
                <td>${projS.projectLecturers.department}</td>
                <td>${projS.projectLecturers.user.username}</td>
                <td>
                    <div class="d-flex justify-content-around align-items-center">
                        <a class="btn btn-primary btn-sm" style="margin-right: 10px; color: white"
                           href="<c:url value="/truongbomon/browse-project/update?action=duyet&id=${projS.id}"/>">
                            Duyệt
                        </a>
                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalCensor">
                            Từ chối
                        </button>
                    </div>
                </td>
            </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="modalCensor" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Cảnh báo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Bạn chắc chắn từ chối đề tài này ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                <button type="button" class="btn btn-primary" onclick="Deny()">Chắc chắn</button>
            </div>
        </div>
    </div>
</div>

<script>
    function Deny(){
        window.location.href = "${urlDeny}";
    }
</script>
</body>
</html>
