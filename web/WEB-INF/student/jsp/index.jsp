<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/17
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生选课系统主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <%--suppress JSUnresolvedLibraryURL --%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="//cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--suppress JSUnresolvedLibraryURL --%>
</head>
<style>

    .btn-default{
    <%--似乎按照菜鸟教程上的顺序定义了方向，但是只考虑上左 --%>
        background-color: lightgreen;
        color: darkblue;
        padding: 5% 5%;
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
    <h1 style="color:bisque"><strong>${sessionScope.name}同学，你好！</strong></h1>
</div>
<div style="height: 60px"></div>
<div class="container">
    <div class="row" >
        <div class="col-md-6" >

            <form  role="form" style="width:100%;height:400px ">
                <div class="form-group" >
                    <a href="${pageContext.request.contextPath}/StudentController/toSelectCourse" type="button" class="btn btn-default">选课</a>
                </div>
                <div class="form-group" >
                    <a href="${pageContext.request.contextPath}/StudentController/toSelectInfo/${sessionScope.id}" type="button" class="btn btn-default">查看个人课程</a>
                </div>
                <div class="form-group">
                    <a href="${pageContext.request.contextPath}/StudentController/toSelectTable" type="button" class="btn btn-default">查看个人课表</a>
                </div>

            </form>
        </div>

        <div class="col-md-6" >
            <div id="myCarousel" class="carousel slide">

                <!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">

                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/sources/zhongqiu1.png" alt="First slide" style="background-color: #08d0b7">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/sources/zhongqiu2.png" style="background-color: #08d0b7" alt="Second slide">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/sources/guoqing2.png" style="background-color: #08d0b7" alt="Third slide">
                    </div>
                </div>
                <!-- 轮播（Carousel）导航 -->
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

    </div>
</div>


</body>
</html>
