<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
</head>
<body> 
<form action="${pageContext.request.contextPath }/item/queryitem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td>
商品id
<input type="text" name="items.id"/>
</td>
<td>
商品名称
<input type="text" name="items.name"/>
</td>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>选择</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemList }" var="item">
<tr>
	<td><input type="checkbox" name="ids" value="${item.id }"/></td>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/item/itemEdit.action?id=${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
<input type="submit" value="批量删除"/>
</form>
<input type="button" value="json数据交互" onclick="sendJson()">
<script type="text/javascript">
	function sendJson() {
		$.ajax({
			url:"${pageContext.request.contextPath }/recive/json.action",
			contentType:"application/json;charset=UTF-8",
			type:"post",
			data:'{"id":1,"name":"台式机1","price":3001.0,"pic":"7f50b3aa-b311-4439-b6fd-e0c94c46ddcc.jpg","createtime":1504411751000,"detail":"该电脑质量非常好！！！！11111"}',
			success:function(data) {
				alert(data);
			}
		});
		
	}
	
</script>
</body>

</html>