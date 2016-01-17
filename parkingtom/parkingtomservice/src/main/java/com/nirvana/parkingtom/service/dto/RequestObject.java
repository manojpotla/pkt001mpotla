package com.nirvana.parkingtom.service.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="requestObject")
public class RequestObject {

	private UserAccountDTO userAccountDTO;
	private AccountDTO accountDTO;
	
	//@XmlElement(name="userAccountDTO")
	public UserAccountDTO getUserAccountDTO() {
		return userAccountDTO;
	}
	
	public void setUserAccountDTO(UserAccountDTO userAccountDTO) {
		this.userAccountDTO = userAccountDTO;
	}
	
	//@XmlElement(name="accountDTO")
	public AccountDTO getAccountDTO() {
		return accountDTO;
	}


	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}
}
