package com.sms.exception;

/**
 * 
 * @author Aneswara reddy
 *
 */
public class SmsDaoException extends SmsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SmsDaoException(String errorCode, String message, Throwable cause) {
		super(errorCode, message, cause);
	}

	public SmsDaoException(String errorCode, String message) {
		super(errorCode, message);
	}

	public SmsDaoException(Throwable cause) {
		super(cause);
	}

}
