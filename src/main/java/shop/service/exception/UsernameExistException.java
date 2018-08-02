package shop.service.exception;

public class UsernameExistException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8338777439825468213L;

	public UsernameExistException() {
		super("用户名已存在");
	}

}
