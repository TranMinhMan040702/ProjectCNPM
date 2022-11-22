<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Đăng nhập</title>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <c:if test="${not empty message}">
            <div class="alert alert-${altert}">
                    ${message}
            </div>
        </c:if>
        <!-- Login Form -->
        <form action="<c:url value="/login"/>" method="post"
              id="formLogin">
            <input type="text" id="userName" class="fadeIn second" name="username" placeholder="Tên đăng nhập"/>
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="Mật khẩu"/>
            <input type="hidden" value="login" name="action"/>
            <input type="submit" class="fadeIn fourth" value="Log in"/>
        </form>
    </div>
</div>
</body>
</html>
