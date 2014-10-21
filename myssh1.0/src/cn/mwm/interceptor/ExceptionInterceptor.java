package cn.mwm.interceptor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.BindException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;

import cn.mwm.exception.BusinessException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExceptionInterceptor extends AbstractInterceptor {

	private HttpServletRequest request;
	private HttpSession session;

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation aInvocation) throws Exception {
		request = ServletActionContext.getRequest();
		String result = null; // Action的返回值
		String errorMsg = "未知错误！";

		try {
			result = aInvocation.invoke();
			return result;
		} catch (DataAccessException ex) {
			errorMsg = "数据库操作失败"+ex.getMessage();
		} catch (NullPointerException ex) {
			errorMsg = "调用了未经初始化的对象或者是不存在的对象"+ex.getMessage();
		} catch (IOException ex) {
			errorMsg = "IO异常"+ex.getMessage();
		} catch (ClassNotFoundException ex) {
			errorMsg = "指定的类不存在"+ex.getMessage();
		} catch (ArithmeticException ex) {
			errorMsg = "运算异常"+ex.getMessage();
		} catch (ArrayIndexOutOfBoundsException ex) {
			errorMsg = "数组下标越界:"+ex.getMessage();
		} catch (IllegalArgumentException ex) {
			errorMsg = "方法的参数错误:"+ex.getMessage();
		} catch (ClassCastException ex) {
			errorMsg = "类型强制转换错误";
		} catch (SecurityException ex) {
			errorMsg = "违背安全原则异常"+ex.getMessage();
		} catch (SQLException ex) {
			errorMsg = "数据库异常"+ex.getMessage();
		} catch (NoSuchMethodError ex) {
			errorMsg = "方法末找到异常"+ex.getMessage();
		} catch (InternalError ex) {
			errorMsg = "Java虚拟机发生了内部错误"+ex.getMessage();
		} catch (InvocationTargetException ex) {
			errorMsg = "程序内部错误，操作失败!"+ex.getMessage();
		} catch (BusinessException e) {
			e.printStackTrace(); // 开发时打印异常信息，方便调试
			errorMsg = e.getMessage().trim();
		} catch (Exception ex) {
			errorMsg = "程序内部错误，操作失败，"+ex.getMessage();
		}
		errorMsg = "错误信息：" + errorMsg;
		/**
		 * 发送错误消息到页面
		 */
		request.setAttribute("tip", errorMsg);
		return "error";
	}

}
