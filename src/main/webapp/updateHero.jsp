<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改英雄个人信息</title>
</head>
<body>
<h3>修改英雄个人信息</h3>
<form action="/tianlong/updateHeroServlet" method="post" enctype="multipart/form-data">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${hero.id}">
    <label>姓名:<input name="name" type="text" value="${hero.name}">
    </label><br>
    <label>密码:<input name="password" type="password" value="${hero.password}">
    </label><br>
    <label>代表功夫:<input name="kongfu" type="text" value="${hero.kongfu}">
    </label><br>
    <label>性别:
        <c:if test="${hero.gender == 1}">
            <input name="gender" type="radio" value="1" checked>男
            <input name="gender" type="radio" value="0">女
        </c:if>
        <c:if test="${hero.gender == 0}">
            <input name="gender" type="radio" value="1">男
            <input name="gender" type="radio" value="0" checked>女
        </c:if>
        </label><br>
    <label>头像上传:<input type="file" name="image"></label><br>
    <label>级别:
        <c:if test="${hero.level == 1}">
            <input name="level" type="radio" value="1" checked>王者
            <input name="level" type="radio" value="2">钻石
            <input name="level" type="radio" value="3">黄金
            <input name="level" type="radio" value="4">白银
            <input name="level" type="radio" value="5">青铜
        </c:if>
        <c:if test="${hero.level == 2}">
            <input name="level" type="radio" value="1">王者
            <input name="level" type="radio" value="2" checked>钻石
            <input name="level" type="radio" value="3">黄金
            <input name="level" type="radio" value="4">白银
            <input name="level" type="radio" value="5">青铜
        </c:if>
        <c:if test="${hero.level == 3}">
            <input name="level" type="radio" value="1">王者
            <input name="level" type="radio" value="2">钻石
            <input name="level" type="radio" value="3" checked>黄金
            <input name="level" type="radio" value="4">白银
            <input name="level" type="radio" value="5">青铜
        </c:if>
        <c:if test="${hero.level == 4}">
            <input name="level" type="radio" value="1">王者
            <input name="level" type="radio" value="2">钻石
            <input name="level" type="radio" value="3">黄金
            <input name="level" type="radio" value="4" checked>白银
            <input name="level" type="radio" value="5">青铜
        </c:if>
        <c:if test="${hero.level == 5}">
            <input name="level" type="radio" value="1">王者
            <input name="level" type="radio" value="2">钻石
            <input name="level" type="radio" value="3">黄金
            <input name="level" type="radio" value="4">白银
            <input name="level" type="radio" value="5" checked>青铜
        </c:if>
    </label><br>
<%--    <label>出生日期:<input name="birthdate" type="date" value="${hero.birthdate}"></label><br>--%>
    <label>所属门派:
        <c:if test="${hero.sectId == 1}">
            <input name="sectId" type="radio" value="1" checked>大理段氏
            <input name="sectId" type="radio" value="2">少林寺
            <input name="sectId" type="radio" value="3">灵鹫宫
            <input name="sectId" type="radio" value="4">丐帮
            <input name="sectId" type="radio" value="5">一品堂
            <input name="sectId" type="radio" value="6">逍遥派
            <input name="sectId" type="radio" value="7">姑苏慕容
        </c:if>
        <c:if test="${hero.sectId == 2}">
            <input name="sectId" type="radio" value="1">大理段氏
            <input name="sectId" type="radio" value="2" checked>少林寺
            <input name="sectId" type="radio" value="3">灵鹫宫
            <input name="sectId" type="radio" value="4">丐帮
            <input name="sectId" type="radio" value="5">一品堂
            <input name="sectId" type="radio" value="6">逍遥派
            <input name="sectId" type="radio" value="7">姑苏慕容
        </c:if>
        <c:if test="${hero.sectId == 3}">
            <input name="sectId" type="radio" value="1">大理段氏
            <input name="sectId" type="radio" value="2">少林寺
            <input name="sectId" type="radio" value="3" checked>灵鹫宫
            <input name="sectId" type="radio" value="4">丐帮
            <input name="sectId" type="radio" value="5">一品堂
            <input name="sectId" type="radio" value="6">逍遥派
            <input name="sectId" type="radio" value="7">姑苏慕容
        </c:if>
        <c:if test="${hero.sectId == 4}">
            <input name="sectId" type="radio" value="1">大理段氏
            <input name="sectId" type="radio" value="2">少林寺
            <input name="sectId" type="radio" value="3">灵鹫宫
            <input name="sectId" type="radio" value="4" checked>丐帮
            <input name="sectId" type="radio" value="5">一品堂
            <input name="sectId" type="radio" value="6">逍遥派
            <input name="sectId" type="radio" value="7">姑苏慕容
        </c:if>
        <c:if test="${hero.sectId == 5}">
            <input name="sectId" type="radio" value="1">大理段氏
            <input name="sectId" type="radio" value="2">少林寺
            <input name="sectId" type="radio" value="3">灵鹫宫
            <input name="sectId" type="radio" value="4">丐帮
            <input name="sectId" type="radio" value="5" checked>一品堂
            <input name="sectId" type="radio" value="6">逍遥派
            <input name="sectId" type="radio" value="7">姑苏慕容
        </c:if>
        <c:if test="${hero.sectId == 6}">
            <input name="sectId" type="radio" value="1">大理段氏
            <input name="sectId" type="radio" value="2">少林寺
            <input name="sectId" type="radio" value="3">灵鹫宫
            <input name="sectId" type="radio" value="4">丐帮
            <input name="sectId" type="radio" value="5">一品堂
            <input name="sectId" type="radio" value="6" checked>逍遥派
            <input name="sectId" type="radio" value="7">姑苏慕容
        </c:if>
        <c:if test="${hero.sectId == 7}">
            <input name="sectId" type="radio" value="1">大理段氏
            <input name="sectId" type="radio" value="2">少林寺
            <input name="sectId" type="radio" value="3">灵鹫宫
            <input name="sectId" type="radio" value="4">丐帮
            <input name="sectId" type="radio" value="5">一品堂
            <input name="sectId" type="radio" value="6">逍遥派
            <input name="sectId" type="radio" value="7" checked>姑苏慕容
        </c:if>
    </label><br>
    <input type="submit" value="确认修改">
</form>
</body>
</html>