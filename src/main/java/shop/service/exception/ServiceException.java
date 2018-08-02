package shop.service.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -699228138222581987L;

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException() {
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
}
