<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登陆</title>
</head>
<body>
<div id="loginDiv">
    <form action="/tianlong/loginServlet" id="form" method="post">
        <h1 id="loginMsg">用户登陆</h1>
        <div id="errorMsg">${login_msg} ${register_msg}</div>
        <p>用户名：<input id="username" name="username" type="text"></p>
        <p>密&nbsp;&nbsp;&nbsp;码：<input id="password" name="password" type="password"></p>
        <p>记住我：<input id="remember" name="remember" value="1" type="checkbox"></p>
        <p>验证码：<input name="checkCode" type="text" id="checkCode"> <img id="checkCodeImg" style="width: 60px; height: 25px; object-fit: cover;" src="/tianlong/checkCodeServlet"> <a href="#" id="changeImg">看不清？</a></p>
        <div id="subDiv">
            <input type="submit" class="button" value="登录">
            <input type="reset" class="button" value="重置">
        </div>
    </form>
</div>
<script>
    document.getElementById("changeImg").onclick = function () {
        document.getElementById("checkCodeImg").src = "/tianlong/checkCodeServlet?" + new Date().getMilliseconds();
    }
</script>
</body>
</html>
