package cn.mwm.action;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.mwm.constant.GlobleNames;
import cn.mwm.pageModel.CurrentUser;
import cn.mwm.pageModel.Page;
import cn.mwm.pageModel.SessionInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
* @ClassName: BaseAction 
* @Description: TODO(����Action ������action�̳�) 
* @author Ma_2014 ma_swun092@163.com 
* @date 2014-8-28 ����11:07:43 
*
 */
public class BaseAction extends ActionSupport{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaseAction.class);
	
	private static SerializerFeature[] features = {SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty };
	
	public final static String MAIN = "main";
	public final static String ADD = "add";
	public final static String EDIT = "edit";
	public final static String VIEW = "view";
	
	protected int page;//��ǰ��ʾҳ
	protected int rows;//ÿҳ��ʾ����������
	protected String sort;//�����ֶ�
	protected String order;// asc/desc

	protected String fileName;
	
	/**
	 * ��ǰ̨����Json�ַ���
	 * @param object
	 */
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	* ��      ����  ��ǰ̨���ط�ҳjson����
	* �� �� �ˣ�mawenming email:swun_092@163.com    
	* ����ʱ�䣺2014-4-16 ����1:29:54  
	* �޸ı�ע��  
	* @version
	 */
	public  String writeJson2Page(Page page){
		try {
			logger.info("=========��ʼ�����ҳjson����===========");
			Map<String, Object> m=new HashMap<String, Object>();		
			m.put("page", page.getPage());
			m.put("total",page.getTotal());
			m.put("rows", page.getResultList());
			String json = JSON.toJSONStringWithDateFormat(m, "yyyy-MM-dd HH:mm:ss",features);
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
			logger.info("=========�����ҳjson���ݽ���==========="+json);
			return json;
		} catch (IOException e) {
			logger.info("=======�����ҳjson���ݳ���========"+e.getMessage());
		}
		return null;
	}	
	/**
	 * ���request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * ���response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	/**
	 * ��ȡSession������
	 * 
	 * @return
	 */
	public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}
	/**
	 * ��ȡ��½�û�
	 * 
	 * @return
	 */
	public SessionInfo getCurrentUser() {
		SessionInfo cuser = getSession().get(GlobleNames.SESSION_INFO) != null ? (SessionInfo) getSession()
				.get(GlobleNames.SESSION_INFO) : null;
		return cuser;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
