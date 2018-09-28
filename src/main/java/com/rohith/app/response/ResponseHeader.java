package com.rohith.app.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseHeader {

	private int responseCode;
	
	private String responseStatus;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
}
