package cn.mvc.common.exception;

public class SysDaoException extends RuntimeException {

	/** 
	* @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô) 
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
