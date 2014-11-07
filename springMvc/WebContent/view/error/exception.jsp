<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/common.jsp"/>
<script type="text/javascript">
$(document).ready(function(){
	var msg=$("#expMsg").val();
	//alert(msg);
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div style="font-family: fantasy;font-size: 12px;width:60%;height: 60px;"><img alt="" src="../lib/images/error.jpg">系统发生${expMsg}</div>
<input id="expMsg" value="${expMsg}" type="hidden"/>
</body>
</html>