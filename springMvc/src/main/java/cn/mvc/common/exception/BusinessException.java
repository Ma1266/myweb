package cn.mvc.common.exception;

/**
 * 
* @ClassName: BusinessException 
* @Description: TODO(�Զ����쳣��) 
* @author Ma_2014 ma_swun092@163.com 
* @date 2014-9-25 ����11:18:29 
*
 */
public class BusinessException extends SysDaoException {

	/** 
	* @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô) 
	*/ 
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
