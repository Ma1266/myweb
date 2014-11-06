<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%String contextPath = request.getContextPath();%>
<script type="text/javascript">
	var web = web || {};
	web_name = '<%=contextPath%>';
</script>
<%-- 引入jQuery --%>
<script type="text/javascript" src="<%=contextPath%>/lib/js/jquery-1.9.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=contextPath%>/lib/js/jqueryTools.js" charset="utf-8"></script>

	<%-- 引入my97日期时间控件 --%>
<script src="<%=contextPath%>/plugins/My97DatePicker/WdatePicker.js"></script>
<%-- 引入EasyUI --%>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/plugins/jquery_easyui_1.4/themes/default/easyui.css">
<link rel="stylesheet" href="<%=contextPath%>/plugins/jquery_easyui_1.4/themes/icon.css" type="text/css">
<script type="text/javascript" src="<%=contextPath%>/plugins/jquery_easyui_1.4/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=contextPath%>/plugins/jquery_easyui_1.4/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<link href="${pageContext.request.contextPath}/lib/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/WEB_APP.js" charset="utf-8"></script>
<%-- <script language="JavaScript" src="${pageContext.request.contextPath}/plugins/lhgdialog/lhgdialog/lhgdialog.min.js"></script>
 --%>
