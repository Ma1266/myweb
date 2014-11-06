$(document).ready(function(){
		init();
	
});

//定义页面标识
function init(){
	var addDilog=$("div[id='add']");
	var editDilog=$("div[id='edit']");
	if(addDilog){
		$("input[name='id']").val('系统自动生成');
		$("input[name='id']").attr('disabled', 'true');
		$("input[name='creater']").val(GetSession());
		$("input[name='creater']").attr('disabled', 'true');
		$("input[name='createDate']").val(getNowDateTime());
		$("input[name='createDate']").attr('disabled', 'true');

		$("#roleNameList").click(function(){			
			 $('#roleNameList').combobox({
		          url:web_app.name+'/web/roleAction!getAllRoleList.do',
		          editable:false,
		          valueField:'id',
		          textField:'name',
		      });
			
		});
		
	}
}
function GetSession() {
    var val =$("#sessionInfo").val();
    return val;
}
function getNowDateTime(){
	var myDate = new Date();
	var date = myDate.toLocaleDateString();
	var hours = myDate.getHours();
	var minutes = myDate.getMinutes();
	var seconds = myDate.getSeconds();
	var str=date;//+" "+hours+":"+minutes+":"+seconds;
	return str;
}