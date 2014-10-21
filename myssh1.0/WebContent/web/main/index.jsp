<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${sessionInfo==null}">
<c:redirect url="/error/noSession.jsp"/>
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>欢迎</title>
	<jsp:include page="/common.jsp"></jsp:include>
	<script type="text/javascript">
		$(function(){
			initMenu();	
		});
		function initMenu(){
			var $ma=$("#menuAccordion");
			$ma.accordion({animate:true,fit:true,border:false});
			$.post("web/menuAction!getAllMenu.do",function(rsp) {
				$.each(rsp,function(i,e){
					var menulist ="<div   class=\"well well-small\">";
					if(e.child && e.child.length>0){
						$.each(e.child,function(ci,ce){
							var url=web_name+ce.url;
							var effort=ce.name+"||"+ce.iconCls+"||"+url;
							menulist+="<a href=\"javascript:void(0);\" class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'"+ce.iconCls+"'\" onclick=\"addTab('"+effort+"');\">"+ce.name+"</a><br/>";
						});
					}
					menulist+="</div>";
					$ma.accordion('add', {
			            title: e.name,
			            content: menulist,
						border:false,
			            iconCls: e.iconCls,
			            selected: false
			        });
				});
			}, "JSON").error(function(data) {
				$.messager.alert("提示", "获取菜单出错,请重新登陆!"+data);
			});
		}
	</script>
	<style type="text/css">
	#menuAccordion a.l-btn span span.l-btn-text {
	    display: inline-block;
	    height: 34px;
	    line-height: 34px;
	    vertical-align: baseline;
	    padding-left:50px;
	    text-align:left;
	    width: 104px;
	}
	#menuAccordion 	a.l-btn span span.l-btn-icon{
	    padding-left:80px;
		vertical-align: baseline;
		
	}
	#menuAccordion .panel-body {
		padding:5px;
	}
	#menuAccordion span:focus{
		outline: none;
	}
	</style>
  </head>
 <body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:88px;overflow: hidden;"  href="${pageContext.request.contextPath}/web/layout/north.jsp"></div>
	<div data-options="region:'west',split:true,title:'功能菜单'" style="width:200px;background-color: #F0F9FD">
			<div  id="menuAccordion"></div>
	</div> 
	<div data-options="region:'south',border:false" style="height:25px;background:#3E96C9;padding:5px;border: 1px" href="${pageContext.request.contextPath}/web/layout/south.jsp"></div>
	<div data-options="region:'center',plain:true,title:'欢迎使用myssh'" style="overflow: hidden;"  href="${pageContext.request.contextPath}/web/layout/center.jsp"></div>
</body>
</html>
