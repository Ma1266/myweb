<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%String contextPath = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	});
	$('#userInfo').click(function(){
		$('<div id="view"/>').dialog({
			title : '个人信息',
			width : 600,
			height :400,
			closed : false,
			cache : false,
			href : web_name+'/web/main/viewInfo.jsp',
			modal : true,
			onClose : function() {
				$(this).dialog('destroy');
			},
		});
	});
})	
</script>


</head>

<div class="top">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="${pageContext.request.contextPath}/lib/images/logo.png" title="系统首页" /></a>
    </div>      
     <ul class="nav">
    <li><a href="default.html" target="rightFrame"><img src="${pageContext.request.contextPath}/lib/images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
    <li><a href="imgtable.html" target="rightFrame"><img src="${pageContext.request.contextPath}/lib/images/icon02.png" title="模型管理" /><h2>模型管理</h2></a></li>
    <li><a href="imglist.html"  target="rightFrame"><img src="${pageContext.request.contextPath}/lib/images/icon03.png" title="模块设计" /><h2>模块设计</h2></a></li>
    <li><a href="tools.html"  target="rightFrame"><img src="${pageContext.request.contextPath}/lib/images/icon04.png" title="常用工具" /><h2>常用工具</h2></a></li>
    <li><a href="computer.html" target="rightFrame"><img src="${pageContext.request.contextPath}/lib/images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>
    <li><a href="tab.html"  target="rightFrame"><img src="${pageContext.request.contextPath}/lib/images/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li>
    </ul>
                 
    <div class="topright">    
    <ul>
    <li><span><img src="${pageContext.request.contextPath}/lib/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="<%=contextPath%>/web/loginAction!loginOff.do">退出</a></li>
    </ul>
     
    <div class="user">
    <span id="userInfo">${sessionInfo.userName}</span>
    <i>(${sessionInfo.roles})||(${sessionInfo.orgName})</i>
    <i>||&nbsp;消息</i>
    <b>5</b>
    </div>    
    
    </div>

</div>
</html>