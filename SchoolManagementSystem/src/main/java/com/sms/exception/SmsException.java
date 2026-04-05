package com.sms.exception;

/**
 * 
 * @author Aneswara reddy
 *
 */
@SuppressWarnings("serial")
public class SmsException extends Exception {

	private String errorCode;

	public SmsException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public SmsException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public SmsException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return errorCode;
	}


}
