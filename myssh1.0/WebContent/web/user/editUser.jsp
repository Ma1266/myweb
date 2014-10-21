<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<form id="user_editForm" method="post" style="width:400px;height:300px;">
		<table style="width:400px;height:300px;">
			<tr>
				<th>用户名:</th>
				<td><input type="hidden" name="id" />
				<input name="username" class="text"  required="true" ajaxurl="#" datatype="*6-15" errormsg="密码范围在6~15位之间！" /></td>
				<th>状态:</th>
				<td><select name="status" class="text"   
					data-options="panelHeight:'auto',editable:false"><option
							value="">-----请选择-----</option>
						<option value="1">启用</option>
						<option value="0">禁用</option></select></td>
			</tr>
			<tr>
				<th>邮箱:</th>
				<td><input name="email" class="text"  validType="email" invalidMessage="请填写正确的邮件格式" /></td>

				<th>联系电话:</th>
				<td><input name="tel" class="text" validType="mobile" invalidMessage="手机号码格式不正确"  /></td>
			</tr>
			<tr>
				<th>角色:</th>
				<td><select id="roleid" name="roleNameList" required="true" missingMessage="请选择用户角色" type="text" class="text" ></select>  
				<th>部门:</th>
				<td><select id="roleid" name="orgName" required="true" missingMessage="请选择用户角色" type="text" class="text" ></select>  

			</tr>
			<tr>
				<th>邮箱:</th>
				<td><input name="email" class="text"  validType="email" invalidMessage="请填写正确的邮件格式" /></td>

				<th>联系电话:</th>
				<td><input name="tel" class="text" validType="mobile" invalidMessage="手机号码格式不正确"  /></td>
			</tr>
		</table>
	</form>

