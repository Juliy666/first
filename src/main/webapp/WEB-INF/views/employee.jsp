<%--
  Created by IntelliJ IDEA.
  User: 82050
  Date: 2019/6/9
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/static/common/common.jsp"%>
    <script type="text/javascript">
      var contextPath = "${pageContext.request.contextPath}";
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/employee.js"></script>
</head>
<body>
    <%--工具栏--%>
    <div id="tb">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" id="add">添加</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" id="edit">编辑</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" id="delete">删除</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" id="reload">刷新</a>
        <input type="text" name="keyword" style="width: 200px; height: 30px;padding-left: 5px;">
        <a class="easyui-linkbutton" iconCls="icon-search" id="searchbtn">查询</a>
    </div>
    <%--数据表格--%>
    <table id="dg"></table>
    <%--对话框--%>
    <div id="dialog">
        <form id="employeeForm">
            <%--添加隐藏域,用作编辑--%>
            <input type="hidden" name="id">
            <table align="center" style="border-spacing: 0px 10px">
                <tr>
                    <td>用户名:</td>
                    <td><input type="text" name="username" class="easyui-validatebox" data-options="required:true"></td>
                </tr>
                <tr id="password">
                    <td>密码:</td >
                    <td><input type="text" name="password" class="easyui-validatebox" ></td>
                </tr>
                <tr>
                    <td>手机:</td>
                    <td><input type="text" name="tel" class="easyui-validatebox" ></td>
                </tr>
                <tr>
                    <td>邮箱:</td>
                    <td><input type="text" name="email" class="easyui-validatebox" ></td>
                </tr>
                <tr>
                    <td>入职日期:</td>
                    <td><input type="text" name="inputtime" class="easyui-datebox"></td>
                </tr>
                <tr>
                    <td>部门:</td>
                    <td><input id="department" name="department.id" placeholder="请选择部门"/></td>
                </tr>
                <tr>
                    <td>是否管理员:</td>
                    <td><input id="state" name="admin" placeholder="是否为管理员"/></td>
                </tr>
                <tr>
                    <td>选择角色:</td>
                    <td><input id="role" name="role.id" placeholder="请选择角色"/></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
