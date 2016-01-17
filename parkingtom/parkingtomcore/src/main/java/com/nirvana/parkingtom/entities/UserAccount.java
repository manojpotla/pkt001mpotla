package com.nirvana.parkingtom.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.springframework.stereotype.Component;
//@NamedQueries({ @NamedQuery(name="selectUserAccount", query = "select ua.firstName, ua.lastName, ua.mobileNumber from UserAccount ua, Account ac  where ua.accountId = ac.accountId and ac.userName=:userName") })
@Component("userAccountBean")
@Entity
@Table(name = "user_account")
public class UserAccount {

	@Id	
	@Column(name="USER_ID")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int userId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_ID")
	@JsonManagedReference
	private Account account;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return mobileNumber;
		
	}
	
	public void setMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		this.mobileNumber = mobileNumber;
		
	}
	
	
}

