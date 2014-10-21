$(document).ready(function(){
		init();
});

//定义页面标识
function init(){
	var api = frameElement.api;
	var rows =api.data[1];
	var optType =api.data[0];
	if(optType=='view'){//查看页面
		$('#user_editForm').form('load',rows[0]);
		//$('form *').attr('readOnly', 'true');	
		$('form *').attr('disabled', 'true');		
	}else if(optType=='add'){
		$("#user_editForm").Validform({
			tiptype:2,
			showAllError:true
		});
	}
}