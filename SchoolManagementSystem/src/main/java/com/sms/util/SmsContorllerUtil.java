package com.sms.util;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Component
@ControllerAdvice
public class SmsContorllerUtil {

	public ServiceResponse successStatus(ServiceResponse serviceResponse, String statusMessage) {
		serviceResponse.setStatus("200");
		serviceResponse.setStatusMessage(statusMessage);
		return serviceResponse;
	}

	public ServiceResponse failureStatus(ServiceResponse serviceResponse, String errorCode, String statusMessage) {
		serviceResponse.setStatus("500");
		serviceResponse.setStatusMessage(statusMessage);
		serviceResponse.setErrorCode(errorCode);
		return serviceResponse;
	}
}
