<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${pageContext.request.contextPath}/lib/css/style.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>


<body> 
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="${pageContext.request.contextPath}/lib/images/sun.png" alt="天气" /></span>
    <b>${sessionInfo.userName},早上好，欢迎使用信息管理系统</b>(admin@uimaker.com)
    <a href="#">帐号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="${pageContext.request.contextPath}/lib/images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：2013-10-09 15:22</i> （不是您登录的？<a href="#">请点这里</a>）
    </div>
    
    <div class="xline"></div>
    
    <ul class="iconlist">
    
    <li><img src="${pageContext.request.contextPath}/lib/images/ico01.png" /><p><a href="#">管理设置</a></p></li>
    <li><img src="${pageContext.request.contextPath}/lib/images/ico02.png" /><p><a href="#">发布文章</a></p></li>
    <li><img src="${pageContext.request.contextPath}/lib/images/ico03.png" /><p><a href="#">数据统计</a></p></li>
    <li><img src="${pageContext.request.contextPath}/lib/images/ico04.png" /><p><a href="#">文件上传</a></p></li>
    <li><img src="${pageContext.request.contextPath}/lib/images/ico05.png" /><p><a href="#">目录管理</a></p></li>
    <li><img src="${pageContext.request.contextPath}/lib/images/ico06.png" /><p><a href="#">查询</a></p></li> 
            
    </ul>
    
    <div class="ibox"><a class="ibtn"><img src="${pageContext.request.contextPath}/lib/images/iadd.png" />添加新的快捷功能</a></div>
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="${pageContext.request.contextPath}/lib/images/dp.png" alt="提醒" /></span>
    <b>Uimaker信息管理系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以快速进行文章发布管理操作</span><a class="ibtn">发布或管理文章</a></li>
    <li><span>您可以快速发布产品</span><a class="ibtn">发布或管理产品</a></li>
    <li><span>您可以进行密码修改、账户设置等操作</span><a class="ibtn">账户管理</a></li>
    </ul>
    
    <div class="xline"></div>


</body>

</html>
