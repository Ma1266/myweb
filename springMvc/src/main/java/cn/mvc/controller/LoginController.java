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
    * @Description: TODO(�����¼����) 
    * @author Ma_2014 ma_swun092@163.com   
    * @param @return    �趨�ļ� 
    * @return String    �������� 
    * @throws 
    * @date 2014-11-6 ����11:00:03 
    * @version V1.0
     */
    @RequestMapping("/goLoginPage")
    public String geLoginPage(){
    	logger.info("�����¼����.......");
    	return "/login/login";
    }

    /**
     * 
    * @Title: doLogin 
    * @Description: TODO(��¼) 
    * @author Ma_2014 ma_swun092@163.com   
    * @param @param loginName
    * @param @param passWord
    * @param @param req
    * @param @return
    * @param @throws Exception    �趨�ļ� 
    * @return AjaxJson    �������� 
    * @throws 
    * @date 2014-11-5 ����1:04:48 
    * @version V1.0
     */
	@RequestMapping("/doLogin")//spring mvc����resful�ķ�� �ܲ���
	@ResponseBody//��ע��  ���Խ�����ֱ���Զ�ת��ΪJason��ʽ����
	public  AjaxJson doLogin(String loginName,String passWord,HttpServletRequest req) throws Exception {

			AjaxJson j=new AjaxJson();
			SysUser user2=userService.findByLoginName(loginName);
			if(user2==null){
				j.setMsg("�û���������!����������!");
				j.setSuccess(false);
			}else {
				if(null!=user2.getPassword()&&!user2.getPassword().equals(passWord)){
					j.setMsg("���벻��ȷ!");
					j.setSuccess(false);
				}else{
					j.setMsg("��¼�ɹ�!");
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
