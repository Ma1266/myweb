package cn.mwm.exception;

/**
 * 
* @ClassName: BusinessException 
* @Description: TODO(自定义异常类) 
* @author Ma_2014 ma_swun092@163.com 
* @date 2014-9-25 上午11:18:29 
*
 */
public class BusinessException extends Exception {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
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
