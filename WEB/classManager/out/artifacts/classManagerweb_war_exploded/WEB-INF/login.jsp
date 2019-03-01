<%--
  Created by IntelliJ IDEA.
  User: yinhansong
  Date: 2018/10/8
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级管理</title>
    <link rel="stylesheet" href="../../resources/layui/css/layui.css"
          type="text/css">
    <script type="text/javascript" src="../../resources/layui/layui.js"></script>
</head>
<body>
    身份:<select name="role" >
        <option value="010">学生</option>
        <option value="021">教师</option>
        <option value="031">管理人员</option>
        </select>
    学号:<input type="text" id="id" placeholder="学号:152085100">
    姓名:<input type="text" id="username">
    密码:<input type="password" id="password">
    <button class="layui-btn" id="btnlogin">登录</button>
    <button class="layui-btn" id="btnforgetthepassword">忘记密码</button>

</body>
</html>
