package com.nirvana.parkingtomweb.service.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="requestObject")
public class LoginRequest {

	private Account accountDTO;

	public Account getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(Account accountDTO) {
		this.accountDTO = accountDTO;
	}
}
