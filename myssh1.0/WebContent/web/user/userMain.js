$(document).ready(function(){
	initUserInfoGataGrid();
});
/*初始化用户信息表格*/
function initUserInfoGataGrid(){
	$('#admin_yhgl_datagrid').datagrid({
		url : web_app.name+'/web/userAction!findByPage.do',
		fit : true,
		fitColumns : true,
		border : true,
		pagination : true,
		idField : 'id',
		pageSize : 15,
		pageList : [ 15, 30, 45, 60 ],
		sortName : 'id',
		sortOrder : 'desc',
		checkOnSelect : false,
		selectOnCheck : false,
		columns : [ [ {field : 'id',title : '用户编号',width : 150, checkbox : true},
		              {field : 'username',title : '用户名称',width : 150,sortable : true},
		              {field : 'orgName',title : '组织部门',sortable : true,width : 150}, 
					  {field : 'email',title : '电子邮箱',width : 150,sortable : true}, 
					  {field : 'tel',title : '联系电话',width : 150,sortable : true}, 
					  {field : 'roleNameList',title : '角色名称',width : 150,sortable : true},
					  {field : 'status',title : '用户状态',width : 150,formatter : function(value, row, index) {
														if (value == '0') {
															return '禁用';
														} else {
															return '启用';
														}},
														styler : function(value, row, index) {
														if (value == '0') {
															return 'color:red';
														} else {
															return 'color:green';
														}},sortable : true},
					  {field : 'creater',title : '创建者',width : 150,sortable : true}, 
					  {field : 'createDate',title : '创建时间',width : 250,sortable : true}			
				  ] ],
														
					toolbar : [ {
						text : '查看',
						iconCls : 'icon-view',
						handler : function() {
							goViewPage();
						}
					}, '-', {
						text : '增加',
						iconCls : 'icon-add',
						handler : function() {
							goAddPage();
						}
					}, '-', {
						text : '删除',
						iconCls : 'icon-remove',
						handler : function() {
							doDelete();
						}
					}, '-', {
						text : '修改',
						iconCls : 'icon-edit',
						handler : function() {
							editUser();
						}
					}, '-', {
						text : '导出excel',
						iconCls : 'icon-edit',
						handler : function() {
							ExporterExcel();
						}
					}, '-' ],
	onDblClickCell:function(index){
		$("#admin_yhgl_datagrid").datagrid('uncheckAll');
		$("#admin_yhgl_datagrid").datagrid('checkRow',index);
		goViewPage();
	},

	onLoadError:function(data){
		$.messager.alert('提示:','查询出错,请联系管理员!');  	
		}
	});
};
//查询
//条件过滤 查询
function doQuery() {
	$('#admin_yhgl_datagrid').datagrid('load',serializeObject($('#admin_yhgl_searchForm')));
}
//重置
function reSet() {
	$('#admin_yhgl_searchForm input').val('');//清空表单数据
	$('#admin_yhgl_datagrid').datagrid('reload', {});//重新加载数据表格
}
//用户信息查看
function goViewPage(){
	var rows = $('#admin_yhgl_datagrid').datagrid('getChecked');
	if (rows.length == 1) {
		$('<div id="view"/>').dialog({
			title : '查看用户',
			width : 550,
			height : 300,
			closed : false,
			cache : false,
			href :web_app.name+'/web/user/editUserDialog.jsp',
			modal : true,
			onClose : function() {
				$(this).dialog('destroy');
				//$("#admin_yhgl_datagrid").datagrid('uncheckRow');
				$('#admin_yhgl_datagrid').datagrid('clearChecked');//清空所选的行
				$('#admin_yhgl_datagrid').datagrid('reload', {});
			},
			onLoad : function() {
				$('#user_editForm').form('load', rows[0]);
				$('#user_editForm *').attr('disabled', 'true');	
			},
		});
	} else {
		$.messager.show({
			title : '系统提示',
			msg : '请选择一条数据！'
		});
	}
}
//动态加载编辑
function goAddPage() {
	$('<div id="add"/>').dialog({
		title : '新增用户',
		width : 550,
		height : 350,
		closed : false,
		cache : false,
		href :'user/editUserDialog.jsp',
		modal : true,
		buttons : [ {
			text : '保存',
			iconCls : 'icon-ok',
			handler : function() {
				if(validateForm('user_editForm')){
					addUser();	
				}else{
					$.messager.alert('提示:','<strong style="color: red;">*</strong>必填字段不能为空!','warning');  	
				}
			}
		}, {
			text : '关闭',
			handler : function() {
				$('#add').dialog('close');
			}
		} ],
		onClose : function() {
			$(this).dialog('destroy');
		}

	});
}
//新增用户
function addUser(){
	$.ajax({
        type: "post",
        url: web_app.name+'/web/userAction!addUser.ajax',
        data:$('#user_editForm').serialize(),
        dataType: "json",
        success: function(data){
        	if (data.success) {
				//alert(obj);
				//console.info(obj);
				//alert(obj.msg);
				$('#admin_yhgl_datagrid').datagrid('load');
				//	$('#admin_yhgl_datagrid').datagrid('appendRow',obj.obj);
				//	$('#admin_yhgl_datagrid').datagrid('insertRow',{
				//	index:0,
				//	row:obj.obj
				//});
			}
			$.messager.show({
				title : '提示',
				msg : data.msg
			});
                 },
        error:function(data){
        	$.messager.alert('提示:','添加失败:'+data.msg,'error'); 
        	/*$.messager.show({
   			 title : '系统提示',
   			 msg : '添加失败'+data.msg
   		});*/
            }         
    });
	/*$('#user_editForm').form('submit', {
		url : web_app.name+'/web/userAction!addUser.ajax',
		 onSubmit:function(){
			 alert($(this));
		     return $(this).form('validate');
		  },
		success : function(r) {
			var obj = jQuery.parseJSON(r);
			if (obj.success) {
				//alert(obj);
				//console.info(obj);
				//alert(obj.msg);
				$('#admin_yhgl_datagrid').datagrid('load');
				//	$('#admin_yhgl_datagrid').datagrid('appendRow',obj.obj);
				//	$('#admin_yhgl_datagrid').datagrid('insertRow',{
				//	index:0,
				//	row:obj.obj
				//});
			}
			$.messager.show({
				title : '提示',
				msg : obj.msg
			});
		
		},
		error:function(data){
        	$.messager.show({
   			 title : '系统提示',
   			 msg : '添加失败'+data.msg
   		});
            }
	});*/
}
function validateForm(formId){
	return $('#'+formId).form('validate');
}
//删除
function doDelete(){
    var rows = $('#admin_yhgl_datagrid').datagrid('getChecked');
    //alert(rows.length);
	var ids = [];
    if(rows.length>0){
    	//$.dialog.confirm('你确定要删除吗？', function(row){
    	//	alert(row);
    	//});
    	/*$.dialog.tips('数据删除中,请稍候...',10000,'loading.gif');
    		$.dialog.tips('数据删除成功',10000000,'success.gif',function(){
    			  
    		});
    	}, function(){
    	    $.dialog.tips('执行取消操作');
    	});*/
		$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
			if (r) {
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].id);
				}
				$.ajax({
					url :web_app.name+'/web/userAction!delete.do',
					data : {
						ids : ids.join(',')
					},
					dataType : 'json',
					success : function(r) {
						$('#admin_yhgl_datagrid').datagrid('load');
						$('#admin_yhgl_datagrid').datagrid('uncheckAll');
						//$.dialog.tips(r.msg,0.5,'success.gif');
						$.messager.show({
							title : '提示',
							msg : r.msg
						});
					}
				});
			}
		});
    }else{
    	$.messager.show({
			title : '系统提示',
			msg : '请选择要删除的数据！'
		});
    }
}
function editUser() {
	/*var rows = $('#admin_yhgl_datagrid').datagrid('getChecked');
	if (rows.length == 1) {

		$('<div id="edit"/>').dialog({
			title : '编辑用户',
			width : 550,
			height : 300,
			closed : false,
			cache : false,
			href : web_app.name+'/web/user/editUserDialog.jsp',
			modal : true,
			buttons : [ {
				text : '更新',
				iconCls : 'icon-edit',
				handler : function() {
					$('#user_editForm').form('submit', {
						//onSubmit : function() {
							//表单验证
							//return $("#user_editForm").form('validate');
						//},
						url : 'userAction!updateUser.action',

						success : function(r) {
							var obj = jQuery.parseJSON(r);
							if (obj.success) {
								console.info(obj);
								$('#admin_yhgl_datagrid').datagrid('load');
							
							}
							$.messager.show({
								title : '提示',
								msg : obj.msg
							});
						}
					});

				}
			}, {
				text : '重置',
				iconCls : 'icon-cancel',

				handler : function() {
					$('#user_editForm').form('load', rows[0]);
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				$('#user_editForm').form('load', rows[0]);
			},

		});
	} else {
		$.messager.show({
			title : '系统提示',
			msg : '请选择一条数据进行编辑！'
		});

	}*/
}

