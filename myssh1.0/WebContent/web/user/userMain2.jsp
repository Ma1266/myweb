<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:include page="/common.jsp"></jsp:include>
<script type="text/javascript" src="user/userMain.js"></script>

<div id="admin_yhgl_layout" class="easyui-layout"
	data-options="fit:true,border:false">
	<div data-options="region:'north',title:'查询条件',border:true" style="height: 70px; background-color: #F4F4F4;">
	
		<form id="admin_yhgl_searchForm"  style="border: 1px;" class="form">
			<table width="100%" style="margin-top: 5px;">
				<tr style="text-align: center;">
					<td>用户名: <input type="text" class="text"
						name="username" />
					</td>
					<td  >起始时间: 
					<input type="text" class="Wdate" id="d4321" name='beginTime' onFocus="WdatePicker({dateFmt:'yyyy-M-d H:mm:ss',maxDate:'#F{$dp.$D(\'d4322\');}'})"/>
					</td>
					<td  >截止时间:
					<input type="text" class="Wdate" id="d4322" name="endTime" onFocus="WdatePicker({dateFmt:'yyyy-M-d H:mm:ss',minDate:'#F{$dp.$D(\'d4321\');}'})"/>			
					</td>
					<td >
					<label> 
					 <a class="easyui-linkbutton" iconCls="icon-search" onclick="doQuery();">查询</a>
					 <a class="easyui-linkbutton" iconCls="icon-cancel" onclick="reSet();">重置</a> 
					 </label>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="admin_yhgl_datagrid"></table>
	</div>
</div>

