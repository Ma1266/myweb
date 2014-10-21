<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<%
	String contextPath = request.getContextPath();
%>
<style>

.userInfo{width:100%;height:100%;border:1px white solid;background: #F0F0F0}
.userInfo td{ border:1px dotted #cccccc;height: 30px;text-align: center;}
</style>
<table  class="userInfo" >
  <tr>
    <td >用户名:</td>
    <td style="width: 350px;">${sessionInfo.username}</td>
    <td rowspan="3"><img alt="454545" src="<%=basePath%>/${sessionInfo.image}">	</td>
  </tr>
  <tr>
    <td>角色:</td>
    <td>${sessionInfo.roles}</td>
  </tr>
  <tr>
    <td>所在部门:</td>
    <td>${sessionInfo.orgName}</td>
  </tr>
  <tr>
    <td>电话号码:</td>
    <td colspan="2">${sessionInfo.phone}</td>
  </tr>
  <tr>
    <td>邮箱:</td>
    <td colspan="2">${sessionInfo.email}</td>
  </tr>
   <tr>
    <td>状态:</td>
    <td colspan="2"><c:if test="${sessionInfo.status==1}">
			<c:out value="启用"></c:out>
			</c:if>
			<c:if test="${sessionInfo.status==0}">
			<c:out value="禁用"></c:out>
			</c:if></td>
  </tr>
   <tr>
    <td>创建时间:</td>
    <td colspan="2">${sessionInfo.createDate}</td>    
  </tr>
</table>
