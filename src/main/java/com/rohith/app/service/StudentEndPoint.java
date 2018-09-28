package com.rohith.app.service;

import com.rohith.app.model.Student;
import com.rohith.app.response.ServiceResponse;

public interface StudentEndPoint {

	public ServiceResponse getStudentData(Long studentId);

	
}
