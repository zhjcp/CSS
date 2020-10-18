<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/17
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <style>
        img{
            width: 100px;
            height: 100px;
            border-radius: 50px;/* 圆角边框 */
            box-shadow: yellow;/*  盒子阴影  */
        }
    </style>
</head>
<body>
        <img src="${pageContext.request.contextPath}/avators/ST000001.jpg">
        <h1>${name}   同学，你好！</h1>
</body>
</html>
