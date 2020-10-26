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
    <title>院级管理员</title>
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
    .btn-default{
    <%--似乎按照菜鸟教程上的顺序定义了方向，但是只考虑上左 --%>
        background-color: lightgreen;
        color: darkblue;

        margin:5%  25% ;
        width: 50%;
        height: 50%;
    }
    .form-group{
        height: 30%;

    }
</style>
<body>
<div style="text-align: center">
    <h1><strong>${sessionScope.name}   欢迎你，院级管理员！</strong></h1>
</div>
<div class="container">
    <div class="row" >
        <div class="col-md-6" >

            <form  role="form" style="width:100%;height:400px ">
                <div class="form-group" >
                    <a type="button" class="btn btn-default" href="#">管理课程</a>
                </div>
                <div class="form-group" >
                    <a type="button" class="btn btn-default" href="#">管理学生</a>
                </div>
                <div class="form-group">

                    <a type="button" class="btn btn-default" href="#">管理教师</a>

                </div>

            </form>
        </div>
        <div class="col-md-6" >
            <img src="${pageContext.request.contextPath}/sources/img1.jpg" width="100%" height="100%">
        </div>
    </div>
</div>
</body>
</html>
