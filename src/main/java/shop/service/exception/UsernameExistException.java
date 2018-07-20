package shop.service.exception;

public class UsernameExistException extends ServiceException {

	public UsernameExistException() {
		super("用户名已存在");
	}

}
