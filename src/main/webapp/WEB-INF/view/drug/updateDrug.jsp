<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/26
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/drugUpdate" method="post">
    <table>
        <tr>
            <td>
                药品id
            </td>
            <td>
                <input name="drugID" type="text" title="药品id" value="${drug.drugID}" readonly/>
            </td>
        </tr>
        <tr>
            <td>
                药品名称
            </td>
            <td>
                <input name="drugName" type="text" title="药品名称" value="${drug.drugName}"/>
            </td>
        </tr>
        <tr>
            <td>
                药品描述
            </td>
            <td>
                <textarea name="description" title="药品描述">${drug.description}</textarea>
            </td>
        </tr>
        <tr>
            <td>
                药品图片
            </td>
            <td>
                <img name="url" title="药品描述" src="${pageContext.request.contextPath}/${drug.drugUrl}" alt="图片找不到">
            </td>
        </tr>
    </table>
    <button type="submit" title="提交">保存</button>
</form>
</body>
</html>
