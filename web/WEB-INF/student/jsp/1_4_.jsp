<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/20
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>公选课详情</title>
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

    .col-md-1,.col-md-2,.col-md-4{
        text-align: center;
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
    div.container{

        background-image: url("${pageContext.request.contextPath}/sources/img1.jpg");
        background-repeat: no-repeat;
        background-size: cover;
        width:100%;
        height:610px

    }
    div.tranbox{
        opacity:0.8;
        filter:alpha(opacity=80);
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
    //https://www.cnblogs.com/camg/p/13151171.html
    function  tip2(){

        layer.alert('您确定要选择该课程吗？', {
            skin: 'layui-layer-molv' //样式类名 自定义样式
            , closeBtn: 1 // 是否显示关闭按钮
            , title : '选课' //标题
            , anim: 1 //动画类型
            , btn: ['确定', '取消'] //按钮
            , yes: function() {
                //这里也可以写响应的ajax请求
                window.location.href="#";
            }
            , btn2: function () {
                layer.msg('取消');
            }
        })

    }
</script>

<body style="overflow-y:hidden">
<div class="container">
    <div class="tranbox">

        <table class="table table-hover table-bordered" style="word-wrap:break-word;word-break:break-all;margin: 100px 0">
            <thead>
            <tr >
                <th  class="col-md-1" >课名</th>
                <th  class="col-md-1" >教师名</th>
                <th  class="col-md-2">容量</th>
                <th  class="col-md-2">学时</th>
                <th  class="col-md-4" >描述</th>
                <th  class="col-md-1">意愿值</th>
                <th  class="col-md-1">确定</th>
            </tr>
            </thead>
            <%-- 我写10的那里我觉得还应该增加人数 --%>
            <tbody>
            <c:forEach var="course" items="${requestScope.get('publicCourseList')}">
                <tr>

                    <td class="col-md-1">${course.getName()}</td>
                    <td class="col-md-1">${course.getTeacherName()}</td>
                    <td class="col-md-2">${course.getStuNum()}/${course.getCapacity()}</td>
                    <td class="col-md-2">${course.getHours()}</td>
                    <td class="col-md-4">${course.getDescription()}</td>

                    <form action="${pageContext.request.contextPath}/StudentController/submitASelection4" method="get">
                    <td class="col-md-1">
                            <input name="courseId" type="text" hidden value="${course.getId()}">
                            <input id="t1"  name="selectionCoins" value="0"  type="text" style="width:100%;height:20px;text-align:center">
                    </td>
                 <td class="col-md-1">
                         <%--     &lt;%&ndash; 点击确认按钮之后重新回到这个界面，但是已经提交了信息 &ndash;%&gt;
                       <a class="btn btn-default" type="submit"  onclick="tip1()"
                          href="${pageContext.request.contextPath}/StudentController/submitASelection4/${course.getId()}/
                                    ">确认选课</a> --%>
                     <input type="submit" value="提交" class="btn btn-default"  onclick="tip1()">
                   </td>
                    </form>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <ul class="pager">
            <li class="previous"><a href="#">&larr; Older</a></li>
            <li class="next"><a href="#">Newer &rarr;</a></li>
        </ul>
    </div>
</div>
</body>
</html>
