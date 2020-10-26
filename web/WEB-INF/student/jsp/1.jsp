<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/20
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>选课界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 新 Bootstrap 核心 CSS 文件 -->

    <%--suppress JSUnresolvedLibraryURL --%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
</head>
<style>
    .btn-default{
        background-color: lightgreen;
        color: darkblue;
        width: 50%;
        height: 20%;
        margin: 150px 25%;
        padding: 10% 10%;
    }
    .col-md-3{
        height: 520px;
    }
    <%--我感觉如果不设置的话，button这类有自己的大小，外层比他大就包含着，比他小反而覆盖了，地点默认在左上了 --%>
    #score{
        background-color:gray;
        color: aqua;
        text-align: center;
        border: 3px solid darkgreen;
        float: right;
        margin: 10px;
        width:100px ;
        height: 40px;
    }
    body{

    }
</style>
<body>





<div class="container">
    <div style="height: 80px;width:100%">
        <label id="score">剩余分数:100</label>
    </div>
    <div class="row">
        <div class="col-md-3"  >

            <a href="${pageContext.request.contextPath}/StudentController/toSelectNecessaryCourse/1/1" type="button" class="btn btn-default">必修课</a>

        </div>
        <div class="col-md-3"  >
            <a href="${pageContext.request.contextPath}/StudentController/toSelectSelectiveCourse/1/1" type="button" class="btn btn-default">专业选修课</a>

        </div>
        <div class="col-md-3"  >
            <a href="${pageContext.request.contextPath}/StudentController/toSelectPECourse/1/2" type="button" class="btn btn-default">体育课</a>

        </div>
        <div class="col-md-3"  >
            <a href="${pageContext.request.contextPath}/StudentController/toSelectPublicCourse/1/3" type="button" class="btn btn-default">公选课</a>

        </div>
    </div>

</div>




</body>
</html>
