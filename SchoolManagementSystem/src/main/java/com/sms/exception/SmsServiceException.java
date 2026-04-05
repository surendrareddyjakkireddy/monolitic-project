package com.sms.exception;

public class SmsServiceException extends SmsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5074615456169093589L;

	public SmsServiceException(String errorCode, String message) {
		super(errorCode, message);
	}

	public SmsServiceException(String errorCode, String message, Throwable cause) {
		super(errorCode, message, cause);
	}

	public SmsServiceException(Throwable cause) {
		super(cause);
	}
}
