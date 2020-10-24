<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/18
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
        <h1>${sessionScope.name}  欢迎你，校级管理员！</h1>
        <h1>
            实时在线的用户数：
            <span style="color: red">
                <%--<%=session.getServletContext().getAttribute("onlineCount")%>--%>
                ${pageContext.request.session.servletContext.getAttribute("onlineCount")-1}
            </span>
        </h1>
</body>
</html>
