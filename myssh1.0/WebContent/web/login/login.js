$(document).ready(function(){
	/*重置登录框位置 使其居中显示*/
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    });
	//点击登录
	$('#login_btn').click(function(e) {
		$('#msg').html('');//每次点击登录时清除错误信息提示
		submit();
	});
	//回车登录
	$(document).keydown(function(e){
		if(e.keyCode == 13) {
			submit();
		}
	});
});

//提交表单
function submit(){
	var submit=true;
	$("input[nullmsg]").each(function(e){
		if (($("#"+ this.id+"").val()=="")) {
			show_errMsg($("#"+ this.id+"").attr("nullmsg"));
			submit=false;
			return false;
		}
	});
	if(submit){
		myMask.load.FullScreenShow('数据核实中,请稍候...');
		doLogin();
	}
};
//登录
function doLogin(){
	$.ajax({
		type : "POST",
		url : web_app.name+"/web/loginAction!login.do",
		data : {
			'username' : $("#userName").val(),
			'password' : $("#passWord").val()
		},//$('#loginForm').serialize(),
		dataType : 'json',
		success : function(data) {
				setTimeout("myMask.load.FullScreenHide()", 500);
			if (data.success) {
				setTimeout("show_errMsg('" + data.msg + "')",500);
				setTimeout("window.location.href='"+web_app.name+"/web/main/index.jsp'",1000);
			} else {
				setTimeout("show_errMsg('" + data.msg + "')",500);
			}
		},
		error : function(data) {
			setTimeout("myMask.load.FullScreenHide()", 500);
			setTimeout("show_errMsg('" + data.msg + "')", 500);
		}
	});
	return false; // 阻止表单自动提交事件 */
};
/*显示提示信息*/
function show_errMsg(msg) {
	var tip = '提示:';
	$("#msg").html(tip + msg);
}
/*用户名输入框改变，清空密码和提示信息*/
function cleanPwd() {
	$('#passWord').val("");
	$('#msg').html('');
}
//加载获取密码框
function loadRePwdDialog(){
	$.dialog(
	{
		content: '帐号：<input type="text" class="text" value="guest" style="margin:5px 0;" /><br />'
	             + '密码：<input id="login-pw" class="text" type="text" value="****" />',
	    lock:true,
	    fixed:true,
	    height:100,
	    width:300,
	    ok:function(){
	             var pw = document.getElementById('login-pw');
	             pw.select();
	             pw.focus();
	             return false;
	         },
	    title:'找回密码',
	    okVal:'登录',
	             cancel:function(){
	             }
	});
};
