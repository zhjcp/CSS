<%--
  Created by IntelliJ IDEA.
  User: 朱华
  Date: 2020/10/14
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
      <%-- 页面缩放 --%>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--  md5工具类cdn  -->
    <script src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>
      <%-- bootstrap便捷地美化界面 cdn --%>
      <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<%--    <!-- 导入bootstrap -->
      <link  rel="stylesheet" type="text/css" href="./statics/bootstrap/css/bootstrap.min.css"/>
      <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
      <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
      <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
      <script src="./statics/bootstrap/js/bootstrap.min.js"></script>--%>

      <style>
          .cont{
              width: 100%;
              /*   [开源]渐变样式网站：https://www.grabient.com/   */
              background-color: #4158D0;
              background-image: linear-gradient(0deg, #4158D0 0%, #C850C0 30%, #FFCC70 66%, #ffffff 100%);
          }

          .labelText{
                line-height: 30px;
           }
      </style>
  </head>
  <body class="cont">
      <!--    1. 表单绑定“提交验证函数”
                  【name属性】：input标签要指定name属性才能在network部分抓包看到提交的数据
                                后端也是通过前端组件指定的name属性来获取数据的！！！

                  使用：使用onsubmit = "return f"指定提交验证函数f，f应该有布尔返回值
      -->

      <div class="container">
          <div class="col-md-12 column">
              <div class="row clearfix">
                  <div class="page-header">
                      <h1 align="center">
                          <small>选  课  系  统  登  录</small>
                      </h1>
                  </div>
              </div>
          </div>
      </div>

      <div style="height: 16%"></div>

      <div>
          <form action="${pageContext.request.contextPath}/LoginController/login" method="post" onsubmit="return checkForm()">
              <div class="container" >
                  <div class="form-group col-md-offset-4 col-sm-8">
                      <label class="col-sm-1 labelText" style="height: 30px">账号</label>
                      <div class="col-sm-4">
                          <input type="text" class="form-control" id="userName" name="id" placeholder="请输入账号" required>
                      </div>
                  </div>
                  <div class="form-group  col-md-offset-4 col-sm-8">
                      <label class="col-sm-1 labelText" style="height: 30px">密码</label>
                      <div class="col-sm-4">
                          <input type="password" class="form-control" id="userPwd"  placeholder="请输入密码" required>
                      </div>
                      <div class="col-md-3">
                          <span style="color: red;font-weight: bold">
                              <label class="labelText">${error}</label>
                          </span>
                      </div>
                  </div>


                  <div class="form-group col-md-offset-4">
                      <div class="col-sm-offset-1 col-sm-8">
                          <div class="checkbox">
                              <label>
                                  <input type="checkbox"> 记住密码
                              </label>
                              <a class="col-md-offset-2" href="#" style="color: black">忘记密码</a>
                          </div>
                      </div>
                  </div>

                  <!--  隐藏域  -->
                  <input type="hidden" id="md5-userPwd" name="pwd">
                  <div class="col-md-offset-5 col-md-2">
                      <input type="submit" class="btn btn-primary btn-block" value="登录">
                  </div>
              </div>
          </form>

        <%--
            <a href="${pageContext.request.contextPath}/WEB-INF/student/jsp/index.jsp">失败的超链接测试</a>
            <a href="${pageContext.request.contextPath}/test.jsp">成功的超链接测试</a>
            超链接本质上是重定向无法直接访问WEB-INF目录
            原因：不可以的,redirect是客户端重定向,也就是说客户端会重新发送一次请求,
                  还是会直接访问/WEB-INF/下的文件,客户端不能直接访问该目录，会被拒绝的
             注意：在服务器端，即：springmvc的控制器中，用转发和重定向都可以访问到/WEB-INF/下的目录！
          --%>
      </div>


      <script>
        function checkForm() {
          /*let userName=document.getElementById("userName");*/
          let userPwd=document.getElementById("userPwd");
          let md5_userPwd=document.getElementById("md5-userPwd");
          /*  2. MD5加密：
          *        原理：根据MD5算法，将数值进行确定的映射（算法规则可能被破译，从而逆推用户提交的数据）
          *        表现：直接把MD5的加密结果赋给自身，input框的内容（点）会在提交的一瞬间变成加密后的结果
          *             显示在屏幕上的效果就是，input框的内容改变了，这很容易让人知道这是MD5加密，所以
          *             可能导致安全问题！！！
          *             如：userPwd.value=md5(userPwd.value)
          *        安全措施：
          *             使用隐藏域，将MD5加密结果赋给隐藏域的value
          *             注意：给类型指定为隐藏域的input指定name属性，不给原来的input指定name属性
          *        结果：
           *             如：123456  --> e10adc3949ba59abbe56e057f20f883e
          * */
          md5_userPwd.value=md5(userPwd.value);//将加密结果赋给隐藏域
            console.log("===="+md5_userPwd);
          //自定义条件验证表单，返回true通过，返回false拦截,拦截后表单将无法提交
          return true;
        }
      </script>
  </body>
</html>
