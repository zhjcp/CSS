<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/20
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选修公选课</title>
    <%-- 页面缩放 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%-- bootstrap便捷地美化界面 cdn --%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <style>
        th,td{
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th class="col-md-3">课程</th>
                    <th class="col-md-2">类型</th>
                    <th class="col-md-2">学时</th>
                    <th class="col-md-2">学分</th>
                    <th class="col-md-3">操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="course" items="${requestScope.get('publicCourseListUnique')}">
                    <tr>
                        <td>${course.getName()}</td>
                        <td>${course.getType()}</td>
                        <td>${course.getHours()}</td>
                        <td>${course.getCredits()}</td>
                        <td>
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/StudentController/toSelectPublicCourseDes?className=${course.getName()}}">查看详情</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
