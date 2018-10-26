<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page import="com.youma.vo.Drug" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/26
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/drugAdd" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>
                药品id
            </td>
            <td>
                <input name="drugID" type="text" title="药品id"/>
            </td>
        </tr>
        <tr>
            <td>
                药品名称
            </td>
            <td>
                <input name="drugName" type="text" title="药品名称"/>
            </td>
        </tr>
        <tr>
            <td>
                药品描述
            </td>
            <td>
                <textarea name="description" title="药品描述"></textarea>
            </td>
        </tr>
        <tr>
            <td>
                药品图片
            </td>
            <td>
                <input type="file" name="url"/>
            </td>
        </tr>
    </table>
    <button type="submit" title="提交">保存</button>
</form>
</body>
</html>
