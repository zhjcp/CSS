<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/20
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>专业选修课</title>
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
    .col-md-4{
        text-align: center;

    }
    td.col-md-4{
        color:green;
    }
    tr,table{
        border: 1px solid black;
    }
    table{
        width: 100%;
        background-color: white;
    }
    .btn-default{
        background-color: lightgreen;
        color: darkblue;
    }

</style>
<body>
<div class="container">
    <div class="col-md-6" style="margin: 0 20%">
        <div class="input-group">
            <input type="text" class="form-control">
            <span class="input-group-btn">
                        <button class="btn btn-default" type="button">查询</button>
                    </span>
        </div>
    </div>
    <div style="height: 80px;width:100%">
        <label id="score">剩余分数:100</label>

        <div>
            <table class="table table-hover table-bordered">
                <thead>
                <tr >
                    <th  class="col-md-4" >课程名</th>
                    <th  class="col-md-4">学分</th>
                    <th  class="col-md-4">详情</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="course" items="${requestScope.get('selectiveCourseListUnique')}">
                    <tr>
                        <td class="col-md-4">${course.getName()}</td>

                        <td class="col-md-4"> ${course.getCredits()}</td>
                        <td class="col-md-4">
                            <a class="btn btn-default" href="${pageContext.request.contextPath}/StudentController/toSelectSelectiveCourseDes/${course.getName()}">查看详情</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <ul class="pager">
            <li class="previous"><a href="#">&larr; Older</a></li>
            <li class="next"><a href="#">Newer &rarr;</a></li>
        </ul>
    </div>
</div>
</body>
</html>
