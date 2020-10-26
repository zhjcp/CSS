<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/20
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>查看个人课表</title>
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
    .col-md-2,.col-md-6{
        text-align: center;

    }
    td.col-md-2,td.col-md-6{
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


    <div style="margin-top: 80px">
        <table class="table table-hover table-bordered">
            <thead>
            <tr >
                <th  class="col-md-2" >课程名</th>
                <th  class="col-md-6">描述</th>
                <th  class="col-md-2">状态</th>
                <th  class="col-md-2">选择</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="course" items="${requestScope.get('allSelectedCourse').getNecessaryCourseList()}" >
                            <tr>
                                <td class="col-md-2">${course.getName()}</td>

                                <td class="col-md-6">${course.getDescription()}</td>
                                <td class="col-md-2">已选</td>
                                <td class="col-md-2">
                                    <button type="button" style="color: gray;text-align: center" >退选</button>

                                </td>
                            </tr>
                </c:forEach>
                <c:forEach var="course" items="${requestScope.get('allSelectedCourse'). getSelectiveCourseList()}" >
                    <tr>
                        <td class="col-md-2">${course.getName()}</td>

                        <td class="col-md-6">${course.getDescription()}</td>
                        <td class="col-md-2">选课中</td>
                        <td class="col-md-2">
                            <a class="btn btn-default"  href="${pageContext.request.contextPath}/StudentController/submitAReturn/${course.getName()}" >退选</a>
                        </td>
                    </tr>
                </c:forEach>
                <c:forEach var="course" items="${requestScope.get('allSelectedCourse').getPeCourseList()}" >
                    <tr>
                        <td class="col-md-2">${course.getName()}</td>

                        <td class="col-md-6">${course.getDescription()}</td>
                        <td class="col-md-2">选课中</td>
                        <td class="col-md-2">
                            <a class="btn btn-default"  href="${pageContext.request.contextPath}/StudentController/submitAReturn/${course.getName()}" >退选</a>
                        </td>
                    </tr>
                </c:forEach>

                <c:forEach var="course" items="${requestScope.get('allSelectedCourse').getPublicCourseList()}" >
                    <tr>
                        <td class="col-md-2">${course.getName()}</td>

                        <td class="col-md-6">${course.getDescription()}</td>
                        <td class="col-md-2">选课中</td>
                        <td class="col-md-2">
                            <a class="btn btn-default"  href="${pageContext.request.contextPath}/StudentController/submitAReturn/${course.getId()}" >退选</a>
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
</body>
</html>

