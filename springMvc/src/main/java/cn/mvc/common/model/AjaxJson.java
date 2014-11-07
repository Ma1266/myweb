package cn.mvc.common.model;

import java.util.Map;

/**
 * 
* @ClassName: AjaxJson 
* @Description: TODO(前台ajax请求返回json对象) 
* @author Ma_2014 ma_swun092@163.com 
* @date 2014-10-19 下午6:40:18 
*
 */
public class AjaxJson {


	private boolean success = true;// 是否成功
	private String msg = "操作成功";// 提示信息
	private Object obj = null;// 其他信息
	private Map<String, Object> attributes;// 其他参数
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	
}
