package cn.mvc.controller;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
* @ClassName: BaseController 
* @Description: TODO(����cotrllor,������controller�̳�) 
* @author Ma_2014 ma_swun092@163.com 
* @date 2014-11-4 ����1:02:18 
*
 */
public abstract class BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaseController.class);

	@ExceptionHandler
	public String exception(HttpServletRequest request,
			HttpServletResponse response, Exception e) {

		// �������ͨ�ô�������־��¼��...
		logger.info("ϵͳ�����쳣,ԭ������:" + e.getMessage());
		// ���ݲ�ͬ���쳣���Ϳ��Է��ز�ͬ����
		String expMsg = "";
		if (e instanceof SQLException) {
			expMsg = "���ݿ��쳣:";
		} else if (e instanceof NullPointerException) {
			expMsg = "��ָ���쳣:";
		} else if (e instanceof DataAccessException) {
			expMsg = "���ݿ�����쳣:";
		}//�˴�ʡ���������� �����Լ��� 
		 else {
			expMsg = "δ֪�쳣:";
		}
		// �����json��ʽ��ajax����
		if (request.getHeader("accept").indexOf("application/json") > -1|| (request.getHeader("X-Requested-With") != null 
				       && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)) {
			response.setStatus(500);
			response.setContentType("application/json;charset=utf-8");
			try {
				PrintWriter writer = response.getWriter();
				writer.write("{\"success\":false, \"expMsg\":\""+expMsg+ e.getMessage() + "\"}");
				writer.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		} else {// �������ͨ����
			request.setAttribute("expMsg", expMsg + e.getMessage());
			return "exception";
		}
	}
}
