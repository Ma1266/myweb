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
* @Description: TODO(基础cotrllor,供其他controller继承) 
* @author Ma_2014 ma_swun092@163.com 
* @date 2014-11-4 下午1:02:18 
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

		// 这里进行通用处理，如日志记录等...
		logger.info("系统发生异常,原因如下:" + e.getMessage());
		// 根据不同的异常类型可以返回不同界面
		String expMsg = "";
		if (e instanceof SQLException) {
			expMsg = "数据库异常:";
		} else if (e instanceof NullPointerException) {
			expMsg = "空指针异常:";
		} else if (e instanceof DataAccessException) {
			expMsg = "数据库操作异常:";
		}//此处省略其他错误 可以自己加 
		 else {
			expMsg = "未知异常:";
		}
		// 如果是json格式的ajax请求
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
		} else {// 如果是普通请求
			request.setAttribute("expMsg", expMsg + e.getMessage());
			return "exception";
		}
	}
}
