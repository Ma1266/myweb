package cn.mvc.controller;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mvc.common.model.AjaxJson;
import cn.mvc.model.SysUser;
import cn.mvc.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
	private UserService userService;
	
    
    /**
     * 
    * @Title: geLoginPage 
    * @Description: TODO(进入登录界面) 
    * @author Ma_2014 ma_swun092@163.com   
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws 
    * @date 2014-11-6 上午11:00:03 
    * @version V1.0
     */
    @RequestMapping("/goLoginPage")
    public String geLoginPage(){
    	logger.info("进入登录界面.......");
    	return "/login/login";
    }

    /**
     * 
    * @Title: doLogin 
    * @Description: TODO(登录) 
    * @author Ma_2014 ma_swun092@163.com   
    * @param @param loginName
    * @param @param passWord
    * @param @param req
    * @param @return
    * @param @throws Exception    设定文件 
    * @return AjaxJson    返回类型 
    * @throws 
    * @date 2014-11-5 下午1:04:48 
    * @version V1.0
     */
	@RequestMapping("/doLogin")//spring mvc基于resful的风格 很不错
	@ResponseBody//此注解  可以将对象直接自动转换为Jason格式数据
	public  AjaxJson doLogin(String loginName,String passWord,HttpServletRequest req) throws Exception {

			AjaxJson j=new AjaxJson();
			SysUser user2=userService.findByLoginName(loginName);
			if(user2==null){
				j.setMsg("用户名不存在!请重新输入!");
				j.setSuccess(false);
			}else {
				if(null!=user2.getPassword()&&!user2.getPassword().equals(passWord)){
					j.setMsg("密码不正确!");
					j.setSuccess(false);
				}else{
					j.setMsg("登录成功!");
					j.setSuccess(true);
				}
			}
		return j;
	}
	@RequestMapping("/interceptorTest")
	public void test(){
		logger.info("test------");
	}
}
