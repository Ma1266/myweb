<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript"
	src="<%=path%>/lib/js/jquery-1.8.0.min.js">
</script>
<script type="text/javascript" src="<%=path%>/lib/js/jquery.form.js">
</script>

<script type="text/javascript">  
function uploadImage() {  
    $(document).ready(function() {  
                        	var options = {  
                            url : "<%=path%>/web/uploadAction!execute.do",  
                            type : "POST",  
                            dataType : "json",  
                            success : function(data) { 
                                if (data.success) {  
                                    //alert(data.obj);
                                    $("#tipDiv").html(data.msg);  
                                    $("#showImage").html("<img src='"+data.obj+"'/>");  
                                } else {  
                                    $("#tipDiv").html(data.msg);  
                                }  
                            }  
                        };  
                        $("#form2").ajaxSubmit(options);  
                        return false;  
                    });  
} </script>
</head>
<body>
	<center>
		<form id="form2" method="post" enctype="multipart/form-data">
			<table width="400" border="1" cellspacing="1" cellpadding="10">
				<tr>
					<td height="25">浏览图片：</td>
					<td><input id="file" name="file" type="file" />
						<div id="tipDiv"></div></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button"
						class="right-button02" onclick="uploadImage()" value="上传" /></td>
				</tr>
			</table>
		</form>
		<br> 图片预览 2 
		<div id="showImage"></div>
		  <s:debug></s:debug>
		
	</center>
</body>
</html>
