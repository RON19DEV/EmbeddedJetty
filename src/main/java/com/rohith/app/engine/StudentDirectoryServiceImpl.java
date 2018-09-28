package com.rohith.app.engine;

import java.util.List;

import com.rohith.app.dao.StudentServiceDAO;
import com.rohith.app.dao.impl.StudentServiceDAOMysqlImpl;
import com.rohith.app.model.Student;

public class StudentDirectoryServiceImpl implements StudentDirectoryService{
	
	
	private StudentServiceDAO studentServiceDAO;
	
	public StudentDirectoryServiceImpl(){
		
		this.studentServiceDAO = new StudentServiceDAOMysqlImpl();
	}

	public Student getStudentInfo(long studentId) {
		
		return this.studentServiceDAO.getStudent(studentId);
		
	}

	public List<Student> getAllStudentInfo() {
		
		return this.studentServiceDAO.getAllStudents();
	}
	


	
	
	
}
