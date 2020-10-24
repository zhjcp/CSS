<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/19
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%=session.getServletContext().getAttribute("onlineCount")%>
        ${pageContext.request.contextPath}
</body>
</html>
