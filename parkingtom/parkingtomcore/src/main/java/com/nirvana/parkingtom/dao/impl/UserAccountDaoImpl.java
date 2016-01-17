package com.nirvana.parkingtom.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nirvana.parkingtom.dao.UserAccountDao;
import com.nirvana.parkingtom.entities.Account;
import com.nirvana.parkingtom.entities.UserAccount;
import com.nirvana.parkingtom.utility.SessionUtil;

@Component("userAccountDaoImpl")
public class UserAccountDaoImpl implements UserAccountDao{

	@Autowired
	SessionUtil sessionUtil;
	private static Logger sl4jLogger = LoggerFactory.getLogger(UserAccountDaoImpl.class);
	
	private Session session;	
	public int registerUser(Account account, UserAccount userAccount) {
		sl4jLogger.info("In create method");
		session = sessionUtil.getSessionInstance();
		Integer createdId = (Integer) session.save(userAccount);
		session.close();
		return createdId;

	}

	public UserAccount findUser(String userName) {
		sl4jLogger.info("In findUser method");
		session = sessionUtil.getSessionInstance();
		//org.hibernate.Query namedAccountQuery =  session.getNamedQuery("selectUserAccount"); 
		//namedAccountQuery.setString("userName", userName);
		//List<UserAccount> userAccount = namedAccountQuery.list();
		String userAccountData = "select ua.* from User_Account ua, Accounts ac  where ua.account_id = ac.account_id and ac.email_id=:userName";
		SQLQuery userAccountNative = session.createSQLQuery(userAccountData);
		userAccountNative.addEntity(UserAccount.class);
		//userAccountNative.addEntity(Account.class);
		userAccountNative.setParameter("userName", userName);
		List<UserAccount> userAccount = (List<UserAccount>)userAccountNative.list();
		 UserAccount userAccount2 = userAccount.get(0);
		//obj.get
//		 userAccount2 = (UserAccount)userAccount.get(0);
//		UserAccount userAccount = (UserAccount)session.load(UserAccount.class, userName);
//		 return userAccount;
		return userAccount2;
		 
		
	}

	public void setSessionUtil(SessionUtil sessionUtil) {
		this.sessionUtil = sessionUtil;
	}

}
