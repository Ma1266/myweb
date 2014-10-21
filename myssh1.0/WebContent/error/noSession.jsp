<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/js/jquery-1.4.4.min.js" charset="utf-8"></script>
    <title>提示</title>
	<script type="text/javascript">
	 $(document).ready(function() {    
         function jump(count) {    
             window.setTimeout(function(){    
                 count--;    
                 if(count > 0) {    
                     $('#num').attr('innerHTML', count);    
                     jump(count);    
                 } else {    
                     location.href="${pageContext.request.contextPath}/index.jsp";    
                 }    
             }, 1000);    
         }    
         jump(5);    
     });    
	</script>
</head>
<body>
  <span style="color:red;font-size: 14px;font-weight: bold;" mce_style="color:red">您还没有登录或登录已超时，请重新登录，然后再刷新本功能！</span>系统将在5秒后自动跳转至登录页面。。。还剩<span id="num">5</span>秒 
</body>
</html>
