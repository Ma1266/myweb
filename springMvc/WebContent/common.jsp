<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%String contextPath = request.getContextPath();%>
<script type="text/javascript">
	var web = web || {};
	web_name = '<%=contextPath%>';
</script>
<%-- 引入jQuery --%>
<script type="text/javascript" src="<%=contextPath%>/lib/js/jquery-1.4.2.min.js" charset="utf-8"></script>
<link  rel="stylesheet" href="<%=contextPath%>/lib/css/style.css" />

<%--引入Jbox提示插件 --%>
<link id="skin" rel="stylesheet" href="<%=contextPath%>/pulugins/jBox/Skins/Blue/jbox.css" />
<script type="text/javascript" src="<%=contextPath%>/pulugins/jBox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/pulugins/jBox/i18n/jquery.jBox-zh-CN.js"></script>
<%--validForm验证框架 --%>
<%-- <link rel="stylesheet" href="<%=contextPath%>/pulugins/validForm5.3.2/css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="<%=contextPath%>/pulugins/validForm5.3.2/js/Validform_v5.3.2_min.js"></script --%>