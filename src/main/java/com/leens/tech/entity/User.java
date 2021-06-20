package com.leens.tech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int uId;	
	private  String uname;	
	private String uAddr;
	
	
	
	public User(int uId, String uname, String uAddr) {
		super();
		this.uId = uId;
		this.uname = uname;
		this.uAddr = uAddr;
	}


	public int getuId() {
		return uId;
	}
	
	
	public User() {
		super();
	}


	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getuAddr() {
		return uAddr;
	}
	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}

}
