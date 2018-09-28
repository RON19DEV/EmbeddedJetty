package com.rohith.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.rohith.app.dao.MySQLDataSourceFactory;
import com.rohith.app.dao.StudentServiceDAO;
import com.rohith.app.model.Student;
import com.rohith.app.util.DateUtil;

public class StudentServiceDAOMysqlImpl implements StudentServiceDAO {

	public Student getStudent(long studentId) {

		Connection conn = MySQLDataSourceFactory.getConnection();

		String sql = "SELECT * FROM student.student_main where s_id=?";

		PreparedStatement updateemp;
		
		Student student = null;
		
		try {
			updateemp = conn.prepareStatement(sql);
			updateemp.setLong(1, studentId);
			ResultSet executeQuery = updateemp.executeQuery();
			if(null!=executeQuery && executeQuery.next()){
				long id = executeQuery.getLong(1);
				String name = executeQuery.getString(2);
				LocalDate joiningDate = DateUtil.convertSQLDateToLocalDate(executeQuery.getDate(3));
				String email = executeQuery.getString(4);
				student = new Student();
				populateStudent(student, id, name, joiningDate, email);
			}
		} catch (SQLException e) {
			
			System.out.println("Exception Ocuured while Creating Prep Stmt" + e.getMessage());
		}
		return student;
	}

	

	public List<Student> getAllStudents() {
		
		Connection conn = MySQLDataSourceFactory.getConnection();

		String sql = "SELECT * FROM student.student_main";

		PreparedStatement updateemp;
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			updateemp = conn.prepareStatement(sql);
			ResultSet executeQuery = updateemp.executeQuery();
			while(null!=executeQuery && executeQuery.next()){
				long id = executeQuery.getLong(1);
				String name = executeQuery.getString(2);
				LocalDate joiningDate = DateUtil.convertSQLDateToLocalDate(executeQuery.getDate(3));
				String email = executeQuery.getString(4);
				Student student = new Student();
				populateStudent(student, id, name, joiningDate, email);
				students.add(student);
			}
		} catch (SQLException e) {
			
			System.out.println("Exception Ocuured while Creating Prep Stmt" + e.getMessage());
		}
		return students;
	}

	public List<Student> getStudentsJoinedAfter(LocalDate joinedDate) {
		return null;
	}

	public void saveStudentInformation(Student student) {
		
	}

	private void populateStudent(Student student, long id, String name, LocalDate joiningDate, String email) {
		student.setEmail(email);
		student.setId(id);
		student.setJoiningDate(joiningDate.toString());
		student.setName(name);
	}
	
}
