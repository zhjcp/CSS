<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/25
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理课程</title>
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
    .form-group{
        margin-top: 30px;
    }
    .btn-default{
        background-color: lightgreen;
        color: darkblue;
    }
</style>
<body>
<form class="form-horizontal" role="form" style="margin-top: 100px">
    <div class="form-group">
        <label  class="col-sm-2 control-label">类别</label>
        <div class="col-sm-2">
            <%-- 这个value的值应该是要调的 --%>
            <input type="radio"  name="class" id="first" value="option1" checked> 专业课
        </div>
        <div class="col-sm-2">
            <input type="radio"  name="class" id="second" value="option2" > 体育课
        </div>
        <div class="col-sm-2">
            <input type="radio"  name="class" id="third" value="option3" > 公选课
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">正选</label>

        <input type="date"  class="col-sm-2" id="zhengfirdate" value="">
        <input type="time"  class="col-sm-2" id="zhengfirtime" value="">
        <input type="date" class="col-sm-2"  id="zhengsecdate" value="">
        <input type="date" class="col-sm-2"  id="zhengsectime" value="">

    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">补选</label>

        <input type="date"  class="col-sm-2" id="bufirdate" value="">
        <input type="time"  class="col-sm-2" id="bufirtime" value="">
        <input type="date" class="col-sm-2"  id="busecdate" value="">
        <input type="date" class="col-sm-2"  id="busectime" value="">

    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">退选</label>

        <input type="date"  class="col-sm-2" id="tuifirdate" value="">
        <input type="time"  class="col-sm-2" id="tuifirime" value="">
        <input type="date" class="col-sm-2"  id="tuisecdate" value="">
        <input type="date" class="col-sm-2"  id="tuisectime" value="">

    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <a type="submit" class="btn btn-default" href="#" >确定</a>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
      <a type="submit" class="btn btn-default" href="${pageContext.request.contextPath}/AdminSController/calculateSelectionResult1" >计算必修课结果</a>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <a type="submit" class="btn btn-default" href="${pageContext.request.contextPath}/AdminSController/calculateSelectionResult2" >计算专业选修课结果</a>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <a type="submit" class="btn btn-default" href="${pageContext.request.contextPath}/AdminSController/calculateSelectionResult3" >计算体育课结果</a>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <a type="submit" class="btn btn-default" href="${pageContext.request.contextPath}/AdminSController/calculateSelectionResult4" >计算公选课结果</a>
        </div>
    </div>

</form>

</body>
</html>
