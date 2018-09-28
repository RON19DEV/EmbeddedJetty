package com.rohith.app.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceResponse{

	
		private ResponseHeader responseHeader;
		
		private ResponseBody responseBody;

		public ResponseHeader getResponseHeader() {
			return responseHeader;
		}

		public void setResponseHeader(ResponseHeader responseHeader) {
			this.responseHeader = responseHeader;
		}

		public ResponseBody getResponseBody() {
			return responseBody;
		}

		public void setResponseBody(ResponseBody responseBody) {
			this.responseBody = responseBody;
		}
		
		
	
}
