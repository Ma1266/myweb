package cn.mwm.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.mwm.constant.GlobleNames;
import cn.mwm.exception.BusinessException;
import cn.mwm.pageModel.Json;
import cn.mwm.pageModel.Page;
import cn.mwm.service.IUserService;
import cn.mwm.utils.ExcelUtil;
import cn.mwm.vo.User;

import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BaseAction implements ModelDriven<User> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserAction.class);

	private User user = new User();

	@Autowired
	private IUserService userService;

	/**
	 * 
	 * @Title: goMainPage
	 * @Description: TODO(��ת���û�������)
	 * @author Ma_2014 ma_swun092@163.com
	 * @param @return �趨�ļ�
	 * @return String ��������
	 * @throws
	 * @date 2014-9-3 ����4:12:20
	 * @version V1.0
	 */
	public String goMainPage() {
		return MAIN;
	}

	/**
	 * 
	 * @Title: findByPage
	 * @Description: TODO(ִ�з�ҳ��ѯ)
	 * @author Ma_2014 ma_swun092@163.com
	 * @param �趨�ļ�
	 * @return void ��������
	 * @throws
	 * @date 2014-9-3 ����4:05:28
	 * @version V1.0
	 */
	public void findByPage() {
		try {
			Page<User> pager = new Page<User>(page, rows, sort, order);
			super.writeJson2Page(userService.findByPage(pager, user));
		} catch (Exception e) {
			Json j = new Json();
			e.printStackTrace();
			j.setMsg("��ѯ����" + e.getMessage());
			j.setSuccess(false);
			addActionError("��ѯ����" + e.getMessage());
			System.out.println("��ѯ����" + e.getMessage());
			super.writeJson(j);
		}
	}

	/**
	 * 
	* @Title: addUser 
	* @Description: TODO(����û�) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	* @date 2014-10-20 ����10:31:50 
	* @version V1.0
	 */
	public void addUser()  {
		Json json = new Json();
		 try {
			userService.save(user);
			json.setMsg("��ӳɹ�!");
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setMsg("���ʧ��:"+e.getMessage());
			json.setSuccess(false);
		}
		 this.writeJson(json);
	}
	/**
	 * 
	* @Title: checkUserExist 
	* @Description: TODO(У���û��Ƿ����) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	* @date 2014-10-20 ����10:32:32 
	* @version V1.0
	 */
	public void checkUserExist() {
		Json json = new Json();
		User u=null;
		 try {
			u=userService.getUserByName(user.getUsername());
			if(null!=u){
				json.setMsg("���û����Ѿ�����!");
				json.setSuccess(false);
			}else{
				json.setMsg("�û�������ʹ��!");
				json.setSuccess(true);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.setMsg("�û�У�����:"+e.getMessage());
			json.setSuccess(false);
		}
		 this.writeJson(json);
	}
	public void delete() {
		Json json = new Json();
		try {
			int count = userService.deleteByIds(user.getIds());
			json.setMsg("ɾ���ɹ�����ɾ��[" + count + "]�����ݣ�");
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("ɾ��ʧ�ܣ�" + e.getMessage());
			e.printStackTrace();
		}
		super.writeJson(json);
	}

	public void doExportExcel() throws BusinessException {
		Json json=new Json();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String excelName = format.format(new Date());
		String path = "UserInfo-"+excelName+".xls";
		String fegefu = File.separator;
		String severPath =this.getRequest().getSession().getServletContext().getRealPath(fegefu);
		String allPath = severPath + "attachment" + fegefu + path;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(allPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			json.setMsg("�ļ��Ҳ�����"+e.getMessage());
			json.setSuccess(false);
		}
		List<User> list;
		try {
			list = userService.findUserList();
			ExcelUtil<User> util = new ExcelUtil<User>(User.class);
			util.doExportExcel(list, GlobleNames.EXCEL_SHEET_NAME,GlobleNames.EXCEL_SHEET_SIZE, out);
			json.setMsg("�����ɹ���");
			json.setSuccess(true);
		} catch (BusinessException e) {
			e.printStackTrace();
			json.setMsg("����ʧ�ܣ�"+e.getMessage());
			json.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public User getModel() {
		return user;
	}

}
