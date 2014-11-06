<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="${pageContext.request.contextPath}/lib/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/lib/css/mymask.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/lib/js/jquery-1.9.1.min.js"></script>
<script language="JavaScript" src="${pageContext.request.contextPath}/plugins/lhgdialog/lhgdialog/lhgdialog.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/js/cloud.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/lib/js/mask.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/web/login/login.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/WEB_APP.js" charset="utf-8"></script>

</head>
<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/lib/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
   <form action="" id="loginForm" method="post">
		<div class="loginbody">
			<span class="systemlogo"></span>
			<div class="loginbox">
				<ul>
					<li><input id="userName" type="text" class="loginuser" placeholder="请输入用户名"  onchange="cleanPwd();" nullmsg="用户名不能为空"/><em style="color: red;">*</em>
					</li>
					<li><input id="passWord" type="password" class="loginpwd" placeholder="请输入密码" nullmsg="密码不能为空"/><em style="color: red;">*</em>
					</li>
					<li><input id="login_btn" type="button" class="loginbtn"
						value="登录" /><label> <input id="pwd" type="checkbox"
							value="" checked="checked" />记住密码</label><label><a onclick="loadRePwdDialog();">忘记密码？</a>
					</label>
					</li>
					<li><div style="color: red;" id="msg"></div>
					</li>
				</ul>
			</div>
		</div>		
	</form>    
		<div class="loginbm">版权所有  2013  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途</div>
</body>

</html>
