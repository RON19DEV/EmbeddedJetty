package com.rohith.app.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rohith.app.engine.StudentDirectoryService;
import com.rohith.app.engine.StudentDirectoryServiceImpl;
import com.rohith.app.model.Student;
import com.rohith.app.response.ResponseBody;
import com.rohith.app.response.ResponseHeader;
import com.rohith.app.response.ServiceResponse;

@Path("/student")
public class StudentServiceEndPoint implements StudentEndPoint{

	private StudentDirectoryService studentDirectoryService;
	
	public  StudentServiceEndPoint() {
		
		this.studentDirectoryService = new StudentDirectoryServiceImpl();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceResponse getStudentData(@PathParam("id") Long id) {
		
		ServiceResponse response = new ServiceResponse();
		Student student  = this.studentDirectoryService.getStudentInfo(id);
		ResponseHeader header = new ResponseHeader();
		if(student==null){
			header.setResponseCode(400);
			header.setResponseStatus("FAILED");	
		}else{
			header.setResponseCode(200);
			header.setResponseStatus("SUCCESS");
		}
		response.setResponseHeader(header);
		ResponseBody<Student> responseBody = new ResponseBody<Student>();
		responseBody.setData(student);
		response.setResponseBody(responseBody);	
		return response;
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceResponse getAllStudentData(){
		
		ServiceResponse response = new ServiceResponse();
		List<Student> student  = this.studentDirectoryService.getAllStudentInfo();
		ResponseHeader header = new ResponseHeader();
		if(student==null || student.isEmpty()){
			header.setResponseCode(400);
			header.setResponseStatus("FAILED");	
		}else{
			header.setResponseCode(200);
			header.setResponseStatus("SUCCESS");
		}
		response.setResponseHeader(header);
		ResponseBody<List<Student>> responseBody = new ResponseBody<List<Student>>();
		responseBody.setData(student);
		response.setResponseBody(responseBody);	
		return response;
	}

}
