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
        <form action="edit" method="get">
        <table>
            <tr>
                <td>Day</td>
                <td>Start</td>
                <td>End</td>
                <td>Date</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td><select name="availableDay">
                    <!--Listing days-->
                </select></td>
                <td><input type="time"   name="availableStart"/></td>
                <td><input type="time"   name="availableEnd"/></td>
                <td><input type="date"   name="availableDate"  value="${date1}"/></td>
                <td><input type="submit" class="add" name="action" value="Add More" ></td>
            </tr>
        </table>
        </form>

</div>
</body>
</html>
