package cn.mvc.common.model;

import java.util.Map;

/**
 * 
* @ClassName: AjaxJson 
* @Description: TODO(ǰ̨ajax���󷵻�json����) 
* @author Ma_2014 ma_swun092@163.com 
* @date 2014-10-19 ����6:40:18 
*
 */
public class AjaxJson {


	private boolean success = true;// �Ƿ�ɹ�
	private String msg = "�����ɹ�";// ��ʾ��Ϣ
	private Object obj = null;// ������Ϣ
	private Map<String, Object> attributes;// ��������
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
