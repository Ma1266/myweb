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
	 * @Description: TODO(跳转到用户主界面)
	 * @author Ma_2014 ma_swun092@163.com
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @date 2014-9-3 下午4:12:20
	 * @version V1.0
	 */
	public String goMainPage() {
		return MAIN;
	}

	/**
	 * 
	 * @Title: findByPage
	 * @Description: TODO(执行分页查询)
	 * @author Ma_2014 ma_swun092@163.com
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 * @date 2014-9-3 下午4:05:28
	 * @version V1.0
	 */
	public void findByPage() {
		try {
			Page<User> pager = new Page<User>(page, rows, sort, order);
			super.writeJson2Page(userService.findByPage(pager, user));
		} catch (Exception e) {
			Json j = new Json();
			e.printStackTrace();
			j.setMsg("查询错误：" + e.getMessage());
			j.setSuccess(false);
			addActionError("查询错误：" + e.getMessage());
			System.out.println("查询错误：" + e.getMessage());
			super.writeJson(j);
		}
	}

	/**
	 * 
	* @Title: addUser 
	* @Description: TODO(添加用户) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	* @date 2014-10-20 上午10:31:50 
	* @version V1.0
	 */
	public void addUser()  {
		Json json = new Json();
		 try {
			userService.save(user);
			json.setMsg("添加成功!");
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setMsg("添加失败:"+e.getMessage());
			json.setSuccess(false);
		}
		 this.writeJson(json);
	}
	/**
	 * 
	* @Title: checkUserExist 
	* @Description: TODO(校验用户是否存在) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	* @date 2014-10-20 上午10:32:32 
	* @version V1.0
	 */
	public void checkUserExist() {
		Json json = new Json();
		User u=null;
		 try {
			u=userService.getUserByName(user.getUsername());
			if(null!=u){
				json.setMsg("该用户名已经存在!");
				json.setSuccess(false);
			}else{
				json.setMsg("用户名可以使用!");
				json.setSuccess(true);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.setMsg("用户校验出错:"+e.getMessage());
			json.setSuccess(false);
		}
		 this.writeJson(json);
	}
	public void delete() {
		Json json = new Json();
		try {
			int count = userService.deleteByIds(user.getIds());
			json.setMsg("删除成功！共删除[" + count + "]条数据！");
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("删除失败：" + e.getMessage());
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
			json.setMsg("文件找不到："+e.getMessage());
			json.setSuccess(false);
		}
		List<User> list;
		try {
			list = userService.findUserList();
			ExcelUtil<User> util = new ExcelUtil<User>(User.class);
			util.doExportExcel(list, GlobleNames.EXCEL_SHEET_NAME,GlobleNames.EXCEL_SHEET_SIZE, out);
			json.setMsg("导出成功！");
			json.setSuccess(true);
		} catch (BusinessException e) {
			e.printStackTrace();
			json.setMsg("导出失败："+e.getMessage());
			json.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public User getModel() {
		return user;
	}

}
