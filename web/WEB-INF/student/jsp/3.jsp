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
    .col-md-1{
        text-align: center;

    }
    td.col-md-1{
        color:green;
    }
    tr,table{
        border: 1px solid black;
    }
    table{
        width: 60%;
        float: left;
        background-color:pink;
    }


</style>
<body>
<div class="container" style="width: 100%">


    <div style="margin-top: 80px">
        <table class="table ">
            <thead>
            <tr >
                <th  class="col-md-1">星期一</th>
                <th  class="col-md-1">星期二</th>
                <th  class="col-md-1">星期三</th>
                <th  class="col-md-1">星期四</th>
                <th  class="col-md-1" >星期五</th>
                <th  class="col-md-1">星期六</th>
                <th  class="col-md-1">星期天</th>

            </tr>
            </thead>
            <tbody>

            <tr>
                <td class="col-md-1">语文</td>
                <td class="col-md-1"></td>
                <td class="col-md-1">语文</td>
                <td class="col-md-1"></td>
                <td class="col-md-1">语文</td>
                <td class="col-md-1"></td>
                <td class="col-md-1"></td>
            </tr>

            <tr>
                <td class="col-md-1">数学</td>
                <td class="col-md-1">数学</td>
                <td class="col-md-1"></td>
                <td class="col-md-1">数学</td>
                <td class="col-md-1"></td>
                <td class="col-md-1"></td>
                <td class="col-md-1"></td>
            </tr>
            <tr>
                <td class="col-md-1"></td>
                <td class="col-md-1"></td>
                <td class="col-md-1">英语</td>
                <td class="col-md-1"></td>
                <td class="col-md-1">英语</td>
                <td class="col-md-1">英语</td>
                <td class="col-md-1"></td>
            </tr>
            <tr>
                <td class="col-md-1"></td>
                <td class="col-md-1"></td>
                <td class="col-md-1"></td>
                <td class="col-md-1">体育</td>
                <td class="col-md-1"></td>
                <td class="col-md-1">体育</td>
                <td class="col-md-1"></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
