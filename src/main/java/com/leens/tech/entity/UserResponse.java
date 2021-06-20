package com.leens.tech.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserResponse {
	
		
	private  String uname;
	
	

	public UserResponse() {
		super();
	}

	public UserResponse(String uname) {
		super();
		this.uname = uname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}	
	

}
