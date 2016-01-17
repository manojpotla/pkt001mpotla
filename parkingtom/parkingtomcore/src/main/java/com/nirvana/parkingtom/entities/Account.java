package com.nirvana.parkingtom.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

@Component("accountBean")
@Entity
@Table(name="ACCOUNTS")
public class Account {
	
	@Id
	@Column(name="ACCOUNT_ID", nullable=false)
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long accountId;
	
	@Column(name="EMAIL_ID")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="CREATED_DT")
	private Date createdDate;
	
	@Column(name="LAST_UPDATED_BY")
	private Date lastUpdatedDate;
	
	@Column(name="QUESTION_1")
	private String question1;
	
	@Column(name="ANSWER")
	private String answer1;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	@OneToOne(mappedBy="account", orphanRemoval=true)
	@JsonBackReference
	private UserAccount userAccount;
	
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	
	
}
