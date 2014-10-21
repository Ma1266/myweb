<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String contextPath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<%-- 引入jQuery --%>
<script type="text/javascript" src="<%=contextPath%>/lib/js/jquery-1.8.0.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=contextPath%>/plugins/jquery_easyui_1.4/jquery.easyui.min.js" charset="utf-8"></script>
<!-- 引入Validform验证插件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/Validform5.3/js/Validform_v5.3.2_min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/Validform5.3/css/style.css" type="text/css" media="all" />

<script type="text/javascript" src="editUserDialog.js"></script>
<style>
*{font-size:9pt;border:0;margin:0;padding:0;}
body{font-family:'微软雅黑'; margin:0 auto;}
/*input textarea*/
.text,textarea{font-size:12px;font-weight:bolder;color:#333;border:1px solid;border-color:#CECECF;border-radius:0;background:white;box-shadow:inset 1px 1px 2px rgba(0, 0, 0, 0.1);-webkit-appearance:none;}
.text:focus,textarea:focus{outline:none;border-color:#92AFED;box-shadow:0 0 5px #92AFEC,inset 1px 1px 2px rgba(0, 0, 0, 0.1);}
.text{width:180px;height:30px;padding:7px 9px;line-height:30px;}
input.err,input.err:focus{color:#900;border-color:#E06341;background:#FFEFEC;box-shadow:0 0 5px #E06341;}
table{
 margin-left: auto;
 margin-right: auto;
 width:100%;
 height: 100%;
}
</style>
<form id="user_editForm" method="post">
	<div >
		<table>
			<tr>
				<th>用户名:</th>
				<td><input type="hidden" name="id" /><input name="username" class="text"  datatype="*6-15" errormsg="密码范围在6~15位之间！"/></td>
				<td><div class="Validform_checktip"></div></td>
			<tr>
				<th>邮箱:</th>
				<td><input name="email" class="text"  datatype="*6-15" errormsg="密码范围在6~15位之间！" /></td>
				<td><div class="Validform_checktip"></div></td>
			</tr>
			<tr>
				<th>角色:</th>
				<td><select id="roleList" name="roleList" required="true" missingMessage="请选择用户角色" type="text" class="text" ></select>  
				<th>部门:</th>
				<td><select id="orgName" name="orgName" required="true" missingMessage="请选择用户角色" type="text" class="text" ></select>  

			</tr>
			<tr>
				<th>邮箱:</th>
				<td><input name="email" class="text"  validType="email" invalidMessage="请填写正确的邮件格式" /><div class="Validform_checktip"></div></td>

				<th>联系电话:</th>
				<td><input name="tel" class="text" validType="mobile" invalidMessage="手机号码格式不正确"  /><div class="Validform_checktip"></div></td>
			</tr>
				<tr>
				<th>邮箱:</th>
				<td><input name="email" class="text"   validType="email" invalidMessage="请填写正确的邮件格式" /></td>

				<th>联系电话:</th>
				<td><input name="tel" class="text" validType="mobile" invalidMessage="手机号码格式不正确"  /></td>
			</tr>
				<tr>
				<th>邮箱:</th>
				<td><input name="email" class="text"  validType="email" invalidMessage="请填写正确的邮件格式" /></td>

				<th>联系电话:</th>
				<td><input name="tel" class="text" validType="mobile" invalidMessage="手机号码格式不正确"  /></td>
			</tr>
		</table>
	</div>
		
</form>

