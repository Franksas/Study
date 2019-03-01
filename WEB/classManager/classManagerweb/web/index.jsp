<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/10/8
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link href="resources/layui/css/layui.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="resources/layui/layui.js"></script>
</head>
<body>
<script type="text/javascript">
    var layui = layui.use(['layer'],function(){
        var layer = layui.layer;
        layer.msg("hello idea");
    });
</script>
</body>
</html>