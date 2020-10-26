<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/20
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>必修套餐</title>
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
    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
    }

    /* 头部样式 */
    .header {
        background-color: #f1f1f1;
        padding: 20px;
        text-align: center;
    }
    .col-md-2,.col-md-4{
        text-align: center;
    }

   td{
    height: 60px;
     }

    /* 创建三个相等的列 */
    .column {
        float: left;
        width: 50%;

    }
    .btn-default{
        background-color: lightgreen;
        color: darkblue;
    }
    /* 列后清除浮动 */
    .row:after {
        content: "";
        display: table;
        clear: both;
    }

    /* 响应式布局 - 小于 600 px 时改为上下布局 */
    @media screen and (max-width: 600px) {
        .column {
            width: 100%;
        }
    }

</style>
<script>
    function tip1() {
        var d=document.getElementById('t1').value;//首先通过文本框的id获取它的值然后进行判断
        if(!(d>=0&&d<=100)){//如果输入的字符不在范围内
            d.value=0;
            alert("格式错误或余额不足");
        }
        else
        {return confirm('您确定要选择该课程吗？');}
    }
</script>
<body>
<%-- 开始没有设计好，这里只能两组了 --%>
<div class="header">
    <h1>必修课套餐选择</h1>
</div>
<div class="row">
<c:forEach var="group1" items="${requestScope.get('necessaryCourseGroups')}" begin="0" end="0">
    <div class="column">
        <table class="table table-hover table-bordered" style="word-wrap:break-word;word-break:break-all">
            <thead>
            <tr >
                <th  class="col-md-2" >课名</th>
                <th  class="col-md-2" >教师名</th>
                <th  class="col-md-2">容量</th>
                <th  class="col-md-2">学时</th>
                <th  class="col-md-4" >描述</th>
            </tr>
            </thead>

            <tbody>

    <c:forEach var="course" items="${pageScope.get('group1').getCourseList()}" >
            <tr>
                <%-- 到时候在这里增加引入数据项 --%>
                <td class="col-md-2">${course.getName()}</td>
                <td class="col-md-2">${course.getTeacherName()}</td>
                <td class="col-md-2">${course.getCapacity()}</td>
                <td class="col-md-2">${course.getHours()}</td>
                <td class="col-md-4">${course.getDescription()}</td>
            </tr>
    </c:forEach>

            </tbody>
        </table>
    <c:forEach var="course" items="${pageScope.get('group1').getCourseList()}" begin="0" end="0">
            <form action="${pageContext.request.contextPath}/StudentController/submitASelectionGrouping" method="get">
                <input id="t1"  name="selectionCoins" value="0"  type="text" style="width:50px;height:20px;text-align:center;margin-left: 50px">
                <input name="groupId" type="text" hidden value="${course.getGroupId()}">
                <input type="submit" value="提交" class="btn btn-default" style="margin-left: 20px" onclick="tip1()">
            </form>
    </c:forEach>
    </div>
</c:forEach>

<c:forEach var="group2" items="${requestScope.get('necessaryCourseGroups')}" begin="1" end="1">
    <div class="column">
        <table class="table table-hover table-bordered" style="word-wrap:break-word;word-break:break-all">
            <thead>

            <tr >
                <th  class="col-md-2" >课名</th>
                <th  class="col-md-2" >教师名</th>
                <th  class="col-md-2">容量</th>
                <th  class="col-md-2">学时</th>
                <th  class="col-md-4" >描述</th>
    </tr>
            </thead>

            <tbody>
    <c:forEach var="course" items="${pageScope.get('group2').getCourseList()}">
                <tr>
                        <%-- 到时候在这里增加引入数据项 --%>
                    <td class="col-md-2">${course.getName()}</td>
                    <td class="col-md-2">${course.getTeacherName()}</td>
                    <td class="col-md-2">${course.getCapacity()}</td>
                    <td class="col-md-2">${course.getHours()}</td>
                    <td class="col-md-4">${course.getDescription()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
     <form action="${pageContext.request.contextPath}/StudentController/submitASelectionGrouping" method="get">
         <div >
    <c:forEach var="course" items="${pageScope.get('group2').getCourseList()}" begin="0" end="0">
         <input id="t2"   name="selectionCoins" value="0"  type="text" style="width:50px;height:20px;text-align:center;margin-left: 50px">
         <input name="groupId" type="text" hidden value="${course.getGroupId()}">
         <input type="submit"  value="提交" class="btn btn-default" style="margin-left: 20px" onclick="tip1()">
         </div>
     </form>
        </c:forEach>
    </div>
</c:forEach>

</div>
</body>
</html>
