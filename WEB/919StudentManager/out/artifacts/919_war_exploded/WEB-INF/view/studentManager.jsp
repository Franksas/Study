<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/9/19
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理</title>
    <link rel="stylesheet" href="../../resources/layui/css/layui.css"
          type="text/css">
    <script type="text/javascript" src="../../resources/layui/layui.js"></script>
</head>
<body>
    <button class="layui-btn" id="btnAdd">增加</button>
    <fieldset id="fsAdd" class="layui-elem-field" style="display: none">
        <legend>增加学生信息</legend>
        <div>
            <form class="layui-form">
            编号：<input id="id" type="text" placeholder="学生编号：20180919001">
            姓名：<input id="name" type="text" placeholder="姓名">
            性别：<input type="radio" name="sex" value="0" title="男" checked>
                <input type="radio" name="sex" value="1" title="女">
            <button class="layui-btn layui-bg-black" id="btnAddSave" type="button" >保存</button>
            </form>
        </div>
    </fieldset>
    <script type="text/javascript">
        var layui = layui.use(['jquery','element','form'],function () {
           var $ = layui.jquery;//引入jQuery
            var element = layui.element;
            var form = layui.form;
            //alert("#btnAdd");
           $("#btnAdd").click(function () {
              //$("#fsAdd")[0].style.display="block";
              $("#fsAdd").css("display","block");
           });
        });

    </script>
    <button class="layui-btn">删除</button>
    <button class="layui-btn">修改</button>
    <button class="layui-btn">查找</button>
    <%int x = 1; %>
    <%!int x = 10; %>
    x=<%=x%>
</body>
</html>
