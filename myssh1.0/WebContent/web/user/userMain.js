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
		columns : [ [ {field : 'id',title : '编号',width : 150, checkbox : true},
		              {field : 'username',title : '用户名称',width : 150,sortable : true},
		              {field : 'orgName',title : '部门',sortable : true,width : 150}, 
					  {field : 'createDate',title : '创建时间',width : 150,sortable : true}, 
					  {field : 'email',title : '邮箱',width : 150,sortable : true}, 
					  {field : 'tel',title : '联系电话',width : 150,sortable : true}, 
					  {field : 'roleNameList',title : '角色名称',width : 150,sortable : true},
					  {field : 'status',title : '状态',width : 150,formatter : function(value, row, index) {
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
														}},sortable : true} ] ],
														
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
							//editUser();
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
	//$('#admin_yhgl_datagrid').datagrid('reload', {});//重新加载数据表格
}



//用户信息查看
function goViewPage(){
	/* 下面的只是演示代码，实际应用中一般这样写：	 */
	  //$.dialog.tips('数据加载中...',600,'loading.gif');
	 //[这里是你要执行的代码]
	 // $.dialog.tips('数据加载完毕',1,'success.gif',function(){
		  
	 // });
	    var rows = $('#admin_yhgl_datagrid').datagrid('getChecked');
	   // alert(rows);
	    if(rows.length==1){
	    	optType='view';
	    	//$.dialog.data('optType',optType);
	  		$.dialog(
	  		{
	  			content:'url:'+web_app.name+'/web/user/editUserDialog.jsp',
	  		    lock:true,
	  		    fixed:true,
	  		    height:250,
	  		    width:650,
	  		    padding: 0,
	  		    autoPos:true,
	  		    data:[optType,rows],
	  		    title:"["+rows[0].username+']的信息',
	  		    close:function(){
					$('#admin_yhgl_datagrid').datagrid('uncheckAll');
	  		  }
	  		});
	    }else{
	    	$.messager.show({
				title : '系统提示',
				msg : '请选择一条数据进行编辑！'
			});
	    	//$.dialog.tips('请选择一条数据进行编辑！');

	    }
	  
};
//新增用户
function goAddPage(){
	$.dialog(
	  		{
	  			content:'url:'+web_app.name+'/web/user/editUserDialog.jsp',
	  		    lock:true,
	  		    fixed:true,
	  		    height:250,
	  		    width:650,
	  		    padding: 0,
	  		    autoPos:true,
	  		    data:["add"],
	  		    title:"新增用户",
	  		    close:function(){
					//$('#admin_yhgl_datagrid').datagrid('uncheckAll');
	  		  },
	  		  ok: function () {
	  			$.ajax({
	  				url: web_app.name+"/web/userAction!addUser.ajax",
	  				data:$('#loginForm').serialize(),
	  				type: "POST",
	  				dataType:'json',
	  				success:function(data){
	  					$.messager.show({
							title : '提示',
							 msg : data.msg
						});
	  				},
	  				error:function(data){
	  					$.messager.show({
							title : '提示',
							 msg : data.msg
						});
	  				}
	  				});
	  			  },	
	  	    cancel: true
	  		});
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
//导出
//EasyUI datagrid 动态导出Excel
function ExporterExcel() {
	//alert('导出');
            /*//获取Datagride的列
            var rows = $('#admin_yhgl_datagrid').datagrid('getRows');
            var columns = $("#admin_yhgl_datagrid").datagrid("options").columns[0];
            var oXL = new ActiveXObject("Excel.Application"); //创建AX对象excel 
            var oWB = oXL.Workbooks.Add(); //获取workbook对象 
            var oSheet = oWB.ActiveSheet; //激活当前sheet
            //设置工作薄名称
            oSheet.name = "导出Excel报表";
            //设置表头
            for (var i = 0; i < columns.length; i++) {
                oSheet.Cells(1, i+1).value = columns[i].title;
            }
            //设置内容部分
            for (var i = 0; i < rows.length; i++) {
                //动态获取每一行每一列的数据值
                for (var j = 0; j < columns.length; j++) {               
                    oSheet.Cells(i + 2, j+1).value = rows[i][columns[j].field];
                }   
            }              
            oXL.Visible = true; //设置excel可见属性
*/
	$.ajax({
        type: "GET",
        url: web_app.name+'/web/userAction!doExportExcel.do',
        data: {fileName:'userInfo.xls'},
        dataType: "json",
        success: function(data){
	        	$.messager.show({
	    			 title : '系统提示',
	    			 msg : '导出成功！'
	    		});
                 },
        error:function(data){
        	$.messager.show({
   			 title : '系统提示',
   			 msg : '导出失败'+data.msg
   		});
            }         
    });

}
