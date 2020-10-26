<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/18
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>校级管理员</title>
    <%-- 页面缩放 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%-- bootstrap便捷地美化界面 cdn --%>
    <%--suppress JSUnresolvedLibraryURL --%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

</head>
<style>
    .header{
        margin: 0 auto;
        max-width: 960px;
        height: 100px;
        background-color: white;
    }
    .content{
        margin: 0 auto;
        max-width: 960px;
        height: 400px;
        background-color: white;
    }
    .footer{
        margin: 0 auto;
        max-width: 960px;
        height: 100px;
        background-color: white;
    }
    .btn-default{
    <%--似乎按照菜鸟教程上的顺序定义了方向，但是只考虑上左 --%>
        background-color: lightgreen;
        color: darkblue;

        margin:5%  25% ;
        width: 50%;
        height: 50%;
    }
    .form-group{
        height:auto;
    }
</style>
<body>
<div class="header" style="text-align: center ">
    <h1>${sessionScope.name}   欢迎你，校级管理员！</h1>
</div>
<div class="row col-md-12" >
    <h2 class="col-md-offset-5 col-md-3" style="color: red">实时在线人数：${applicationScope.onlineCount}</h2>
</div>
<div class="content">
    <form  role="form" style="width:100%;height:400px ">
        <%-- 这里应该加jstl --%>
        <div class="form-group" >
            <a type="button" class="btn btn-default" href="#">软件学院</a>
        </div>
        <div class="form-group" >
            <a type="button" class="btn btn-default" href="#">计算机学院</a>
        </div>


    </form>
</div>
<div class="footer">

</div>
</body>
</html>
