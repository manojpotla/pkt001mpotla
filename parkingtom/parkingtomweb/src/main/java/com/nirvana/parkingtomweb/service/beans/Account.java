package com.nirvana.parkingtomweb.service.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {

	private String userName;
	private String password;

	private String mobileNumber;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
