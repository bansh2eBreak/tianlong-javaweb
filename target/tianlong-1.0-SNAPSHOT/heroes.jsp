<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>

<h1>${user.username}，欢迎您！<a href="/tianlong/logoutServlet">退出登录</a></h1>

<input type="button" value="新增英雄" id="add"> <a href="/tianlong/selectAllSectsServlet">去查看门派</a>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>代表武功</th>
        <th>性别</th>
        <th>头像</th>
        <th>级别</th>
        <th>出生日期</th>
        <th>门派</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${heroes}" var="hero" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${hero.name}</td>
            <td>${hero.kongfu}</td>
            <c:if test="${hero.gender == 0}">
                <td>女</td>
            </c:if>
            <c:if test="${hero.gender == 1}">
                <td>男</td>
            </c:if>
            <%--<td>${hero.image}</td>--%>
            <td><img src="${hero.image}" alt="None" style="max-width: 100px; max-height: 100px;"></td>
            <c:if test="${hero.level == 1}">
                <td>王者</td>
            </c:if>
            <c:if test="${hero.level == 2}">
                <td>钻石</td>
            </c:if>
            <c:if test="${hero.level == 3}">
                <td>黄金</td>
            </c:if>
            <c:if test="${hero.level == 4}">
                <td>白银</td>
            </c:if>
            <c:if test="${hero.level == 5}">
                <td>青铜</td>
            </c:if>
            <td><fmt:formatDate value="${hero.birthdate}" pattern="yyyy-MM-dd"/></td>
            <c:if test="${hero.sectId == 1}">
                <td>大理段氏</td>
            </c:if>
            <c:if test="${hero.sectId == 2}">
                <td>少林寺</td>
            </c:if>
            <c:if test="${hero.sectId == 3}">
                <td>灵鹫宫</td>
            </c:if>
            <c:if test="${hero.sectId == 4}">
                <td>丐帮</td>
            </c:if>
            <c:if test="${hero.sectId == 5}">
                <td>一品堂</td>
            </c:if>
            <c:if test="${hero.sectId == 6}">
                <td>逍遥派</td>
            </c:if>
            <c:if test="${hero.sectId == 7}">
                <td>姑苏慕容</td>
            </c:if>
            <td><a href="/tianlong/selectHeroByIdServlet?id=${hero.id}">修改</a> <a href="/tianlong/deleteHeroByIdServlet?id=${hero.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<br>

<h1>当前在线人数：<span id="onlineUsersCount">加载中....</span></h1>

<script>
    function getOnlineUsersCount() {
        fetch('/tianlong/getonline')
            .then(response => response.json())
            .then(data => {
                document.getElementById("onlineUsersCount").innerText = data.onlineUsers;
            })
            .catch(error => {
                console.error('Error fetching online users count: ', error);
                document.getElementById("onlineUsersCount").innerText = 'N/A';
            });
    }

    // 初次加载页面时获取在线人数
    getOnlineUsersCount();

    // 每隔5秒更新在线人数
    setInterval(getOnlineUsersCount, 1000);

    document.getElementById("add").onclick=function (){
        location.href = "addHero.html";
    }
</script>

</body>
</html>