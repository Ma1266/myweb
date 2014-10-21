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
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation aInvocation) throws Exception {
		request = ServletActionContext.getRequest();
		String result = null; // Action�ķ���ֵ
		String errorMsg = "δ֪����";

		try {
			result = aInvocation.invoke();
			return result;
		} catch (DataAccessException ex) {
			errorMsg = "���ݿ����ʧ��"+ex.getMessage();
		} catch (NullPointerException ex) {
			errorMsg = "������δ����ʼ���Ķ�������ǲ����ڵĶ���"+ex.getMessage();
		} catch (IOException ex) {
			errorMsg = "IO�쳣"+ex.getMessage();
		} catch (ClassNotFoundException ex) {
			errorMsg = "ָ�����಻����"+ex.getMessage();
		} catch (ArithmeticException ex) {
			errorMsg = "�����쳣"+ex.getMessage();
		} catch (ArrayIndexOutOfBoundsException ex) {
			errorMsg = "�����±�Խ��:"+ex.getMessage();
		} catch (IllegalArgumentException ex) {
			errorMsg = "�����Ĳ�������:"+ex.getMessage();
		} catch (ClassCastException ex) {
			errorMsg = "����ǿ��ת������";
		} catch (SecurityException ex) {
			errorMsg = "Υ����ȫԭ���쳣"+ex.getMessage();
		} catch (SQLException ex) {
			errorMsg = "���ݿ��쳣"+ex.getMessage();
		} catch (NoSuchMethodError ex) {
			errorMsg = "����ĩ�ҵ��쳣"+ex.getMessage();
		} catch (InternalError ex) {
			errorMsg = "Java������������ڲ�����"+ex.getMessage();
		} catch (InvocationTargetException ex) {
			errorMsg = "�����ڲ����󣬲���ʧ��!"+ex.getMessage();
		} catch (BusinessException e) {
			e.printStackTrace(); // ����ʱ��ӡ�쳣��Ϣ���������
			errorMsg = e.getMessage().trim();
		} catch (Exception ex) {
			errorMsg = "�����ڲ����󣬲���ʧ�ܣ�"+ex.getMessage();
		}
		errorMsg = "������Ϣ��" + errorMsg;
		/**
		 * ���ʹ�����Ϣ��ҳ��
		 */
		request.setAttribute("tip", errorMsg);
		return "error";
	}

}
