package cn.mvc.common.exception;

public class SysDaoException extends RuntimeException {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;

	public SysDaoException() {
		super();
	}

	public SysDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public SysDaoException(String message) {
		super(message);
	}

	public SysDaoException(Throwable cause) {
		super(cause);
	}

	
	
	
}
