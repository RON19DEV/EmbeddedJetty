package com.rohith.app.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.rohith.app.model.Student;

@XmlRootElement
@XmlSeeAlso({Student.class,ArrayList.class})
public class ResponseBody<T> {
	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}
