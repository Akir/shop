package shop.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "签名无效")
public class AlipaySignatureException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1544185657257564846L;

	public AlipaySignatureException() {
		super();
	}

	public AlipaySignatureException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlipaySignatureException(String message) {
		super(message);
	}

	public AlipaySignatureException(Throwable cause) {
		super(cause);
	}
	
}
