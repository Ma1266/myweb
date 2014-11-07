<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%String contextPath = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<jsp:include page="/common.jsp"/>
<script type="text/javascript">
$(document).ready(function(){
/* 	$("#userNam2e").focusout(function(){
		$.jBox.tip("正在校验,请稍候...", 'loading');
		$.ajax({
			   type: "POST",
			   url: web_name+"/login",
			   data:$("#loginForm").serialize(),
			   success: function(data){
				   var ressult=eval('('+data+')');
				   if(ressult.success){
					   window.setTimeout(function () {$.jBox.tip(ressult.msg, 'success');}, 2000);
				   }else{
					   window.setTimeout(function () {$.jBox.tip(ressult.msg, 'error');}, 1000);
				   }
			   },
			   error:function(data){
				   var ressult=eval('('+data+')');
				   window.setTimeout(function () {$.jBox.tip(ressult.msg, 'error');}, 2000);
			   }
			});
	}); */
	$("#loginBtn").click(function(){
		if(validateForm()){
			$.jBox.tip("正在提交,请稍候...", 'loading');
			$.ajax({
				   type: "POST",
				   url: web_name+"/login/doLogin",
				   data:$("#loginForm").serialize(),
				   success: function(data){
					   var ressult=eval('('+data+')');
					   if(ressult.success){
						   $.jBox.tip(ressult.msg, 'success');
						   $.jBox.closeTip();
						   $.jBox.tip('登录成功，系统正在跳转,请稍候...', 'loading');
						   window.location.href=web_name+"/view/index.jsp";
						   //window.setTimeout(function () {
							   //$.jBox.tip(ressult.msg, 'success');
							   //$.jBox.tip('登录成功，系统正在跳转,请稍候...', 'loading');
							//   window.location.href=web_name+"/view/index.jsp";
						  // },1000);
					   }else{
						   //$.jBox.closeTip();
						   window.setTimeout(function () {$.jBox.tip(ressult.msg, 'error');},1000);

					   }
				   },
				   //timeout: 1000, //
				   error:function(data){
					   $.jBox.closeTip();
					   var ressult=eval('('+data.responseText+')');
					   window.setTimeout(function () {$.jBox.error('调用方法发生异常:['+ressult.expMsg+'],请联系管理员!', '提示信息');}, 500);
				   }
				  /*  error: function (jqXhr, textStatus, errorThrown) {
					  window.setTimeout(function () {$.jBox.tip('调用方法发生异常,请联系管理员:'+errorThrown, 'error');}, 500);
					  alert("Error '" + jqXhr.status + "' (textStatus: '" + textStatus + "', errorThrown: '" + errorThrown + "')");
					   } */
				});
		}
	});
});

function validateForm(){
	var userName=$("#userName").val();
	var userPwd=$("#passWord").val();
	if(userName==null||userName==''){
		 $.jBox.tip('请填写用户名!', 'error');
		 return false;
	}else if(userPwd == null || userPwd == ''){
		 $.jBox.tip('请填写密码!', 'error');
		 return false;
	}
	return true;
};
function loadding(stype,msg,info,timeout){
	if(stype=='tip'){
		window.setTimeout(function () {$.jBox.tip(msg,info);}, timeout);
	}else if(stype=='info'){
		
	}
}
</script>
</head>
<body>
<div class="login_main">
<form id="loginForm" action="" method="post">
<table cellpadding="0" cellspacing="0" style="border: dotted;width: 100%;height:200px;">
<tr> <td>用户名:<input name="loginName" type="text" id="userName"/></td>
</tr>
<tr><td>密  &nbsp;码:<input name="passWord" type="password" id="passWord"/></td>
</tr>
<tr><td><input id="loginBtn" type="button" value="登录" /></td></tr>
</table>
</form>
</div>
</body>
</html>