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

<input type="button" value="新增门派" id="add"> <a href="/tianlong/selectAllHeroesServlet">去查看英雄</a>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th style="width: 50px;">序号</th>
        <th style="width: 100px;">门派名称</th>
        <%--<th>创建时间</th>
        <th>更新时间</th>--%>
        <th>门派介绍</th>
        <th style="width: 100px;">操作</th>
    </tr>

    <c:forEach items="${sects}" var="sect" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${sect.name}</td>
            <%--<td><fmt:formatDate value="${sect.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><fmt:formatDate value="${sect.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
            <td style="word-wrap: break-word">${sect.introduction}</td>
            <td><a href="/tianlong/selectSectByIdServlet?id=${sect.id}">修改</a> <a href="/tianlong/deleteSectByIdServlet?id=${sect.id}">删除</a></td>
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
        location.href = "addSect.html";
    }
</script>

</body>
</html>