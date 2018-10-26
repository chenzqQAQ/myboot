<%--<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/26
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>

<html>
<head>
    <title>药品查询</title>
    <script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
    <script type="text/javascript">
        console.log("aaaa");
        $(function () {
            console.log("jQuery is ok");

        })

        function bb() {
            $.ajax({
                url: "<%=path%>/ajax",
                type: "get",
                success: function (msg) {
                    console.log(msg);
                    var k = eval(msg);
                    $('p:first').text(k['a']);
                    $('p:last').text(k['b']);
                }
            })
        }

        //分页函数声明
        function totalPage() {
            $("#pageNo").val(1);
            $("#form1").attr("action", "<%=path%>/drugList").submit();
            return false;
        }

        function up() {
            var p = $("#pageNo");
            var k = parseInt(p.val());
            p.val(k > 1 ? k - 1 : 1);
            $("#form1").attr("action", "<%=path%>/drugList").submit();
            return false;
        }

        function down() {
            var p = $("#pageNo");
            var k = parseInt(p.val());
            var k1 = parseInt($("#totalPage").val());
            p.val(k < k1 ? k + 1 : k1);
            $("#form1").attr("action", "<%=path%>/drugList").submit();
            return false;
        }

        function lastPage() {
            $("#pageNo").val($("#totalPage").val());
            $("#form1").attr("action", "<%=path%>/drugList").submit();
            return false;
        }
    </script>
</head>
<body>
<form id="form1" method="post">
    药品id<input name="drugID" type="text" title="药品id" value="${drug.drugID}"/><br/>
    药品名字<input name="drugName" type="text" title="药品名字" value="${drug.drugName}"/><br/>
    <button type="submit">点我啊</button>
    <a href="#" onclick="bb();return false">异步</a>
</form>
<table>
    <tr>
        <td>
            药品id
        </td>
        <td>
            药品名称
        </td>
        <td>
            药品描述
        </td>
        <td>
            操作
        </td>
    </tr>
    <c:forEach items="${drugs}" var="drug">
        <tr>
            <td>
                    ${drug.drugID}
            </td>
            <td>
                    ${drug.drugName}
            </td>
            <td>
                    ${drug.description}
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/drugFind?drugID=${drug.drugID}">修改</a>
                <a href="${pageContext.request.contextPath}/drugDel?drugID=${drug.drugID}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/toDrugAdd">添加药品</a><br/>

<input type="hidden" form="form1" value="${page.pageNo}" id="pageNo" name="pageNo">
<input type="hidden" form="form1" value="${page.totalPage}" id="totalPage" name="totalPage" disabled>
<a href='#' onclick="totalPage();return false">第一页</a>
<a href='#' onclick="up();return false">上一页</a>
<span class='current'>${page.pageNo}</span>
<a href='#' onclick="down();return false">下一页</a>
<a href='#' onclick="lastPage();return false">最后一页</a>
${page.totalCount} 条记录 ${page.pageNo} /${page.totalPage} 页
<div>
    <p></p>
    <p></p>
</div>
</body>
</html>
