package com.rohith.app.engine;

import java.util.List;

import com.rohith.app.model.Student;

public interface StudentDirectoryService {

	
	public Student getStudentInfo(long studentId);
	
	public List<Student> getAllStudentInfo();
	
}
