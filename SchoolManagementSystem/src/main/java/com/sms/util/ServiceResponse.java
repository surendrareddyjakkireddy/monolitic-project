package com.sms.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Aneswara reddy
 *
 */
public class ServiceResponse {

	private String status;
	private String statusMessage;
	private String errorCode;
	private Map<String,Object> data = new HashMap<String,Object>();
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}
	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the data
	 */
	public Map<String, Object> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public void addDataObject(String key, Object dataObject){
		data.put(key, dataObject);
	}
}
