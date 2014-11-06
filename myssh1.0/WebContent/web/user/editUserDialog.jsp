<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionInfo==null}">
<c:redirect url="${pageContext.request.contextPath}/index.jsp"/>
</c:if>
<script type="text/javascript" src="user/editUserDialog.js"></script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true" title="" style="overflow: hidden;padding: 10px;">
		<form id="user_editForm" method="post" >
				 <table style="width: 100%;height: 100%;">
					 <tr>
					    <td>用户编号:</td>
						<td><input name="id" id="id"  class="text easyui-validatebox" type="text" required="required"/><em style="color: red;">*</em></td>
						<td>用户状态:</td>
						<td><select id ="status" name="status"  class="text" type="text">
						<option value="0">新建</option>						
						<option value="1">启用</option>
						<option value="2">停用</option>
						<option value="3">锁定</option>
						</select></td>
					 </tr>
					 <tr>
					    <td>用户姓名:</td>
						<td><input name="username" id="username" type="text" class="text easyui-validatebox" required="required"/><em style="color: red;">*</em></td>
						<td>用户密码:</td>
						<td><input id="password" name="password" type="password" class="text" /></td>
					 </tr>
					  <tr>
					    <td>电子邮箱:</td>
						<td><input id="email" name="email" type="text" class="text easyui-validatebox" required="required"/><em style="color: red;">*</em></td>
						<td>联系电话:</td>
						<td><input id="tel" name="tel" type="text" class="text"/></td>
					 </tr>
					 <tr>
					    <td>组织 部门:</td>
						<td><input id="organizeId" name="organizeId" type="text" class="text" /></td>
						<td>用户角色:</td>
						<td><input id="roleNameList" name="roleNameList" type="text" class="text"/></td>
					 </tr>
					  <tr>
					  	<td>创建者:</td>
						<td>
						<input id="sessionInfo" type="hidden" value="${sessionInfo.userName}"/>
						<input id="creater" name="creater" type="text" class="text"/></td>
					    <td>创建时间:</td>
						<td><input type="text" class="Wdate" id="createDate" name="createDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>		</td>
					
					 </tr>
					 <tr>
						<td>备注信息:</td>
						<td colspan="3"><textarea class="text easyui-textbox" name="remarks"  style="width: 435px;height: 60px;"></textarea></td>
					</tr>
				 </table>
		</form>
	</div>
</div>

