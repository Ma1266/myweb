/*模式遮盖层 CREATEBY BoomBaxx
使用如：var mask=new MyMask(); 创建层对象
 mask.ScreenConvert(); 打开层
 mask.ScreenClean();关闭层
*/
function MyMask(op){
	this.options = {};
	this.defaultCfg={
		color:'#001',    //遮罩透明色
	    alpha:0,    //遮罩透明度
		title:'&nbsp;数据加载中，请稍候......' //提示语言
	};
	op = op || {};
	for (var p in this.defaultCfg) {
        this.options[p] = this.defaultCfg[p];
    }
	for (var o in op) {
        this.options[o] =op[o];
    }	
	this.isIE = false;
	this.isNS = false;
	this.isOP = false;
	this.isSF = false;
	this.d=document;
	this.db=document.body;
    this.rootEl=document.compatMode=='CSS1Compat'?document.documentElement:document.body;	//根元素
	this.Browser();
}
MyMask.prototype.$ = function(id){
    if (typeof(id) != "string" || id == "") return null;
    if (document.getElementById) return document.getElementById(id);
    if (document.all) return document.all(id);
    try {return eval(id);} catch(e){ return null;}
};
MyMask.prototype.changeOption=function(op){
    op = op || {};
    for (var o in op) {
        this.options[o] =op[o];
    }
};
MyMask.prototype.ScreenConvert=function(op){
	op=op||{};
	var y={width:200,height:100};
	//第一次需要创建一个蒙板层
	if(!this.$('ScreenOver')){
		var shieldStyle='position:absolute;top:0px;left:0px;width:0;height:0;background:'+this.options.color+';text-align:center;z-index:10000;filter:alpha(opacity='+(this.options.alpha*100)+');opacity:'+this.options.alpha;
    	try{	//IE
    		this.db.appendChild(this.d.createElement("<div id='ScreenOver' style=\'"+shieldStyle+"\'></div>"));
    		this.db.appendChild(this.d.createElement("<iframe id='ScreenIframe'></iframe>"));
    	}catch(e){
    		var promptShield=this.d.createElement('div');
    		promptShield.id='ScreenOver';
    		promptShield.setAttribute('style',shieldStyle);
    		this.db.appendChild(promptShield);
    		promptShield=null;
    	}
    }
    //计算蒙板的高宽，因为页面内容可能变化，所以每次弹出都应该更新宽高
    this.$('ScreenOver').style.display='none';	//如果显示则先隐藏便于后面计算页面的高宽
    //使用scrollTop和scrollWidth判断是否有滚动条更加准确，但需要加上onscroll监听,一旦发现有scrollTop或scrollLeft则使用scrollWidth/Height
    this.$('ScreenOver').style.width=(this.rootEl.scrollLeft==0?this.rootEl.clientWidth:this.rootEl.scrollWidth)-10+"px";
    this.$('ScreenOver').style.height=(this.rootEl.scrollTop==0?this.rootEl.clientHeight:this.rootEl.scrollHeight)-10+"px";
    //添加Iframe遮罩，仅在IE下才会存在Iframe遮罩
    var ScreenIframe=this.$('ScreenIframe');
    var title=op['title']||this.options.title;
	outerStyle='position:absolute;left:'+((this.rootEl.clientWidth-y.width)/2+this.rootEl.scrollLeft)+'px;width:'+y.width+'px;top:'+((this.rootEl.clientHeight-y.height)/2+this.rootEl.scrollTop)+'px;height:'+y.height+'px;z-index:10001';
	if(!this.$('ScreenOverLoading')){
	  var ScreenOverLoading=this.d.createElement('div');
	  ScreenOverLoading.id='ScreenOverLoading';
	  ScreenOverLoading.innerHTML="<div style='font-size: 9pt;background-color:infobackground;width:95%;border: #000000 solid 1px;padding:5px;'><img src='"+web_app.name+"/images/load.gif' border='0'/>"+title+"</div>";
	  this.db.appendChild(ScreenOverLoading);
	}else{
		this.$('ScreenOverLoading').innerHTML="<div style='font-size: 9pt;background-color:infobackground;width:95%;border: #000000 solid 1px;padding:5px;'><img src='"+web_app.name+"/images/load.gif' border='0'/>"+title+"</div>";
	}
    this.addCSS(this.$('ScreenOverLoading'),outerStyle);
	if(op.flag){this.$('ScreenOverLoading').style.display='none';}
    //禁止对页面的任何操作
    this.db.onselectstart = function(){return false;};
    this.db.oncontextmenu = function(){return false;};
	if(ScreenIframe){
    	this.addCSS(ScreenIframe,this.$('ScreenOver').style.cssText+';z-index:9999;filter:alpha(opacity=0);opacity:0');
    	ScreenIframe.style.display='';
    }
	//显示蒙板
	this.$('ScreenOver').style.display='';
};
MyMask.prototype.Browser=function(){//浏览器识别
	 var ua, s, i;
	 ua = navigator.userAgent.toLowerCase();
	 s = "opera";
	 if ((i = ua.indexOf(s)) >= 0){
		 this.isOP = true;
		 return;
	 }
	 s = "msie";
	 if ((i = ua.indexOf(s)) >= 0) {
		 this.isIE = true;
		 return;
     }
	 s = "netscape6/";
	 if ((i = ua.indexOf(s)) >= 0) {
		 this.isNS = true;
		 return;
	 }
	 s = "gecko";
	 if ((i = ua.indexOf(s)) >= 0) {
		 this.isNS = true;
		 return;
	 }
	 s = "safari";
	 if ((i = ua.indexOf(s)) >= 0) {
		 this.isSF = true;
		 return;
	 }
};
MyMask.prototype.ScreenClean=function(time){
	time=time||0;
	var obj=this;
	setTimeout(function(){
		obj.$('ScreenOver').style.display='none';
		obj.$('ScreenOverLoading').style.display='none';
		if(obj.$('ScreenIframe')){obj.$('ScreenIframe').style.display='none';};
		obj.db.onselectstart = function(){return true;};
		obj.db.oncontextmenu = function(){return true;};
	},time);
};
MyMask.prototype.addCSS=function(obj,css,append){
    	!append?(this.isOP?obj.setAttribute('style',css):obj.style.cssText=css):(this.isOP?obj.setAttribute('style',obj.getAttribute('style')+css):obj.style.cssText+=css);
};
MyMask.prototype.changeTitle=function(title){
	var loading=this.$('ScreenOverLoading');
	if(loading){
		loading.innerHTML="<div style='font-size: 9pt;background-color:infobackground;width:95%;border: #000000 solid 1px;padding:5px;'><img src='"+web_app.name+"/images/title.gif' border='0'/>&nbsp;"+title+"</div>";
	}
};