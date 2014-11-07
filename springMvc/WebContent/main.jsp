<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>人才招聘求职网-前程无忧 | 51job 个人服务中心</title>
<meta name="description" content="前程无忧为企业提供人才招聘、猎头、培训、测评和人事外包在内的全方位的人力资源服务，帮助个人求职者与企业搭建最佳的人才招募和人才培养渠道。">
<meta name="keywords" content="人才，招聘，简历，工作，面试，薪酬，跳槽，猎头，培训，测评，人事">
<meta name="robots" content="all">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<link href="http://js.51jobcdn.com/in/css/login.css?20140825" rel="stylesheet" type="text/css">
<link href="http://js.51jobcdn.com/in/css/mobile_code/phone_signUp.css" rel="stylesheet" type="text/css">

<script language="javascript" src="http://js.51jobcdn.com/in/js/2009/jQuery.js"></script>
<script language="javascript" src="http://js.51jobcdn.com/in/js/2009/JsBase.js?20141020"></script>
<script language="javascript" src="http://js.51jobcdn.com/in/js/2009/chkSignIn.js?20130318"></script>
<script language="javascript" src="http://js.51jobcdn.com/in/js/2009/login.js?20141020"></script>
</head>
<body bgcolor="#FFFFFF">
	<div id="zptx_msg" style="width:1004px;height:31px;padding:0px;margin:0px;background:url(http://img01.51jobcdn.com/im/2009/newlogin/zptxbg.jpg) no-repeat;position:relative;">
		<div style="padding:8px 0px 0px 10px;margin:0px;font-size:12px;color:#e95c02;">
		最近有不法分子冒充前程无忧，让用户提供账户和密码。在此申明，我们绝不会通过电话、邮件或短信等形式，询问用户名和密码。请用户提高警惕，增加自我保护意识。</div>
		<div style="position:relative;left:980px;top:-15px;width:16px;">
			<img src="http://img01.51jobcdn.com/im/2009/newlogin/close_zptx.jpg" style="cursor:pointer;" onclick="closeZptx('zptx_msg',this,'http://my.51job.com','979644b990a9393b41ca0fcef7b7c778','1415264976');">
		</div>
	</div>
<div class="head">
   <div class="left">
			<a href="http://www.51job.com/default.php"><img src="http://img01.51jobcdn.com/im/2009/newlogin/login_img1.gif" border="0" align="left"></a> 
		<img src="http://img01.51jobcdn.com/im/2009/newlogin/login_img2.gif" align="right"></div>
   <div class="right">
       	   <div class="menu"><a href="http://www.51job.com/default.php">首页</a> | <a href="http://www.51job.com/hl/grjl.php">帮助</a></div>
	      </div>
</div>

<div class="menu">
   <div class="left"><img src="http://img01.51jobcdn.com/im/2009/newlogin/login_img8.gif"></div>
  <div class="mid">
	      <div class="menu">
	      <ul>
	      		      	
		      <li><a href="http://my.51job.com/my/My_SignUp.php"><img border="0" src="http://img01.51jobcdn.com/im/2009/newlogin/login_img12.gif"></a></li>
			  <li><a href="http://my.51job.com/my/My_SignIn.php"><img border="0" src="http://img01.51jobcdn.com/im/2009/newlogin/login_img11.gif"></a></li>
			  		  </ul>
     </div>
	   </div>
   <div class="right"><img src="http://img01.51jobcdn.com/im/2009/newlogin/login_img9.gif"></div>
</div>

<div class="content">
<div class="login_box">
		<div class="content">
			<ul>
								<form action="https://mylogin.51job.com/21999393389645467896/my/My_Pmc.php" method="post" name="signin" id="signin" onsubmit="javascript:return chkSignIn('CN', 'https://mylogin.51job.com');" style="display:inline">
										<li class="inputlist"><span style="float:left;padding-top:8px;">登录名：</span>
						<div class="textboxs">
							<input name="username" type="text" id="username" value="邮箱/用户名/手机号" class="textbox" style="color: rgb(153, 153, 153);">
						</div>
					</li>
					<li class="inputlist"><span style="float:left;padding-top:8px;">密&nbsp;&nbsp;码：</span><div class="textboxs"><input name="userpwd" type="password" id="userpwd" value="" class="textbox"></div></li>

					<li class="inputlist" style="display:none">
						<span style="float:left;padding-top:8px;">验证码：</span>
						<div class="textboxs textboxsY">
							<input id="login_verify" name="login_verify" class="textbox textboxY" value="" type="text" maxlength="4" style="text-align:center;color:black;">
							<input type="hidden" id="isNeedVerify" value="0">
						</div>
						<img class="verifyPicChangeClick" id="verifyPic_img" align="absmiddle" src="http://my.51job.com/my/passport_verify.php?type=3&amp;from_domain=my.51job.com" style="cursor: pointer; margin-left: 5px; width: 60px; height: 31px;">
						<a class="verifyPicChangeClick" href="javascript:void(0);" style="font-size:12px; color:#999">换一张</a>
					</li>

					<li class="padding_distance" style="padding-top:0px; margin-top:0px"><input name="autologin" type="checkbox" id="autologin" value="1">&nbsp;自动登录<input name="url" type="hidden" id="url" value=""></li>
					<li class="padding_distance" style="padding-top:0px; margin-top:2px"><a href="javascript:;"><input type="image" src="http://img01.51jobcdn.com/im/2009/newlogin/login_img13.gif"></a> <a href="http://my.51job.com/my/My_ForgetEmail.php">忘记密码？</a></li>
					<li class="padding_distance2">&nbsp;还不是会员？&nbsp;<a href="http://my.51job.com/my/My_SignUp.php">免费注册</a></li></form>
			</ul>
		</div>
		<div class="tips">
		    <ul>
			    <li><img src="http://img01.51jobcdn.com/im/2009/newlogin/login_img7.gif"> 温馨提示：<br>用人单位招聘人才，以任何名义向应聘者收取费用都是不被法律允许的，请应聘者提高警惕！<br>
求职者要时刻睁大眼睛，谨防招聘骗局！<a target="_blank" href="http://my.51job.com/careerpost/pianju/default.htm">查看详情</a></li>
				<li></li>
			</ul>
		</div>
  </div><div style="float:left;"><img src="http://img01.51jobcdn.com/im/2009/newlogin/login_show.gif" width="700" height="398"></div>
	<div style="clear:both;"></div>
</div><!--content-->
<div class="foot">
  <ul>
     <li>
     	<a href="http://www.51job.com/bo/sitemap.php">网站导航</a> | 
     	<a href="http://www.51job.com/bo/service.php">服务声明</a> | 
     	<a href="http://www.51job.com/bo/contact.php">联络我们</a> | 
     	<a href="http://www.51job.com/bo/AboutUs.php">关于我们</a> | 
     	<a href="http://www.51job.com/bo/media/media.php">媒体报道</a> | 
     	<a href="http://www.51job.com/vip/index.php">加入无忧</a> | 
     	<a href="http://www.51job.com/hl/grjl.php">帮助</a> | 
     	<a href="http://ir.51job.com/ir/IRMain.php">Investor Relations</a> | 
     	<a href="http://www.51job.com/link.php">合作伙伴</a> 
     </li> 
	 <li>无忧工作网版权所有©1999-2014</li></ul>
</div>




<!--
</body></html>
-->


</body></html>