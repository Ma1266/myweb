var mymask=null;
$(document).ready(function(){
	//setTimeout(function(){$('#screenOverMain').hide();},500);
	mymask=new MyMask({title:'&nbsp;数据保存中，请稍候......'}); //创建层对象
});

function ajaxRequest(url,param,fn,flag){
	mymask.ScreenConvert();
	$.ajax({type: "POST",url:url,dataType:'json',data:param,
		success: function(data){
		    if(!data){ 
		    	alert('服务器无返回！');
		    	mymask.ScreenClean();
		    	return;
		    }
			if(data.error){
				alert(data.error);
				mymask.ScreenClean();
			}else if(data.success){
				if(fn)fn.call(document,data);
				if(!flag){
					mymask.changeTitle('数据操作成功!');
					mymask.ScreenClean(1000);
				}else{
					mymask.ScreenClean();
				}
			}else{
				if(fn)fn.call(document,data);
				mymask.ScreenClean();
			}
		},
		error: function(data) {alert('服务器访问错误！');mymask.ScreenClean();}
	});
}

function queryRequest(url,param,fn){
	mymask.ScreenConvert({title:'&nbsp;数据加载中，请稍候......'});
	$.ajax({type: "POST",url:url,data:param,
		success: function(data){
			mymask.ScreenClean();
			if(fn)fn.call(document,data);
		},
		error: function(data) {mymask.ScreenClean();alert('服务器访问错误！');}
	});
}