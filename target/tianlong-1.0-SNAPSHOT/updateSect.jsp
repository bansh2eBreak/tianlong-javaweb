<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改门派信息</title>
</head>
<body>
<h3>修改门派信息</h3>
<form action="/tianlong/updateSectServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${sect.id}">

    <label>门派名称:<input name="name" type="text" value="${sect.name}">
    </label><br>
    <label>门派介绍:<textarea name="introduction" rows="4" cols="50">${sect.introduction}</textarea>
    </label><br>
    <input type="submit" value="确认修改">
</form>
</body>
</html>