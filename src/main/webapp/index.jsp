<%--
  Created by IntelliJ IDEA.
  User: 胡思荣
  Date: 2019/6/22
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--ico的做法-->
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" href="css/cssreset.css">
    <title>图书馆预约系统</title>
    <!--公共样式-->
    <link rel="stylesheet" href=css/index.css>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src='jQuery版本/jquery-3.0.0.js'></script>
    <link rel="stylesheet" href="css/left.css">
</head>

<body>
<div class="w">
    <!-- banner部分开始 -->
    <div class="banner">
        <div class="left">
        </div>
        <div class="right">
            <img src="images/logo.png" alt="">
            <div class="welcome">
                <p>欢迎你：胡同学!</p>
            </div>
        </div>
    </div>

    <div class="center-fl1">
        <img src="./images/fl1.png" alt="">
    </div>
    <!-- baner部分结束 -->
    <!-- 中心部分开始 -->
    <div class="main">
        <!-- 主体部分 -->
        <div class="main-left">
            <iframe src="p.html" name="mainiframe" scrolling="no" frameborder="0" borber="0" width="100%" height="100%"></iframe>
        </div>
        <!-- 边导航栏部分 -->
        <div class="main-right">
            <ul>
                <a href="p.html" target="iframe_f"></a>
                <li id="login"><a href="login.html" target="mainiframe">登录</a></li>
                <li id="register"><a href="register.html" target="mainiframe">注册</a></li>
                <li id="book"><a href="book.html" target="mainiframe">预约座位</a></li>
                <li id="left"><a href="left.html" target="mainiframe">离开/签到</a></li>
                <li id="mes"><a href="查询记录.html" target="mainiframe">信息查询</a></li>
                <li class="fl2"><img src="images/fl2.png" alt=""></li>
            </ul>

        </div>
    </div>

</div>
<script>
    // $("#login").click(function() {
    //     var mainiframe=document.getElementById("mainiframe");
    //     parent.mainiframe.contentWindow.loaction.href="login.html";
    //
    // });
    // $("#mes").click(function() {
    //
    //
    //     $("#p").css("display", "none");
    // });
</script>
<!-- <script type=text/javascript>
    document.getElementById("iframe_a").addEventLister("click", show);

    function show(event) {
        event.stopPragation();
    }
</script> -->

</body>

</html>
