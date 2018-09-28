package com.rohith.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.rohith.app.model.Student;

public interface StudentServiceDAO {
	
	
	public Student getStudent(long student);
	
	
	public List<Student> getAllStudents();
	
	
	public List<Student> getStudentsJoinedAfter(LocalDate joinedDate);
	
	
	public void saveStudentInformation(Student student);

}
